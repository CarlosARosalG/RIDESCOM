/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.ridescom.controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.ridescom.Modelo.Evento;
import mx.com.ridescom.Modelo.EventoDAO;

/**
 *
 * @author spy51
 */
public class Controlador extends HttpServlet {

    Evento ev=new Evento();
    EventoDAO edao=new EventoDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        
        if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if(menu.equals("Evento")){
            switch(accion){
                case "Listar":
                    List lista=edao.listar();
                    request.setAttribute("Evento", lista);
                    break;
                case "Agregar":
                    break;
                case "Editar":
                    break;
                case "Delete":
                    break;
                default:
                    throw new AssertionError();
                    
            }
            request.getRequestDispatcher("Evento.jsp").forward(request, response);
        }
        if(menu.equals("Usuarios")){
           
            request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
        }
        if(menu.equals("Prueba")){
           
            request.getRequestDispatcher("Prueba.jsp").forward(request, response);
        }
      
//        switch (accion) {
//            case "Principal":
//                request.getRequestDispatcher("Principal.jsp").forward(request, response);
//                break;
//            case "Coord":
//                request.getRequestDispatcher("Coord.jsp").forward(request, response);
//                break;
//            case "Alumno":
//                request.getRequestDispatcher("Main.jsp").forward(request, response);
//                break;
//            case "Evento":
//                request.getRequestDispatcher("Evento.jsp").forward(request, response);
//                break;
//            case "Prueba":
//                request.getRequestDispatcher("Prueba.jsp").forward(request, response);
//                break;
//            case "Usuarios":
//                request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
//                break;
//            case "index":
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//                break;
//            default:
//                throw new AssertionError();
//        }
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
