package jogo.logica;

import jogo.sistema.Setup;

import java.awt.*;

public class Bloco extends Entidade {

    //CONSTRUTOR
    public Bloco(int x, int y){
        super(x*Setup.LADO, y*Setup.LADO, Setup.LADO, Setup.LADO,true);
    }

}
