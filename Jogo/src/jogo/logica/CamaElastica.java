package jogo.logica;

import jogo.sistema.Setup;

import java.awt.*;

public class CamaElastica extends Entidade {

    //ATRIBUTOS
    private float elasticidade;

    //CONSTRUTOR
    public CamaElastica(int x, int y){
        super(x*Setup.LADO, y*Setup.LADO+((int)Math.ceil(Setup.LADO/2.0)), Setup.LADO, (int) Math.floor(Setup.LADO/4.0), Color.cyan, false);
        this.elasticidade = -12;
    }

    //METODOS
    public void pular(){

    }

    //METODOS ESPECIAIS
    public float getElasticidade(){
        return this.elasticidade;
    }


}
