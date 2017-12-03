/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio;

import MVC.classes.Conta;
import MVC.dados.ContaDAO;
import MVC.dados.DAOFactory;

import java.util.List;


 
/**
 *
 * @author robso
 */
public class ContaControle {
     private ContaDAO factoryConta;
    private Conta contaTeste;

    public ContaControle() {
        factoryConta = DAOFactory.getContaDAO();
    }
  public ContaControle(Conta conta) {
        factoryConta = DAOFactory.getContaDAO();
        this.contaTeste = conta;
    }    
    public void setContaTeste(Conta contaTeste) {
        this.contaTeste = contaTeste;
    }
    public void inserirConta(Conta contaAdd){
        setContaTeste(contaAdd);
        factoryConta.insert(contaTeste);      
    }
  public void removerConta(int id){
        Conta contaRemover = factoryConta.searchByKey(id);
        factoryConta.remove(contaRemover);
    }
   public void atualizarConta(Conta contaLogada, Conta contaAtualizada){
        Conta contaModificada = factoryConta.searchByKey(contaLogada.getId());
        
       contaModificada.setGerente(contaAtualizada.getGerente());
       contaModificada.setSaldo(contaAtualizada.getSaldo());
        
        factoryConta.update(contaModificada);
    }
  public List<Conta> listarConta(){
        return factoryConta.getAll();
    }
}
