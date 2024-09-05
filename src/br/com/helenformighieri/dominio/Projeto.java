package br.com.helenformighieri.dominio;

public class Projeto extends Conteudo {
    private int dificuldade;

    public Projeto() {
    }

    @Override
    public double calculeXp() {
        return XP_PADRAO * dificuldade;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", dificuldade=" + dificuldade +
                '}';
    }
}