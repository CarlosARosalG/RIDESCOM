/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
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
    ModelAndView mav=new ModelAndView();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    Usuario us=new Usuario();
    UsuarioDAO udao=new UsuarioDAO();
    
    int EventoID;
    List dat;
    List dat1;

     ////////////////////////////////// Operadores CRUD //////////////////////////////////////////////////////
    //Scripts para Agregar Deportes
    @RequestMapping(value="DDyFD/AgregarEvento", method=RequestMethod.GET)
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
    @RequestMapping(value="DDyFD/AgregarEvento", method=RequestMethod.POST)
    public ModelAndView Agrega(Eventos ev)throws Exception{
            
            String sql="insert into Evento(Nombre_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Lugar_del_Evento, Descripcion, Direccion, P_Referencia, Fecha_Evento, Ciclo_ID_Ciclo, Act_Deportiva_ID_Deporte) value (?,?,?,?,?,?,?,?,?,?);";
            this.rid.update(sql, ev.getNombre_E(), ev.getFIR(), ev.getFFR(), ev.getLugar(), ev.getDesc(), ev.getDir(), ev.getP_Ref(), ev.getFE(), ev.getCiclo(), ev.getDeporte());
            return new ModelAndView("redirect:../DDyFD/Eventosiguiente");
    }
    @RequestMapping(value="DDyFD/Eventosiguiente", method=RequestMethod.GET)
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
    @RequestMapping(value="DDyFD/EditarEvento", method=RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest re)throws SQLException{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        EventoID=Integer.parseInt(re.getParameter("EventoID"));
            String sql="select * from Evento where Evento_ID="+EventoID;
        dat = this.rid.queryForList(sql);
        mav.addObject("eve",dat);
        mav.setViewName("EditarEvento");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/EditarEvento", method=RequestMethod.POST)
    public ModelAndView Editar(Eventos ev){
        String sql="update Evento set Nombre_Evento=?, Fecha_inicio_Registro=?, Fecha_fin_Registro=?, Lugar_del_Evento=?, Descripcion=?, Direccion=?, P_Referencia=?, Fecha_Evento=?, Ciclo_ID_Ciclo=?, Act_Deportiva_ID_Deporte=? where Evento_ID="+EventoID;
        this.rid.update(sql, ev.getNombre_E(), ev.getFIR(), ev.getFFR(), ev.getLugar(), ev.getDesc(), ev.getDir(), ev.getP_Ref(), ev.getFE(), ev.getCiclo(), ev.getDeporte());
        ModelAndView mv=new ModelAndView ("redirect:../ConfirmaEvento");
        
        return mv;
    }
    @RequestMapping(value="DDyFD/ConfirmaEvento", method=RequestMethod.GET)
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
    @RequestMapping(value="DDyFD/BorrarEvento", method=RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        EventoID=Integer.parseInt(re.getParameter("EventoID"));
//        String sql="select * from Evento where Evento_ID="+EventoID;
        String sql="select Evento_ID, Nombre_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Lugar_del_Evento, Descripcion, Direccion, P_referencia, Fecha_Evento, Ciclo.Ciclo_Escolar, Act_Deportiva.Disciplina from Evento "
                + "inner join (Ciclo, Act_Deportiva) on (Evento.Ciclo_ID_Ciclo=Ciclo.ID_Ciclo AND Evento.Act_Deportiva_ID_Deporte=Act_Deportiva.ID_Deporte) where Evento_ID="+EventoID;
        dat = this.rid.queryForList(sql);
        mav.addObject("eve",dat);
        mav.setViewName("BorrarEvento");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }    
    @RequestMapping(value="DDyFD/BorrarEvento", method=RequestMethod.POST)
    public ModelAndView delete(Eventos ev){
        String sql="update Evento set Nombre_Evento=?, Fecha_inicio_Registro=?, Fecha_fin_Registro=?, Lugar_del_Evento=?, Descripcion=?, Direccion=?, P_Referencia=?, Fecha_Evento=?, Ciclo_ID_Ciclo=?, Act_Deportiva_ID_Deporte=? where Evento_ID="+EventoID;
        this.rid.update(sql, ev.getNombre_E(), ev.getFIR(), ev.getFFR(), ev.getLugar(), ev.getDesc(), ev.getDir(), ev.getP_Ref(), ev.getFE(), ev.getCiclo(), ev.getDeporte());
        ModelAndView mv=new ModelAndView ("redirect:../DDyFD/ConfirmaBorrarEvento");
        return mv;
    }
    @RequestMapping(value="DDyFD/ConfirmaBorrarEvento")
    public ModelAndView confirma(HttpServletRequest re){
        EventoID=Integer.parseInt(re.getParameter("EventoID"));
        String sql ="delete from Evento where Evento_ID="+EventoID;
        this.rid.update(sql);
        ModelAndView mv=new ModelAndView ("redirect:../DDyFD");
//        mv.addObject("msjs", "<div style='color: green;'>Se ha eliminado correctamente</div>");
        return mv;
    }

    
}
