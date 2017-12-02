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
import MVC.classes.Pessoa;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class Fachada implements IFachada {

    private FuncionarioControle controleFuncionario;
    private GerenteControle controleGerente;
    private MovimentacaoControle controleMovimentacao;
    private ContaControle controleConta;

    public Fachada() {
        this.controleFuncionario = new FuncionarioControle() ;
        this.controleGerente = new GerenteControle();
        this.controleMovimentacao = new MovimentacaoControle();
        this.controleConta = new ContaControle();
    }

   

    @Override
    public void inserirFuncionario(Funcionario funcionario) {
        controleFuncionario.inserirFuncionario(funcionario);
    }

    @Override
    public void inserirGerente(Gerente gerente) {
        controleGerente.inserirGerente(gerente);
    }

    @Override
    public void inserirMovimentacao(Movimentacao movimentacao) {
        controleMovimentacao.inserirMovimentacao(movimentacao);
    }

    @Override
    public void inserirConta(Conta conta) {
        controleConta.inserirConta(conta);
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionarioLogado, Funcionario funcionarioAtualizado) {
        controleFuncionario.atualiarFuncionario(funcionarioLogado, funcionarioAtualizado);
    }

    @Override
    public void atualizarGerente(Gerente gerenteLogado, Gerente gerenteAtualizado) {
        controleGerente.atualizarGerente(gerenteLogado, gerenteAtualizado);
    }

    @Override
    public void atualizarMovimentacao(Movimentacao movimentacao, Movimentacao movimentacao1Atualizada) {
        controleMovimentacao.atualiarMovimentacao(movimentacao, movimentacao1Atualizada);
    }

    @Override
    public void atualizarConta(Conta contaLogada, Conta contaAtualizada) {
        controleConta.atualizarConta(contaLogada, contaAtualizada);
    }

    @Override
    public void removerFuncionario(int id) {
        controleFuncionario.removerFuncionario(id);
    }

    @Override
    public void removerGerente(int id) {
        controleGerente.removerGerente(id);
    }

    @Override
    public void removerMovimentacao(int id) {
        controleMovimentacao.removerMovimentacao(id);
    }

    @Override
    public void removerConta(int id) {
        controleConta.removerConta(id);
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        return controleFuncionario.listarFuncionario();
    }

    @Override
    public List<Gerente> listarGerentes() {
        return controleGerente.listarGerente();
    }

    @Override
    public List<Movimentacao> listarMovimentacao() {
        return controleMovimentacao.listarMovimentacao();
    }

    @Override
    public List<Conta> listarContas() {
        return controleConta.listarConta();

    }
}
