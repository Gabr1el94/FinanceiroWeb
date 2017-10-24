/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio;
import MVC.classes.*;
import MVC.dados.*;
import MVC.negocio.exececao.ExececaoDeNegocio;
import java.util.List;

/**
 *
 * @author User
 */
public class MovimentacaoControle {
    
    private MovimentacaoDAO factoryMovimentacao;
    private Movimentacao movimentacaoTeste;
    public List <Movimentacao> listaMovimentações;
    
    public MovimentacaoControle(){
        
    }
    
    public MovimentacaoControle(Movimentacao movimentacao){
        
        factoryMovimentacao = DAOFactory.getMovimentacaoDAO();
        this.listaMovimentações = factoryMovimentacao.getAll();
        this.movimentacaoTeste = movimentacao;
    
    
    }
    
    
    public void setMovimentacaoTeste(Movimentacao movimentacaoTeste){
        this.movimentacaoTeste = movimentacaoTeste;
    }
    
    
    public String isOK(){
        try {
            testaCategoria();
            testaDescricao();
            testaGerente();
            testaValor();
                        
            return "ok";
                
        } catch (ExececaoDeNegocio ex) {
            return ex.toString();            
        }
    }
    
    private void testaCategoria() throws ExececaoDeNegocio{
        if (movimentacaoTeste.getCategoria().length() > 10 || movimentacaoTeste.getCategoria().length() <= 3) {
        throw new ExececaoDeNegocio("Categoria não pode ter menos de 3 caracteres ou mais de 10", "mensagem_TamanhoInvalidoCategoria");
    }
               
    }
    
    private void testaDescricao() throws ExececaoDeNegocio{
        if (movimentacaoTeste.getDescricao().length() > 40 || movimentacaoTeste.getDescricao().length() <= 3) {
            throw new ExececaoDeNegocio("Descrição não pode ter mais de 40 caracteres ou menos de 3", "mensagem_TamanhoInvalidoCategoria");
        }
    }
    
    private void testaValor() throws ExececaoDeNegocio{
        if (movimentacaoTeste.getValor() == 0.0) {
            throw new ExececaoDeNegocio("Valor não pode ser 0", "mensagem_valorInvalido");
        }
    }
    
    private void testaGerente() throws ExececaoDeNegocio{
        if (movimentacaoTeste.getGerente().equals("")) {
            throw new ExececaoDeNegocio("O nome do Gerente não pode estar vazio", "mensagem_GerenteInexistente");
        }
        if (!movimentacaoTeste.getGerente().equals(movimentacaoTeste.getGerente())){
            throw new ExececaoDeNegocio("Esse Gerente não existe", "mensagem_GerenteInválido");
        }
    }
    
    
    
    
    
}
