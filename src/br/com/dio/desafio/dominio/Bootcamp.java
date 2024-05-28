package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Bootcamp {
  private String nome;
  private String descricao;
  private final LocalDate dataInicio = LocalDate.now();
  private final LocalDate dataFim = dataInicio.plusDays(45);
  private Set<Dev> devs = new HashSet<>();
  private Set<Conteudo> conteudos = new LinkedHashSet<>();

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public LocalDate getDataInicio() {
    return dataInicio;
  }

  public LocalDate getDataFim() {
    return dataFim;
  }

  public Set<Dev> getDevs() {
    return devs;
  }

  public void setDevs(Set<Dev> devs) {
    this.devs = devs;
  }

  public Set<Conteudo> getConteudos() {
    return conteudos;
  }

  public void setConteudos(Set<Conteudo> conteudos) {
    this.conteudos = conteudos;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
    result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
    result = prime * result + ((devs == null) ? 0 : devs.hashCode());
    result = prime * result + ((conteudos == null) ? 0 : conteudos.hashCode());
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
    Bootcamp other = (Bootcamp) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (descricao == null) {
      if (other.descricao != null)
        return false;
    } else if (!descricao.equals(other.descricao))
      return false;
    if (dataInicio == null) {
      if (other.dataInicio != null)
        return false;
    } else if (!dataInicio.equals(other.dataInicio))
      return false;
    if (dataFim == null) {
      if (other.dataFim != null)
        return false;
    } else if (!dataFim.equals(other.dataFim))
      return false;
    if (devs == null) {
      if (other.devs != null)
        return false;
    } else if (!devs.equals(other.devs))
      return false;
    if (conteudos == null) {
      if (other.conteudos != null)
        return false;
    } else if (!conteudos.equals(other.conteudos))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Bootcamp [nome=" + nome + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim
        + ", devs=" + devs + ", conteudos=" + conteudos + "]";
  }

}
