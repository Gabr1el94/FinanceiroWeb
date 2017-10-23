/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio;

import MVC.classes.Gerente;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        Gerente funcGerente = new Gerente(null, "", "gabriel.soares@gmail.com", dataNascimento, "212.121.211-22", "aaa@123");
        conGerente.setGerenteTeste(funcGerente);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Nome não pode ser nulo", conGerente.isok());
    }

    @Test
    public void testIsOkNomeTamanoMaior() throws Exception {
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(1990, 10, 21);
        Gerente funcGerente = new Gerente(null, "rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr", "gabriel.soares@gmail.com", dataNascimento, "209.171.981-20", "bbb@123");
        conGerente.setGerenteTeste(funcGerente);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Nome não pode ter mais de 60 caracteres ou  menos de 3", conGerente.isok());
    }

    @Test
    public void testIsOkEmailNulo() throws Exception {
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(1990, 10, 21);
        Gerente funcGerente = new Gerente(null, "gabriel", "", dataNascimento, "209.171.981-20", "bbb@123");
        conGerente.setGerenteTeste(funcGerente);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Email não pode ser vázio", conGerente.isok());

    }

    @Test
    public void testIsOkEmaiMaior() throws Exception {
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(1990, 10, 21);
        Gerente funcGerente = new Gerente(null, "gabriel", "gabriel@gchufhbvuhjcvdjjnjnjnjnjfivfkmjgkb.com", dataNascimento, "209.171.981-20", "bbb@123");
        conGerente.setGerenteTeste(funcGerente);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Email não pode ter mais de 30 caracteres", conGerente.isok());
    }

    @Test
    public void testNascimentoNull() {
        Calendar dataNascimento = null;
        Gerente funcGerente = new Gerente(null, "gabriel soares", "gabriel.soares@gmail.com", dataNascimento, "212.121.211-22", "aaa@123");
        conGerente.setGerenteTeste(funcGerente);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Data Nascimento não pode ser nulo", conGerente.isok());
    }

    @Test
    public void testNascimentoNow() {
        Calendar dataNascimento = Calendar.getInstance();
        Gerente funcGerente = new Gerente(null, "gabriel soares", "gabriel.soares@gmail.com", dataNascimento, "212.121.211-22", "aaa@123");
        conGerente.setGerenteTeste(funcGerente);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Data Nascimento não pode ser inserido com a data atual", conGerente.isok());
    }

    @Test
    public void testIsOkCpfMaior() throws Exception {
        Calendar dataNascimento = Calendar.getInstance();
        Gerente funcGerente = new Gerente(null, "gabriel soares", "gabriel.soares@gmail.com", dataNascimento, "212.121.211-22432", "aaa@123");
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Cpf não pode ter mais de 14 caracteres", conGerente.isok());
    }

    @Test
    public void testIsOkCpfNull() throws Exception {
        Calendar dataNascimento = Calendar.getInstance();
        Gerente funcGerente = new Gerente(null, "gabriel soares", "gabriel.soares@gmail.com", dataNascimento, "", "aaa@123");
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Cpf não pode ser nulo", conGerente.isok());
    }

}
