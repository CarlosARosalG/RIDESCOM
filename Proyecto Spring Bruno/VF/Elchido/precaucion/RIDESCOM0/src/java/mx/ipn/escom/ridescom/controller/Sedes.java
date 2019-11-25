/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.model.Sede;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author spy51
 */
public class Sedes {
    Conexion con=new Conexion();
    ModelAndView mav=new ModelAndView();
    UsuarioDAO udao=new UsuarioDAO();
    Usuario us=new Usuario();
    Sede pr=new Sede();
    int SedeID;
    
    Connection ct;
    ResultSet rs;
    PreparedStatement ps;
    Connection ctt;
    ResultSet rss;
    PreparedStatement pss;
    String dep=null;
    String da=null;
    
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    
    List dat;
    List dat1;
    
    @RequestMapping(value="DDyFD/Sedes.html", method=RequestMethod.GET)
    public ModelAndView Sede(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
            String sql1="select s.ID_Sede, s.Nombre_S, s.Calle, s.Colonia, s.Numero, s.CP, m.Municipio, e.Estado from Sede s" +
"                    inner join(Municipio m, Estados e)" +
"                    on (e.ID_estado= m.Estados_ID_estado" +
"                    AND m.ID_Municipio=s.Municipio_ID_Municipio" +
"                    AND m.Estados_ID_estado=s.Municipio_Estados_ID_estado)";
            dat=this.rid.queryForList(sql1);
            mav.addObject("se",dat);
            mav.setViewName("Sedes");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/Sedes.html", method=RequestMethod.POST)
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
    //Scripts para Agregar Sedes
    @RequestMapping(value="DDyFD/Sedes/AgregarSede.html", method=RequestMethod.GET)
    public ModelAndView Agrega(HttpServletRequest re)throws SQLException{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("AgregarSede");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/Sedes/AgregarSede.html", method=RequestMethod.POST)
    public ModelAndView Agrega(HttpServletRequest req, HttpServletResponse resp, Sede sed)throws Exception{
            if(sed.getNumero().isEmpty()){
            String sql="insert into Sede (Nombre_S, Calle, Colonia, Numero, CP, Municipio_ID_Municipio, Municipio_Estados_ID_estado) values (?, ?, ?, 's/n', ?, ?, (select Estados_ID_estado from Municipio where ID_Municipio=?))";
            this.rid.update(sql, sed.getSede(), sed.getCalle(), sed.getColonia(), sed.getCP(), sed.getMunicipio(), sed.getMunicipio());
        }else{
        String sql="insert into Sede (Nombre_S, Calle, Colonia, Numero, CP, Municipio_ID_Municipio, Municipio_Estados_ID_estado) values (?, ?, ?, ?, ?, ?, (select Estados_ID_estado from Municipio where ID_Municipio=?))";
            this.rid.update(sql, sed.getSede(), sed.getCalle(), sed.getColonia(), sed.getNumero(), sed.getCP(), sed.getMunicipio(), sed.getMunicipio());
        }
        mav.setViewName("redirect:../Sedes.html");
        mav.addObject("msjs", "<div style='color: green;'>Se ha Agregado una sede correctamente</div>");
        return mav;
    }
    @RequestMapping(value="DDyFD/Sedes/Sedesiguiente.html", method=RequestMethod.GET)
    public ModelAndView sig(HttpServletRequest re){
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Login");
        }else{
        mav.setViewName("Sedenext");
        }
        return mav;
    }
    
    //Scripts para edición de Sedes
    @RequestMapping(value="DDyFD/Sedes/EditarSede.html", method=RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest re)throws SQLException{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        SedeID=Integer.parseInt(re.getParameter("SedeID"));
        String sql="select * from sede s inner join(municipio m, estados edo) on (m.Estados_ID_estado=edo.ID_estado and s.Municipio_ID_Municipio=m.ID_Municipio) where ID_Sede="+SedeID;
        dat = this.rid.queryForList(sql);
        mav.addObject("sed",dat);
        mav.setViewName("EditarSede");
        }else{
            mav.setViewName("CoordUA");
        }
        System.out.println(mav);
        return mav;
    }
    @RequestMapping(value="DDyFD/Sedes/EditarSede.html", method=RequestMethod.POST)
    public ModelAndView Editar(Sede sed){
        if(sed.getNumero().isEmpty()){
            String sql="update Sede set Nombre_S=?, Calle=?, Colonia=?, Numero='s/n', CP=?, Municipio_ID_Municipio=?, Municipio_Estados_ID_estado=(select Estados_ID_estado from Municipio where ID_Municipio=?)where ID_Sede="+SedeID;
            this.rid.update(sql, sed.getSede(), sed.getCalle(), sed.getColonia(), sed.getCP(), sed.getMunicipio(), sed.getMunicipio());
        }else{
        String sql="update Sede set Nombre_S=?, Calle=?, Colonia=?, Numero=?, CP=?, Municipio_ID_Municipio=?, Municipio_Estados_ID_estado=(select Estados_ID_estado from Municipio where ID_Municipio=?)where ID_Sede="+SedeID;
            this.rid.update(sql, sed.getSede(), sed.getCalle(), sed.getColonia(), sed.getNumero(), sed.getCP(), sed.getMunicipio(), sed.getMunicipio());
        }
        mav.setViewName("redirect:../Sedes.html");
        mav.addObject("msjs", "<div style='color: green;'>Se han Actualizado los datos correctamente</div>");
        return mav;
    }
    //Scripts para borrar registros
    @RequestMapping(value="DDyFD/Sedes/BorrarSede.html", method=RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        SedeID=Integer.parseInt(re.getParameter("SedeID"));
        String sql="SELECT * from sede s INNER join (municipio mu, estados edo) on (mu.Estados_ID_estado=edo.ID_estado and mu.ID_Municipio=s.Municipio_ID_Municipio and s.Municipio_Estados_ID_estado=mu.Estados_ID_estado) where ID_Sede="+SedeID;
        dat = this.rid.queryForList(sql);
        mav.addObject("sed",dat);
        mav.setViewName("BorrarSede");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }    
    @RequestMapping(value="DDyFD/Sedes/BorrarSede.html", method=RequestMethod.POST)
    public ModelAndView delete(HttpServletRequest re, Sede sed){
        SedeID=Integer.parseInt(re.getParameter("SedeID"));
        String sql ="delete from Sede where ID_Sede="+SedeID;
        this.rid.update(sql);
//        ModelAndView mv=new ModelAndView ("redirect:../Sedes.html");
        mav.setViewName("redirect:../Sedes.html");
        mav.addObject("msjs", "<div style='color: green;'>Se ha eliminado correctamente</div>");
        return mav;
    }
    //No sirve más
    @RequestMapping(value="DDyFD/Sedes/ConfirmaBorrar.html")
    public ModelAndView confirma(HttpServletRequest re){
        SedeID=Integer.parseInt(re.getParameter("SedeID"));
        String sql ="delete from Sede where ID_Sede="+SedeID;
        this.rid.update(sql);
        ModelAndView mv=new ModelAndView ("redirect:../Sedes.html");
//        mv.addObject("msjs", "<div style='color: green;'>Se ha Eliminado correctamente</div>");
        return mv;
    }
}
