package br.com.map.dao;

import br.com.map.Usuario;
import br.com.map.facade.IUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import singleton.ConexaoSingleton;

public class UsuarioDao {
  Connection conn = ConexaoSingleton.conectar();
  
  /**
   * Metodo para inserir um usuario no banco.
   */
  public void inserirUsuario(IUsuario usuario) throws SQLException {

    String sql = "insert into usuarios(nome, cpf) values(?,?)";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, usuario.getNome());
    stmt.setString(2, usuario.getCpf());
    stmt.execute();
    stmt.close();
  }
  
  /**
   * Metodo para excluir um usuario no banco.
   */
  public void excluirUser(String cpf) throws SQLException {

    String sql = "DELETE FROM usuarios where cpf = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, cpf);
    stmt.execute();
    stmt.close();
  }
  
}
