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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author robso
 */
@ManagedBean(name = "manipuladorDataTableMB")
@ViewScoped
public class ManipuladorDataTableFuncionarioMB {
        private static final long serialVersionUID = 1L;
          
    private DataTable dataTable;
    private List<Funcionario> funcionarios;

    public ManipuladorDataTableFuncionarioMB() {
     funcionarios = new ArrayList<Funcionario>();
        listarFuncionarios();
    }
    
    public void listarFuncionarios() {
        Fachada f = new Fachada();
        this.funcionarios = f.listarFuncionarios();
    }

    public void remove(){
            try {
                Funcionario funcionarioSelecionado = (Funcionario) dataTable.getRowData();
                Fachada f = new Fachada();
                 for (Funcionario funcionario : f.listarFuncionarios()) {
                     if(funcionario.getId() == funcionarioSelecionado.getId()){
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

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
