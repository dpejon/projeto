package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegistrarELogin;
import service.RegistrarService;

public class ManterRegistro implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	      String pNome = request.getParameter("nome");
	        String pEmail = request.getParameter("email");
	        String pSenha = request.getParameter("senha");
	        String pLogin = request.getParameter("login");
	        
	        //instanciar o javabean
	        RegistrarELogin registrarELogin = new RegistrarELogin();
	        registrarELogin.setNome(pNome);
	        registrarELogin.setEmail(pEmail);
	        registrarELogin.setSenha(pSenha);
	        registrarELogin.setLogin(pLogin);
	        
	        //instanciar o service
	        RegistrarService cs = new RegistrarService();
	        cs.criar(registrarELogin);
	        cs.carregar(registrarELogin.getLogin());
	        
	        //enviar para o jsp
	        request.setAttribute("registro", registrarELogin);

	        PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
		 	   out.println("alert('Cadastro Efetuado com Sucesso!');");
		 	   out.println("location='index.jsp';");
		 	   out.println("</script>");     

	}



}
