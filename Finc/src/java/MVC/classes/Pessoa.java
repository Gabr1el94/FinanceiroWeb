/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.classes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author gabriel
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Cascade(CascadeType.ALL)
    @Column(name = "idPessoa", insertable = true, updatable = true)
    protected int id;

    @Column(name = "Nome", insertable = true, updatable = true, nullable = false, length = 60)
    protected String nome;

    @Column(name = "Email", insertable = true, updatable = true, nullable = false, length = 100)
    protected String email;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "Nascimento", insertable = true, updatable = true, nullable = false)
    protected Calendar dataNascimento = Calendar.getInstance();

    @Column(name = "Cpf", insertable = true, updatable = true, nullable = false, length = 14)
    protected String cpf;

    @Column(name = "Senha", insertable = true, updatable = true, nullable = false, length = 255)
    protected String senha;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, Calendar dataNascimento, String cpf, String senha) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", senha=" + senha + '}';
    }
}
