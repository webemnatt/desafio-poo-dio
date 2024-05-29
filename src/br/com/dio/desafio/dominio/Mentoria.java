package br.com.dio.desafio.dominio;

import java.time.LocalDate;

/**
 * Classe que estende Conteudo para criar uma Mentoria.
 * Tem como atributo a data da mentoria.
 * Sobrescreve método calcularXP acrescentando 20 ao XP_PADRAO;
 * Possui construtor que inicializa as variáveis titulo, descricao e data.
 * Possui também um construtor vazio para o caso de declarar um Conteudo como tipo.
 *  
 * @author webemnatt
 * @since 05/28/24
 * @version 1.0.0
 */
public class Mentoria extends Conteudo {

  private LocalDate data;

  public Mentoria() {
  }

  public Mentoria(String titulo, String descricao, LocalDate data) {
    super(titulo, descricao);
    this.data = data;
  }

  @Override
  public double calcularXP() {
    return XP_PADRAO + 20d;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "Mentoria [titulo=" + super.getTitulo() + ", descricao=" + super.getDescricao() + ", data=" + data + "]";
  }

}
