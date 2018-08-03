package jogo.logica;

import jogo.sistema.Setup;

import java.awt.*;

public class Chave extends Entidade {

    //ATRIBUTO
    protected boolean coletado;

    //CONSTRUTOR
    public Chave(int x, int y){
        super(x*Setup.LADO, y*Setup.LADO, Setup.LADO/2, Setup.LADO/2, false);
        this.coletado = false;
    }

    //METODOS
    @Override
    public void desenhar(Graphics g){
        if(!this.coletado){
            int rr = (int) (Math.random()*256);
            int gg = (int) (Math.random()*256);
            int bb = (int) (Math.random()*256);
            g.setColor(new Color(rr, gg, bb));
        }
        else{
            g.setColor(Color.black);
        }
        g.fillRect(this.x+3, this.y+3, this.largura, this.altura);
    }

    public void pegarChave(){
        for(int i=0; i<Setup.entidades.size(); i++){
            if(Setup.entidades.get(i) instanceof Chave){((Chave)(Setup.entidades.get(i))).coletar();}
            else if(Setup.entidades.get(i) instanceof Porta){((Porta) Setup.entidades.get(i)).abrir();}
        }
    }

    private void coletar(){this.coletado = true;}

    //METODOS ESPECIAIS
    public boolean isColetado(){
        return this.coletado;
    }

}
