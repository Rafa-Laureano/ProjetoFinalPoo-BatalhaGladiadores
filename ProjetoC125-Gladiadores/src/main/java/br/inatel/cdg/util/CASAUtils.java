package br.inatel.cdg.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import br.inatel.cdg.gladiador.GladiadorEscravo;
import br.inatel.cdg.gladiador.GladiadorGuerreiro;
import br.inatel.cdg.gladiador.GladiadorGladiador;
import br.inatel.cdg.gladiador.GladiadorLendario;

public class CASAUtils {


    public static List<GladiadorEscravo> leEscravoTXT(Path arquivo){

        //LISTA DO TIPO GLADIADOR ESCRAVO
        List<GladiadorEscravo> gladiadorEscravo = new ArrayList<>();


        //TENTA LER O ARQUIVO, CASO NÃO TENHA PRINTA ERRO!
        try {

            List<String> linhas = Files.readAllLines(arquivo);	 //LÊ TODAS AS LINHAS
            linhas.remove(0);									//REMOVE A LINHA ZERO (CABEÇALHO)

            linhas.forEach((linha) ->{							//FOR MEGAZORD

                String[] linhaSplit = linha.split(",");				//QUEBRA NAS VIRGULAS PARA SEPARAR O TEXTO

                if (linhaSplit[2].equals("Escravo")) {				//FILTRO DO TIPO DO GLADIADOR


                    //DIVIDE OS DADOS COM , E PASSA PARA O CONSTRUTOR CRIAR UM NOVO GLADIADOR DO TIPO ESCRAVO
                    gladiadorEscravo.add(new GladiadorEscravo(linhaSplit[1], Integer.parseInt(linhaSplit[3]),
                            Integer.parseInt(linhaSplit[0])));
                }

            });
        } catch (IOException e) {
            System.out.println("Erro no arquivo!");;
        }

        return gladiadorEscravo;		//RETORNA A LISTA DE Gladiadores escravos
    }


    public static List<GladiadorLendario> leLendarioTXT(Path arquivo){

        //LISTA DO TIPO GLADIADOR LENDARIO
        List<GladiadorLendario> gladiadorLendario = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(arquivo);
            linhas.remove(0);

            linhas.forEach((linha) ->{

                String[] linhaSplit = linha.split(",");

                if (linhaSplit[2].equals("Lendario")) {
                    gladiadorLendario.add(new GladiadorLendario(linhaSplit[1], Integer.parseInt(linhaSplit[3]),
                            Integer.parseInt(linhaSplit[0])));
                }

            });
        } catch (IOException e) {
            System.out.println("Erro no arquivo!");;
        }


        return gladiadorLendario;
    }



    public static List<GladiadorGladiador> leGladiadorTXT(Path arquivo){

        List<GladiadorGladiador> gladiadorGladiador = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(arquivo);
            linhas.remove(0);

            linhas.forEach((linha) ->{

                String[] linhaSplit = linha.split(",");

                if (linhaSplit[2].equals("Gladiador")) {
                    gladiadorGladiador.add(new GladiadorGladiador(linhaSplit[1], Integer.parseInt(linhaSplit[3]),
                            Integer.parseInt(linhaSplit[0])));
                }

            });
        } catch (IOException e) {
            System.out.println("Erro no arquivo!");;
        }


        return gladiadorGladiador;
    }



    public static List<GladiadorGuerreiro> leGuerreiroTXT(Path arquivo){

        List<GladiadorGuerreiro> gladiadorGuerreiro = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(arquivo);
            linhas.remove(0);

            linhas.forEach((linha) ->{

                String[] linhaSplit = linha.split(",");

                if (linhaSplit[2].equals("Guerreiro")) {
                    gladiadorGuerreiro.add(new GladiadorGuerreiro(linhaSplit[1], Integer.parseInt(linhaSplit[3]),
                            Integer.parseInt(linhaSplit[0])));
                }

            });
        } catch (IOException e) {
            System.out.println("Erro no arquivo!");;
        }


        return gladiadorGuerreiro;
    }


}
