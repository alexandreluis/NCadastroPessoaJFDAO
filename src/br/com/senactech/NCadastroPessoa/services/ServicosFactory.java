package br.com.senactech.NCadastroPessoa.services;

/**
 *
 * @author alexandreluis
 */
public class ServicosFactory
{
    private static PessoaServicos pessoaServicos = new PessoaServicos();
    private static CarroServicos carroServicos = new CarroServicos();
    
    
    public static PessoaServicos getPessoaServicos()
    {
        return pessoaServicos;
    }
    
    public static CarroServicos getCarroServicos()
    {
        return carroServicos;
    }
}