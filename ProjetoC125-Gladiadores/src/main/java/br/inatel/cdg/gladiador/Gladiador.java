package br.inatel.cdg.gladiador;

import java.util.Random;
import br.inatel.cdg.interfaces.Atributos;
import br.inatel.cdg.interfaces.Habilidades;

public abstract class Gladiador implements Habilidades, Atributos {

    protected String nome;
    protected int nivel;
    protected int id_casa;
    protected int vida;
    protected int ataque;
    protected int defesa;

    // CONSTRUTOR DA SUPERCLASSE
    public Gladiador(String nome, int nivel, int id_casa) {
        this.nome = nome;
        this.nivel = nivel;
        this.id_casa = id_casa;

        //ATAQUE - DEFESA SÃO GERADOS DE FORMA ALEATORIA (1 - 50)
        Random rand = new Random();
        this.ataque = rand.nextInt(50) + 1;
        this.defesa = rand.nextInt(50) + 1;
        this.vida = 100;

    }



    //FUNÇÃO RESPONSAVEL EM EVOLUIR O GLADIADOR QUANDO GANHAR A LUTA
    @Override
    public void evoluir(Gladiador casa) {
        int id = casa.getId_casa();

        switch(id) {

            case 74: //Spartacus
                casa.setNome("Evoluiu para varro escravo nivel 2");
                casa.setId_casa(75);
                casa.setNivel(2);
                break;

            case 95: //Nasir
                casa.setNome("Evoluiu para Pietros escravo nivel 2");
                casa.setId_casa(208);
                casa.setNivel(2);
                break;

            case 120: //Gnaeus
                casa.setNome("Evoluiu para The Egipcio guerreiro nivel 2");
                casa.setId_casa(121);
                casa.setNivel(2);
                break;

            case 118: //Priscus
                casa.setNome("Evoluiu para Verus guerreiro nivel 2");
                casa.setId_casa(119);
                casa.setNivel(2);
                break;

            case 25: //Carpoforo
                casa.setNome("Evoluiu para Flamma gladiador nivel 3");
                casa.setId_casa(26);
                casa.setNivel(3);
                break;

            case 125: //Oenomaus
                casa.setNome("Evoluiu para Segovax gladiador nivel 3");
                casa.setId_casa(466);
                casa.setNivel(3);
                break;

            case 114: //Doctore
                casa.setNome("Evoluiu para Barca lendário nivel 2");
                casa.setId_casa(465);
                casa.setNivel(2);
                break;

            case 70: //Gannicus
                casa.setNome("Evoluiu para Criso lendario tipo 3");
                casa.setId_casa(71);
                casa.setNivel(3);
                break;

        }
    }



    //FUNÇÃO RESPONSAVEL POR CAUSAR DANO A UM GLADIADOR QUANDO O MESMO FOR ATACADO
    @Override
    public void tomarDano(Gladiador gladiador, int dano) {
        gladiador.vida -= dano;

    }



    // Getters

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getId_casa() {
        return id_casa;
    }

    public int getNivel() {
        return nivel;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }


    //Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
