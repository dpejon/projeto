package service;

import java.util.List;

import dao.RegistrarDAO;
import model.RegistrarELogin;


public class RegistrarService {
	RegistrarDAO dao = new RegistrarDAO();
	
	public int criar(RegistrarELogin cliente) {
		return dao.criar(cliente);
	}
	
	public void atualizar(RegistrarELogin cliente){
		dao.atualizar(cliente);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public RegistrarELogin carregar(String login){
		return dao.carregar(login);
	}
	
	public RegistrarELogin login(String login, String senha){
		return dao.login(login, senha);
	}
	
	public List<RegistrarELogin> carregarTodosClientes(){
		return dao.carregarTodasAreas();
	}

}
