package jogo.logica;

import jogo.sistema.Setup;

import java.awt.*;

public class CheckPoint extends Entidade {

    //ATRIBUTOS
    private boolean checado;
    private boolean comChave;
    private Polygon bandeira;
    private int frameCount;

    //CONSTRUTOR
    public CheckPoint(int x, int y){
        super(x*Setup.LADO+4, y*Setup.LADO-Setup.LADO, Setup.LADO-8, Setup.LADO*2, new Color(50, 50, 0), false);
        this.checado = false;
        this.comChave = false;
        int[] polyX = {(this.x+this.largura), (this.x+this.largura+Setup.LADO), (this.x+this.largura)};
        int[] polyY = {(this.y-1), (this.y+Setup.LADO/2-1), (this.y+Setup.LADO-1)};
        this.bandeira = new Polygon(polyX, polyY, polyX.length);
        this.frameCount = 1;
    }

    //METODOS
    @Override
    public void desenhar(Graphics g){
        g.setColor(this.cor);
        g.fillRect(this.x, this.y, this.largura, this.altura);
        if(this.checado){
            g.setColor(new Color(255, 0, 0));
            g.fillPolygon(this.bandeira);
        }
        if(this.frameCount % 5 == 0){
            this.mexerBandeira();
        }
        this.frameCount++;
    }

    @Override
    public boolean equals(Object o){
        CheckPoint c = (CheckPoint) o;
        if(this.x == c.getX() && this.y == c.getY() && this.comChave == c.getComChave()){
            return true;
        }
        else{return false;}
    }

    private void mexerBandeira(){
        int rx = (int)(Math.random()*3);
        int ry = (int)(Math.random()*3);
        int[] polyX = {(this.x+this.largura), (this.x+this.largura+8+rx), (this.x+this.largura)};
        int[] polyY = {(this.y-1), (this.y+3+ry), (this.y+Setup.LADO-1)};
        this.bandeira = new Polygon(polyX, polyY, polyX.length);
        this.frameCount = 1;
    }

    public void checar(){
        this.checado = true;
        this.cor = new Color(255, 255, 0 );
        for(Entidade e : Setup.entidades){
            if(e instanceof Porta){
                Porta p = (Porta) e;
                this.comChave = ((Porta) e).getAberto();
                break;
            }
        }
    }

    //METODOS ESPECIAIS
    public boolean getChecado(){
        return this.checado;
    }

    public boolean getComChave(){
        return this.comChave;
    }


}
