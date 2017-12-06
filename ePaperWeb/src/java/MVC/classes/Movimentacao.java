/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.classes;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author gabriel
 */
@Entity
public class Movimentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Cascade(CascadeType.ALL)
    @Column(name = "idMovimentacao", insertable = true, updatable = true)
    private int id;
    private boolean status;

    @Temporal(TemporalType.DATE)
    @Column(insertable = true, updatable = true, nullable = false)
    private Calendar dataEmissao = Calendar.getInstance();

    @Column(name = "Descricao", insertable = true, updatable = true, nullable = false, length = 40)
    private String descricao;

    @Column(name = "Categoria", insertable = true, updatable = true, nullable = false, length = 10)
    private String categoria;

    @Column(name = "Valor", insertable = true, updatable = true, nullable = false, scale = 2)
    private float valor;

    @Enumerated(EnumType.STRING)
    @Column(insertable = true, updatable = true, nullable = true)
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "idGerente", referencedColumnName = "idPessoa", nullable = true, insertable = true, updatable = true, unique = false)
    @Cascade(CascadeType.ALL)
    private Gerente gerente;

    public Movimentacao() {
    }

    public Movimentacao(boolean status, Calendar dataEmissao, String descricao, String categoria, float valor) {
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

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Despesas{" + "status=" + status + ", dataEmissao=" + dataEmissao + ", descricao=" + descricao + ", categoria=" + categoria + ", valor=" + valor + ", gerente=" + gerente + '}';
    }

}
