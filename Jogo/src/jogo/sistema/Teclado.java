package jogo.sistema;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

    //METODOS OVERRIDE
    @Override
    public void keyTyped(KeyEvent key) {

    }

    @Override
    public void keyPressed(KeyEvent key) {
        Setup.jogador.botaoPressionado(key.getKeyCode());

        //ATIVAR TEMPO
        if(!Setup.tempoAtivo){Setup.iniciarTempo();}

        //METODOS TEMPORARIOS
        if(key.getKeyChar() == '<'){Setup.CHEATvoltarFase();}
        else if(key.getKeyChar() == '>'){Setup.CHEATavancarFase();}
    }

    @Override
    public void keyReleased(KeyEvent key) {
        Setup.jogador.botaoSolto(key.getKeyCode());
    }
}
