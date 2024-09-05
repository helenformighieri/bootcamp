# Bootcamp 

Fomos desafiados a desenvolver nossa capacidade de abstração com um problema real e implementar as evoluções que achamos necessárias, como métodos e classes. Eu implementei as classes Projeto, Hacking e Certificado, que acredito ser uma acrescimo de valor a aplicação.

## Descrição do Projeto

Este projeto simula um bootcamp para desenvolvedores, onde os participantes podem se inscrever em cursos, mentorias, projetos e atividades de hacking para ganhar experiência (XP) e obter certificados ao concluir o bootcamp.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes principais:

- `Conteudo`: Classe abstrata que representa um conteúdo do bootcamp.
- `Curso`: Representa um curso com uma carga horária específica.
- `Mentoria`: Representa uma mentoria com uma data específica.
- `Projeto`: Representa um projeto com um nível de dificuldade.
- `Hacking`: Representa uma atividade de hacking com um nível de dificuldade.
- `Certificado`: Representa um certificado emitido após a conclusão do bootcamp.
- `Dev`: Representa um desenvolvedor inscrito no bootcamp.
- `Bootcamp`: Representa o bootcamp com seus conteúdos e desenvolvedores inscritos.

## Desafio

1. **Abstrair o domínio Bootcamp e modelar seus atributos e métodos.**
2. **Criar as classes e relacioná-las.**
3. **Modelar as classes criando seus atributos e métodos.**
4. **Utilizar ferramentas do paradigma de orientação a objetos (POO) para tornar o código mais legível e de fácil manutenção: abstração, encapsulamento, herança e polimorfismo.**
5. **Transformar as classes criadas e relacionadas em objetos.**

## Configuração e Execução

1. Clone o repositório:
    ```sh
    git clone https://github.com/seu-usuario/bootcamp-java-developer.git
    ```

2. Navegue até o diretório do projeto:
    ```sh
    cd bootcamp-java-developer
    ```
3. Importar o projeto na IDE:
   - Intellij IDEA
      - Abra o IntelliJ IDEA.
      - Clique em `Open or Import`.
      - Selecione a pasta do projeto e clique em `Open`.
      - Aguarde a indexação do projeto e as dependências serem baixadas.
   - Eclipse
        - Abra o Eclipse.
        - Clique em `File` > `Open Projects from File System...`.
        - Selecione a pasta do projeto e clique em `Finish`.
        - Aguarde a indexação do projeto e as dependências serem baixadas.
4. Executar o projeto:
    - Localize a classe`Main` e a execute para testar a aplicação.
   
## Exemplo de Uso

```java
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
```

### Desenvolvido por Helen Formighieri
