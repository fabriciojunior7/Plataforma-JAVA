package jogo.sistema;

import jogo.logica.Bloco;

import javax.swing.event.MouseInputListener;
import java.awt.event.*;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener, MouseInputListener {

    //METODOS OVERRIDE
    @Override
    public void mouseClicked(MouseEvent mouse) {
        Setup.adicionarEntidade(new Bloco((int)(mouse.getX()/Setup.LADO), (int)((mouse.getY()-25)/Setup.LADO)));
    }

    @Override
    public void mousePressed(MouseEvent mouse) {

    }

    @Override
    public void mouseReleased(MouseEvent mouse) {

    }

    @Override
    public void mouseEntered(MouseEvent mouse) {

    }

    @Override
    public void mouseExited(MouseEvent mouse) {

    }

    @Override
    public void mouseDragged(MouseEvent mouse) {

    }

    @Override
    public void mouseMoved(MouseEvent mouse) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouse) {

    }
}
