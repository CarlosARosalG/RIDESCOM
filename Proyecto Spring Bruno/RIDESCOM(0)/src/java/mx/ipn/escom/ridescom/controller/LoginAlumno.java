/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.List;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class LoginAlumno {
    ModelAndView mav=new ModelAndView();
    Conexion cn=new Conexion();
    Connection con;
    JdbcTemplate rid=new JdbcTemplate(cn.ConectaRID());
    PreparedStatement ps;
    ResultSet rs;
    
    Usuario us=new Usuario();
    UsuarioDAO udao=new UsuarioDAO();
    
    List dat;

    @RequestMapping(value="LoginAlumno")
    public ModelAndView alumno(){   
        mav.setViewName("LoginAlumno");
        return mav;
    }
    
}
