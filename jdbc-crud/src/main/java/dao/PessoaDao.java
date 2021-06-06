package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.Conexao;
import model.Pessoa;

public class PessoaDao {

	private Connection connection;

	public PessoaDao() {
		connection = Conexao.geConnection();
	}

	public void salvar(Pessoa pessoa) {

		try {
			String sql = "insert into pessoa (nome, email) values ( ? , ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, pessoa.getNome());
			insert.setString(2, pessoa.getEmail());
			insert.execute();
			connection.commit(); // salvar dados no banco

		} catch (SQLException e) {
			try {
				connection.rollback(); // reverte operação caso tenha erro
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public List<Pessoa> listar() throws SQLException {

		List<Pessoa> list = new ArrayList<Pessoa>();

		String sql = "select * from pessoa";
		PreparedStatement listar = connection.prepareStatement(sql);

		ResultSet resultado = listar.executeQuery();

		while (resultado.next()) {
			Pessoa pessoa = new Pessoa();

			pessoa.setId(resultado.getLong("id"));
			pessoa.setNome(resultado.getString("nome"));
			pessoa.setEmail(resultado.getString("email"));

			list.add(pessoa);
		}

		return list;
	}

	public Pessoa buscarPessoa(Long id) throws SQLException {

		Pessoa pessoa = new Pessoa();
		
		String sql = "select * from pessoa where id = " + id;
		PreparedStatement buscar = connection.prepareStatement(sql);

		ResultSet resultado = buscar.executeQuery();

		while (resultado.next()) {

			pessoa.setId(resultado.getLong("id"));
			pessoa.setNome(resultado.getString("nome"));
			pessoa.setEmail(resultado.getString("email"));

		}

		return pessoa;
	}
	
	public void atualizar(Pessoa pessoa) {
		
		
		try {
		
			String sql = "update pessoa set nome = ? , email = ? where id = " + pessoa.getId();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoa.getNome());
			statement.setString(2, pessoa.getEmail());
			
			statement.execute();
			connection.commit();
			
			
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	
	public void deletar(Long id) {
		
		try {
			
			String sql = "delete from pessoa where id = " + id;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
			
		} catch (Exception e) {
			
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			e.printStackTrace();
		}
		
	}

}





















