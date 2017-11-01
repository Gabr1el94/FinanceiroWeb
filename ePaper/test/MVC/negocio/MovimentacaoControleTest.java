/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio;
import MVC.classes.Movimentacao;
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
 * @author Vinícius
 */
public class MovimentacaoControleTest {
    
    MovimentacaoControle conMovimentacao;

    public MovimentacaoControleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        conMovimentacao = new MovimentacaoControle();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void isOkDescricaoNull() throws Exception{
        Calendar dataEmissao = Calendar.getInstance();
        Movimentacao mov = new Movimentacao(true, dataEmissao, "", "categoria3", 2.5);
        conMovimentacao.setMovimentacaoTeste(mov);
        Assert.assertEquals("MVC.negocio.exececao.ExcecaoDeNegocio: Descrição não pode ter mais de 40 caracteres ou menos de 3", conMovimentacao.isOK());
    }
    
    @Test
    public void isOkDescricaoTamano() throws Exception{
        Calendar dataEmissao = Calendar.getInstance();
        Movimentacao mov2 = new Movimentacao(true, dataEmissao, "des", "categoria3", 2.5);
        conMovimentacao.setMovimentacaoTeste(mov2);
        Assert.assertEquals("MVC.negocio.exececao.ExcecaoDeNegocio: Descrição não pode ter mais de 40 caracteres ou menos de 3", conMovimentacao.isOK());
    }
    
    @Test
    public void isOkDescricaoTamanoMaior() throws Exception{
        Calendar dataEmissao = Calendar.getInstance();
        Movimentacao mov3 = new Movimentacao(true, dataEmissao, "descricaokasjdlaksjdioqwuenmalskndklasjdlasmclaskdjlaksjdlamclkmalskdj", "categoria3", 2.5);
        conMovimentacao.setMovimentacaoTeste(mov3);
        Assert.assertEquals("MVC.negocio.exececao.ExcecaoDeNegocio: Descrição não pode ter mais de 40 caracteres ou menos de 3", conMovimentacao.isOK());
    }
    
    @Test
    public void isOkCategoriaNull() throws Exception{
        Calendar dataEmissao = Calendar.getInstance();
        Movimentacao mov5 = new Movimentacao(true, dataEmissao, "descricao", "", 2.5);
        conMovimentacao.setMovimentacaoTeste(mov5);
        Assert.assertEquals("MVC.negocio.exececao.ExcecaoDeNegocio: Categoria não pode ter menos de 3 caracteres ou mais de 10", conMovimentacao.isOK());
    }
    
    @Test
    public void isOkCategoriaTamano() throws Exception{
        Calendar dataEmissao = Calendar.getInstance();
        Movimentacao mov6 = new Movimentacao(true, dataEmissao, "descricao", "aaa", 2.5);
        conMovimentacao.setMovimentacaoTeste(mov6);
        Assert.assertEquals("MVC.negocio.exececao.ExcecaoDeNegocio: Categoria não pode ter menos de 3 caracteres ou mais de 10", conMovimentacao.isOK());
    }
    
    @Test
    public void isOkCategoriaTamanoMaior() throws Exception{
        Calendar dataEmissao = Calendar.getInstance();
        Movimentacao mov7 = new Movimentacao(true, dataEmissao, "descricao", "asddfasdasdbhgasdhjkdsjhkdashjkdaskhjdask", 2.5);
        conMovimentacao.setMovimentacaoTeste(mov7);
        Assert.assertEquals("MVC.negocio.exececao.ExcecaoDeNegocio: Categoria não pode ter menos de 3 caracteres ou mais de 10", conMovimentacao.isOK());
    }
    
    @Test
    public void isOkValorNull() throws Exception{
        Calendar dataEmissao = Calendar.getInstance();
        Movimentacao mov8 = new Movimentacao(true, dataEmissao, "descricao", "categoria1", 0.0);
        conMovimentacao.setMovimentacaoTeste(mov8);
        Assert.assertEquals("MVC.negocio.exececao.ExcecaoDeNegocio: Valor não pode ser 0", conMovimentacao.isOK());
    }
            
        
    }
    
    
    
    
    

