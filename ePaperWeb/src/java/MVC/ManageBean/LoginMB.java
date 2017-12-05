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
import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    private String email, senha, nome, cpf;
    private Calendar dataNascimento = Calendar.getInstance();
    private String tipo;
    private int id;
    private Gerente gerente;
    private Funcionario funcionario;


    public LoginMB() {
        this.gerente = new Gerente();
        this.funcionario = new Funcionario();
        
    }

    public void efetuarLogin() {
        if (tipo.equals("F")) {
            checarFuncionario();
        } else if (tipo.equals("G")) {
            checarGerente();
        }
    }

    public void checarFuncionario() {

        try {
            Fachada f = new Fachada();
            for (Funcionario funcionario1 : f.listarFuncionarios()) {
                if (funcionario1.getEmail().equals(getEmail()) && funcionario1.getSenha().equals(getSenha())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Login Com sucesso."));
                    FacesContext.getCurrentInstance().getExternalContext().redirect("faces/funcionario/index.xhtml");

                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Login Inválido."));

                }
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error! ftfuyghguhjop", e.getMessage()));

        }

    }

    public void checarGerente() {
        try {
            Fachada f = new Fachada();
            for (Gerente gerente1 : f.listarGerentes()) {
                if (gerente1.getEmail().equals(getEmail()) && gerente1.getSenha().equals(getSenha())) {
                    this.nome = gerente1.getNome();
                    this.id = gerente1.getId();
                    this.cpf = gerente1.getCpf();
                    this.dataNascimento = gerente1.getDataNascimento();
                    this.senha = gerente1.getSenha();
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                    session.setAttribute("email", getEmail());
                    session.setAttribute("nome", getNome());
                    session.setAttribute("cpf", getCpf());
                    session.setAttribute("id", getId());
                    session.setAttribute("senha", getSenha());
                    session.setAttribute("dataNascimento", getDataNascimento());
                    
                    FacesContext.getCurrentInstance().getExternalContext().redirect("faces/gerente/consulta.xhtml");
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Login Inválido."));

                }
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
        }

    }
    
     public void updateGerente() {
        try {
            Fachada f = new Fachada();
            gerente.setId(id);
            gerente.setNome(nome);
            gerente.setSenha(senha);
            gerente.setEmail(email);
            gerente.setDataNascimento(dataNascimento);
            gerente.setCpf(cpf);
            f.atualizarGerente(gerente, gerente);
        } catch (Exception e) {
            e.getMessage();
        }
    }
  public void updateFuncionario() {
        try {
            Fachada f = new Fachada();
            funcionario.setId(id);
            funcionario.setNome(nome);
            funcionario.setSenha(senha);
            funcionario.setEmail(email);
            funcionario.setDataNascimento(dataNascimento);
            funcionario.setCpf(cpf);
           
         f.atualizarFuncionario(funcionario, funcionario);
        } catch (Exception e) {
            e.getMessage();
        }
  }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento =  dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

 

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
