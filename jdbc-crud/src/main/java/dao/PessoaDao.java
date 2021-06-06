package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaojdbc.Conexao;
import model.Pessoa;

public class PessoaDao {

	private Connection connection;
	
	public PessoaDao() {
		connection = Conexao.geConnection();
	}
	
	public void salvar(Pessoa pessoa) {
		
		
		try {
			String sql = "insert into pessoa (id, nome, email) values (? , ? , ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, pessoa.getId());
			insert.setString(2, pessoa.getNome());
			insert.setString(3, pessoa.getEmail());
			insert.execute();
			connection.commit(); //salvar dados no banco
			
		} catch (SQLException e) {
			try {
				connection.rollback(); // reverte operação caso tenha erro
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
}
