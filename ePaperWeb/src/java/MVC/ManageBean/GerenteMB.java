/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.ManageBean;

import MVC.classes.Gerente;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gabriel
 */
@ManagedBean
@ViewScoped
public class GerenteMB implements Serializable{
   //Ajax.oncomplete("alert('peek-a-boo');");
    private Gerente gerente = new Gerente();
   

    public GerenteMB() {
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    
     
    
}
