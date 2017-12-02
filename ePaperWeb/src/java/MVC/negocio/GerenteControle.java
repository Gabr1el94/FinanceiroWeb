/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio;

import MVC.classes.Conta;
import MVC.classes.Funcionario;
import MVC.classes.Gerente;
import MVC.dados.DAOFactory;
import MVC.dados.GerenteDAO;
import MVC.negocio.exececao.ExcecaoDeNegocio;
import static java.time.LocalDate.now;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gabriel
 */
public class GerenteControle {

    private GerenteDAO factoryGerente;
    private Gerente gerenteTeste;
    public List<Gerente> listaGerente;
    

    public GerenteControle() {
         factoryGerente = DAOFactory.getGerenteDAO();
    }

    /*
    public GerenteControle(GerenteDAO factoryGerente, Gerente gerenteTeste, List<Gerente> listaGerente) {
        factoryGerente = DAOFactory.getGerenteDAO();
        this.gerenteTeste = gerenteTeste;
        this.listaGerente = factoryGerente.getAll();
    }
    */
    public void inserirGerente(Gerente gerenteAdd) {
        factoryGerente.insert(gerenteAdd);
    }

    public void setGerenteTeste(Gerente gerenteTeste) {
        this.gerenteTeste = gerenteTeste;
    }

    public String isok() {
        try {
            testaNome();
            testaCpf();
            testaEmail();
            testaNascimento();
            testaSenha();
            testaConta();
            return "ok";
        } catch (ExcecaoDeNegocio ex) {
            return ex.toString();
        }

    }

    

    public void removerGerente(int id) {
        Gerente gerenteRemover = factoryGerente.searchByKey(id);
        factoryGerente.remove(gerenteRemover);
    }

    public void atualizarGerente(Gerente gerenteLogado, Gerente gerenteAtualizado) {
        Gerente gerenteModificado = factoryGerente.searchByKey(gerenteLogado.getId());

        gerenteModificado.setConta(gerenteAtualizado.getConta());
        gerenteModificado.setNome(gerenteAtualizado.getNome());
        gerenteModificado.setSenha(gerenteAtualizado.getSenha());
        gerenteModificado.setCpf(gerenteAtualizado.getCpf());
        gerenteModificado.setEmail(gerenteAtualizado.getEmail());
        gerenteModificado.setDataNascimento(gerenteAtualizado.getDataNascimento());

        factoryGerente.update(gerenteModificado);
    }

    public List<Gerente> listarGerente() {
        return factoryGerente.getAll();
    }

    private void testaNome() throws ExcecaoDeNegocio {
        if (gerenteTeste.getNome().trim().length() > 60 || gerenteTeste.getNome().trim().length() <= 3) {
            throw new ExcecaoDeNegocio("Nome não pode ter mais de 60 caracteres ou  menos de 3", "mensagem_TamanhoInvalidoNome");
        } else if (gerenteTeste.getNome().trim().equals("") && gerenteTeste.getNome().trim().equals(null)) {
            throw new ExcecaoDeNegocio("Nome não ser nulo", "mensagem_TamanhoNulo");
        }
    }

    private void testaEmail() throws ExcecaoDeNegocio {
        if (gerenteTeste.getEmail().trim().equals("")) {
            throw new ExcecaoDeNegocio("Email não pode ser nulo", "mensagem_emailNulo");
        }
        if (gerenteTeste.getEmail().trim().length() > 30) {
            throw new ExcecaoDeNegocio("Email não pode ter mais de 30 caracteres", "mensagem_TamanhoInvalidoEmail");
        }

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(gerenteTeste.getEmail());

        if (!(matcher.matches())) {
            throw new ExcecaoDeNegocio("Email inválido", "mensagem_emailInvalido");
        }

    }

    private void testaCpf() throws ExcecaoDeNegocio {
        if (gerenteTeste.getCpf().trim().equals("")) {
            throw new ExcecaoDeNegocio("Cpf não pode ser nulo", "mensagem_cpfNulo");
        }
        if (gerenteTeste.getCpf().trim().length() > 14) {
            throw new ExcecaoDeNegocio("Cpf não pode ter mais de 14 caracteres", "mensagem_tamanhoInvalidoCpf");
        }
    }

    private void testaSenha() throws ExcecaoDeNegocio {
        if (gerenteTeste.getSenha().trim().equals("") || gerenteTeste.getSenha().trim().equals(null)) {
            throw new ExcecaoDeNegocio("Senha não pode ser nula", "mensagem_senhaNula");
        }
        if (gerenteTeste.getSenha().trim().length() > 255) {
            throw new ExcecaoDeNegocio("Senha não pode conter mais de 255 caracteres", "mensagem_tamanhoInvalidoSenha");
        }
    }

    private void testaNascimento() throws ExcecaoDeNegocio {
        if (gerenteTeste.getDataNascimento().equals("") || gerenteTeste.getDataNascimento().equals(null)) {
            throw new ExcecaoDeNegocio("Data Nascimento não pode ser Nula", "mensagem_NascimentoNula");
        }

        if (gerenteTeste.getDataNascimento().equals(Calendar.getInstance())) {
            throw new ExcecaoDeNegocio("Data Nascimento não ser inserida com a data atual", "mensagem_NascimentoInvalido");
        }

    }

    private void testaConta() throws ExcecaoDeNegocio {
        if (gerenteTeste.getConta().equals(0)) {
            throw new ExcecaoDeNegocio("A identificação da conta não deve ser igual que zero.", "mensagem_ContaInvalido");
        }
        if (!gerenteTeste.getConta().equals(gerenteTeste.getConta())) {
            throw new ExcecaoDeNegocio("A identificação da Conta não existe.", "mensagem_ContaInvalido");
        }

    }

}
