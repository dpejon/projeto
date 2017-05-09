package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mural;
import model.RegistrarELogin;
import service.LoginService;
import service.MuralService;
import service.RegistrarService;;

public class LoginUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		RegistrarELogin usuario = new RegistrarELogin ();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		LoginService service = new LoginService();
		if(service.validar(usuario)){
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			System.out.println("Logou "+ usuario);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
		 	   out.println("alert('Login Incorreto!');");
		 	   out.println("location='index.jsp';");
		 	   out.println("</script>");    
	        return;
		}

		Mural mural = new Mural();
		usuario.setLogin(login);
		usuario.setSenha(senha);
    	//instanciar o service
    	MuralService ms = new MuralService();
    	 RegistrarService cs = new RegistrarService();
    	List<Mural> lista = ms.carregarTodosPosts();
    	 cs.carregar(login);
    	 usuario = cs.carregar(usuario.getLogin());
    	//enviar para o jsp
    	request.setAttribute("lista", lista);
    	request.setAttribute("login", usuario);
    	RequestDispatcher view = 
    	request.getRequestDispatcher("mural.jsp");
    	view.forward(request, response); 

	}

}
