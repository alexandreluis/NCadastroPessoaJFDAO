package br.com.senactech.NCadastroPessoa.dao;


import br.com.senactech.NCadastroPessoa.conexao.Conexao;
import br.com.senactech.NCadastroPessoa.model.Pessoa;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


/*
S IG L AS 
• VO = Value Object - Objeto de valor 
• DAO = Data Access Object - Acesso aos dados do objeto 
• Factory = Fábrica    
*/

/**
 * consultas no banco
 * @author 180900411
 */
public class PessoaDAO 
{
    //
    public void cadastrarPessoa(Pessoa pVO) throws SQLException
    {
        //abre/buscar conexao do db
        Connection conn = Conexao.getConexao();
        
        //abre conexao
        Statement statement = conn.createStatement();
        
        try 
        {
            //
            String sql;
            
            sql = "INSERT INTO pessoa VALUES (null, '" 
                    + pVO.getNomePessoa() + "', '" 
                    + pVO.getCpf() + "','" 
                    + pVO.getEndereco() + "', '" 
                    + pVO.getTelefone() + "', '" 
                    + pVO.getIdPessoa() + "', " 
                    + pVO.isStatus() + ");";
            
            statement.execute(sql);
        } catch (SQLException e) 
        {
            //
            throw new SQLException("Erro ao inserir pessoa.\n"
            + e.getMessage());
        } finally
        {
            //
            conn.close();
            statement.close();
        }
    }
    
    public ArrayList<Pessoa> listarPessoas() throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();
        
        try {
            //
            String sql;
            sql = "SELECT * FROM pessoa";
            
            ResultSet rs = statement.executeQuery(sql);
            
            ArrayList<Pessoa> pessoas = new ArrayList<>();
            
            while(rs.next())
            {
                Pessoa p = new Pessoa();
                
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNomePessoa(rs.getString("nomePessoa"));
                p.setCpf(rs.getString("cpf"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setIdade(rs.getInt("idade"));
                p.setStatus(rs.getBoolean("status"));
                
                pessoas.add(p);
            }
            
            return pessoas;
        } catch (SQLException e) 
        {
            //
            throw new SQLException("Erro ao buscar pessoas.\n" + 
                    e.getMessage());
        } finally 
        {
            conn.close();
            statement.close();
        }
    }
}