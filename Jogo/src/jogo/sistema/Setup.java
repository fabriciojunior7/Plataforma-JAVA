package jogo.sistema;

import jogo.gui.Janela;
import jogo.logica.Entidade;
import jogo.logica.Jogador;
import jogo.sistema.fases.Fase;

import java.util.ArrayList;

public class Setup {

    //VARIAVEIS GLOBAIS
    public static final int FRAMERATE = 60;
    public static final int LADO = 10;
    public static final int LARGURA = 900;
    public static final int ALTURA = 702;
    public static final int LARGURAVERDADEIRA = LARGURA;
    public static final int ALTURAVERDADEIRA = ALTURA-22;
    public static final float GRAVIDADE = 0.4f;
    public static int faseAtual = 1;

    //OBJETOS GLOBAIS
    public static Janela janela;
    public static Jogador jogador;

    public static ArrayList<Entidade> entidades;

    //METODOS ESTATICOS
    public static void adicionarEntidade(Entidade... listaDeEntidades){
        for(int i=0; i<listaDeEntidades.length; i++){
            if(listaDeEntidades[i] != null){entidades.add(listaDeEntidades[i]);}
        }
    }

    public static void faseInteira(ArrayList<Entidade> faseCompleta){
        entidades = faseCompleta;
    }

    public static void passarDeFase(){
        faseAtual++;
        entidades = Fase.gerarFase(faseAtual);
    }

}
