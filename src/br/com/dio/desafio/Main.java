package br.com.dio.desafio;

import java.time.LocalDate;
import java.util.Scanner;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) throws Exception {
        Curso cursoJava = new Curso("curso Java", "descricao curso java", 8);
        System.out.println(cursoJava);

        Curso cursoPOO = new Curso("curso POO", "descricao curso Programação Orientada a Objetos", 5);
        System.out.println(cursoPOO);

        Curso curso2 = new Curso("curso Javascript", "descricao curso javascript", 12);
        System.out.println(curso2);

        Mentoria mentoriaJava = new Mentoria("mentoria Java", "descricao mentoria java", LocalDate.now());

        Conteudo conteudo = new Mentoria();
        conteudo.setTitulo("mentoria Javascript");
        conteudo.setDescricao("descricao mentoria javascript");
        Mentoria mentoriaJs = (Mentoria) conteudo;
        mentoriaJs.setData(LocalDate.now());

        Bootcamp bootcampJava = new Bootcamp("Bootcamp Java Developer", "Descricao Bootcamp Java Developer");
        bootcampJava.getConteudos().add(cursoJava);
        bootcampJava.getConteudos().add(cursoPOO);
        bootcampJava.getConteudos().add(mentoriaJava);

        Bootcamp bootcampJS = new Bootcamp("Bootcamp Javascript", "Descrição Bootcamp Javascript");
        bootcampJS.getConteudos().add(curso2);
        bootcampJS.getConteudos().add(mentoriaJs);

        System.out.println("----------Menu aluno-----------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Como deseja ser chamado?\t");
        String nome = scanner.nextLine();
        int opcao = -1;
        Dev dev = new Dev(nome);

        try {
            while (opcao != 0) {
                System.out.println("\n" + dev.getNome() +
                        ", o que gostaria de fazer? 1. Inscrever-se num bootcamp, 2. Ver bootcamps inscritos, 3. Ver progresso, 4.Fazer aula, 0. Sair");
                // ver xp, fazer aula; concluir aula
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("--------------------Bootcamps disponíveis:--------------------");
                        System.out.println(bootcampJava.getNome());
                        bootcampJava.getConteudos().forEach(System.out::println);
                        System.out.println("--------------------");
                        System.out.println(bootcampJS.getNome());
                        bootcampJS.getConteudos().forEach(System.out::println);
                        System.out.println("--------------------");
                        System.out.println(
                                "Em qual bootcamp deseja se inscrever? 1. Bootcamp Java, 2. Bootcamp Javascript, 0. Retornar ao menu principal");
                        int opcaoBootcamp = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcaoBootcamp) {
                            case 1:
                                boolean jaInscrito = false;
                                for (Bootcamp bc : dev.getBootcampsInscritos()) {
                                    if (bc.equals(bootcampJava)) {
                                        System.out.println("Você já está inscrito nesse bootcamp");
                                        jaInscrito = true;
                                        break;
                                    }
                                }
                                if (!jaInscrito) {
                                    dev.inscreverBootCamp(bootcampJava);
                                    System.out.println("Bootcamp Java: inscrição feita com sucesso!");
                                }
                                break;
                            case 2:
                                boolean jaInscritoJS = false;
                                for (Bootcamp bc : dev.getBootcampsInscritos()) {
                                    if (bc.equals(bootcampJS)) {
                                        System.out.println("Você já está inscrito nesse bootcamp");
                                        jaInscritoJS = true;
                                        break;
                                    }
                                }
                                if (!jaInscritoJS) {
                                    dev.inscreverBootCamp(bootcampJS);
                                    System.out.println("Bootcamp Java: inscrição feita com sucesso!");
                                }
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                        break;
                    case 2:
                        if (dev.getConteudosInscritos().isEmpty()) {
                            System.out.println("Você não está inscrito em nenhum bootcamp");
                        } else {
                            System.out.println("\nVocê se inscreveu nos seguintes bootcamps:\n");
                            for (Bootcamp bootcamp : dev.getBootcampsInscritos()) {
                                System.out.println(bootcamp.getNome());
                                for (Conteudo curso : bootcamp.getConteudos()) {
                                    System.out.println(curso);
                                }
                                System.out.println("\n-------\n");
                            }
                        }
                        break;
                    case 3:
                        if (dev.getConteudosInscritos().isEmpty()) {
                            System.out.println("Você não está inscrito em nenhum bootcamp");
                            break;
                        } else {
                            System.out.println("\nVeja o seu progresso:\n");
                            dev.verProgresso();
                            if (dev.getConteudosInscritos().size() == 0) {
                                System.out.println("\nVocê concluiu todos os conteúdos do bootcamp!");
                            } else {
                                System.out.println(
                                        "Você ainda tem que concluir os seguintes conteúdos:\n");
                                for (Conteudo aFazer : dev.getConteudosInscritos()) {
                                    System.out.println(aFazer);
                                }
                            }
                        }
                        break;
                    case 4:
                        if (dev.getConteudosInscritos().isEmpty()) {
                            System.out.println("Inscreva-se em um bootcamp:");
                            break;
                        } else {
                            dev.progredir();
                            System.out.println("Parabéns, mais um conteúdo concluído!");
                            System.out.println("A seguir, os cursos concluídos:");
                            dev.getConteudosConcluidos().forEach(System.out::print);
                            System.out.println();
                        }
                        if (dev.getConteudosInscritos().size() == 0) {
                            System.out.println("-----------Você fez todos os conteúdos do bootcamp!-----------");
                            System.out.println("--------------Bootcamp concluído com sucesso!!-----------------");
                        }
                        break;
                    case 0:
                        System.out.println("Saindo....");
                        break;
                    default:
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Entrada inválida.");
        } finally {
            scanner.close();
        }
    }
}
