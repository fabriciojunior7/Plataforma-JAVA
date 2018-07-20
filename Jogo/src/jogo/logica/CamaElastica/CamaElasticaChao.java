package jogo.logica.CamaElastica;

import jogo.logica.Entidade;
import jogo.sistema.Setup;

import java.awt.*;

public class CamaElasticaChao extends CamaElastica {

    //CONSTRUTOR
    public CamaElasticaChao(int x, int y){
        super(x, y, -12);
    }

    //METODOS
    @Override
    public void desenhar(Graphics g){
        g.setColor(this.cor);
        g.fillRect(this.x, this.y+((int)Math.floor(Setup.LADO/2.0f)), this.largura, ((int)Math.floor(Setup.LADO/4.0f)));
    }

    //METODOS ESPECIAIS
    public float getElasticidade(){
        return this.elasticidade;
    }


}
