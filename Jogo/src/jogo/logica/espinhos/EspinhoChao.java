package jogo.logica.espinhos;

import jogo.sistema.Setup;

public class EspinhoChao extends Espinho {

    //CONSTRUTOR
    public EspinhoChao(int x, int y){
        super(x, y, new int[]{(x*Setup.LADO), (x*Setup.LADO)+Setup.LADO/2, (x*Setup.LADO)+Setup.LADO}, new int[]{(y*Setup.LADO)+Setup.LADO, (y*Setup.LADO), (y*Setup.LADO)+Setup.LADO});
    }

}
