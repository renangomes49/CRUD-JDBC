package jdbc_crud.jdbc_crud;

import org.junit.Test;

import conexaojdbc.Conexao;
import dao.PessoaDao;
import model.Pessoa;

public class TesteConexaoBanco {

	@Test
	public void iniciarBanco() {
		Conexao.geConnection();
	}
	
	@Test
	public void salvarBanco() {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(4L);
		pessoa.setNome("Jose Bezerra Silva");
		pessoa.setEmail("josebez@gmail.com");
		
		PessoaDao dao = new PessoaDao();
		dao.salvar(pessoa);
		
		
	}
}
