package br.com.dio.desafio.dominio;

import java.util.*;

/**
 * Classe que cria um aluno desenvolvedor.
 * Tem como atributos nome do tipo String, conteudosInscritos e
 * conteudosConcluidos do tipo Set<Conteudo> e bootcampsInscritos do tipo
 * Set<Bootcamp>.
 * 
 * Possui construtor que inicializa a variável nome.
 * 
 * Possui os métodos:
 * 
 * <strong>inscreverBootCamp</strong>,
 * <strong>progredir</strong>,
 * <strong>calcularTotalXp</strong>,
 * <strong>cancelarInscricao</strong>, e
 * <strong>verProgresso</strong>.
 * 
 * @author webemnatt
 * @since 05/28/24
 * @version 1.0.0
 */
public class Dev {
  private String nome;
  private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
  private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
  private Set<Bootcamp> bootcampsInscritos = new LinkedHashSet<>();

  public Dev(String nome) {
    this.nome = nome;
  }

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
    this.bootcampsInscritos.add(bootcamp);
    this.conteudosInscritos.addAll(bootcamp.getConteudos());
    bootcamp.getDevsInscritos().add(this);
  }

  /**
   * Método que, à medida em que for progredindo, aumenta os conteudos concluidos.
   * Faz uso do findFirst do stream porque espera-se que o estudante vá concluindo
   * na ordem dos cursos listados.
   */
  public void progredir() {
    // encontra o primeiro conteudo de
    Optional<Conteudo> primeiroConteudo = this.conteudosInscritos.stream().findFirst();
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
   * @return um double com o total de XPs acumulados
   */
  public double calcularTotalXp() {
    return conteudosConcluidos.stream()
        .mapToDouble(Conteudo::calcularXP)
        .sum();
  }

  /**
   * Método que cancela a inscrição em um bootcamp
   * 
   * @param bootcamp do tipo Bootcamp
   */
  public void cancelarInscricao(Bootcamp bootcamp) {
    this.conteudosInscritos.removeAll(bootcamp.getConteudos());
    this.conteudosConcluidos.removeAll(bootcamp.getConteudos());
    for (Bootcamp bootcampInscrito : this.getBootcampsInscritos()) {
      if (bootcampInscrito.equals(bootcamp)) {
        Set<Dev> devsInscritos = new LinkedHashSet<>(bootcampInscrito.getDevsInscritos());
        for (Dev desenvolvedorInscrito : devsInscritos) {
          if (desenvolvedorInscrito.getNome().equals(this.getNome())) {
            devsInscritos.remove(this);
          }
        }
        bootcampInscrito.setDevsInscritos(devsInscritos);
        this.getBootcampsInscritos().remove(bootcampInscrito);
      }
    }
  }

  /**
   * Método que exibe o progresso em porcentagem de todos os bootcamps que o
   * desenvolvedor
   * estiver inscrito.
   * Mostra quantos cursos concluídos e quantos tem a fazer.
   * Se tiver concluído tudo, cancela a inscrição do bootcamp concluído.
   */
  public void verProgresso() {

    for (Bootcamp bootcamp : this.bootcampsInscritos) {
      System.out.println("Bootcamp: " + bootcamp.getNome());
      int cursosConcluidos = 0;
      int cursosPorFazer = 0;
      for (Conteudo aula : bootcamp.getConteudos()) {
        if (this.conteudosConcluidos.contains(aula)) {
          cursosConcluidos++;
        } else if (this.conteudosInscritos.contains(aula)) {
          cursosPorFazer++;
        }
      }
      System.out.println("Cursos concluídos:\t" + cursosConcluidos + " / cursos por fazer: "
          + cursosPorFazer);
      double porcentagem = (double) cursosConcluidos / (cursosConcluidos + cursosPorFazer);
      System.out.println(String.format("Progresso: %.2f%%\n", porcentagem * 100));
      if (porcentagem == 1) {
        cancelarInscricao(bootcamp);
      }
    }
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

  public Set<Bootcamp> getBootcampsInscritos() {
    return bootcampsInscritos;
  }

  public void setBootcampsInscritos(Set<Bootcamp> bootcampsInscritos) {
    this.bootcampsInscritos = bootcampsInscritos;
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
        + conteudosConcluidos + ", bootcampsInscritos=" + bootcampsInscritos + "]";
  }

}
