package jogo.logica;

import jogo.logica.CamaElastica.CamaElastica;
import jogo.logica.CamaElastica.CamaElasticaChao;
import jogo.logica.CamaElastica.CamaElasticaParede;
import jogo.logica.espinhos.Espinho;
import jogo.sistema.Collide;
import jogo.sistema.Setup;

import java.awt.*;

public class Jogador extends Entidade {

    //ATRIBUTOS
    protected boolean[] ad;
    protected float forcaPulo, velocidadeMaxX, velocidadeMaxY, velocidadeX, velocidadeY, aceleracao, desaceleracao;
    protected boolean caindo;
    protected Entidade checadorDireita, checadorEsquerda;

    //CONSTRUTOR
    public Jogador(int x, int y){
        super(x*Setup.LADO, y*Setup.LADO, Setup.LADO , Setup.LADO, Color.green, true);
        this.ad = new boolean[]{false, false};
        this.velocidadeMaxX = 3;
        this.velocidadeMaxY = 10;
        this.velocidadeX = 0;
        this.velocidadeY = 0;
        this.forcaPulo = -6.2f;
        this.aceleracao = 0.5f;
        this.desaceleracao = 0.2f;
        this.caindo = true;
        this.checadorEsquerda = new Entidade(this.x+2, this.y+this.altura, 1, 5, false);
        this.checadorDireita = new Entidade(this.x+this.largura-7, this.y+this.altura, 1, 5, false);
        this.checadorEsquerda.setCor(Color.red);
        this.checadorDireita.setCor(Color.red);
    }

    //METODOS OVERRIDE
    @Override
    public void desenhar(Graphics g){
        g.setColor(this.cor);
        g.fillRect(this.x, this.y, this.largura, this.altura);
        this.checadores(g);
        this.mover();
        this.atualizarVelocidades();
        this.checarPosicao();
    }

    //METODOS
    public void botaoPressionado(int key){
        //Eixo X
        if(key == 37 || key == 65){this.ad[0] = true;}
        else if(key == 39 || key == 68){this.ad[1] = true;}
        //ACOES
        if(key == 38 || key == 87 || key == 32){this.pular();}
    }

    public void botaoSolto(int key){
        //Eixo X
        if(key == 37 || key == 65){this.ad[0] = false;}
        else if(key == 39 || key == 68){this.ad[1] = false;}
    }

    public void mover(){
        //Dormir.dormir();
        //Eixo X
        this.x += (int) this.velocidadeX;
        this.y += (int) this.velocidadeY;
    }

    public void atualizarVelocidades(){
        //Eixo X - Esquerda (ACELERANDO)
        /*if(this.ad[0] && !this.ad[1] && Math.abs(this.velocidadeX) > Math.abs(this.velocidadeMaxX)){
            this.velocidadeX = -this.velocidadeMaxX;
        }*/
        if(this.ad[0] && !this.ad[1] && Math.abs(this.velocidadeX) < Math.abs(this.velocidadeMaxX)){
            this.velocidadeX -= this.aceleracao;
        }
        //Eixo X - Direita (ACELERANDO)
        /*if(this.ad[1] && !this.ad[0] && Math.abs(this.velocidadeX) > Math.abs(this.velocidadeMaxX)){
            this.velocidadeX = this.velocidadeMaxX;
        }*/
        if(this.ad[1] && !this.ad[0] && Math.abs(this.velocidadeX) < Math.abs(this.velocidadeMaxX)){
            this.velocidadeX += this.aceleracao;
        }

        //Eixo X - (DESACELERACAO)
        if((!this.ad[0] && !this.ad[1]) || (this.ad[0] && this.ad[1]) || (this.ad[0] && this.velocidadeX > 0) || (this.ad[1] && this.velocidadeX < 0)){
            if(Math.abs(this.velocidadeX) > Math.abs(this.desaceleracao)){
                if(this.velocidadeX > 0){this.velocidadeX -= this.desaceleracao;}
                else if(this.velocidadeX < 0){this.velocidadeX += this.desaceleracao;}
            }
            else{this.velocidadeX = 0;}
        }
        //Eixo Y
        this.cair();
    }

    private void cair(){
        this.caindo = true;
        for(Entidade e : Setup.entidades){
            if(this != e && e.getFisica()){
                if((Collide.collideEntidades(this.checadorDireita, e) || Collide.collideEntidades(this.checadorEsquerda, e)) && this.velocidadeY >= 0){this.caindo = false; break;}
            }
        }
        if(this.caindo){
            if(this.velocidadeY < this.velocidadeMaxY){this.velocidadeY += Setup.GRAVIDADE;}
            else{this.velocidadeY = this.velocidadeMaxY;}
        }
        else{
            this.velocidadeY = 0;
        }
    }

    private void pular(){
        if(!this.caindo){this.velocidadeY = this.forcaPulo; this.caindo = true;}
    }

    public void colidirComEntidade(Entidade e){
        if(e.getFisica()){this.colidirFisica(e);}

        if(e instanceof Chave){this.pegarChave((Chave) e);}
        else if(e instanceof Porta){this.entrarPorta((Porta) e);}
        else if(e instanceof CamaElastica){this.pularCamaElastica((CamaElastica) e);}


        else if(e instanceof Espinho){this.morrer();}
    }

    private void pegarChave(Chave c){
        c.pegarChave();
    }

    private void entrarPorta(Porta p){
        p.entrar();
    }

    private void pularCamaElastica(CamaElastica c){
        if(c instanceof CamaElasticaChao){
            if(this.caindo && this.velocidadeY >= 0){this.velocidadeY = c.getElasticidade();}
        }
        else if(c instanceof CamaElasticaParede){
            this.ad = new boolean[]{false, false};
            if(this.x < c.getX()){this.velocidadeX = -c.getElasticidade();}
            else{this.velocidadeX = c.getElasticidade();}
        }
    }

    private void morrer(){
        System.out.println("Perdeu!");
        Setup.resetarFase();
    }

    private void colidirFisica(Entidade e){
        int distX = Math.abs((this.getX()+this.getLargura()/2) - (e.getX()+e.getLargura()/2));
        int distY = Math.abs((this.getY()+this.getAltura()/2) - (e.getY()+e.getAltura()/2));
        int distLargura = (int) this.getLargura()/2 + e.getLargura()/2;
        int distAltura = (int) this.getAltura()/2 + e.getAltura()/2;

        //Jogador (EM CIMA)
        if(this.y <= e.getY() && distX <= distY){
            this.caindo = false;
            this.y = e.y - this.altura;
        }
        //Jogador (EM BAIXO)
        else if(this.y >= e.getY() && distX <= distY){
            this.caindo = true;
            this.y = e.y + e.getAltura();
            this.velocidadeY *= -0.5f;
        }
        //Jogador (NA ESQUERDA)
        else if(this.x <= e.getX() && distY <= distX){
            this.x = e.getX() - this.largura;
            this.velocidadeX = 0;
        }
        //Jogador (NA DIREITA)
        else if(this.x >= e.getX() && distY <= distX){
            this.x = e.getX() + e.getLargura();
            this.velocidadeX = 0;
        }
        else{this.caindo = true;}
    }

    public void checadores(Graphics g){
        this.checadorEsquerda.setX(this.x+2);
        this.checadorEsquerda.setY(this.y+this.altura);
        this.checadorDireita.setX(this.x+this.largura-this.checadorDireita.getLargura()-1);
        this.checadorDireita.setY(this.y+this.altura);
        //this.checadorDireita.desenhar(g);
        //this.checadorEsquerda.desenhar(g);
    }

}
