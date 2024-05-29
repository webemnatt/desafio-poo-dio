package br.com.dio.desafio.dominio;

/**
 * Classe que estende Conteudo para criar uma Curso.
 * Tem como atributo próprio a cargahoraria do tipo int.
 * Sobrescreve método calcularXP multiplicando cargaHoraria pelo XP_PADRAO;
 * Possui construtor que inicializa as variáveis titulo, descricao e cargaHoraria.
 * Possui também um construtor vazio para o caso de declarar um Conteudo como tipo.
 * 
 * @author webemnatt
 * @since 05/28/24
 * @version 1.0.0
 */
public class Curso extends Conteudo {
  private int cargaHoraria;

  public Curso() {
  }

  public Curso(String titulo, String descricao, int cargaHoraria) {
    super(titulo, descricao);
    this.cargaHoraria = cargaHoraria;
  }

  @Override
  public double calcularXP() {
    return XP_PADRAO * cargaHoraria;
  }

  public int getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(int cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  @Override
  public String toString() {
    return "Curso [titulo=" + super.getTitulo() + ", descricao=" + super.getDescricao() + ", cargaHoraria="
        + cargaHoraria + "]";
  }

}
