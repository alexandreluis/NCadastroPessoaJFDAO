package br.com.senactech.NCadastroPessoa.services;

import br.com.senactech.NCadastroPessoa.dao.PessoaDAO;
import br.com.senactech.NCadastroPessoa.dao.DAOFactory;
import br.com.senactech.NCadastroPessoa.model.Pessoa;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author alexandreluis
 */
public class PessoaServicos
{
    //
    public void cadPessoa(Pessoa pVO) throws SQLException
    {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.cadastrarPessoa(pVO);
    }
    
    public ArrayList<Pessoa> getPessoas() throws SQLException
    {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.listarPessoas();
    }
    
    public boolean verCPFDB(String cpf) throws SQLException
    {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.verCPF(cpf);
    }
    
    public Pessoa getPessoaByDoc(String cpf) throws SQLException
    {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.getByDoc(cpf);
    }
    
    public Pessoa getPessoaById(int idPessoa) throws SQLException
    {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.getById(idPessoa);
    }
    
    public void deletarPessoaBD(int id) throws SQLException
    {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.deletarPessoa(id);
    }

    public void atualizarPessoaBD(Pessoa pVO) throws SQLException
    {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.atualizarPessoa(pVO);
    }
}