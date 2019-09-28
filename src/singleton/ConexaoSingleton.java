package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSingleton {
  private static Connection conn;

  private ConexaoSingleton() {

  }

  /**
   * Metodo que conecta com o banco.
   */
  public static Connection conectar() {
    if (ConexaoSingleton.conn == null) {
      try {
        Class.forName("com.mysql.jdbc.Driver");
        ConexaoSingleton.conn = DriverManager
            .getConnection("jdbc:mysql://127.0.0.1/apsi?useTimezone=true&serverTimezone=Brazil/East", "root", "");
      } catch (SQLException | ClassNotFoundException ex) {
        System.out.println("Erro: " + ex.getMessage());
        return null;
      }
    }
    return ConexaoSingleton.conn;
  }
}
