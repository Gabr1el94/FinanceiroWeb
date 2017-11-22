/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.ManageBean;

import MVC.classes.Conta;
import MVC.classes.Gerente;
import MVC.classes.Pessoa;
import MVC.dados.DAOFactory;
import MVC.dados.GerenteDAO;
import MVC.negocio.Fachada;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author gabriel
 */
@ManagedBean(name = "geBean")
public class GerenteMB implements Serializable {

    // String nome, email, cpf, senha;
    // Calendar dataNascimento = Calendar.getInstance();
    private Gerente gerente = new Gerente();

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

    public void salvar() {
        try {
            GerenteDAO factoryge = DAOFactory.getGerenteDAO();
            factoryge.insert(gerente);
            gerente = new Gerente();
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
