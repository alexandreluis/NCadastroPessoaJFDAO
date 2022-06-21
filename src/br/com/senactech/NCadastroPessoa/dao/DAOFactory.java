package br.com.senactech.NCadastroPessoa.dao;

/**
 *
 * @author alexandreluis
 */
public class DAOFactory
{
    private static PessoaDAO pDAO = new PessoaDAO();
    
    public static PessoaDAO getPessoaDAO()
    {
        return pDAO;
    }  
}