/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.ManageBean;

import MVC.classes.Gerente;
import MVC.classes.Movimentacao;
import MVC.classes.Tipo;
import MVC.negocio.Fachada;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.lang.Object;
import    javax.faces.component.UIComponent;
import        javax.faces.component.UIComponentBase;
import         javax.faces.component.UIData;
import                org.primefaces.component.datatable.DataTable;
/**
 *
 * @author robso
 */
@ManagedBean(name = "moBean")
@ViewScoped
public class MovimentacaoMB implements Serializable {
    private int id;
    private boolean status;
    private Calendar dataEmissao = Calendar.getInstance();
    private String descricao, categoria;
    private float valor;
    private Tipo tipo;
    private Gerente gerente;
    private List<Movimentacao> listaMovimentacao = new ArrayList<Movimentacao>();
    private Movimentacao movimentacao;

    public MovimentacaoMB() {
        this.movimentacao = new Movimentacao();
    }
    
       public String prepararAdicionarMovimentacao() {
        movimentacao = new Movimentacao();
        return "gerenciarMovimentacao";
    }
       
        public void salvar() {
        try {
            Fachada f = new Fachada();
         f.inserirMovimentacao(movimentacao);
        } catch (Exception e) {
            e.getMessage();
        }
    }    
        
        public void remove(){
            try {
                
                Fachada f = new Fachada();
                 for (Movimentacao movimentacao : f.listarMovimentacao()) {
                         f.removerMovimentacao(movimentacao.getId());
                         break;
                 }
            
             } catch (Exception e) {
                 e.getMessage();
             }
    }   
        
   public void limpar() {
        movimentacao = new Movimentacao();
    }

    public List<Movimentacao> getListaMovimentacao() {
        Fachada f = new Fachada();
        listaMovimentacao = f.listarMovimentacao();
        return listaMovimentacao;
    }

    public void setListaMovimentacao(List<Movimentacao> listaMovimentacao) {
        this.listaMovimentacao = listaMovimentacao;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Calendar getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Calendar dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }


    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

}
