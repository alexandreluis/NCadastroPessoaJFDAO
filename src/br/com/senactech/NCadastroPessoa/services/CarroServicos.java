
package br.com.senactech.NCadastroPessoa.services;

import br.com.senactech.NCadastroPessoa.dao.CarroDAO;
import br.com.senactech.NCadastroPessoa.dao.DAOFactory;
import br.com.senactech.NCadastroPessoa.model.Carro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 180900411
 */
public class CarroServicos {
    public void cadCarro(Carro pVO) throws SQLException
    {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.cadastrarCarro(pVO);
    }
    
    public ArrayList<Carro> getTodosCarros() throws SQLException
    {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.listarCarros();
        
        return cDAO.listarCarros();
    }
    
    public boolean existePlaca(String placa) throws SQLException
    {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        
        return cDAO.existePlaca(placa);
    }
    
    public Carro getByDoc(String placa) throws SQLException
    {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        
        return cDAO.getByDoc(placa);
    }
    
    public void deletarCarroBD(int idCarro) throws SQLException
    {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.deletarCarro(idCarro);
    }
    
    public void atualizarCarroBD(Carro pVO) throws SQLException
    {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.atualizarCarro(pVO);
    }
}