package jogo.sistema;

import jogo.logica.Entidade;
import jogo.logica.Jogador;

public class Processos {

    //METODOS ESTATICOS
    public static void processos(){
        //Frames
        Dormir.dormir();

        ///Colisoes com o Jogador
        for(Entidade e : Setup.entidades){
            if(!(e instanceof Jogador)){
                boolean hit = Collide.collideEntidades(Setup.jogador, e);
                if(hit){Setup.jogador.colidirComEntidade(e);}
            }
        }
        Setup.jogador.checarPortais();
    }

}
