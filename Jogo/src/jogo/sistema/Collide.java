package jogo.sistema;

import jogo.logica.Entidade;

public class Collide {

    //METODOS ESTATICOS
    public static boolean collideEntidades(Entidade e1, Entidade e2){
        int distX = Math.abs((e1.getX()+e1.getLargura()/2) - (e2.getX()+e2.getLargura()/2));
        int distY = Math.abs((e1.getY()+e1.getAltura()/2) - (e2.getY()+e2.getAltura()/2));
        int distLargura = (int) e1.getLargura()/2 + e2.getLargura()/2;
        int distAltura = (int) e1.getAltura()/2 + e2.getAltura()/2;
        if(distX < distLargura && distY < distAltura){return true;}
        else{return false;}
    }

    public static boolean collidePointEntidade(int x, int y, Entidade e){
        x -= 8;
        y -= 31;
        if(x > e.getX() && x < e.getX()+e.getLargura() && y > e.getY() && y < e.getY()+e.getAltura()){return true;}
        else {return false;}
    }

}
