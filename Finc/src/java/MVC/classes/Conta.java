/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.classes;

import java.util.Objects;

/**
 *
 * @author gabriel
 */
public class Conta {
    
    private int id;
    private float saldo;
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
