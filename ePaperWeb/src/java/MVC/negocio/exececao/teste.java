/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio.exececao;

import MVC.classes.Funcionario;
import MVC.classes.Gerente;
import MVC.dados.DAOFactory;
import MVC.dados.GerenteDAO;
import MVC.negocio.Fachada;
import java.util.Calendar;
import javax.jms.Session;

/**
 *
 * @author gabriel
 */
public class teste {
    
    public static void main(String[] args) {
        
        /*
        Gerente gerente = new Gerente();
        gerente.setId(1);
        gerente.setNome("Karlos Nascimento");
        gerente.setCpf("177.254.333-44");
        Calendar dataNascimento=  Calendar.getInstance();
        dataNascimento.set(1994, 12,20);
        gerente.setDataNascimento(dataNascimento);
        gerente.setEmail("biel@biel.com");
        gerente.setSenha("fgv");
        try {
            Fachada f = new Fachada();
            f.atualizarGerente(gerente, gerente);
            System.err.println("Atualização com sucesso");
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        */
        /*
        try {
            Fachada f = new Fachada();
            for (Gerente gerente1 : f.listarGerentes()) {
                   System.out.println("Nome:"+gerente1.getNome());
                   System.out.println("Email:"+gerente1.getEmail());
                   System.out.println("---------------------------");
            }
            
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        */
        
        
        /*
        try {
            Fachada f= new Fachada();
            f.removerGerente(1);
            System.out.println("Remoção com sucesso!");
        } catch (Exception e) {
        }
        */
        Funcionario f1 = new Funcionario();
        try {
            Calendar dataNascimento=Calendar.getInstance();
            
            f1.setNome("Gabriel");
            f1.setEmail("gab@gab.com");
            f1.setSenha("123");
            f1.setCpf("5656951512");
            f1.setDataNascimento(dataNascimento);
            Fachada f = new Fachada();
            f.inserirFuncionario(f1);
        } catch (Exception e) {
            
        }
   
    }
    
}
