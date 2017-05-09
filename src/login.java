/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegistrarELogin;
import service.RegistrarService;

/**
 *
 * @author Oops
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          String login = request.getParameter("uname");
          String pass  = request.getParameter("pass");

          try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd8","root","20744335");
          
          Statement stmt = con.createStatement();
          
         ResultSet rs = stmt.executeQuery("select ID, Login, Senha from usuario where Login = '"+login+"' and Senha ='"+pass+"'");
         if(rs.next())
         {
         
          String redirectedPage = "/parentPage";
          response.sendRedirect("mural.jsp");
         }else{
     		out.println("<script type=\"text/javascript\">");
     	 	   out.println("alert('Usuário ou Senha Incorreto!');");
     	 	   out.println("location='index.jsp';");
     	 	   out.println("</script>");    
             
         }
            
               
             
               
            
          
          }catch(Exception e){}
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("uname");
        

        RegistrarELogin registrar = new RegistrarELogin();
        registrar.setLogin(login);
        //instanciar o service
        RegistrarService cs = new RegistrarService();
        cs.carregar(login);
        registrar = cs.carregar(registrar.getLogin());
        
        
        //enviar para o jsp
        request.setAttribute("login", registrar);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("ManterMural.do");
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
