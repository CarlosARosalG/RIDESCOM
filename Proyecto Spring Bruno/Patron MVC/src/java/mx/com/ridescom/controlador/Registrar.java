/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.ridescom.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.ridescom.Modelo.Persona;
import mx.com.ridescom.Modelo.PersonaDAO;
import mx.com.ridescom.Modelo.Usuario;
import mx.com.ridescom.Modelo.UsuarioDAO;
import mx.com.ridescom.config.Conexion;

/**
 *
 * @author spy51
 */
public class Registrar extends HttpServlet {
    
    Usuario us=new Usuario();
    UsuarioDAO udao=new UsuarioDAO();
    Persona p=new Persona();
    PersonaDAO pdao=new PersonaDAO();
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    PreparedStatement psp;
    ResultSet rsp;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registrar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registrar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        String accion=request.getParameter("accion");
        String sqlu="select Nombre_U from Usuario";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sqlu);
            rs=ps.executeQuery();
        }catch (Exception e){}
        String usu =rs.toString();
        if(accion.equalsIgnoreCase("Registrar")){
            String user=request.getParameter("txtuser");
            String pass=request.getParameter("txtpass");
            
            //p=pdao.consultarPersona();
            us=udao.validar(user, pass);
            if(us.getUsuario()!= null){
                if(us.getUsuario().equals(usu)){

                    request.getRequestDispatcher("Controlador?accion=Principal").forward(request, response);
                }else{
                    request.getRequestDispatcher("Controlador?accion=Coord").forward(request, response);
                }
            }else{
                
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
//processRequest(request, response);
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
