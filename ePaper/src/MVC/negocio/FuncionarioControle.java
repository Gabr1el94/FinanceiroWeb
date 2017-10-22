/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio;

import MVC.classes.Funcionario;
import MVC.dados.DAOFactory;
import MVC.dados.FuncionarioDAO;
import MVC.negocio.exececao.ExececaoDeNegocio;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rodrigo
 */
public class FuncionarioControle {
    
    private FuncionarioDAO factoryFuncionario;
    private Funcionario funcionarioTeste;
    public List<Funcionario> listaFuncionarios; 
    
    public FuncionarioControle(){
        
    }
    
    public FuncionarioControle(Funcionario funcionario){
        factoryFuncionario = DAOFactory.getFuncionarioDAO();
        this.listaFuncionarios = factoryFuncionario.getAll();
        this.funcionarioTeste = funcionario;
    }

    public void setFuncionarioTeste(Funcionario funcionarioTeste) {
        this.funcionarioTeste = funcionarioTeste;
    }

    public String isOk() {
        try{
        testaNome();
        testaEmail();
        testaCpf();
        testaSenha();
        
        return "ok";
        }catch(ExececaoDeNegocio ex){
            System.out.println(ex.toString());
            return ex.toString();
           
        }
    }
    
    private void testaNome() throws ExececaoDeNegocio{
        if(funcionarioTeste.getNome().length() > 60 || funcionarioTeste.getNome().length() <= 3){
            throw new ExececaoDeNegocio ("Nome não pode ter mais de 60 caracteres ou  menos de 3", "mensagem_TamanhoInvalidoNome");
        }
    }
    
    private void testaEmail() throws ExececaoDeNegocio{
        if(funcionarioTeste.getEmail().equals("")){
            throw new ExececaoDeNegocio ("Email não pode ser nulo", "mensagem_emailNulo");
        }
        if(funcionarioTeste.getEmail().length() > 30){
            throw new ExececaoDeNegocio ("Email não pode ter mais de 30 caracteres", "mensagem_TamanhoInvalidoEmail");
        }
        
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(funcionarioTeste.getEmail());
        
        if(!(matcher.matches())){
            throw new ExececaoDeNegocio ("Email inválido", "mensagem_emailInvalido");
        }
 
    }
    
    private void testaCpf() throws ExececaoDeNegocio{
        if(funcionarioTeste.getCpf().equals("") ){
            throw new ExececaoDeNegocio ("Cpf não pode ser nulo", "mensagem_cpfNulo");
        }
        if(funcionarioTeste.getCpf().length() > 14){
            throw new ExececaoDeNegocio ("Cpf não pode ter mais de 14 caracteres", "mensagem_tamanhoInvalidoCpf");
        }

    }
    
    private void testaSenha() throws ExececaoDeNegocio{
        if(funcionarioTeste.getSenha().equals("") || funcionarioTeste.getSenha().equals(null)){
            throw new ExececaoDeNegocio ("Senha não pode ser nula", "mensagem_senhaNula");
        }
        if(funcionarioTeste.getSenha().length() > 255){
            throw new ExececaoDeNegocio ("Senha não pode conter mais de 255 caracteres", "mensagem_tamanhoInvalidoSenha");
        }
    }

}

