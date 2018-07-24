package jogo.logica.espinhos;

import jogo.logica.Entidade;
import jogo.sistema.Setup;

import java.awt.*;

public class Espinho extends Entidade {

    //ATRIBUTOS
    private int[] xPoly;
    private int[] yPoly;
    private Polygon corpo;

    //CONSTRUTOR
    public Espinho(int x, int y, int[] xPoly, int[] yPoly){
        super(x*Setup.LADO+1, y*Setup.LADO+1, Setup.LADO-2, Setup.LADO-2, Color.red,false);
        this.xPoly = xPoly;
        this.yPoly = yPoly;
        this.corpo = new Polygon(xPoly, yPoly, xPoly.length);
    }

    //METODOS
    @Override
    public void desenhar(Graphics g){
        g.setColor(this.cor);
        g.fillPolygon(this.corpo);
    }

}
