package br.com.helenformighieri.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calculeXp).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(getNome(), dev.getNome()) &&
                Objects.equals(getConteudosInscritos(), dev.getConteudosInscritos()) &&
                Objects.equals(getConteudosConcluidos(), dev.getConteudosConcluidos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getConteudosInscritos(), getConteudosConcluidos());
    }

    public void inscreverProjeto(Projeto projeto) {
        this.conteudosInscritos.add(projeto);
    }

    public void concluirProjeto() {
        Optional<Conteudo> projeto = this.conteudosInscritos.stream()
                .filter(conteudo -> conteudo instanceof Projeto)
                .findFirst();
        if (projeto.isPresent()) {
            this.conteudosConcluidos.add(projeto.get());
            this.conteudosInscritos.remove(projeto.get());
        } else {
            System.err.println("Você não está inscrito em nenhum projeto");
        }
    }

    public void inscreverHacking(Hacking hacking) {
        this.conteudosInscritos.add(hacking);
    }

    public void concluirHacking() {
        Optional<Conteudo> hacking = this.conteudosInscritos.stream()
                .filter(conteudo -> conteudo instanceof Hacking)
                .findFirst();
        if (hacking.isPresent()) {
            this.conteudosConcluidos.add(hacking.get());
            this.conteudosInscritos.remove(hacking.get());
        } else {
            System.err.println("Você não está inscrito em nenhuma atividade de hacking");
        }
    }

    public Certificado emitirCertificado(Bootcamp bootcamp) {
        if (this.conteudosConcluidos.containsAll(bootcamp.getConteudos())) {
            return new Certificado(this.nome, bootcamp.getNome());
        } else {
            System.err.println("Você não concluiu todos os conteúdos do bootcamp");
            return null;
        }
    }
}