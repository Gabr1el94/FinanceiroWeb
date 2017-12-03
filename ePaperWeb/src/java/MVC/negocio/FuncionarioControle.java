/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio;

import MVC.classes.Funcionario;
import MVC.dados.DAOFactory;
import MVC.dados.FuncionarioDAO;
import MVC.negocio.exececao.ExcecaoDeNegocio;
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
   

    public FuncionarioControle() {
        factoryFuncionario = DAOFactory.getFuncionarioDAO();
    }

    public FuncionarioControle(Funcionario funcionario) {
        factoryFuncionario = DAOFactory.getFuncionarioDAO();
        this.funcionarioTeste = funcionario;
    }

    public void setFuncionarioTeste(Funcionario funcionarioTeste) {
        this.funcionarioTeste = funcionarioTeste;
    }

    public String isOk() {
        try {
            testaNome();
            testaEmail();
            testaCpf();
            testaSenha();
            

            return "ok";
        } catch (ExcecaoDeNegocio ex) {
            return ex.toString();
        }
    }
    
    public void inserirFuncionario(Funcionario funcionarioAdd){
        factoryFuncionario.insert(funcionarioAdd);      
    }
    
    public void removerFuncionario(int id){
        Funcionario funcionarioRemover = factoryFuncionario.searchByKey(id);
        factoryFuncionario.remove(funcionarioRemover);
    }
    
    
    public void atualiarFuncionario(Funcionario funcionarioLogado, Funcionario funcionarioAtualizado){
        Funcionario funcionarioModificado = factoryFuncionario.searchByKey(funcionarioLogado.getId());
        
        funcionarioModificado.setNome(funcionarioAtualizado.getNome());
        funcionarioModificado.setSenha(funcionarioAtualizado.getSenha());
        funcionarioModificado.setCpf(funcionarioAtualizado.getCpf());
        funcionarioModificado.setDataNascimento(funcionarioAtualizado.getDataNascimento());
        funcionarioModificado.setIdGerenteResponsavel(funcionarioAtualizado.getIdGerenteResponsavel());
        
        factoryFuncionario.update(funcionarioModificado);
    }
    
    public List<Funcionario> listarFuncionario(){
        return factoryFuncionario.getAll();
    }

    private void testaNome() throws ExcecaoDeNegocio {
        if (funcionarioTeste.getNome().length() > 60 || funcionarioTeste.getNome().length() <= 3) {
            throw new ExcecaoDeNegocio("Nome não pode ter mais de 60 caracteres ou  menos de 3", "mensagem_TamanhoInvalidoNome");
        }
    }

    private void testaEmail() throws ExcecaoDeNegocio {
        if (funcionarioTeste.getEmail().trim().equals("")) {
            throw new ExcecaoDeNegocio("Email não pode ser nulo", "mensagem_emailNulo");
        }
        if (funcionarioTeste.getEmail().trim().length() > 30) {
            throw new ExcecaoDeNegocio("Email não pode ter mais de 30 caracteres", "mensagem_TamanhoInvalidoEmail");
        }

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(funcionarioTeste.getEmail());

        if (!(matcher.matches())) {
            throw new ExcecaoDeNegocio("Email inválido", "mensagem_emailInvalido");
        }

    }

    private void testaCpf() throws ExcecaoDeNegocio {
        if (funcionarioTeste.getCpf().trim().equals("")) {
            throw new ExcecaoDeNegocio("Cpf não pode ser nulo", "mensagem_cpfNulo");
        }
        if (funcionarioTeste.getCpf().length() > 14) {
            throw new ExcecaoDeNegocio("Cpf não pode ter mais de 14 caracteres", "mensagem_tamanhoInvalidoCpf");
        }

    }

    private void testaSenha() throws ExcecaoDeNegocio {
        if (funcionarioTeste.getSenha().trim().equals("") || funcionarioTeste.getSenha().trim().equals(null)) {
            throw new ExcecaoDeNegocio("Senha não pode ser nula", "mensagem_senhaNula");
        }
        if (funcionarioTeste.getSenha().trim().length() > 255) {
            throw new ExcecaoDeNegocio("Senha não pode conter mais de 255 caracteres", "mensagem_tamanhoInvalidoSenha");
        }
    }

}
