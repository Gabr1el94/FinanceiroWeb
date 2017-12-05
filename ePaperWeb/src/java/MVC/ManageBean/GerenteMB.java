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
    private int id;
    private String nome, email, cpf, senha;
    private Calendar dataNascimento = Calendar.getInstance();
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

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
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
                 for (Gerente gerente : f.listarGerentes()) {
                         f.removerGerente(gerente.getId());
                         break;
                 }
            
             } catch (Exception e) {
                 e.getMessage();
             }
    }
    
    public void limpar() {
        gerente = new Gerente();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
