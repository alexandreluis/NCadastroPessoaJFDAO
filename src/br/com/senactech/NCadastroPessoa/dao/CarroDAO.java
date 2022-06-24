package br.com.senactech.NCadastroPessoa.dao;

import br.com.senactech.NCadastroPessoa.conexao.Conexao;
import br.com.senactech.NCadastroPessoa.model.Carro;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alexandreluis
 */
public class CarroDAO
{
    public void cadastrarCarro(Carro pVO) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        
        Statement statement = conn.createStatement();
        
        try
        {
            String sql;

            sql = "INSERT INTO carro VALUES (null, '" 
                    + pVO.getPlaca() + "', '"
                    + pVO.getMarca() + "', '"
                    + pVO.getModelo() + "', "
                    + pVO.getAnoFabricacao() + ", "
                    + pVO.getAnoModelo() + ", '"
                    + pVO.getCor() + "', "
                    + pVO.getnPortas() + ", "
                    + pVO.getIdPessoa() + ");";
            
            statement.execute(sql);
        } catch (Exception e)
        {
            throw new SQLException("Erro ao inserir carro. CPF não cadastrado. \n" 
                    + e.getMessage());
        } finally
        {
            conn.close();
            statement.close();
        }
    }
    
    public ArrayList<Carro> listarCarros() throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement= conn.createStatement();
        
        try
        {
            String sql;
            sql = "SELECT * FROM carro";
            
            ResultSet rs = statement.executeQuery(sql);
            
            ArrayList<Carro> carros = new ArrayList<>();
            
            while(rs.next())
            {
                Carro carro = new Carro();
                
                carro.setIdCarro(rs.getInt("idCarro"));
                carro.setPlaca(rs.getString("placa"));
                carro.setMarca(rs.getString("marca"));
                carro.setModelo(rs.getString("modelo"));
                carro.setAnoFabricacao(rs.getInt("anoFabricacao"));
                carro.setAnoModelo(rs.getInt("anoModelo"));
                carro.setCor(rs.getString("cor"));
                carro.setnPortas(rs.getInt("nPortas"));
                carro.setIdPessoa(rs.getInt("idPessoa"));
                
                carros.add(carro);
            }
            
            return carros;
        } catch (Exception e)
        {
            throw new SQLException("Erro ao buscar carros.\n + "
                    + e.getMessage());
        } finally
        {
            conn.close();
            statement.close();
        }
    }
    
    //ref. método verPlaca
    public boolean existePlaca(String placa) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();
        
        boolean existePlaca = false;
        
        try {
            String sql;
            sql = "SELECT placa FROM carro WHERE placa = " + placa;
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next())
            {
                existePlaca = rs.wasNull();
            }
        } catch (Exception e) {
            throw new SQLException("Esta placa não consta em noss sistema." + 
                    e.getMessage());
        } finally {
            conn.close();
            statement.close();
        }
        
        return existePlaca;
    }
    
    public Carro getByDoc(String placa) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();
        
        Carro c = new Carro();
        
        try {
            String sql;
            sql = "SELECT * FROM carro WHERE placa = " + placa;
            
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next())
            {
                c.setIdCarro(rs.getInt("idCarro"));
                c.setPlaca(rs.getString("placa"));
                c.setModelo(rs.getString("modelo"));
                c.setAnoFabricacao(rs.getInt("anoFabricacao"));
                c.setAnoModelo(rs.getInt("anoModelo"));
                c.setCor(rs.getString("cor"));
                c.setnPortas(rs.getInt("nPortas"));
            }
        } catch (Exception e) {
            throw new SQLException("Carro não existe no sistema.\n" + 
             e.getMessage());
        } finally {
            conn.close();
            statement.close();
        }
        
        return c;
    }
    
    public void deletarCarro(int idCarro) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();
        
        try {
            String sql;
            sql = "DELETE FROM carro WHERE idCarro = " + idCarro;
            statement.execute(sql);
        } catch (Exception e) {
            throw new SQLException("Erro ao deletar carro.\n" + e.getMessage());
        } finally {
            conn.close();
            statement.close();
        }
    }
    
    public void atualizarCarro(Carro pVO) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();
        
        try {
            String sql;
            sql = "UPDATE carro SET " +
                    "placa = '" + pVO.getPlaca() + "', " +
                    "modelo = '" + pVO.getModelo() + "', " + 
                    "anoFabricacao = " + pVO.getAnoModelo() + ", " + 
                    "anoModelo = " + pVO.getAnoFabricacao() + ", " + 
                    "cor = '" + pVO.getCor() + "', " + 
                    "nPortas = " + pVO.getnPortas() + 
                    "WHERE idCarro = " + pVO.getIdCarro();
            
            statement.executeUpdate(sql);
        } catch (Exception e) {
            throw new SQLException("Erro ao atualizar as informações do Carro.\n" +
                    e.getMessage());
        } finally {
            conn.close();
            statement.close();
        }
    }
}