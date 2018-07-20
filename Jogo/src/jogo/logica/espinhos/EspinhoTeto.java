package jogo.logica.espinhos;

import jogo.sistema.Setup;

public class EspinhoTeto extends Espinho {

    //CONSTRUTOR
    public EspinhoTeto(int x, int y){
        super(x, y, new int[]{(x*Setup.LADO), (x*Setup.LADO)+Setup.LADO/2, (x*Setup.LADO)+Setup.LADO}, new int[]{(y*Setup.LADO), (y*Setup.LADO)+Setup.LADO, (y*Setup.LADO)});
    }

}
