/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.model.Eventos;
import mx.ipn.escom.ridescom.model.Prueba;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author spy51
 */
public class Pruebas {
    Conexion con=new Conexion();
    ModelAndView mav=new ModelAndView();
    UsuarioDAO udao=new UsuarioDAO();
    Usuario us=new Usuario();
    Prueba pr=new Prueba();
    int PruebaID;
    
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    
    List dat;
    List prue;
    
    @RequestMapping(value="DDyFD/Pruebas.html", method=RequestMethod.GET)
    public ModelAndView Prueba(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Login");
        }else{
        mav.setViewName("Pruebas");
        }
        String sql1="select ID_Pruebas, Prueba, Tipo_Pruebas_ID_Tipo, Act_Deportiva_ID_Deporte, Tipo_Pruebas.Tipo, Tipo_Pruebas.Rama, Act_Deportiva.Disciplina from Pruebas "
                + "inner join (Tipo_Pruebas,Act_Deportiva) on (Pruebas.Tipo_Pruebas_ID_Tipo=Tipo_Pruebas.ID_Tipo AND Pruebas.Act_Deportiva_ID_Deporte=Act_Deportiva.ID_Deporte) ORDER BY ID_Pruebas ASC";
//        String sql2="select ID_Pruebas, Prueba, if(Tipo_Pruebas_ID_Tipo='1','Individual','Por Equipos')as Tipo_Pruebas_ID_Tipo, Act_Deportiva_ID_Deporte from Pruebas";
        dat=this.rid.queryForList(sql1);
        mav.addObject("prue",dat);
        return mav;
    }
    @RequestMapping(value="DDyFD/Pruebas.html", method=RequestMethod.POST)
    public ModelAndView log(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        
        String accion=req.getParameter("btn");
        if(accion.equalsIgnoreCase("Entrar")){
        String usuario=req.getParameter("Nombre_U");
        String pass=req.getParameter("Password_U");
        String jefe= "DDyFD";
        
        us=udao.validar(usuario, pass);
//        if(req.getParameter("btn")!= null){
        if(us.getNombre_U()!= null){
            if(us.getNombre_U().equals(jefe)){
            
            HttpSession session=req.getSession();
//            String user=req.getParameter("Nombre_U");
            session.setAttribute("Nombre_U", jefe); //user
            
            return new ModelAndView("redirect:/DDyFD.html");
            }else {
                return new ModelAndView("redirect:/Coordinador.html");
            }
        }else{
        ModelAndView mv=new ModelAndView("Login.html");
        mv.addObject("mjs", "<div style='color: red;'>ERROR, usuario no existe.</div>");
        return mv;  
        }
        }else{
            return new ModelAndView("Login.html");
        }
    }
    
    ////////////////////////////////// Operadores CRUD //////////////////////////////////////////////////////
    //Scripts para Agregar Pruebas
    @RequestMapping(value="DDyFD/Pruebas/AgregarPrueba.html", method=RequestMethod.GET)
    public ModelAndView Agrega(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        String sq="select* from Pruebas pr inner join (Act_Deportiva d, Tipo_Pruebas tp) on (pr.Act_Deportiva_ID_Deporte=d.ID_Deporte and tp.ID_Tipo=pr.Tipo_Pruebas_ID_Tipo)";
        prue=this.rid.queryForList(sq);
        mav.addObject("prueba", prue);
        mav.setViewName("AgregarPrueba");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/Pruebas/AgregarPrueba.html", method=RequestMethod.POST)
    public ModelAndView Agrega(HttpServletRequest req, HttpServletResponse resp, Prueba pru)throws Exception{
            
            String sql="insert into Pruebas(Prueba, Tipo_Pruebas_ID_Tipo, Act_Deportiva_ID_Deporte) values (?,?,?);";
            this.rid.update(sql, pru.getPrueba(), pru.getTipo(), pru.getAct_Prueba());
//            return new ModelAndView("redirect:../Pruebas/Pruebasiguiente.html");
        mav.setViewName("redirect:../Pruebas.html");
        mav.addObject("mjs", "<div style='color: green;'>Se ha Agregado una Prueba correctamente</div>");
        return mav;
    }
    @RequestMapping(value="DDyFD/Pruebas/Pruebasiguiente.html", method=RequestMethod.GET)
    public ModelAndView sig(HttpServletRequest re){
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Login");
        }else{
        mav.setViewName("Pruebanext");
        }
        return mav;
    }
    
    //Scripts para edición de Pruebas
    @RequestMapping(value="DDyFD/Pruebas/EditarPrueba.html", method=RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest re)throws SQLException{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        PruebaID=Integer.parseInt(re.getParameter("PruebaID"));
        String sql="select * from Pruebas pr inner join (Act_Deportiva d, Tipo_Pruebas tp) on (pr.Act_Deportiva_ID_Deporte=d.ID_Deporte and pr.Tipo_Pruebas_ID_Tipo=tp.ID_Tipo) where ID_Pruebas="+PruebaID;
        dat = this.rid.queryForList(sql);
        mav.addObject("prue",dat);
        mav.setViewName("EditarPrueba");
        }else{
            mav.setViewName("CoordUA");
        }
        System.out.println(mav);
        return mav;
    }
    @RequestMapping(value="DDyFD/Pruebas/EditarPrueba.html", method=RequestMethod.POST)
    public ModelAndView Editar(Prueba pru){
        String sql="update Pruebas set Prueba=?, Act_Deportiva_ID_Deporte=?, Tipo_Pruebas_ID_Tipo=? where ID_Pruebas="+PruebaID;
        this.rid.update(sql, pru.getPrueba(), pru.getAct_Prueba(), pru.getTipo());
//        ModelAndView mv=new ModelAndView ("redirect:../Pruebas.html");
//        return mv;
        mav.setViewName("redirect:../Pruebas.html");
        mav.addObject("mjs", "<div style='color: green;'>Se han Actualizado los datos de una Prueba correctamente</div>");
        return mav;
    }
    @RequestMapping(value="DDyFD/Pruebas/ConfirmaEdicion.html", method=RequestMethod.GET)
    public ModelAndView confirm(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        PruebaID=Integer.parseInt(re.getParameter("PruebaID"));
        String sql="select ID_Pruebas, Prueba, Tipo_Pruebas_ID_Tipo, Act_Deportiva_ID_Deporte, Tipo_Pruebas.Tipo, Act_Deportiva.Disciplina from Pruebas "
                + "inner join (Tipo_Pruebas,Act_Deportiva) on (Pruebas.Tipo_Pruebas_ID_Tipo=Tipo_Pruebas.ID_Tipo AND Pruebas.Act_Deportiva_ID_Deporte=Act_Deportiva.ID_Deporte) where ID_Pruebas="+PruebaID;
        dat = this.rid.queryForList(sql);
        mav.addObject("prue",dat);
        mav.setViewName("ConfirmaEdicion");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }

    //Scripts para borrar registros
    @RequestMapping(value="DDyFD/Pruebas/BorrarPrueba.html", method=RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        PruebaID=Integer.parseInt(re.getParameter("PruebaID"));
        String sql="select ID_Pruebas, Prueba, Tipo_Pruebas_ID_Tipo, Act_Deportiva_ID_Deporte, Tipo_Pruebas.Tipo, Tipo_Pruebas.Rama, Act_Deportiva.Disciplina from Pruebas "
                + "inner join (Tipo_Pruebas,Act_Deportiva) on (Pruebas.Tipo_Pruebas_ID_Tipo=Tipo_Pruebas.ID_Tipo AND Pruebas.Act_Deportiva_ID_Deporte=Act_Deportiva.ID_Deporte) where ID_Pruebas="+PruebaID;
        dat = this.rid.queryForList(sql);
        mav.addObject("prue",dat);
        mav.setViewName("BorrarPrueba");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
//        PruebaID=Integer.parseInt(req.getParameter("PruebaID"));
//        String sql ="delete from Pruebas where ID_Pruebas="+PruebaID;
//        this.rid.update(sql);
//        ModelAndView mv=new ModelAndView ("redirect:../Pruebas");
//
//        return mv;
    }    
    @RequestMapping(value="DDyFD/Pruebas/BorrarPrueba.html", method=RequestMethod.POST)
    public ModelAndView delete(HttpServletRequest re, Prueba pru){
        PruebaID=Integer.parseInt(re.getParameter("PruebaID"));
        String sql ="delete from Pruebas where ID_Pruebas="+PruebaID;
        this.rid.update(sql);
//        ModelAndView mv=new ModelAndView ("redirect:../Pruebas.html");
//        return mv;
        mav.setViewName("redirect:../Pruebas.html");
        mav.addObject("mjs", "<div style='color: green;'>Se ha Eliminado una Prueba correctamente</div>");
        return mav;
    }
    @RequestMapping(value="DDyFD/Pruebas/ConfirmaBorrar.html")
    public ModelAndView confirma(HttpServletRequest re){
        PruebaID=Integer.parseInt(re.getParameter("PruebaID"));
        String sql ="delete from Pruebas where ID_Pruebas="+PruebaID;
        this.rid.update(sql);
        ModelAndView mv=new ModelAndView ("redirect:../Pruebas.html");
//        mv.addObject("msjs", "<div style='color: green;'>Se ha eliminado correctamente</div>");
        return mv;
    }
}
