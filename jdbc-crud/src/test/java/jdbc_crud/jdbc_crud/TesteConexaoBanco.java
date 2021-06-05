package jdbc_crud.jdbc_crud;

import org.junit.Test;

import conexaojdbc.Conexao;

public class TesteConexaoBanco {

	@Test
	public void iniciarBanco() {
		Conexao.geConnection();
	}
	
}
