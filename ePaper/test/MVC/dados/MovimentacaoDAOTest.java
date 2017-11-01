/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.dados;

import MVC.classes.Movimentacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class MovimentacaoDAOTest {
    
    private MovimentacaoDAO factoryMovimentacao;

    public MovimentacaoDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    //Executa sempre que você roda a classe de teste (Funciona como um "main")
    @Before
    public void setUp() {
        //Instancia a nossa fábrica de Movimentacaos
        factoryMovimentacao = DAOFactory.getMovimentacaoDAO();
    }

    @After
    public void tearDown() {
    }

    
    
    


//------------------------TESTA Todo o CRUD do DAOGenerico para <Movimentacao>-------------------------------------
    /**
     * Test of insert method, of class DAOGenerico.
     */

    /* @Test
     public void testInsert(){
         Movimentacao funTest = new Movimentacao(true, Calendar.getInstance(), "descricao1", "categoria2", 20.0);
         factoryMovimentacao.insert(funTest);
    }
   /**
     * Test of insertCollection method, of class DAOGenerico.
     */
   /* @Test
    public void testInsertCollection() {
        List<Movimentacao> listaMovimentacaos = new ArrayList<Movimentacao>();

        Movimentacao funTest3 = new Movimentacao(true, Calendar.getInstance(), "descricao3", "categoria4", 10.00);
        Movimentacao funTest4 = new Movimentacao(false, Calendar.getInstance(), "descricao3", "descricao4", 200.00);
        Movimentacao funTest5 = new Movimentacao(true, Calendar.getInstance(), "descricao5", "descricao6", 200.00);

        listaMovimentacaos.add(funTest3);
        listaMovimentacaos.add(funTest4);
        listaMovimentacaos.add(funTest5);

        factoryMovimentacao.insertCollection(listaMovimentacaos);
    }

    /**
     * Test of getAll method, of class DAOGenerico.
     */
    /*@Test
    public void testGetAll() {
        List<Movimentacao> listaMovimentacao;
        listaMovimentacao = factoryMovimentacao.getAll();

    }

    /**
     * Test of remove method, of class DAOGenerico.
     */
    /*@Test
    public void testRemove() {
        Movimentacao movimentacao = factoryMovimentacao.searchByKey(1);
        factoryMovimentacao.remove(movimentacao);
    }

    
   /**
     * Test of update method, of class DAOGenerico.
     */
    @Test
    public void testUpdate() {
        Movimentacao movimentacao = factoryMovimentacao.searchByKey(2);
        movimentacao.setCategoria("categorp");
        factoryMovimentacao.update(movimentacao);
    }
  
}