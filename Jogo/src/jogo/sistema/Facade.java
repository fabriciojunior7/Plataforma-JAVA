package jogo.sistema;

import jogo.gui.Janela;
import jogo.sistema.fases.Fase;

import java.util.ArrayList;

public class Facade {

    public void rodarJogo(){
        Setup.faseInteira(Fase.gerarFase(Setup.faseAtual));
        while(true){Processos.processos();}
    }

}
