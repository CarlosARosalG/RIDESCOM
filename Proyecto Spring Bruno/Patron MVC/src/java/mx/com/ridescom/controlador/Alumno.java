package mx.com.ridescom.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.ridescom.Modelo.Usuario;
import mx.com.ridescom.Modelo.UsuarioDAO;
import mx.com.ridescom.config.Conexion;

/**
 *
 * @author spy51
 */
public class Alumno extends HttpServlet {

    UsuarioDAO udao=new UsuarioDAO();
    Usuario us=new Usuario();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Alumno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Alumno at " + request.getContextPath() + "</h1>");
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
        String al="Alumno";
        if(accion.equalsIgnoreCase("Ingresar")){
            String user=request.getParameter("txtal");
            String pass=request.getParameter("txtpass");

            
            //p=pdao.consultarPersona();
            us=udao.validar(user, pass);
            if(us.getUsuario()!= null){
                    request.setAttribute("usuario", us);
                    request.getRequestDispatcher("Controlador?accion=Alumno").forward(request, response);
            }else{
                request.setAttribute("usuario", us);
                request.getRequestDispatcher("Main.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("Alumno.jsp").forward(request,response);
        }
        processRequest(request, response);
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
