package br.com.map.facade;

import br.com.map.OrdemDeServico;
import br.com.map.Usuario;
import br.com.map.dao.OrdemDeServicoDao;
import br.com.map.dao.UsuarioDao;
import br.com.map.simplefactory.SimpleFactory;

import java.sql.SQLException;
import java.util.HashMap;

public class Facada implements IFacade {
  
  UsuarioDao bancoUsuario = new UsuarioDao();
  OrdemDeServicoDao bancoOrdem = new OrdemDeServicoDao();
  
  public Facada() {
    
  }

  /**
   * metodo responsavel por inserir usuario.
   */
  public void inserirUsuario(String nome, String cpf) {
    IUsuario usuario = SimpleFactory.usuario(nome, cpf);
    try {
      this.bancoUsuario.inserirUsuario(usuario);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * metodo responsavel por inserir um nova ordem.
   */
  public boolean inserirOs(String titulo, String descricao, String cpf) {
    IOrdemDeServico ordemDeServico = SimpleFactory.ordemDeServico(titulo, descricao, cpf);
    try {
      this.bancoOrdem.inserirOrdem(ordemDeServico);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Metodo responsavel por excluir usuario.
   */
  public boolean deletarUsuario(String cpf) {
    try {
      this.bancoUsuario.excluirUser(cpf);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return false;
  }

  /**
   * metodo para deletar uma ordem de serviço.
   */
  public boolean deletarOs(String cpf, String titulo) {
    try {
      this.bancoOrdem.excluirOrdem(cpf, titulo);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return false;
  }

  /**
   * metodo para resolver uma OS.
   */
  public boolean resolverOs(String cpf, String titulo) {
    try {
      this.bancoOrdem.editarStatus(cpf, titulo);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return false;
  }

}
