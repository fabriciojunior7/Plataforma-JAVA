package jogo.sistema;

import jogo.logica.Entidade;

import java.awt.*;

public class Draw {

    //METODOS ESTATICOS
    public static void draw(Graphics g){
        grade(g);
        desenharEntidades(g);
    }

    private static void grade(Graphics g){
        g.setColor(new Color(255, 255, 255, 25));
        for(int i=0; i<Setup.LARGURA/10; i++){
            g.drawLine(i*10, 0, i*10, Setup.ALTURA);
        }
        for(int i=0; i<Setup.ALTURA/10; i++){
            g.drawLine(0, i*10, Setup.LARGURA, i*10);
        }
    }

    private static void desenharEntidades(Graphics g){
        for(Entidade e : Setup.entidades){
            e.desenhar(g);
        }
    }

}
