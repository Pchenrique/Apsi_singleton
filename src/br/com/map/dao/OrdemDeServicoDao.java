package br.com.map.dao;

import br.com.map.facade.IOrdemDeServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import singleton.ConexaoSingleton;

public class OrdemDeServicoDao {
  Connection conn = ConexaoSingleton.conectar();
  
  /**
   * Metodo para inserir uma ordem de serviço.
   */
  public void inserirOrdem(IOrdemDeServico ordem) throws SQLException {

    String sql = "insert into ordem_servico(titulo,descricao,status,cpf_usuario) values(?,?,?,?)";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, ordem.getTitulo());
    stmt.setString(2, ordem.getDescricao());
    stmt.setBoolean(3, ordem.getAberta());
    stmt.setString(4, ordem.getCpf());
    stmt.execute();
    stmt.close();
  }
  
  /**
   * Metodo para excluir uma ordem de serviço.
   */
  public void excluirOrdem(String cpf, String titulo) throws SQLException {

    String sql = "DELETE FROM ordem_servico where cpf_usuario = ? and titulo = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, cpf);
    stmt.setString(2, titulo);
    stmt.execute();
    stmt.close();
  }
  
  /**
   * Metodo para editar uma ordem de serviço.
   */
  public void editarStatus(String cpf, String titulo) throws SQLException {
    
    String sql = "update ordem_servico set status=? where cpf_usuario=? and titulo=?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setBoolean(1, false);
    stmt.setString(2, cpf);
    stmt.setString(3, titulo);
    stmt.executeUpdate();
  }

}
