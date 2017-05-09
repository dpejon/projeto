package service;

import model.RegistrarELogin;
import dao.LoginDAO;

public class LoginService {
	
	public boolean validar(RegistrarELogin usuario){
		LoginDAO dao = new LoginDAO();
		return dao.validar(usuario);
	}
}

