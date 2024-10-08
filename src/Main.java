import br.com.helenformighieri.dominio.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Curso> cursos = configurarCursos();
        List<Mentoria> mentorias = configurarMentorias();
        List<Projeto> projetos = configurarProjetos();
        List<Hacking> hackings = configurarHackings();

        Bootcamp bootcamp = configurarBootcamp(cursos, mentorias, projetos, hackings);

        Dev dev = configurarDev("Helen", bootcamp);

        System.out.println("Inscrito: " + dev.getConteudosInscritos());
        dev.progredir();
        dev.concluirProjeto();
        dev.concluirHacking();
        System.out.println("Concluidos: " + dev.getConteudosConcluidos());
        System.out.println("Total XP: " + dev.calcularTotalXp());

        Certificado certificado = dev.emitirCertificado(bootcamp);
        if (certificado != null) {
            System.out.println("Certificado emitido: " + certificado);
        }
    }

    private static List<Curso> configurarCursos() {
        Curso curso1 = new Curso();
        curso1.setTitulo("Java Básico");
        curso1.setDescricao("Descrição do curso de Java Básico");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Typescript Básico");
        curso2.setDescricao("Descrição do curso de Typescript Básico");
        curso2.setCargaHoraria(5);

        return List.of(curso1, curso2);
    }

    private static List<Mentoria> configurarMentorias() {
        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Spring Boot");
        mentoria1.setDescricao("Descrição da mentoria de Spring Boot");
        mentoria1.setData(LocalDate.now());

        Mentoria mentoria2 = new Mentoria();
        mentoria2.setTitulo("Angular");
        mentoria2.setDescricao("Descrição da mentoria de Angular");
        mentoria2.setData(LocalDate.now());

        return List.of(mentoria1, mentoria2);
    }

    private static List<Projeto> configurarProjetos() {
        Projeto projeto1 = new Projeto();
        projeto1.setTitulo("Projeto Java Avançado");
        projeto1.setDescricao("Descrição do projeto de Java Avançado");
        projeto1.setDificuldade(3);

        Projeto projeto2 = new Projeto();
        projeto2.setTitulo("Projeto Angular Avançado");
        projeto2.setDescricao("Descrição do projeto de Angular Avançado");
        projeto2.setDificuldade(4);

        return List.of(projeto1, projeto2);
    }

    private static List<Hacking> configurarHackings() {
        Hacking hacking1 = new Hacking();
        hacking1.setTitulo("Hacking Básico");
        hacking1.setDescricao("Descrição da atividade de Hacking Básico");
        hacking1.setNivel(2);

        Hacking hacking2 = new Hacking();
        hacking2.setTitulo("Hacking Avançado");
        hacking2.setDescricao("Descrição da atividade de Hacking Avançado");
        hacking2.setNivel(5);

        return List.of(hacking1, hacking2);
    }

    private static Bootcamp configurarBootcamp(List<Curso> cursos, List<Mentoria> mentorias, List<Projeto> projetos, List<Hacking> hackings) {
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição do bootcamp Java Developer");
        bootcamp.getConteudos().addAll(cursos);
        bootcamp.getConteudos().addAll(mentorias);
        bootcamp.getConteudos().addAll(projetos);
        bootcamp.getConteudos().addAll(hackings);
        return bootcamp;
    }

    private static Dev configurarDev(String nome, Bootcamp bootcamp) {
        Dev dev = new Dev();
        dev.setNome(nome);
        dev.inscreverBootcamp(bootcamp);
        return dev;
    }
}