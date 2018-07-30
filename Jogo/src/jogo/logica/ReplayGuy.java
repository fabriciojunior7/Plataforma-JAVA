package jogo.logica;

import jogo.sistema.Setup;

import java.awt.*;
import java.util.ArrayList;

public class ReplayGuy extends Entidade {

    //ATRIBUTOS
    protected ArrayList<int[]> linhaDoTempo;
    protected int frameAtual, fase;

    //CONSTRUTOR
    public ReplayGuy(int fase, ArrayList<int[]> linhaDoTempo){
        super(-Setup.LADO, -Setup.LADO, Setup.LADO, Setup.LADO, new Color(200, 255, 100, 50), false);
        this.linhaDoTempo = linhaDoTempo;
        this.frameAtual = 0;
        this.fase = fase;
    }

    //METODOS
    public void mover(){
        this.x = this.linhaDoTempo.get(this.frameAtual)[0];
        this.y = this.linhaDoTempo.get(this.frameAtual)[1];
        this.frameAtual++;
        if(this.frameAtual >= this.linhaDoTempo.size()){this.frameAtual = this.linhaDoTempo.size()-1;}
    }

    public void resetar(){
        this.frameAtual = 0;
    }

    //METODOS ESPECIAIS
    public int getFase(){
        return this.fase;
    }


}
