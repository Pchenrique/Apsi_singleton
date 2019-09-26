package br.com.map.facade;

import br.com.map.OrdemDeServico;
import br.com.map.Usuario;
import br.com.map.simplefactory.SimpleFactory;

import java.util.HashMap;

public class Facada implements IFacade {
  private HashMap<String, IUsuario> usuarios;

  public Facada() {
    this.usuarios = new HashMap<String, IUsuario>();
  }

  /**
   * metodo responsavel por inserir usuario.
   */
  public void inserirUsuario(String nome, String cpf) {
    IUsuario usuario = SimpleFactory.usuario(nome, cpf);
    this.usuarios.put(cpf, usuario);
  }

  /**
   * metodo responsavel por inserir um nova ordem.
   */
  public boolean inserirOs(String titulo, String descricao, String cpf) {
    IOrdemDeServico ordemDeServico = SimpleFactory.ordemDeServico(titulo, descricao);
    if (this.usuarios.get(cpf).addOs(ordemDeServico)) {
      return true;
    }
    return false;
  }

  /**
   * Metodo responsavel por excluir usuario.
   */
  public boolean deletarUsuario(String cpf) {
    if (this.usuarios.get(cpf) != null) {
      this.usuarios.remove(cpf);
      return true;
    }
    return false;
  }

  /**
   * metodo para deletar uma ordem de serviço.
   */
  public boolean deletarOs(String cpf, String titulo) {
    if (this.usuarios.get(cpf).removerOs(titulo)) {
      return true;
    }
    return false;
  }

  /**
   * metodo para resolver uma OS.
   */
  public boolean resolverOs(String cpf, String titulo) {
    if (this.usuarios.get(cpf).resolverOs(titulo)) {
      return true;
    }
    return false;
  }

}
