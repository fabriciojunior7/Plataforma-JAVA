package jogo.logica;

import jogo.sistema.Setup;

import java.awt.*;

public class Porta extends Entidade{

    //ATRIBUTOS
    protected boolean aberta;

    //CONSTRUTOR
    public Porta(int x, int y){
        super(x*Setup.LADO, y*Setup.LADO, Setup.LADO, Setup.LADO, false);
        this.cor = new Color(75, 30, 0);
    }

    //METODOS
    @Override
    public void desenhar(Graphics g){
        if(this.aberta){
            int rr = (int) (Math.random()*256);
            int gg = (int) (Math.random()*256);
            int bb = (int) (Math.random()*256);
            g.setColor(new Color(rr, gg, bb));
        }
        else{
            g.setColor(this.cor);
        }
        g.fillRect(this.x, this.y, this.largura, this.altura);
    }

    public void abrir(){
        this.aberta = true;
        this.cor = new Color(150, 100, 0);
    }

    public void entrar(){
        if(this.aberta){
            Setup.passarDeFase();
        }
    }

    //METODOS ESPECIAIS
    public boolean getAberto(){return this.aberta;}

}
