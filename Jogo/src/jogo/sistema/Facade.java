package jogo.sistema;

import jogo.gui.Janela;
import jogo.logica.Entidade;
import jogo.logica.Jogador;
import jogo.sistema.fases.Fase;

import java.util.ArrayList;

public class Facade {

    public void novaJanela(){
        Setup.janela = new Janela(Setup.LARGURA, Setup.ALTURA);
        Setup.entidades = new ArrayList<>();
    }

    public void rodarJogo(){
        Setup.faseInteira(Fase.gerarFase(Setup.faseAtual));
        while(true){Processos.processos();}
    }

}
