package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
  private String nome;
  // SET porque não há como se inscrever 2x no mesmo curso
  private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
  private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

  /**
   * Método que adiciona todos os conteúdos do bootcamp no set de conteudos
   * inscritos, porque ao se inscrever no bootcamp, deve trazeer os conteúdos do
   * mesmo para o set de inscritos.
   * Ao se inscrever num bootcamp, o próprio deve ser adicionado na lista dos
   * devsIncritos no bootcamp
   * 
   * @param bootcamp do tipo Bootcamp
   */
  public void inscreverBootCamp(Bootcamp bootcamp) {
    this.conteudosInscritos.addAll(bootcamp.getConteudos());
    bootcamp.getDevsInscritos().add(this);
  }

  /**
   * Método que, à medida em que for progredindo, aumenta os conteudos concluidos.
   * Faz uso do findFirst do stream porque espera-se que o estudante vá concluindo
   * na ordem dos cursos listados.
   */
  public void progredir() {
    Optional<Conteudo> primeiroConteudo = this.conteudosConcluidos.stream().findFirst();
    if (primeiroConteudo.isPresent()) {
      conteudosConcluidos.add(primeiroConteudo.get());
      conteudosInscritos.remove(primeiroConteudo.get());
    } else {
      System.err.println("Matricule-se em um conteúdo para progredir.");
    }
  }

  /**
   * Método que calcula total de xps dos conteúdos concluídos e retorna a soma
   * deles.
   * 
   * @return
   */
  public double calcularTotalXp() {
    return conteudosConcluidos.stream()
        // .mapToDouble(conteudo -> conteudo.calcularXP())
        .mapToDouble(Conteudo::calcularXP)
        .sum();
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
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((conteudosInscritos == null) ? 0 : conteudosInscritos.hashCode());
    result = prime * result + ((conteudosConcluidos == null) ? 0 : conteudosConcluidos.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Dev other = (Dev) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (conteudosInscritos == null) {
      if (other.conteudosInscritos != null)
        return false;
    } else if (!conteudosInscritos.equals(other.conteudosInscritos))
      return false;
    if (conteudosConcluidos == null) {
      if (other.conteudosConcluidos != null)
        return false;
    } else if (!conteudosConcluidos.equals(other.conteudosConcluidos))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Dev [nome=" + nome + ", conteudosInscritos=" + conteudosInscritos + ", conteudosConcluidos="
        + conteudosConcluidos + "]";
  }

}
