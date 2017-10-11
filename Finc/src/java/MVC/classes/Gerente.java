/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.classes;

/**
 *
 * @author gabriel
 */
public class Gerente extends Pessoa{
    
     private Conta conta;

    public Gerente() {
    }

    public Gerente(Conta conta) {
        this.conta = conta;
    }

    public Gerente(Conta conta, String nome, String email, String dataNascimento, String cpf, String senha) {
        super(nome, email, dataNascimento, cpf, senha);
        this.conta = conta;
    }
    
     @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    
@Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    
@Override
    public String getDataNascimento() {
        return dataNascimento;
    }
    
@Override
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
@Override
    public String getCpf() {
        return cpf;
    }
@Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
@Override
    public String getSenha() {
        return senha;
    }
@Override
    public void setSenha(String senha) {
        this.senha = senha;
    }


    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
