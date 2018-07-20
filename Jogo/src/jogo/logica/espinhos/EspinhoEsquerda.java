package jogo.logica.espinhos;

import jogo.sistema.Setup;

public class EspinhoEsquerda extends Espinho {

    //CONSTRUTOR
    public EspinhoEsquerda(int x, int y){
        super(x, y, new int[]{(x*Setup.LADO), (x*Setup.LADO)+Setup.LADO, (x*Setup.LADO)}, new int[]{(y*Setup.LADO), (y*Setup.LADO)+Setup.LADO/2, (y*Setup.LADO)+Setup.LADO});
    }

}
