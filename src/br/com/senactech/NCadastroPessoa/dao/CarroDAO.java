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
                    + pVO.getCor() + "', '"
                    + pVO.getMarca()+ "', '"
                    + pVO.getModelo()+ "', '"
                    + pVO.getPlaca()+ "', '"
                    + pVO.getAnoFabricacao()+ "', '"
                    + pVO.getAnoModelo() + "', '"
                    + pVO.getIdCarro()+ "', '"
                    + pVO.getIdPessoa()+ "', "
                    + pVO.getnPortas()+ ");";
        } catch (Exception e)
        {
            throw new SQLException("Erro ao inserir carro.\n" 
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
}