/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio;

import MVC.classes.Funcionario;
import MVC.classes.Gerente;
import MVC.classes.Movimentacao;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class Fachada implements IFachada{
    private FuncionarioControle controleFuncionario;
    private GerenteControle controleGerente;
    private MovimentacaoControle controleMovimentacao;

    public Fachada(FuncionarioControle controleFuncionario, GerenteControle controleGerente, MovimentacaoControle controleMovimentacao) {
        this.controleFuncionario = controleFuncionario;
        this.controleGerente = controleGerente;
        this.controleMovimentacao = controleMovimentacao;
    }

    @Override
    public void inserirFuncionario(Funcionario funcionario) {
        controleFuncionario.inserirFuncionario(funcionario);
    }

    @Override
    public void inserirGerente(Gerente gerente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserirMovimentacao(Movimentacao movimentacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionarioLogado, Funcionario funcionarioAtualizado) {
        controleFuncionario.atualiarFuncionario(funcionarioLogado, funcionarioAtualizado);
    }

    @Override
    public void atualizarGerente(Gerente gerenteLogado, Gerente gerenteAtualizado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarMovimentacao(Movimentacao movimentacao, Movimentacao movimentacao1Atualizada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerFuncionario(int id) {
       controleFuncionario.removerFuncionario(id);
    }

    @Override
    public void removerGerente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerMovimentacao(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        return controleFuncionario.listarFuncionario();
    }

    @Override
    public List<Gerente> listarGerentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movimentacao> listarMovimentacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
