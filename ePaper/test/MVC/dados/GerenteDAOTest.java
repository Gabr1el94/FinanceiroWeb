/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.dados;

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
        dataNascimento.set(Calendar.YEAR, 1940);
        dataNascimento.set(Calendar.MONTH, Calendar.FEBRUARY);
        dataNascimento.set(Calendar.DAY_OF_MONTH, 05);
        Gerente genTest = new Gerente(1, null, "Fernando Souza", "fern@fern.com", dataNascimento, "103457345", "aaa@123");
        factoryGerente.insert(genTest);

    }

    @Test
    public void testInsertCollection() {
        List<Gerente> listaGerente = new ArrayList<Gerente>();

        Calendar dataNascimento = Calendar.getInstance();

        Gerente genTest2 = new Gerente(2, null, "Marquinho Vicente", "mcente@gmail.com", dataNascimento, "353256781", "ccc@123");
        Gerente genTest3 = new Gerente(3, null, "Gerson Loureiro", "loureiro64@hotmail.com", dataNascimento, "176888975", "kkk@123");
    }
}
