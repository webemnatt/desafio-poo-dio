package br.com.dio.desafio;

import java.time.LocalDate;
import java.util.*;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) throws Exception {
        Curso cursoJava = new Curso("curso Java", "descricao curso java", 8);

        Curso cursoPOO = new Curso("curso POO", "descricao curso Programação Orientada a Objetos", 5);

        Curso curso2 = new Curso("curso Javascript", "descricao curso javascript", 12);

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

        // Dev dev1 = new Dev("Sara");
        // dev1.inscreverBootCamp(bootcampJava);
        // dev1.inscreverBootCamp(bootcampJS);
        // for (Bootcamp bc : dev1.getBootcampsInscritos()) {
        // System.out.println(bc.getNome());
        // // System.out.println(bc.getConteudos());
        // // imprimir os devs inscritos no bootcamp:
        // for (Dev d : bc.getDevsInscritos()) {
        // System.out.println(d.getNome());
        // }
        // }

        // System.out.println("----cancelando inscrição---------");
        // dev1.cancelarInscricao(bootcampJS);

        // for (Bootcamp bc : dev1.getBootcampsInscritos()) {
        // System.out.println(bc.getNome());
        // // System.out.println(bc.getConteudos());
        // // imprimir os devs inscritos no bootcamp:
        // for (Dev d : bc.getDevsInscritos()) {
        // System.out.println(d.getNome());
        // }
        // }

        System.out.println("----------Menu aluno-----------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Como deseja ser chamado?\t");
        String nome = scanner.nextLine();
        int opcao = -1;
        Dev dev = new Dev(nome);

        try {
            while (opcao != 0) {
                System.out.println("\n" + dev.getNome()
                        + ", o que gostaria de fazer? 1. Inscrever-se num bootcamp, 2. Cancelar inscrição, 3. Ver progresso, 4.Fazer aula, 0. Sair");
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
                                    System.out.println("Inscrição feita com sucesso! " + bootcampJava.getNome());
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
                                    System.out.println("Inscrição feita com sucesso! " + bootcampJS.getNome());
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
                        if (dev.getBootcampsInscritos().isEmpty()) {
                            System.out.println("Nenhum Bootcamp encontrado.");
                        } else {
                            for (Bootcamp bc : dev.getBootcampsInscritos()) {
                                System.out.println("Bootcamp:\t" + bc.getNome());
                                System.out.println("Deseja cancelar a inscrição? 1. Sim, 2. Não");
                                int opcaoCancelar = scanner.nextInt();
                                switch (opcaoCancelar) {
                                    case 1:
                                        dev.cancelarInscricao(bc);
                                        System.out.println("Bootcamp " + bc.getNome() + " cancelado com sucesso!");
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        break;
                    case 3:
                        if (dev.getConteudosInscritos().isEmpty()&&dev.getConteudosConcluidos().size()==0) {
                            System.out.println("Inscreva-se em um bootcamp:");
                            break;
                        } else {
                            System.out.println("\nVeja o seu progresso:\n");
                            dev.verProgresso();
                            if (dev.getConteudosInscritos().size() == 0) {
                                System.out.println("\nVocê concluiu todos os conteúdos do bootcamp!");
                                //quando finaliza cancela a inscrição:
                                dev.cancelarInscricao(bootcampJS);
                            } else {
                                System.out.println(
                                        "O próximo conteúdo a fazer é:\n");
                                for (Conteudo aFazer : dev.getConteudosInscritos()) {
                                    System.out.println(aFazer);
                                    break;
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
                            System.out.println("Total de XP:\t" + (dev.calcularTotalXp()));
                            System.out.println();
                        }
                        if (dev.getConteudosInscritos().size() == 0) {
                            System.out.println("-----------Você fez todos os conteúdos do bootcamp!-----------");
                            System.out.println("**********Bootcamp concluído com sucesso!!**********");
                        }
                        break;
                    case 0:
                        System.out.println("Saindo....");
                        break;
                    default:
                        break;
                }
            }

        } catch (

        Exception e) {
            System.out.println("Entrada inválida.");
        } finally {
            scanner.close();
        }
    }

}
