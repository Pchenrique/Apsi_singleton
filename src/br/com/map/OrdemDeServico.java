package br.com.map;

import br.com.map.facade.IOrdemDeServico;

public class OrdemDeServico implements IOrdemDeServico {
  
  private String titulo;
  private String descricao;
  private Boolean aberta;
  
  /**
   * Construtor padr�o.
   * @param titulo da OrdemDeServico
   * @param descricao da OrdemDeServico
   */
  public OrdemDeServico(String titulo, String descricao) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.aberta = true;
  }

  public String getTitulo() {
    return titulo;
  }
  
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  
  public String getDescricao() {
    return descricao;
  }
  
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  
  public Boolean getAberta() {
    return aberta;
  }
  
  public void setAberta(boolean aberta) {
    this.aberta = aberta;
  }
  
  
}
