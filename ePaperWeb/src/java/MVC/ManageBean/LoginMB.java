/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.ManageBean;

import MVC.classes.Funcionario;
import MVC.classes.Gerente;
import MVC.negocio.Fachada;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {
    
    private String email,senha, mensagem, tipo;
    Fachada f = new Fachada();
    
    public void efetuarLogin() {
        if(tipo.equals("F")){
            checarFuncionario();
        }else if(tipo.equals("G")){
            checarGerente();
        }
    }
    
    public void checarFuncionario(){
        for(Funcionario funcionario : f.listarFuncionarios()){
                if(funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha)){
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Login Com sucesso."));
                }
            }
    }
    
    public void checarGerente(){
        
            for(Gerente gerente : f.listarGerentes()){
                if(gerente.getEmail().equals(email) && gerente.getSenha().equals(senha)){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Login Com sucesso."));
                } 
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Login Inválido."));
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
