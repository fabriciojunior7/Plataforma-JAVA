package jogo.logica.CamaElastica;

import jogo.logica.Entidade;
import jogo.sistema.Setup;

import java.awt.*;

public class CamaElastica extends Entidade {

    //ATRIBUTOS
    protected float elasticidade;

    //CONSTRUTOR
    public CamaElastica(int x, int y, float elasticidade){
        super(x*Setup.LADO, y*Setup.LADO, Setup.LADO, Setup.LADO, Color.cyan, false);
        this.elasticidade = elasticidade;
    }

    //METODOS ESPECIAIS
    public float getElasticidade(){
        return this.elasticidade;
    }


}
