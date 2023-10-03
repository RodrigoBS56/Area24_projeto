package area24Financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import area24Financeiro.connection.SingleConnection;
import area24Financeiro.model.Login;

public class LoginDAO {
	private Connection connection;

	public LoginDAO() {
		connection = SingleConnection.getConnection();
	}

	public void insertLogin(Login login) {
		try {
			String insert = "INSERT INTO login (usuario, senha) VALUES (?, ?);";
			PreparedStatement preparedInsert = connection.prepareStatement(insert);
			preparedInsert.setString(1, login.getUsuario());
			preparedInsert.setString(2, login.getSenha());
			preparedInsert.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public List<Login> findAllLogin() throws Exception {
		List<Login> selects = new ArrayList<>();
		String select = "SELECT * FROM login";

		PreparedStatement preparedSelect = connection.prepareStatement(select);
		ResultSet resultSelect = preparedSelect.executeQuery();

		while (resultSelect.next()) {
			Login login = new Login();
			login.setIdLogin(resultSelect.getLong("id"));
			login.setUsuario(resultSelect.getString("usuario"));
			login.setSenha(resultSelect.getString("senha"));
			selects.add(login);
		}

		return selects;
	}
}
