/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.dados;

import MVC.classes.Conta;
import MVC.classes.Funcionario;
import MVC.classes.Gerente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabriel
 */
public class GerenteDAOTest {

    private GerenteDAO factoryGerente;

    public GerenteDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        factoryGerente = DAOFactory.getGerenteDAO();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsert() {
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(1969, 3, 20);
        Gerente funcTest = new Gerente(null, "Hugo Vicente", "hVict@yahoo.com", dataNascimento, "123456789", "aaa@123");
        factoryGerente.insert(funcTest);
    }

    @Test
    public void testInsertColl() {
        List<Gerente> listaGerente = new ArrayList<Gerente>();
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(1980, 7, 16);
        Gerente funTest = new Gerente(null, "Luiz Kaio", "caio@hotmail.com", dataNascimento, "198765432", "bbb@123");
        Gerente funTest2 = new Gerente(null, "Marcos Pereira", "pmarc@gmail.com", dataNascimento, "5678901234", "ccc@123");
        listaGerente.add(funTest);
        listaGerente.add(funTest2);
        factoryGerente.insertCollection(listaGerente);
    }

    @Test
    public void testGetAll() {
        List<Gerente> listaGerente;
        listaGerente = factoryGerente.getAll();
    }

    @Test
    public void testRemove() {
        Gerente gerente = factoryGerente.searchByKey(163840);
        factoryGerente.remove(gerente);

    }

    @Test
    public void testUpdate() {
        Gerente gerente = factoryGerente.searchByKey(163841);
        gerente.setNome("Otávio Dias");
        factoryGerente.update(gerente);
    }

}
