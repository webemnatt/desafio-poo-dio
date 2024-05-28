package br.com.dio.desafio;

import java.time.LocalDate;

import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) throws Exception {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso Java");
        curso1.setDescricao("descricao curso java");
        curso1.setCargaHoraria(8);
        System.out.println(curso1);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso Javascript");
        curso2.setDescricao("descricao curso javascript");
        curso2.setCargaHoraria(12);
        System.out.println(curso2);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria Java");
        mentoria.setDescricao("descricao mentoria java");
        mentoria.setData(LocalDate.now());
        System.out.println(mentoria);

        Conteudo conteudo = new Mentoria();
        conteudo.setTitulo("mentoria Javascript");
        conteudo.setDescricao("descricao mentoria javascript");
        System.out.println(conteudo);
        Mentoria mentoria2 = (Mentoria) conteudo;
        mentoria2.setData(LocalDate.now());
    }
}
