package jogo.logica;

import jogo.sistema.Setup;

import java.awt.*;

public class Portal extends Entidade {

    //ATRIBUTOS
    private int tickCor;

    //CONSTRUTOR
    public Portal(int x, int y){
        super(x*Setup.LADO, y*Setup.LADO, (int)(Setup.LADO*1.3), (int)(Setup.LADO*3), Color.pink, false);
        this.tickCor = 0;
    }

    //METODOS
    @Override
    public void desenhar(Graphics g){
        int r = (int)(Math.random()*181);
        g.setColor(new Color(75+r, 0, 75+r));
        g.fillOval(this.x-(int)(Setup.LADO*0.1), this.y-(int)(Setup.LADO*2), this.largura, this.altura);

    }

    @Override
    public boolean equals(Object p){
        final Portal pp = (Portal) p;

        if(p == null){return false;}
        if(this.x == pp.getX() && this.y == pp.getY()){return true;}
        else{return false;}
    }

    public void atravessarPortal(){
        //Localizar Portais
        Portal outroPortal = null;
        for(Entidade e : Setup.entidades){
            if(e instanceof Portal && !this.equals(e)){
                outroPortal = (Portal) e; break;
            }
        }

        //Teletransportar Jogador
        if(!Setup.jogador.getColidindoPortal()){
            Setup.jogador.setColidindoPortal(true);
            Setup.jogador.teletransporta(outroPortal.getX(), outroPortal.getY());
        }
    }

}
