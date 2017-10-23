/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.classes;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author gabriel
 */
@Entity
public class Funcionario extends Pessoa {

    @Column(nullable = false, insertable = true, updatable = true)
    private int idGerenteResponsavel;

    public Funcionario() {

    }

    public Funcionario(int idGerenteResponsavel, String nome, String email, Calendar dataNascimento, String cpf, String senha) {
        super(nome, email, dataNascimento, cpf, senha);
        this.idGerenteResponsavel = idGerenteResponsavel;
    }

    public int getIdGerenteResponsavel() {
        return idGerenteResponsavel;
    }

    public void setIdGerenteResponsavel(int idGerenteResponsavel) {
        this.idGerenteResponsavel = idGerenteResponsavel;
    }
}
