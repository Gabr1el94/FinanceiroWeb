/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.ManageBean;

import MVC.classes.Gerente;
import MVC.classes.Movimentacao;
import MVC.negocio.Fachada;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "manipuladorDataTableMovMB")
@ViewScoped
public class ManipuladorDataTableMovMB {
    private static final long serialVersionUID = 1L;
    private String nomeMovimentacao;      
    private DataTable dataTable;
    private List<Movimentacao> listaMovimentacao;
    private Fachada f;

    public ManipuladorDataTableMovMB() {
        this.listaMovimentacao = new ArrayList<>();
        this.f = new Fachada();
        listarMovimentacao();
    }
    
    private void listarMovimentacao() {
        try{
            this.listaMovimentacao = f.listarMovimentacao();
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    public void remove(){
            try {
                Movimentacao movimentacaoSelecionada = (Movimentacao) dataTable.getRowData();
                
                 for (Movimentacao mov : f.listarMovimentacao()) {
                     if(mov.getId() == movimentacaoSelecionada.getId()){
                         f.removerMovimentacao(mov.getId());
                         break;
                     }
                 }
                
             } catch (Exception e) {
                 e.getMessage();
             }
    }

    public String getNomeMovimentacao() {
        return nomeMovimentacao;
    }

    public void setNomeMovimentacao(String nomeMovimentacao) {
        this.nomeMovimentacao = nomeMovimentacao;
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public List<Movimentacao> getListaMovimentacao() {
        return listaMovimentacao;
    }

    public void setListaMovimentacao(List<Movimentacao> listaMovimentacao) {
        this.listaMovimentacao = listaMovimentacao;
    }
    
    
}
