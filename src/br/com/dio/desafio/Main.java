package br.com.dio.desafio;

import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) throws Exception {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso Java");
        curso1.setDescricao("descricao curso java");
        curso1.setCargaHoraria(8);
        System.out.println(curso1);

        Curso cursoPOO = new Curso();
        cursoPOO.setTitulo("curso POO");
        cursoPOO.setDescricao("descricao curso Programação Orientada a Objetos");
        cursoPOO.setCargaHoraria(5);
        System.out.println(cursoPOO);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso Javascript");
        curso2.setDescricao("descricao curso javascript");
        curso2.setCargaHoraria(12);
        System.out.println(curso2);

        Mentoria mentoriaJava = new Mentoria();
        mentoriaJava.setTitulo("mentoria Java");
        mentoriaJava.setDescricao("descricao mentoria java");
        mentoriaJava.setData(LocalDate.now());
        System.out.println(mentoriaJava);

        Conteudo conteudo = new Mentoria();
        conteudo.setTitulo("mentoria Javascript");
        conteudo.setDescricao("descricao mentoria javascript");
        System.out.println(conteudo);
        Mentoria mentoriaJs = (Mentoria) conteudo;
        mentoriaJs.setData(LocalDate.now());

        System.out.println("---------bootcamp java------------");
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(cursoPOO);
        bootcamp.getConteudos().add(mentoriaJava);
        System.out.println(bootcamp);

        System.out.println("---------bootcamp Javascript------------");
        Bootcamp bootcampJS = new Bootcamp();
        bootcampJS.getConteudos().add(curso2);
        bootcampJS.getConteudos().add(mentoriaJs);
        System.out.println(bootcampJS);

        System.out.println("----------desenvolvedores-----------");
        Dev dev1 = new Dev();
        dev1.setNome("Carla");
        dev1.inscreverBootCamp(bootcamp);
        System.out.println("Conteudos Inscritos Carla: \n" + dev1.getConteudosInscritos());

        Dev dev2 = new Dev();
        dev2.setNome("Roger");
        dev2.inscreverBootCamp(bootcamp);
        dev2.inscreverBootCamp(bootcampJS);
        System.out.println("Conteudos Inscritos Roger: \n" + dev2.getConteudosInscritos());

        System.out.println("-------conteúdos concluídos------");
        System.out.println("Conteúdos concluídos : " + dev1.getNome() + "\t" + dev1.getConteudosConcluidos());
        System.out.println("Conteúdos concluídos : " + dev2.getNome() + "\t" + dev2.getConteudosConcluidos());

        System.out.println("\n-------progredir conteúdo------");
        System.out.println("\nConteudos Inscritos Carla: ***************\n");
        dev1.getConteudosInscritos().forEach(System.out::println);
        System.out.println("XP de " + dev1.getNome() + "\t" + dev1.calcularTotalXp());
        dev1.progredir();
        System.out.println("\nConteúdos concluídos : " + dev1.getNome() + "\t" + dev1.getConteudosConcluidos());
        System.out.println("XP de " + dev1.getNome() + "\t" + dev1.calcularTotalXp());

        System.out.println("\n-----concluir outro-------------");
        dev1.progredir();
        System.out.println("\nConteúdos concluídos : " + dev1.getNome() + "\t" + dev1.getConteudosConcluidos());
        System.out.println("XP de " + dev1.getNome() + "\t" + dev1.calcularTotalXp());

        System.out.println("\n-----concluir outro-------------");
        dev1.progredir();
        System.out.println("\nConteúdos concluídos : " + dev1.getNome() + "\t" + dev1.getConteudosConcluidos());
        System.out.println("XP de " + dev1.getNome() + "\t" + dev1.calcularTotalXp());

        System.out.println("\n-----tentar progredir sem cursos pra fazer-------------");
        dev1.progredir();
        System.out.println("Cursos a concluir de: " + dev1.getNome() + "\t" + dev1.getConteudosInscritos());

        System.out.println("\nConteudos Inscritos Roger: ***************\n");
        dev2.getConteudosInscritos().forEach(System.out::println);
        dev2.progredir();
        System.out.println("\nConteúdos concluídos : " + dev2.getNome() + "\t" + dev2.getConteudosConcluidos());
        System.out.println("XP de " + dev2.getNome() + "\t" + dev2.calcularTotalXp());
        System.out.println("Cursos a concluir de: " + dev2.getNome() + "\t" + dev2.getConteudosInscritos());

    }
}
