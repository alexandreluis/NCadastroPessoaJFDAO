package br.com.senactech.NCadastroPessoa.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * estabelece conexao com o db
 *
 * @author 180900411
 */
public class Conexao {

    //cria constante com endereço do db e schema
    private static String url = "jdbc:mysql://localhost:3306/devn211";

    //cria constante com user do db
    private static String user = "root";

    //cria uma constante com a senha do db
    private static String password = "";

    //
    public static Connection getConexao() throws SQLException {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar banco.\n"
                    + e.getMessage());
        }
        return conn;
    }
}
