/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.ManageBean;

import MVC.classes.Gerente;

import MVC.negocio.Fachada;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


 /*
 * @author gabriel
 */
@ManagedBean(name = "geBean")
@ViewScoped
public class GerenteMB implements Serializable {

    // String nome, email, cpf, senha;
    // Calendar dataNascimento = Calendar.getInstance();
    private Gerente gerente;
    private Gerente gerenteLogado;
  
   
    public GerenteMB() {
        this.gerente = new Gerente();
        this.gerenteLogado = new Gerente();
    }
    //Ajax.oncomplete("alert('peek-a-boo');");
    public String prepararAdicionarGerente() {
        gerente = new Gerente();
        return "gerenciarGerente";
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Gerente getGerenteLogado() {
        return gerenteLogado;
    }

    public void setGerenteLogado(Gerente gerenteLogado) {
        this.gerenteLogado = gerenteLogado;
    }
    
    
   

    public void salvar() {
        try {
            Fachada f = new Fachada();
            f.inserirGerente(gerente);
            limpar();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void update() {
        try {
            Fachada f = new Fachada();
            f.atualizarGerente(gerenteLogado, gerente);
            gerente = new Gerente();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void limpar() {
        gerente = new Gerente();
    }
}
