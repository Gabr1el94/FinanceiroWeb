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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "fuBean")
@ViewScoped
public class FuncionarioMB implements Serializable {

    private int id;
    private String nome, email, cpf, senha;
    private Calendar dataNascimento = Calendar.getInstance();
    private Funcionario funcionario;
    private Gerente idGerenteResponsavel;

    private List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

    public String prepararAdicionarFuncionario() {
        funcionario = new Funcionario();
        return "gerenciarFuncionario";
    }

    public FuncionarioMB() {
        this.funcionario = new Funcionario();
    }

    public void salvar() {
        try {
            Fachada f = new Fachada();
            f.inserirFuncionario(funcionario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Funcionário adicionado com sucesso!"));

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void remover() {

        try {
            Fachada f = new Fachada();
            for (Funcionario funcionario : f.listarFuncionarios()) {
                f.removerFuncionario(funcionario.getId());
                break;
            }

        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void limpar() {
        funcionario = new Funcionario();
    }

    public List<Funcionario> getListaFuncionario() {
        Fachada f = new Fachada();
        listaFuncionario = f.listarFuncionarios();
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Gerente getIdGerenteResponsavel() {
        return idGerenteResponsavel;
    }

    public void setIdGerenteResponsavel(Gerente idGerenteResponsavel) {
        this.idGerenteResponsavel = idGerenteResponsavel;
    }

}
