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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "fuBean")
@ViewScoped
public class FuncionarioMB implements Serializable{
    
    private Funcionario funcionario;

    public FuncionarioMB() {
        this.funcionario = new Funcionario();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public void salvar() {
        try {
            Fachada f = new Fachada();
            f.inserirFuncionario(funcionario);
            limpar();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void update() {
        try {
            Fachada f = new Fachada();
            f.atualizarFuncionario(funcionario, funcionario);
            funcionario = new Funcionario();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void limpar() {
        funcionario = new Funcionario();
    }
 
}
