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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "movBean")
@ViewScoped
public class MovMB {
    private Fachada f;
    private Gerente gerente;
    private List<Movimentacao> listaMovimentacao;
    private Movimentacao movimentacao;

    public MovMB() {
        this.gerente = new Gerente();
        this.listaMovimentacao = new ArrayList<Movimentacao>();
        this.movimentacao = new Movimentacao();
        this.f = new Fachada();
        listarMovimentacao();
    }
    
    private void listarMovimentacao(){
        try{
            listaMovimentacao = f.listarMovimentacao();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
        }
    }
    
    public void salvar() {
        try {
         movimentacao.setGerente(gerente);
         f.inserirMovimentacao(this.movimentacao);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));

        }
    }

     public void limpar() {
        movimentacao = new Movimentacao();
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Movimentacao> getListaMovimentacao() {
        return listaMovimentacao;
    }

    public void setListaMovimentacao(List<Movimentacao> listaMovimentacao) {
        this.listaMovimentacao = listaMovimentacao;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    } 
}
