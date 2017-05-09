package service;

import java.util.List;

import dao.MuralDAO;
import model.Mural;


public class MuralService {
	MuralDAO dao = new MuralDAO();
	
	
	public Mural carregar(int id){
		return dao.carregarMeusPosts(id);
	}
	
	public List<Mural> carregarTodosPosts(){
		return dao.carregarTodosPosts();
	}

}
