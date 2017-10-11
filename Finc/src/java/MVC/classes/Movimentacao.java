/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.classes;

/**
 *
 * @author gabriel
 */
public class Movimentacao {
     
    private int id;
    private boolean status;
    private String dataEmissao, descricao, categoria;
    private float valor;
    private enum Tipo  {Recebimento, Despesa}; 
    private Gerente gerente;

    public Movimentacao() {
    }

    public Movimentacao(boolean status, String dataEmissao, String descricao, String categoria, float valor, Gerente gerente) {
        this.status = status;
        this.dataEmissao = dataEmissao;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.gerente = gerente;
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

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Despesas{" + "status=" + status + ", dataEmissao=" + dataEmissao + ", descricao=" + descricao + ", categoria=" + categoria + ", valor=" + valor + ", gerente=" + gerente + '}';
    }
    
}
