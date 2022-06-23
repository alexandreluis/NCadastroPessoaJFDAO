package br.com.senactech.NCadastroPessoa.dao;

/**
 *
 * @author alexandreluis
 */
public class DAOFactory
{
    private static PessoaDAO pDAO = new PessoaDAO();
    private static CarroDAO cDAO = new CarroDAO();
    
    
    public static PessoaDAO getPessoaDAO()
    {
        return pDAO;
    }
    
    public static CarroDAO getCarroDAO()
    {
        return cDAO;
    }
}