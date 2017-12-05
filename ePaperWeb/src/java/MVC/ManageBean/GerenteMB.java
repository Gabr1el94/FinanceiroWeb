/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.ManageBean;

import MVC.classes.Gerente;

import MVC.negocio.Fachada;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


 /*
 * @author gabriel
 */
@ManagedBean(name = "geBean")
@ViewScoped
public class GerenteMB implements Serializable {

    private String email, senha, nome, cpf;
    private Calendar dataNascimento = Calendar.getInstance();
    private String tipo;
    private int id;
    private Gerente gerente;
  
        private List<Gerente> listaGerente = new ArrayList<Gerente>();
   
    public GerenteMB() {
        this.gerente = new Gerente();
        
    }
    //Ajax.oncomplete("alert('peek-a-boo');");
    public String prepararAdicionarGerente() {
        gerente = new Gerente();
        return "gerenciarGerente";
    }

    public List<Gerente> getListaGerente() {
        
            Fachada f = new Fachada();
            this.listaGerente = f.listarGerentes();
            
        return listaGerente;
    }

    public void setListaGerente(List<Gerente> listaGerente) {
        this.listaGerente = listaGerente;
    }
    
    public void salvar() {
        try {
            Fachada f = new Fachada();
            f.inserirGerente(gerente);
           
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void remove(){
            try {
                Fachada f = new Fachada();
                f.removerGerente(id);
             } catch (Exception e) {
                 e.getMessage();
             }
    }

    public void limpar() {
        gerente = new Gerente();
    }
}
