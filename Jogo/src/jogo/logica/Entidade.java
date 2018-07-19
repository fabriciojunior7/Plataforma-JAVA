package jogo.logica;

import jogo.sistema.Setup;

import javax.swing.*;
import java.awt.*;

public class Entidade {

    //ATRIBUTOS
    protected int x;
    protected int y;
    protected int largura;
    protected int altura;
    protected Color cor;
    protected ImageIcon imagem;
    protected boolean fisica;

    //CONSTRUTORES
    public Entidade(int x, int y, int largura, int altura){
        this.setX(x);
        this.setY(y);
        this.setLargura(largura);
        this.setAltura(altura);
        this.setCor(Color.white);
        this.setFisica(false);
    }

    public Entidade(int x, int y, int largura, int altura, boolean fisica){
        this.setX(x);
        this.setY(y);
        this.setLargura(largura);
        this.setAltura(altura);
        this.setCor(Color.white);
        this.setFisica(fisica);
    }

    public Entidade(int x, int y, int largura, int altura, Color cor){
        this.setX(x);
        this.setY(y);
        this.setLargura(largura);
        this.setAltura(altura);
        this.setCor(cor);
        this.setFisica(false);
    }

    public Entidade(int x, int y, int largura, int altura, Color cor, boolean fisica){
        this.setX(x);
        this.setY(y);
        this.setLargura(largura);
        this.setAltura(altura);
        this.setCor(cor);
        this.setFisica(fisica);
    }

    public Entidade(int x, int y, int largura, int altura, ImageIcon imagem){
        this.setX(x);
        this.setY(y);
        this.setLargura(largura);
        this.setAltura(altura);
        this.setCor(Color.white);
        this.setImagem(imagem);
        this.setFisica(false);
    }

    public Entidade(int x, int y, int largura, int altura, ImageIcon imagem, boolean fisica){
        this.setX(x);
        this.setY(y);
        this.setLargura(largura);
        this.setAltura(altura);
        this.setCor(Color.white);
        this.setImagem(imagem);
        this.setFisica(fisica);
    }

    //METODOS
    public void desenhar(Graphics g){
        g.setColor(this.cor);
        g.fillRect(this.x, this.y, this.largura, this.altura);
    }

    public void vibrar(){
        this.setX(this.getX() + (int) (Math.random() * 2 - 1));
        this.setY(this.getY() + (int) (Math.random() * 2 - 1));
    }

    public void checarPosicao(){
        //Eixo X
        if(this.x < 0){this.x = 0;}
        else if(this.x > Setup.LARGURAVERDADEIRA-this.largura){this.x = Setup.LARGURAVERDADEIRA-this.largura;}
        //Eixo Y
        if(this.y < 0){this.y = 0;}
        else if(this.y > Setup.ALTURAVERDADEIRA-this.altura){this.y = Setup.ALTURAVERDADEIRA-this.altura;}
    }

    //METODOS ESPECIAIS
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargura() {
        return this.largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Color getCor() {
        return this.cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public ImageIcon getImagem() {
        return this.imagem;
    }

    public void setImagem(ImageIcon imagem) {
        this.imagem = imagem;
    }

    public boolean getFisica(){
        return this.fisica;
    }

    public void setFisica(boolean fisica){
        this.fisica = fisica;
    }

}
