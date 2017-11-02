/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.dados;

import MVC.classes.Conta;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author robso
 */
public class ContaDAOTest {

  private ContaDAO factoryConta;
     
      public ContaDAOTest() {
    }
     @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
 @Before
    public void setUp() {
        //Instancia a nossa fábrica de Funcionarios
        factoryConta = DAOFactory.getContaDAO();
    }
  @After
    public void tearDown() {
    }
 @Test
    public void testInsert() {
     Conta con = new Conta ();
       con.setSaldo(500);
       factoryConta.insert(con);
    }
 @Test
    public void testInsertCollection() {
        List<Conta> listaConta = new ArrayList<Conta>();

       Conta cont = new Conta();
       cont.setSaldo(122);
       Conta cont1 = new Conta();
       cont1.setSaldo(300);
       listaConta.add(cont);
        listaConta.add(cont1);
       

        factoryConta.insertCollection(listaConta);
    }    
 @Test
    public void testGetAll() {
        List<Conta> listaConta;
        listaConta = factoryConta.getAll();

    }
    @Test
    public void testRemove() {
        Conta conta = factoryConta.searchByKey(1);
        factoryConta.remove(conta);
    }
    @Test
    public void testUpdate() {
        Conta conta = factoryConta.searchByKey(2);
        conta.setSaldo(100);
        factoryConta.update(conta);
    }
}
