package br.com.helenformighieri.dominio;

public class Certificado {
    private String nomeDev;
    private String nomeBootcamp;

    public Certificado(String nomeDev, String nomeBootcamp) {
        this.nomeDev = nomeDev;
        this.nomeBootcamp = nomeBootcamp;
    }

    public String getNomeDev() {
        return nomeDev;
    }

    public void setNomeDev(String nomeDev) {
        this.nomeDev = nomeDev;
    }

    public String getNomeBootcamp() {
        return nomeBootcamp;
    }

    public void setNomeBootcamp(String nomeBootcamp) {
        this.nomeBootcamp = nomeBootcamp;
    }

    @Override
    public String toString() {
        return "Certificado{" +
                "nomeDev='" + nomeDev + '\'' +
                ", nomeBootcamp='" + nomeBootcamp + '\'' +
                '}';
    }
}