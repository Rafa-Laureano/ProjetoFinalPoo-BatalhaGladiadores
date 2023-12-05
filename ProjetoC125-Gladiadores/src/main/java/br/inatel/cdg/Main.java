package br.inatel.cdg;


import br.inatel.cdg.arena.Arena;
import br.inatel.cdg.gladiador.GladiadorEscravo;
import br.inatel.cdg.gladiador.GladiadorGuerreiro;
import br.inatel.cdg.gladiador.GladiadorGladiador;
import br.inatel.cdg.gladiador.GladiadorLendario;
import br.inatel.cdg.treinador.Treinador;
import br.inatel.cdg.util.CASAUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {



    public static void main(String[] args) {


        //ARQUIVO TXT COM OS Gladiadores A SEREM CRIADOS

        Path arquivotxt = Paths.get("gladiadores.txt");


        //Array de treinadores de tamanho 4
        Treinador t [] = new Treinador [4];

        // NOME,Arena, QUANTIDADE DE GLADIADORES
        t [0] = new Treinador("Batiatus","Arena de Pula", 2);
        t [1] = new Treinador("Claudius Glaber","Arena de Capua", 2);
        t [2] = new Treinador("Tiberius","Arena de Arles", 2);
        t [3] = new Treinador("Varinius","Arena de El Djem", 2);


        //INSTNANCIA DE ARENA PARA INVOCAR OPERAÇÕES SCREEN E COMBATE
        Arena arena = new Arena();


        //CRIA 4 LISTAS DE GLADIADORES, ADICIONA OS GLADIADORES DE CADA TIPO DENTRO DE SUA LISTA UTILIZANDO A CLASSE CASAUtils
        List<GladiadorEscravo> gladiadorEscravo = CASAUtils.leEscravoTXT(arquivotxt);
        List<GladiadorGladiador> gladiadorGladiador = CASAUtils.leGladiadorTXT(arquivotxt);
        List<GladiadorGuerreiro> gladiadorGuerreiro = CASAUtils.leGuerreiroTXT(arquivotxt);
        List<GladiadorLendario> gladiadorLendario = CASAUtils.leLendarioTXT(arquivotxt);


        //ADD OS Gladiadores Escravos AO TREINADOR  t[0] - Batiatus
        for(GladiadorEscravo gladiador:gladiadorEscravo) {
            if (gladiador.getId_casa() == 74) {
                t[0].addGladiador(gladiador);
            }
            else if (gladiador.getId_casa() == 95) {
                t[0].addGladiador(gladiador);
            }
        }


        //ADD OS Gladiadores Guerreiros AO TREINADOR t[1] - Claudius Glaber
        for(GladiadorGuerreiro gladiador:gladiadorGuerreiro) {
            if (gladiador.getId_casa() == 118) {
                t[1].addGladiador(gladiador);
            }
            else if (gladiador.getId_casa() == 120) {
                t[1].addGladiador(gladiador);
            }
        }

        //ADD OS Gladiadores do tipo Gladiador AO TREINADOR t[2] - Tiberius
        for(GladiadorGladiador gladiador:gladiadorGladiador) {
            if (gladiador.getId_casa() == 125) {
                t[2].addGladiador(gladiador);
            }
            else if (gladiador.getId_casa() == 25) {
                t[2].addGladiador(gladiador);
            }
        }

        //ADD OS Gladiadores Lendarios AO TREINADOR t[3] - Varinius
        for(GladiadorLendario gladiador:gladiadorLendario) {
            if (gladiador.getId_casa() == 70) {
                t[3].addGladiador(gladiador);
            }
            else if (gladiador.getId_casa() == 114) {
                t[3].addGladiador(gladiador);
            }
        }



        //PRINTA A MENSAGEM DE BATALHA DE GLADIADORES
        Arena.screen();


        // MOSTRA INFO DE TODOS OS GLADIADORES DO TREINADOR DESEJADO
        t[0].mostraGladiadores(t[0]);
        t[1].mostraGladiadores(t[1]);
        t[2].mostraGladiadores(t[2]);
        t[3].mostraGladiadores(t[3]);




        //PASSA O TREINADOR 1 E 2 E SEUS GLADIADORES PARA INICIAR A BATALHA
        arena.iniciarBatalha(t[0], t[0].getGladiadores(0), t[1], t[1].getGladiadores(0));
        arena.iniciarBatalha(t[1], t[1].getGladiadores(1), t[2], t[2].getGladiadores(0));
        arena.iniciarBatalha(t[2], t[2].getGladiadores(1), t[3], t[3].getGladiadores(0));














    }

}