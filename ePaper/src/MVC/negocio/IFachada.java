/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio;

import MVC.classes.Conta;
import MVC.classes.Funcionario;
import MVC.classes.Gerente;
import MVC.classes.Movimentacao;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface IFachada {
    
    public void inserirFuncionario(Funcionario funcionario);
    public void inserirGerente(Gerente gerente);
    public void inserirMovimentacao(Movimentacao movimentacao);
    public void inserirConta(Conta conta);
    
    public void atualizarFuncionario(Funcionario funcionarioLogado, Funcionario funcionarioAtualizado );
    public void atualizarGerente(Gerente gerenteLogado, Gerente gerenteAtualizado );
    public void atualizarMovimentacao(Movimentacao movimentacao, Movimentacao movimentacaoAtualizada);
    public void atualizarConta(Conta conta,Conta contaAtualizada);
    
    public void removerFuncionario(int id);
    public void removerGerente(int id);
    public void removerMovimentacao(int id);
    public void removerConta(int id);
    
    public List<Funcionario> listarFuncionarios();
    public List<Gerente> listarGerentes();
    public List<Movimentacao> listarMovimentacao();
    public List<Conta> listarContas();
}
