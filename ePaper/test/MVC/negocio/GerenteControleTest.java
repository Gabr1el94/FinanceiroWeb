/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio;

import MVC.classes.Gerente;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabriel
 */
public class GerenteControleTest {

    private GerenteControle conGerente;

    public GerenteControleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        conGerente = new GerenteControle();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testIsOkNomeNull() throws Exception {
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(1990, 10, 21);
        Gerente funcGerente = new Gerente(null, "", "gabriel.soares@gmail.com", dataNascimento, "", "");
        conGerente.setGerenteTeste(funcGerente);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Nome não pode ter mais de 60 caracteres ou  menos de 3", conGerente.isok());

    }

}
