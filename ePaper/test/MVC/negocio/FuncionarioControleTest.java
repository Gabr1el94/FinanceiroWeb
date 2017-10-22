/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio;

import MVC.classes.Funcionario;
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
 * @author Rodrigo
 */
public class FuncionarioControleTest {
    FuncionarioControle controle;
    
    public FuncionarioControleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        controle = new FuncionarioControle();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isOk method, of class FuncionarioControle.
     */
    
    
    @Test
    public void testIsOkNomeNulo() throws Exception {
        Funcionario funcionarioTestaNome = new Funcionario(1,"","nulo@gmail.com",Calendar.getInstance(),"2323234564384","123456");
        controle.setFuncionarioTeste(funcionarioTestaNome);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Nome não pode ter mais de 60 caracteres ou  menos de 3", controle.isOk());
    }
    
    @Test
    public void testIsOkNomeTamano() throws Exception {
        Funcionario funcionarioTestaNome2 = new Funcionario(1,"rrr","nulo@gmail.com",Calendar.getInstance(),"2323234564384","123456");
        controle.setFuncionarioTeste(funcionarioTestaNome2);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Nome não pode ter mais de 60 caracteres ou  menos de 3", controle.isOk());
        
        
    }
    
    @Test
    public void testIsOkNomeTamanoMaior() throws Exception {
        Funcionario funcionarioTestaNome3 = new Funcionario(1,"rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr","nulo@gmail.com",Calendar.getInstance(),"2323234564384","123456");
        controle.setFuncionarioTeste(funcionarioTestaNome3);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Nome não pode ter mais de 60 caracteres ou  menos de 3", controle.isOk());
        
        
    }
    
    @Test
    public void testIsOkEmailNulo() throws Exception {
        Funcionario funcionarioTestaNome4 = new Funcionario(1,"Rodrigo","",Calendar.getInstance(),"2323234564384","123456");
        controle.setFuncionarioTeste(funcionarioTestaNome4);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Email não pode ser nulo", controle.isOk());
        
        
    }
    
    @Test
    public void testIsOkEmaiMaior() throws Exception {
        Funcionario funcionarioTestaNome5 = new Funcionario(1,"Rodrigo","rodrigo@shsuauhsauhhusauhsahu.com",Calendar.getInstance(),"2323234564384","123456");
        controle.setFuncionarioTeste(funcionarioTestaNome5);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Email não pode ter mais de 30 caracteres", controle.isOk());
    }
    
    @Test
    public void testIsOkEmailInvalido() throws Exception {
        Funcionario funcionarioTestaNome5 = new Funcionario(1,"Rodrigo","rodrigo.com",Calendar.getInstance(),"2323234564384","123456");
        controle.setFuncionarioTeste(funcionarioTestaNome5);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Email inválido", controle.isOk());
    }
    
    @Test
    public void testIsOkCpfNulo() throws Exception {
        Funcionario funcionarioTestaNome6 = new Funcionario(1,"Rodriooogo","adr@gmail.com",Calendar.getInstance(),"","123456");
        controle.setFuncionarioTeste(funcionarioTestaNome6);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Cpf não pode ser nulo", controle.isOk());
    }
    
     @Test
    public void testIsOkCpfMaior() throws Exception {
        Funcionario funcionarioTestaNome6 = new Funcionario(1,"Rodriooogo","adr@gmail.com",Calendar.getInstance(),"4343434343434343434343","123456");
        controle.setFuncionarioTeste(funcionarioTestaNome6);
        Assert.assertEquals("MVC.negocio.exececao.ExececaoDeNegocio: Cpf não pode ter mais de 14 caracteres", controle.isOk());
    }
    
}
