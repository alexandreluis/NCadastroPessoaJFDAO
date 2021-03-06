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
 *
 * @author 180900411
 */
public class PessoaDAO
{

    //
    public void cadastrarPessoa(Pessoa pVO) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        try
        {
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

        try
        {
            String sql;
            sql = "SELECT * FROM pessoa";

            ResultSet rs = statement.executeQuery(sql);

            ArrayList<Pessoa> pessoas = new ArrayList<>();

            while (rs.next())
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
            throw new SQLException("Erro ao buscar pessoas.\n"
                    + e.getMessage());
        } finally
        {
            conn.close();
            statement.close();
        }
    }

    public boolean verCPF(String cpf) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        boolean verCPF = false;

        try
        {
            String sql;
            sql = "SELECT cpf FROM pessoa WHERE cpf = " + cpf;

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                verCPF = !(rs.wasNull());
            }
        } catch (Exception e)
        {
            throw new SQLException("Pessoa com este cpf não existe.\n"
                    + e.getMessage());
        } finally
        {
            conn.close();
            statement.close();
        }

        return verCPF;
    }

    public Pessoa getByDoc(String cpf) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        Pessoa p = new Pessoa();

        try
        {
            String sql;
            sql = "SELECT * FROM pessoa WHERE cpf = " + cpf;
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNomePessoa(rs.getString("nomePessoa"));
                p.setCpf(rs.getString("cpf"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setIdade(rs.getInt("idade"));
                p.setStatus(rs.getBoolean("status"));
            }
        } catch (Exception e)
        {
            throw new SQLException("Pessoa com este cpf não existe.\n"
                    + e.getMessage());
        } finally
        {
            conn.close();
            statement.close();
        }

        return p;
    }

    public Pessoa getById(int idDaPessoa) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        if (conn.isClosed())
        {
            System.out.println("Conexão fechada.");
        }

        Pessoa p = new Pessoa();

        try
        {
            String sql;
            sql = "SELECT * FROM pessoa WHERE idPessoa = " + idDaPessoa + ";";

            ResultSet rs = statement.executeQuery(sql);
            if (rs.next())
            {
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNomePessoa(rs.getString("nomePessoa"));
                p.setCpf(rs.getString("cpf"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setIdade(rs.getInt("idade"));
                p.setStatus(rs.getBoolean("status"));
            } else
            {
                System.out.println("não houve resultados");
            }
        } catch (Exception e)
        {
            throw new SQLException("Pessoa com este cpf não existe.\n"
                    + e.getMessage());
        } finally
        {
            conn.close();
            statement.close();
        }

        return p;
    }

    public void deletarPessoa(int id) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        try
        {
            String sql;
            sql = "DELETE FROM pessoa WHERE idPessoa = " + id;
            statement.execute(sql);
        } catch (Exception e)
        {
            throw new SQLException("Erro ao deletar Pessoa.\n"
                    + e.getMessage());
        } finally
        {
            conn.close();
            statement.close();
        }
    }

    public void atualizarPessoa(Pessoa pVO) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        try
        {
            String sql;

            sql = "UPDATE pessoa SET "
                    + "nomePessoa = '" + pVO.getNomePessoa() + "', "
                    + "endereco = '" + pVO.getEndereco() + "', "
                    + "idade = " + pVO.getIdade() + ", "
                    + "telefone = '" + pVO.getTelefone() + "', "
                    + "status = " + pVO.isStatus() + " "
                    + "WHERE idPessoa = " + pVO.getIdPessoa();

            statement.executeUpdate(sql);
        } catch (Exception e)
        {
            throw new SQLException("Erro ao atualizar Pessoa.\n" + e.getMessage());
        } finally
        {
            conn.close();
            statement.close();
        }
    }
}
