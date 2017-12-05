/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.ManageBean;

import MVC.classes.Conta;
import MVC.classes.Gerente;
import MVC.negocio.Fachada;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author robso
 */
@ManagedBean(name = "coBean")
@ViewScoped
public class ContaMB {
      private int id;
      private float saldo;
      private Gerente gerente;
      private Conta conta;
      private List<Conta> listaConta = new ArrayList<Conta>();

    public ContaMB() {
        this.conta = new Conta();
    }
    
         public String prepararAdicionarConta() {
       conta = new Conta();
        return "gerenciarConta";
    }    
         
       public void salvar() {
        try {
            Fachada f = new Fachada();
         f.inserirConta(conta);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void remove(){
            try {
                
                Fachada f = new Fachada();
                 for (Conta conta : f.listarContas()) {
                         f.removerConta(conta.getId());
                         break;
                 }
            
             } catch (Exception e) {
                 e.getMessage();
             }
    }
    
    public void limpar() {
       conta = new Conta();
    }    

    public List<Conta> getListaConta() {
        Fachada f = new Fachada();
        listaConta = f.listarContas();
        return listaConta;
    }

    public void setListaConta(List<Conta> listaConta) {
        this.listaConta = listaConta;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    
    
}
