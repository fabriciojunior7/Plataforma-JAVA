package jogo.sistema;

import jogo.logica.Entidade;
import jogo.logica.Jogador;

public class Processos {

    //METODOS ESTATICOS
    public static void processos(){
        //Frames
        Dormir.dormir();

        ///COLISOES COM O JOGADOR
        for(Entidade e : Setup.entidades){
            if(!(e instanceof Jogador)){
                if(e.getFisica() && Collide.collideEntidades(Setup.jogador, e)){
                    Setup.jogador.colidirBloco(e);
                }
            }
        }
    }

}
