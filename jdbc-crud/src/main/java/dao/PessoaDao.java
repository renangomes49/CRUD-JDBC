package dao;

import java.sql.Connection;

import conexaojdbc.Conexao;

public class PessoaDao {

	private Connection connection;
	
	public PessoaDao() {
		connection = Conexao.geConnection();
	}
	
}
