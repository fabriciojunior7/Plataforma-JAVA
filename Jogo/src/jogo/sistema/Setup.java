package jogo.sistema;

import jogo.gui.Janela;
import jogo.logica.Entidade;
import jogo.logica.Jogador;
import jogo.logica.ReplayGuy;
import jogo.sistema.fases.Fase;

import java.util.ArrayList;

public class Setup {

    //VARIAVEIS GLOBAIS
    public static final int FRAMERATE = 60;
    public static final int LADO = 10;
    public static final int LARGURA = 900;
    public static final int ALTURA = 742;

    public static int LARGURAVERDADEIRA = LARGURA;
    public static int ALTURAVERDADEIRA = ALTURA-22;
    public static final float GRAVIDADE = 0.4f;
    public static int faseAtual = 1;
    public static boolean tempoAtivo = false;
    public static long tempoInicial = System.currentTimeMillis();
    public static float ultimoTempo = 0;

    public static ArrayList<int[]> gravacao = new ArrayList<>();
    public static ArrayList<ReplayGuy> replays = new ArrayList<>();
    public static ArrayList<ReplayGuy> replaysDaFase = new ArrayList<>();

    //OBJETOS GLOBAIS
    public static Janela janela = new Janela(LARGURAVERDADEIRA, ALTURAVERDADEIRA);
    public static Jogador jogador;

    public static ArrayList<Entidade> entidades = new ArrayList<>();

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
        replays.add(new ReplayGuy(faseAtual, gravacao));

        faseAtual++;

        resetarReplays();
        entidades = Fase.gerarFase(faseAtual);
        System.out.println(tempoTotal());
    }

    public static void resetarFase(){
        entidades = Fase.gerarFase(faseAtual);
    }

    private static float tempoTotal(){
        float tempoGasto = System.currentTimeMillis() - tempoInicial;
        tempoAtivo = false;
        ultimoTempo = tempoGasto;
        return tempoGasto/1000;
    }

    public static void iniciarTempo(){
        tempoInicial = System.currentTimeMillis();
        tempoAtivo = true;
    }

    public static float tempoAtual(){
        float tempoGasto = System.currentTimeMillis() - tempoInicial;
        return tempoGasto/1000;
    }

    public static void resetarReplays(){
        gravacao = new ArrayList<>();
        replaysDaFase = new ArrayList<>();
        for(ReplayGuy r: replays){
            if(r.getFase() == faseAtual){
                replaysDaFase.add(r);
            }
        }
        for(ReplayGuy r : replaysDaFase){
            r.resetar();
        }
    }

    //METODOS TEMPORARIOS
    public static void CHEATavancarFase(){
        faseAtual++;
        resetarReplays();
        entidades = Fase.gerarFase(faseAtual);
        tempoTotal();
    }

    public static void CHEATvoltarFase(){
        faseAtual--;
        resetarReplays();
        entidades = Fase.gerarFase(faseAtual);
        tempoTotal();
    }

}
