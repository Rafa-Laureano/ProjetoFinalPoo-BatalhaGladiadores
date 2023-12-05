package br.inatel.cdg.gladiador;

public class GladiadorGladiador extends Gladiador {

    public GladiadorGladiador(String nome, int nivel, int id_pokedex) {
        super(nome, nivel, id_pokedex);

        calculaAtaque();
        calculaDefesa();
        calculaVida();
    }




    //-----------------------------------------------------------------------------------
    //Metodos para recalcular as caracteristicas do Gladiador, com base no seu tipo

    @Override
    public void calculaAtaque() {
        this.ataque += this.nivel * 6;
    }

    @Override
    public void calculaDefesa() {
        this.defesa += this.nivel * 4;
    }

    @Override
    public void calculaVida() {
        this.vida += (this.nivel - 1) * 10;
    }

    //-----------------------------------------------------------------------------------

}
