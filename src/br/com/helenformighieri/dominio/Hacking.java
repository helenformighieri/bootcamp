package br.com.helenformighieri.dominio;

public class Hacking extends Conteudo {
    private int nivel;

    public Hacking() {
    }

    @Override
    public double calculeXp() {
        return XP_PADRAO * nivel * 2;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Hacking{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}