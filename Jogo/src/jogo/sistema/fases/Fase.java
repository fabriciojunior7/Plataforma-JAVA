package jogo.sistema.fases;

import jogo.logica.Bloco;
import jogo.logica.Entidade;
import jogo.logica.Jogador;
import jogo.sistema.Setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Fase {

    //METODOS ESTATICOS
    public static ArrayList<Entidade> gerarFase(int fase){

        //Variaveis Necessarias
        ArrayList<Entidade> faseFinal = new ArrayList<>();
        String faseCompleta = carregarFase(fase);
        int x = -1, y = -1;
        Entidade e;
        char letra;

        //Traducao das Letras
        for(int i=0; i<faseCompleta.length(); i++){
            letra = faseCompleta.charAt(i);
            e = traducao(letra, x, y);
            if(letra != '\n' && e != null){
                faseFinal.add(e);
            }
            else if(letra == '\n'){
                x = -1;
                y++;
            }
            x++;
        }

        //Retorno da Fase Completa
        return faseFinal;

    }

    private static String carregarFase(int fase){

        //Variaveis Necessarias
        int i;
        String faseCompleta = "";
        FileInputStream fin = null;

        //Abrindo Arquivo
        try {
            fin = new FileInputStream("src/jogo/sistema/fases/fase"+fase+".fase");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Construindo String
        do{
            i = -1;
            try {
                i = fin.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            faseCompleta += (char) i;
        }while(i != -1);

        //Fechando Leitor de Arquivos
        try {
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Retorno da String
        return faseCompleta;

    }

    private static Entidade traducao(char letra, int x, int y){
        //Decodificando Letras
        if(letra == 'x'){return new Bloco(x, y);}
        else if(letra == 'j'){
            Jogador jogador = new Jogador(x, y);
            Setup.jogador = jogador;
            return jogador;
        }
        else{return null;}
    }

}