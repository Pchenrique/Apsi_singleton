package br.com.map.facade;

public interface IUsuario {
  
  public boolean addOs(IOrdemDeServico ordemDeServico);
  
  public boolean removerOs(String titulo);
  
  public boolean resolverOs(String titulo);
  
  public String getCpf();
  
  public void setCpf(String cpf);
  
  public String getNome();
  
  public void setNome(String nome);
  
  public IOrdemDeServico getOss();

}
