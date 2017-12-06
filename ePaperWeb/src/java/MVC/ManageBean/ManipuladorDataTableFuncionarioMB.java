/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.ManageBean;

import MVC.classes.Funcionario;
import MVC.negocio.Fachada;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author robso
 */
@ManagedBean(name = "manipuladorDataTableMB")
@ViewScoped
public class ManipuladorDataTableFuncionarioMB {

    private static final long serialVersionUID = 1L;
    private String nomeFuncionario;
    private DataTable dataTable;
    private List<Funcionario> funcionarios;
    private Fachada f;

    public ManipuladorDataTableFuncionarioMB() {
        this.funcionarios = new ArrayList<Funcionario>();
        this.f = new Fachada();
        listarFuncionarios();
    }

    public void listarFuncionarios() {
        Fachada f = new Fachada();
        this.funcionarios = f.listarFuncionarios();
    }

    public void buscarPeloNome() {
        for (Funcionario funcionario : f.listarFuncionarios()) {
            if (funcionario.getNome().equals(nomeFuncionario)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Usuário encontrado"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuário inexistente."));

            }
        }

    }

    public void remove() {
        try {
            Funcionario funcionarioSelecionado = (Funcionario) dataTable.getRowData();

            for (Funcionario funcionario : f.listarFuncionarios()) {
                if (funcionario.getId() == funcionarioSelecionado.getId()) {
                    f.removerFuncionario(funcionario.getId());
                    break;
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setGerentes(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

}
