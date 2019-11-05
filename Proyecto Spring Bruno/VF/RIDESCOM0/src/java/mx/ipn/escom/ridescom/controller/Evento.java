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
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.config.Connect;
import mx.ipn.escom.ridescom.model.Deporte;
import mx.ipn.escom.ridescom.model.Eventos;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Evento {
    Conexion con=new Conexion();
    Connect cn=new Connect();
    ModelAndView mav=new ModelAndView();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    Usuario us=new Usuario();
    UsuarioDAO udao=new UsuarioDAO();
    
    Connection ct;
    ResultSet rs;
    PreparedStatement ps;
    String dep;
    
    int EventoID;
    List dat;
    List dat1;
   
     ////////////////////////////////// Operadores CRUD //////////////////////////////////////////////////////
    //Scripts para Agregar Deportes
    @RequestMapping(value="DDyFD/AgregarEvento.html", method=RequestMethod.GET)
    public ModelAndView Agrega(HttpServletRequest re)throws SQLException{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("AgregarEvento");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/AgregarEvento.html", method=RequestMethod.POST)
    public ModelAndView Agrega(Eventos ev)throws Exception{            
//            String sql="insert into Evento(Nombre_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Lugar_del_Evento, Descripcion, Direccion, P_Referencia, Fecha_Evento, Ciclo_ID_Ciclo, Act_Deportiva_ID_Deporte) value (?,?,?,?,?,?,?,?,?,?);";
//            this.rid.update(sql, ev.getNombre_E(), ev.getFIR(), ev.getFFR(), ev.getLugar(), ev.getDesc(), ev.getDir(), ev.getP_Ref(), ev.getFE(), ev.getCiclo(), ev.getDeporte());
        
        String sql="insert into Evento(Nombre_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Descripcion, Fecha_Evento, Ciclo_ID_Ciclo, Pruebas_ID_Pruebas, Sede_ID_Sede) value (?,left(now(),10),?,?,?,?,?,?);";
            this.rid.update(sql, ev.getNombre_E(), ev.getFFR(), ev.getDesc(), ev.getFE(), ev.getCiclo(), ev.getDeporte(), ev.getSede());
            return new ModelAndView("redirect:../DDyFD/Eventosiguiente.html");
    }
    @RequestMapping(value="DDyFD/Eventosiguiente.html", method=RequestMethod.GET)
    public ModelAndView sig(HttpServletRequest re){
          HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("Eventonext");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    
    //Scripts para edición de Deportes
    @RequestMapping(value="DDyFD/EditarEvento.html", method=RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest re)throws SQLException{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        EventoID=Integer.parseInt(re.getParameter("EventoID"));
        String ei="select Evento_Evento_ID from Inscripcion where Evento_Evento_ID="+EventoID;
        try{
            ct=cn.Connect();
            ps=ct.prepareStatement(ei);
            rs=ps.executeQuery();
            if(rs!=null ){
                while(rs.next() ){
                dep =rs.getString("Evento_Evento_ID");
                }
            }
        }catch(Exception e){
        }
        if(dep==null){
            String sql="select Evento_ID, Nombre_Evento, Descripcion, Fecha_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Prueba, Disciplina, Nombre_S, Ciclo_Escolar " +
                        "from Evento e, Ciclo c, Sede s, Pruebas pr, act_deportiva d " +
                        "where e.Ciclo_ID_Ciclo=c.ID_Ciclo " +
                        "and e.Sede_ID_Sede=s.ID_Sede " +
                        "and e.Pruebas_ID_Pruebas=pr.ID_Pruebas " +
                        "and pr.Act_Deportiva_ID_Deporte=d.ID_Deporte " +
                        "and Evento_ID="+EventoID;
//            String f="select left (now(),10)";
            String f="select Fecha_inicio_Registro from Evento where Evento_ID="+EventoID;
        dat = this.rid.queryForList(sql);
        dat1=this.rid.queryForList(f);
        
        String o = dat1.toString();
//        mav.addObject("fecha", o.substring(18, 28));
        mav.addObject("fecha", o.substring(24, 34));
        
        mav.addObject("eve",dat);
//        mav.addObject("fecha", dat1);
        mav.setViewName("EditarEvento");
        }else{
            String adep =null;
            
            String sql="select Evento_ID, Nombre_Evento, Descripcion, Fecha_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Prueba, Disciplina, Nombre_S, Ciclo_Escolar " +
                        "from Evento e, Ciclo c, Sede s, Pruebas pr, act_deportiva d " +
                        "where e.Ciclo_ID_Ciclo=c.ID_Ciclo " +
                        "and e.Sede_ID_Sede=s.ID_Sede " +
                        "and e.Pruebas_ID_Pruebas=pr.ID_Pruebas " +
                        "and pr.Act_Deportiva_ID_Deporte=d.ID_Deporte " +
                        "and Evento_ID="+EventoID;
//            String f="select left (now(),10)";
            String f="select Fecha_inicio_Registro from Evento where Evento_ID="+EventoID;
        dat = this.rid.queryForList(sql);
        dat1=this.rid.queryForList(f);
        
        String o = dat1.toString();
//        mav.addObject("fecha", o.substring(18, 28));
        mav.addObject("fecha", o.substring(24, 34));
        
        mav.addObject("eve",dat);
        mav.addObject("mjs", "<div style='color: red;'>No se puede editar porque ya tiene inscritos en �l</div>");
        mav.addObject("jav", "<script>\n" +
"                            var cond;\n" +
"                            cond="+adep+"!==null;\n" +
"                            $('#actt').toggle(cond);\n" +
"                        </script>");
        mav.setViewName("EditarEvento");
//         mav.setViewName("redirect:/DDyFD.html");
        }
            
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/EditarEvento.html", method=RequestMethod.POST)
    public ModelAndView Editar(Eventos ev){
        String sql="update Evento set Nombre_Evento=?, Fecha_fin_Registro=?, Descripcion=?, Fecha_Evento=?, Ciclo_ID_Ciclo=?, Pruebas_ID_Pruebas=?, Sede_ID_Sede=? where Evento_ID="+EventoID;
        this.rid.update(sql, ev.getNombre_E(), ev.getFFR(), ev.getDesc(), ev.getFE(), ev.getCiclo(), ev.getDeporte(), ev.getSede());
        ModelAndView mv=new ModelAndView ("redirect:../DDyFD.html");
        
        return mv;
    }
    @RequestMapping(value="DDyFD/ConfirmaEvento.html", method=RequestMethod.GET)
    public ModelAndView confirm(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        EventoID=Integer.parseInt(re.getParameter("EventoID"));
        String sql="select * from Evento where Evento_ID="+EventoID;
        dat = this.rid.queryForList(sql);
        mav.addObject("eve",dat);
        mav.setViewName("ConfirmaEdicione");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }

    //Scripts para borrar registros
    @RequestMapping(value="DDyFD/BorrarEvento.html", method=RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        EventoID=Integer.parseInt(re.getParameter("EventoID"));
//        String sql="select * from Evento where Evento_ID="+EventoID;
        String sql="select Evento_ID, Nombre_Evento, Descripcion, Fecha_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Prueba, Disciplina, Nombre_S, Ciclo_Escolar " +
                        "from Evento e, Ciclo c, Sede s, Pruebas pr, act_deportiva d " +
                        "where e.Ciclo_ID_Ciclo=c.ID_Ciclo " +
                        "and e.Sede_ID_Sede=s.ID_Sede " +
                        "and e.Pruebas_ID_Pruebas=pr.ID_Pruebas " +
                        "and pr.Act_Deportiva_ID_Deporte=d.ID_Deporte " +
                        "and Evento_ID="+EventoID;
        dat = this.rid.queryForList(sql);
        mav.addObject("eve",dat);
        mav.setViewName("BorrarEvento");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }    
    @RequestMapping(value="DDyFD/BorrarEvento.html", method=RequestMethod.POST)
    public ModelAndView delete(Eventos ev){
        //Cambiar act_deportiva
        String sql="update Evento set Nombre_Evento=?, Fecha_inicio_Registro=?, Fecha_fin_Registro=?, Descripcion=?, Fecha_Evento=?, Ciclo_ID_Ciclo=?, Pruebas_ID_Pruebas=?, Sede_ID_Sede=? where Evento_ID="+EventoID;
        this.rid.update(sql, ev.getNombre_E(), ev.getFIR(), ev.getFFR(), ev.getDesc(), ev.getFE(), ev.getCiclo(), ev.getDeporte(), ev.getSede());
        ModelAndView mv=new ModelAndView ("redirect:../DDyFD/ConfirmaBorrarEvento.html");
        return mv;
    }
    @RequestMapping(value="DDyFD/ConfirmaBorrarEvento.html")
    public ModelAndView confirma(HttpServletRequest re){
        EventoID=Integer.parseInt(re.getParameter("EventoID"));
        String sql ="delete from Evento where Evento_ID="+EventoID;
        this.rid.update(sql);
        ModelAndView mv=new ModelAndView ("redirect:../DDyFD.html");
//        mv.addObject("msjs", "<div style='color: green;'>Se ha eliminado correctamente</div>");
        return mv;
    }
}