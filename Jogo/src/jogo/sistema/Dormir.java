package jogo.sistema;

public class Dormir {

    //METODOS ESTATICOS
    public static void dormir(){
        try {
            Thread.sleep((int) (1000/Setup.FRAMERATE));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
