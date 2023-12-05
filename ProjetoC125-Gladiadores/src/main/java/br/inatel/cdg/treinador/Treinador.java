package br.inatel.cdg.treinador;
import br.inatel.cdg.gladiador.Gladiador;

public class Treinador  {

    private String nome;
    private String arena;
    private int qtdGladiador;
    private Gladiador gladiadores[];


    //CONSTRUTOR
    public Treinador(String nome, String cidade, int qtdGladiador) {

        this.nome = nome;
        this.arena = cidade;
        this.qtdGladiador = qtdGladiador;
        this.gladiadores = new Gladiador[this.qtdGladiador];

    }




    //ADICIONA GLADIADORES AO TREINADOR
    public void addGladiador (Gladiador casa) {
        for(int i = 0; i < gladiadores.length ; i++) {
            if(this.gladiadores[i] == null) {
                this.gladiadores[i] = casa;
                break;
            }
        }
    }



    //MOSTRA O TREINADOR E SEUS RESPECTIVOS GLADIADORES
    public void mostraGladiadores (Treinador treinador_x) {
        System.out.println("Gladiadores do treinador: " + treinador_x.getNome());

        for (Gladiador casas : treinador_x.gladiadores) {

            try {
                System.out.println("Gladiador: " + casas.getNome() + " - ID Casa: " + casas.getId_casa());
                System.out.println("Vida: " + casas.getVida() + " Ataque: " + casas.getAtaque() + " Defesa: " + casas.getDefesa());

            } catch (NullPointerException e) {
                System.out.println("Nao existe Gladiador nessa posicao");
            }
        }
        System.out.println("");	// PULA LINHA
    }





    //Getters
    public String getArena() {
        return arena;
    }
    public String getNome() {
        return nome;
    }

    public Gladiador getGladiadores(int i) {
        return gladiadores[i];
    }




}
