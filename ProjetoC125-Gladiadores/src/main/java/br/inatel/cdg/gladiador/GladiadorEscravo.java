package br.inatel.cdg.gladiador;

public class GladiadorEscravo extends Gladiador {

    public GladiadorEscravo(String nome, int nivel, int id_casa) {
        super(nome, nivel, id_casa);

        calculaAtaque();
        calculaDefesa();
        calculaVida();
    }


    //-----------------------------------------------------------------------------------
    //Metodos para recalcular as caracteristicas do Gladiador, com base no seu tipo

    @Override
    public void calculaAtaque() {
        this.ataque += this.nivel * 4;
    }

    @Override
    public void calculaDefesa() {
        this.defesa += this.nivel * 5;
    }

    @Override
    public void calculaVida() {
        this.vida += (this.nivel - 1) * 10;
    }

    //-----------------------------------------------------------------------------------

}