package area24Financeiro.testeLogin;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import area24Financeiro.connection.SingleConnection;
import area24Financeiro.dao.LoginDAO;
import area24Financeiro.model.Login;

public class TesteLoginBD {
	Scanner leia = new Scanner(System.in);

	@Test
	public void init() {
		SingleConnection.getConnection();
	}

	@Test
	public void testeInsert() {
		LoginDAO loginDAO = new LoginDAO();
		Login login = new Login();

		System.out.print("Login: ");
		login.setUsuario(leia.nextLine());

		System.out.print("Senha: ");
		login.setSenha(leia.nextLine());

		loginDAO.insertLogin(login);
		testeSelect();
		
		leia.close();

	}

	@Test
	public void testeSelect() {
		LoginDAO loginDAO = new LoginDAO();
		try {
			List<Login> logins = loginDAO.findAllLogin();
			for (Login login : logins) {
				System.out.println(login);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
