package MVC.dados;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public abstract class DAOFactory {

	
	private static final EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("hibernatetest");		
	}
        
        public static GerenteDAO getGerenteDAO(){
		GerenteDAO dao = new GerenteDAO(factory);
		return dao;
	}
        
        public static FuncionarioDAO getFuncionarioDAO(){
		FuncionarioDAO dao = new FuncionarioDAO(factory);
		return dao;
	}
        
        public static ContaDAO getContaDAO(){
		ContaDAO dao = new ContaDAO(factory);
		return dao;
	}
        
        public static MovimentacaoDAO getMovimentacaoDAO(){
		MovimentacaoDAO dao = new MovimentacaoDAO(factory);
		return dao;
	}
}
