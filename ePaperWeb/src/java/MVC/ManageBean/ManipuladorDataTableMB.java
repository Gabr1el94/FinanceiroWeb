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

/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "manipuladorDataTableMB")
@ViewScoped
public class ManipuladorDataTableMB {
    private static final long serialVersionUID = 1L;
          
    private HtmlDataTable dataTable;
    private List<Gerente> gerentes;

    public ManipuladorDataTableMB() {
        gerentes = new ArrayList<Gerente>();
        listarGerentes();
    }
    
    public void listarGerentes() {
        Fachada f = new Fachada();
        this.gerentes = f.listarGerentes();
    }
    
    public void selecionarLinha(){
           Gerente gerenteSelecionado = (Gerente) dataTable.getRowData();
      }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    public List<Gerente> getGerentes() {
        return gerentes;
    }

    public void setGerentes(List<Gerente> gerentes) {
        this.gerentes = gerentes;
    }
}
