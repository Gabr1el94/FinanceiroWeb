/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.ManageBean;

import MVC.classes.Funcionario;
import MVC.classes.Gerente;

import MVC.negocio.Fachada;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {
    
    private String email,senha;
    String tipo;
    
    public void efetuarLogin() {
        if(tipo.equals("F")){
            checarFuncionario();
        }else if(tipo.equals("G")){
            checarGerente();
        }
    }
    
    public void checarFuncionario(){
        
        try {
            Fachada f = new Fachada();
              for(Funcionario funcionario1 : f.listarFuncionarios()){
                if(funcionario1.getEmail().equals(getEmail()) && funcionario1.getSenha().equals(getSenha())){
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Login Com sucesso."));
                     break;
                }else{
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Login Inválido."));
                     break;
                }
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error! ftfuyghguhjop", e.getMessage()));

        }
      
    }
    
    public void checarGerente(){ 
            try {
               Fachada f = new Fachada();
                for (Gerente gerente1 : f.listarGerentes()) {
                    if (gerente1.getEmail().equals(getEmail())&&gerente1.getSenha().equals(getSenha())) {
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Login Com sucesso."));
                       break;
                    }else{
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Login Inválido."));
                        break;
                    }
                }
            
            } catch (Exception e) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
            }

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
    
}
