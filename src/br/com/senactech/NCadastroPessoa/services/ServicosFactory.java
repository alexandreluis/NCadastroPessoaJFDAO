package br.com.senactech.NCadastroPessoa.services;

/**
 *
 * @author alexandreluis
 */
public class ServicosFactory
{
    private static PessoaServicos pessoaServicos = new PessoaServicos();
    
    public static PessoaServicos getPessoaServicos()
    {
        return pessoaServicos;
    }
}