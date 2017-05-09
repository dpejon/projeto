package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Mural;
import service.MuralService;

public class ManterMural implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Mural mural = new Mural();

    	//instanciar o service
    	MuralService ms = new MuralService();
		RequestDispatcher view = null;
		List<Mural> lista = ms.carregarTodosPosts();
		request.setAttribute("mural", lista);
		view = request.getRequestDispatcher("mural.jsp");

		view.forward(request, response);

	}

}
