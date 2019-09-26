package br.com.map.facade;

public interface IUsuario {
  
  public boolean addOs(IOrdemDeServico ordemDeServico);
  
  public boolean removerOs(String titulo);
  
  public boolean resolverOs(String titulo);

}
