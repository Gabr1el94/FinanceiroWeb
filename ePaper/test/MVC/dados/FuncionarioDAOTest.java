/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.dados;

import MVC.classes.Funcionario;
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
 * @author Rodrigo
 */
public class FuncionarioDAOTest {
    //Variavel Global que inicia a fábrica de Funcionarios (Padrão Factory)
    private FuncionarioDAO factoryFuncionario;
    
    public FuncionarioDAOTest() {
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
        //Instancia a nossa fábrica de Funcionarios
        factoryFuncionario = DAOFactory.getFuncionarioDAO();
    }
    
    @After
    public void tearDown() {
    }
    
    //------------------------TESTA Todo o CRUD do DAOGenerico para <Funcionario>-------------------------------------

    /**
     * Test of insert method, of class DAOGenerico.
     */
    @Test
    public void testInsert() {
        
        Funcionario funTest  = new Funcionario(1,"Rodrigo","rodrigo@gmail.com", Calendar.getInstance(), "34434343", "12345");
        factoryFuncionario.insert(funTest);
        
        Funcionario funTest2  = new Funcionario(1,"Adriano","adr@gmail.com", Calendar.getInstance(), "34434343", "12345");
        factoryFuncionario.insert(funTest2);
    }

    /**
     * Test of insertCollection method, of class DAOGenerico.
     */
    @Test
    public void testInsertCollection() {
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        Funcionario funTest3  = new Funcionario(1,"Pedro","Pedro@gmail.com", Calendar.getInstance(), "34434343", "12345");
        Funcionario funTest4  = new Funcionario(1,"Thiago","Thiago@gmail.com", Calendar.getInstance(), "34434343", "12345");
        Funcionario funTest5  = new Funcionario(1,"Roberto","Roberto@gmail.com", Calendar.getInstance(), "34434343", "12345");
        
        listaFuncionario.add(funTest3);
        listaFuncionario.add(funTest4);
        listaFuncionario.add(funTest5);
        
        factoryFuncionario.insertCollection(listaFuncionario);
    }
    
     /**
     * Test of getAll method, of class DAOGenerico.
     */
    @Test
    public void testGetAll() {
        List<Funcionario> listaFuncionario ;
        listaFuncionario = factoryFuncionario.getAll();
        
    }
    

    /**
     * Test of remove method, of class DAOGenerico.
     */
    @Test
    public void testRemove() {
       Funcionario funcionario = factoryFuncionario.searchByKey(1);
       factoryFuncionario.remove(funcionario);
    }
    
    /**
     * Test of update method, of class DAOGenerico.
     */
    @Test
    public void testUpdate() {
        Funcionario funcionario = factoryFuncionario.searchByKey(2);
        funcionario.setNome("AdrianoNoob");
        factoryFuncionario.update(funcionario);
    }

}
