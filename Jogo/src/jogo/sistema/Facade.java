package jogo.sistema;

import jogo.sistema.fases.Fase;

public class Facade {

    public void rodarJogo(){
        Setup.faseInteira(Fase.gerarFase(Setup.faseAtual));
        while(true){Processos.processos();}
    }

}
