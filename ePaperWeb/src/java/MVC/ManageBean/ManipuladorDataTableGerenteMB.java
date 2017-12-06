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
          
    private DataTable dataTable;
    private List<Gerente> gerentes;

    public ManipuladorDataTableGerenteMB() {
        gerentes = new ArrayList<Gerente>();
        listarGerentes();
    }
    
    public void listarGerentes() {
        Fachada f = new Fachada();
        this.gerentes = f.listarGerentes();
    }

    public void remove(){
            try {
                Gerente gerenteSelecionado = (Gerente) dataTable.getRowData();
                Fachada f = new Fachada();
                 for (Gerente gerente : f.listarGerentes()) {
                     if(gerente.getId() == gerenteSelecionado.getId()){
                         f.removerGerente(gerente.getId());
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
}
