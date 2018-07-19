package jogo.gui;

import jogo.sistema.Dormir;
import jogo.sistema.Draw;
import jogo.sistema.Mouse;
import jogo.sistema.Teclado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JPanel {

    //ATRIBUTOS
    private JFrame tela;
    private int LARGURA;
    private int ALTURA;
    private Teclado teclado;
    private Mouse mouse;

    //CONSTRUTOR
    public Janela(int largura, int altura){
        super();
        this.teclado = new Teclado();
        this.mouse = new Mouse();
        this.tela = new JFrame("Meu Primeiro JOGO!");
        this.LARGURA = largura;
        this.ALTURA = altura;
        this.tela.setSize(this.LARGURA, this.ALTURA);
        this.tela.setVisible(true);
        this.tela.setLocationRelativeTo(null);
        this.tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.tela.setResizable(false);
        this.tela.setBackground(Color.black);
        this.tela.add(this);
        this.tela.revalidate();
        this.tela.addKeyListener(teclado);
        this.tela.addMouseListener(this.mouse);
        this.tela.addMouseMotionListener(this.mouse);
        this.tela.addMouseWheelListener(this.mouse);
    }

    //METODOS OVERRIDE
    @Override
    public void paintComponent(Graphics g){
        Dormir.dormir();
        g.setColor(Color.black);
        g.fillRect(0,0, this.LARGURA, this.ALTURA);
        Draw.draw(g);
        this.repaint();
    }

}
