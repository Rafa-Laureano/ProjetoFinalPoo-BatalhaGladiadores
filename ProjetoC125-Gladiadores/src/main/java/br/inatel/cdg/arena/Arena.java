package br.inatel.cdg.arena;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

//import org.junit.Test;

import br.inatel.cdg.gladiador.Gladiador;
import br.inatel.cdg.treinador.Treinador;


public class Arena {


    Path arquivo = Paths.get("duelos.txt");

    private int num_rounds = 1;


    // MENSAGEM PRINTADA ANTES DE INICIAR A LUTA
    public static void screen() {
        System.out.println("BEM VINDOS A BATALHA DE GLADIADORES!!!");
        System.out.println();
    }


    //INICIA A BATALHA, MOSTRANDO OS DETALHES DA LUTA E DEPOIS CHAMA A FUNÇÃO LUTAR
    public void iniciarBatalha(Treinador t1, Gladiador atacando, Treinador t2, Gladiador defendendo) {

        Random rand = new Random();
        int arena = rand.nextInt(2) + 1;

        if(arena == 1) {

            //PRINTA NO CONSOLE
            String arena1 = "Iniciando batalha no " + t1.getArena();
            System.out.println(arena1);

            //ESCREVE NO ARQUIVO INICIO DE CADA LUTA COM O NOME DO GINASIO
            try {
                Files.writeString(arquivo, arena1 + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        else {

            //PRINTA NO CONSOLE
            String arena2 = "Iniciando batalha no " + t2.getArena();
            System.out.println(arena2);


            //ESCREVE NO ARQUIVO INICIO DE CADA LUTA COM O NOME DO GINASIO
            try {
                Files.writeString(arquivo, arena2 + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //PRINTA NO CONSOLE OS 2 TREINADORES E SEUS GLADIADORES QUE IRÃO LUTAR
        System.out.println( t1.getNome() + " x " + t2.getNome());
        System.out.println(atacando.getNome() + " x " + defendendo.getNome());


        //ARMAZENA O CONTEUDO QUE VAI SER ESCRITO NO ARQUIVO DENTRO DE STRINGS
        String trainers = t1.getNome() + " x " + t2.getNome();
        String pokes = atacando.getNome() + " x " + defendendo.getNome();


        //ESCREVE NO ARQUIVO
        try {
            Files.writeString(arquivo, trainers + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.writeString(arquivo, pokes + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //CHAMANDO O METODO PRIVADO PARA REALIZAR A LUTA
        lutar(atacando, defendendo);


    }

    //REALIZA O COMBATE ENTRE OS GLADIADORES
    private void lutar(Gladiador atacando, Gladiador defendendo) {

        //ENQUANTO A VIDA DOS DOIS GLADIADORES POSSUIREM VIDA ( VIDA > 0 )
        while (atacando.getVida() > 0 && defendendo.getVida() > 0) {


            // SE AS DEFESAS FOREM MAIORES QUE OS PODERES DE ATAQUE
            if (atacando.getAtaque() < defendendo.getDefesa() && defendendo.getAtaque() < atacando.getDefesa()) {
                System.out.println("As Defesas de ambos os Gladiadores são maiores que seus poderes de Ataque");

                // ESCREVE NO ARQUIVO QUE AS DEFESAS SÃO MAIORES QUE OS PODERES DE ATAQUE
                try {
                    Files.writeString(arquivo, "As Defesas de ambos os Gladiadores são maiores que seus poderes de Ataque \n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    Files.writeString(arquivo, " " + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);		//PULA LINHA
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // SAI DO WHILE UTILIZANDO O BREAK
                break;
            }

            else {

                // PRINTA EM QUAL ROUND SE ENCONTRA A BATALHA
                System.out.println("Round " + num_rounds);

                if (atacando.getAtaque() > defendendo.getDefesa()) {
                    defendendo.tomarDano(defendendo, Math.abs((defendendo.getDefesa()) - atacando.getAtaque()));
                    System.out.println(defendendo.getNome() + " tomou "
                            + (atacando.getAtaque() - defendendo.getDefesa()) + " de dano");
                } else {
                    System.out.println("Ataque do " + atacando.getNome() + " sem efeito! Defesa maior que o dano de ataque");
                }

                // QUEM ATACOU PRIMEIRO, EM SEGUIDA É ATACADO

                if (defendendo.getAtaque() > atacando.getDefesa()) {
                    atacando.tomarDano(atacando, Math.abs((atacando.getDefesa()) - defendendo.getAtaque()));
                    System.out.println(atacando.getNome() + " tomou " + (defendendo.getAtaque() - atacando.getDefesa())
                            + " de dano");
                } else {
                    System.out.println("Ataque do " + defendendo.getNome() + " sem efeito! Defesa maior que o dano de ataque");
                }


                // SE APÓS UM DETERMINADO ROUND A VIDA DE ALGUM GLADIADOR SE TORNE NEGATIVA ELA É SETADA PARA ZERO
                if (defendendo.getVida() < 0)
                    defendendo.setVida(0);
                else if (atacando.getVida() < 0)
                    atacando.setVida(0);



                System.out.println("Vida dos Gladiadores após o " + num_rounds + "° round");
                System.out.println(atacando.getNome() + " hp: " + atacando.getVida());
                System.out.println(defendendo.getNome() + " hp: " + defendendo.getVida());
                System.out.println("");	//pula linha

                num_rounds ++;

            }

        }

        // APOS SAIR DO WHILE RETORNA O cont DO N° DE ROUNDS DE VOLTA PARA 1
        num_rounds = 1;


        //GLADIADOR DEFENDENDO PERDEU A BATALHA
        if (defendendo.getVida() <= 0) {

            //SALVA O CONTEUDO QUE SERÁ ESCRITO NO ARQUIVO DENTRO DE STRINGS
            String temp1 = "O Gladiador " + defendendo.getNome() + " perdeu a batalha!";
            String evo1 = "O Gladiador " + atacando.getNome() + " evolui para ";



            //PRINTA NO CONSOLE
            System.out.println("O Gladiador " + defendendo.getNome() + " perdeu a batalha!");
            System.out.println("O Gladiador " + atacando.getNome() + " evoluiu");
            atacando.evoluir(atacando);
            System.out.println("Gladiador: " + atacando.getNome() + " apos batalha");


            //SALVA O CONTEUDO QUE SERÁ ESCRITO NO ARQUIVO DENTRO DE STRING
            String evo2 = atacando.getNome();


            //ESCREVE NO ARQUIVO
            try {
                Files.writeString(arquivo, temp1 + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                Files.writeString(arquivo, evo1 + evo2 + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                Files.writeString(arquivo, " " + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);		//PULA LINHA
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        //GLADIADOR ATACANDO PERDEU A BATALHA
        else if (atacando.getVida() <= 0) {

            //SALVA O CONTEUDO QUE SERÁ ESCRITO NO ARQUIVO DENTRO DE STRINGS
            String temp = "O Gladiador " + atacando.getNome() + " perdeu a batalha!";
            String evo1 = "O Gladiador " + defendendo.getNome() + " evolui para ";


            //PRINTA NO CONSOLE
            System.out.println("O Gladiador " + atacando.getNome() + " perdeu a batalha!");
            System.out.println("O Gladiador " + defendendo.getNome() + " evoluiu");
            defendendo.evoluir(defendendo);
            System.out.println("Gladiador: " + defendendo.getNome() + " apos batalha");


            //SALVA O CONTEUDO QUE SERÁ ESCRITO NO ARQUIVO DENTRO DE STRING
            String evo2 = defendendo.getNome();


            //ESCREVE NO ARQUIVO
            try {
                Files.writeString(arquivo, temp + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                Files.writeString(arquivo, evo1 + evo2 + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                Files.writeString(arquivo, " " + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);		//PULA LINHA
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        System.out.println(""); //PULA LINHA

    }

}