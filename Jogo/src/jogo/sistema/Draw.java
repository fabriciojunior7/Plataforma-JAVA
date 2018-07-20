package jogo.sistema;

import jogo.logica.Entidade;
import jogo.logica.Jogador;

import java.awt.*;

public class Draw {

    //METODOS ESTATICOS
    public static void draw(Graphics g){
        grade(g);
        desenharEntidades(g);
    }

    private static void grade(Graphics g){
        g.setColor(new Color(255, 255, 255, 20));
        for(int i=0; i<Setup.LARGURA/10; i++){
            g.drawLine(i*Setup.LADO, 0, i*Setup.LADO, Setup.ALTURA);
        }
        for(int i=0; i<Setup.ALTURA/10; i++){
            g.drawLine(0, i*Setup.LADO, Setup.LARGURA, i*Setup.LADO);
        }
    }

    private static void desenharEntidades(Graphics g){
        for(Entidade e : Setup.entidades){
            if(!(e instanceof Jogador)){e.desenhar(g);}
        }
        if(Setup.jogador != null){Setup.jogador.desenhar(g);}
    }

}
