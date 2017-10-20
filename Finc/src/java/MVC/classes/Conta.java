/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.classes;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author gabriel
 */
@Entity
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Cascade(CascadeType.ALL)
    @Column(name = "idConta", insertable = true, updatable = true)
    private int id;

    @Column(name = "saldoConta", nullable = false, insertable = true, updatable = true, scale = 2)
    private float saldo;

    @OneToOne
    @JoinColumn(name = "idGerente", referencedColumnName = "idPessoa", nullable = true, insertable = true)
    @Cascade(CascadeType.ALL)
    private Gerente gerente;

    public Conta() {
    }

    public Conta(float saldo, Gerente gerente) {
        this.saldo = saldo;
        this.gerente = gerente;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.gerente, other.gerente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta{" + "saldo=" + saldo + ", Titular=" + gerente.getNome() + '}';
    }

}
