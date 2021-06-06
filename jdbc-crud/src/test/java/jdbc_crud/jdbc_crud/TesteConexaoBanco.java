package jdbc_crud.jdbc_crud;

import java.util.List;
import java.sql.SQLException;
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
		pessoa.setNome("Carlos ferreira");
		pessoa.setEmail("carlos@.com.br");

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

	@Test
	public void buscarPessoa() {

		try {
			PessoaDao dao = new PessoaDao();
			Pessoa pessoa = dao.buscarPessoa(1L);
			System.out.println(pessoa);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void atualizarPessoa() {

		try {
			PessoaDao dao = new PessoaDao();
			Pessoa pessoa = dao.buscarPessoa(1L);
			pessoa.setNome("Renan M");
			pessoa.setEmail("renan@gmail.com");
			dao.atualizar(pessoa);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
