package br.com.map.simplefactory;

import br.com.map.OrdemDeServico;
import br.com.map.Usuario;
import br.com.map.facade.Facada;
import br.com.map.facade.IFacade;
import br.com.map.facade.IOrdemDeServico;
import br.com.map.facade.IUsuario;

public class SimpleFactory {
  
  private SimpleFactory() {
    
  }
  
  public static IFacade facade() {
    return new Facada();
  }
  
  public static IOrdemDeServico ordemDeServico(String titulo, String descricao) {
    return new OrdemDeServico(titulo, descricao);
  }
  
  public static IUsuario usuario(String nome, String cpf) {
    return new Usuario(nome, cpf);
  }

}
