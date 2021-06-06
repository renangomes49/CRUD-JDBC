package jdbc_crud.jdbc_crud;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	@Test
	public void listar() throws SQLException {
		
		PessoaDao dao = new PessoaDao();
		
		List<Pessoa> list = dao.listar();
		
		for (Pessoa pessoa : list) {
			System.out.println(pessoa);
		}
		
	}
}
















