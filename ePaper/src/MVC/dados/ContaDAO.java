/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.dados;

import MVC.classes.Conta;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Rodrigo
 */
public class ContaDAO extends DAOGenerico<Conta>{
    
    public ContaDAO(EntityManagerFactory emf) {
		super(emf);
	}
}
