package jogo.logica;

import jogo.sistema.Setup;

import java.awt.*;
import java.util.ArrayList;

public class ReplayGuy extends Entidade {

    //ATRIBUTOS
    protected ArrayList<int[]> linhaDoTempo;
    protected int frameAtual, fase, index;

    //CONSTRUTOR
    public ReplayGuy(int fase, ArrayList<int[]> linhaDoTempo, int index){
        super(-Setup.LADO, -Setup.LADO, Setup.LADO, Setup.LADO, new Color(200, 255, 100, 50), false);
        this.linhaDoTempo = linhaDoTempo;
        this.frameAtual = 0;
        this.fase = fase;
        this.index = index;
    }

    //METODOS
    @Override
    public void desenhar(Graphics g){
        g.setColor(this.cor);
        if(this.index<10){g.drawString(this.index+"", this.x+1, this.y-2);}
        else{g.drawString(this.index+"", this.x-3, this.y-2);}
        g.fillRect(this.x, this.y, this.largura, this.altura);
    }

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
