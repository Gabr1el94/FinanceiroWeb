/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.ManageBean;

import MVC.classes.Gerente;
import MVC.negocio.Fachada;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "manipuladorDataTableMB")
@ViewScoped
public class ManipuladorDataTableGerenteMB {

    private static final long serialVersionUID = 1L;
    private String nomeGerente;
    private DataTable dataTable;
    private List<Gerente> gerentes;
    private Fachada f;

    public ManipuladorDataTableGerenteMB() {
        this.gerentes = new ArrayList<Gerente>();
        this.f = new Fachada();
        listarGerentes();
    }

    public void listarGerentes() {
        Fachada f = new Fachada();
        this.gerentes = f.listarGerentes();
    }

    public void buscarPeloNome() {
        for (Gerente gerente : f.listarGerentes()) {
            if (gerente.getNome().equals(nomeGerente)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Usuário encontrado"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuário inexistente."));

            }
        }

    }

    public void remove() {
        try {
            Gerente gerenteSelecionado = (Gerente) dataTable.getRowData();

            for (Gerente gerente : f.listarGerentes()) {
                if (gerente.getId() == gerenteSelecionado.getId()) {
                    f.removerGerente(gerente.getId());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Gerente removido com sucesso!"));
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

    public List<Gerente> getGerentes() {
        return gerentes;
    }

    public void setGerentes(List<Gerente> gerentes) {
        this.gerentes = gerentes;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

}
