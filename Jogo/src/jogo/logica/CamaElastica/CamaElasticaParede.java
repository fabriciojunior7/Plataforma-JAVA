package jogo.logica.CamaElastica;

import jogo.logica.Entidade;
import jogo.sistema.Setup;

import java.awt.*;

public class CamaElasticaParede extends CamaElastica {

    //CONSTRUTOR
    public CamaElasticaParede(int x, int y){
        super(x, y, 10);
    }

    //METODOS
    @Override
    public void desenhar(Graphics g){
        g.setColor(this.cor);
        g.fillRect(this.x+((int)Math.floor(Setup.LADO/2.0f))-1, this.y, ((int)Math.floor(Setup.LADO/4.0f)), this.altura);
    }

    //METODOS ESPECIAIS
    public float getElasticidade(){
        return this.elasticidade;
    }


}
