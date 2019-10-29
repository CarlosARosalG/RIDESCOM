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
import mx.ipn.escom.ridescom.config.Connect;
import mx.ipn.escom.ridescom.model.Resultado;
import mx.ipn.escom.ridescom.model.Boleta;

import mx.ipn.escom.ridescom.model.Contacto;
import mx.ipn.escom.ridescom.model.Eventos;
import mx.ipn.escom.ridescom.model.Persona;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class Resultados {
    Conexion con=new Conexion();
    Connect cn=new Connect();
    Connection ct;
    PreparedStatement ps;
    PreparedStatement ps1;
    ResultSet rs;
    ResultSet rs1;
    
    ModelAndView mav=new ModelAndView();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    Boleta b=new Boleta();
    
    int ResulID;
    String AlumnoID;
            
    List dat;
    List dat2;
    List es;
    List ust;
    List dr;
    String p;
    String a;
    String co;
    
    @RequestMapping(value="Coordinador/Resultados.html", method=RequestMethod.GET)
    public ModelAndView resul(){   
        String sql1="select i.Alumno_ID_Alumno, p.ID_Persona, p.Nombre, e.Escuela, ad.Disciplina, pr.Prueba, r.Lugar_Obtenido, r.Marca, ev.Nombre_Evento \n" +
"	FROM Resultados r\n" +
"    inner join (Inscripcion i, Escuela e, Evento ev, Pruebas pr, Act_Deportiva ad, Persona p, Alumno a )\n" +
"    on (p.ID_Persona=a.Persona_ID_Persona\n" +
"       and pr.Act_Deportiva_ID_Deporte=ad.ID_Deporte\n" +
"       and pr.ID_Pruebas=ev.Pruebas_ID_Pruebas\n" +
"       and a.ID_Alumno=i.Alumno_ID_Alumno\n" +
"       and ev.Evento_ID=i.Evento_Evento_ID\n" +
"       and e.ID_Escuela=i.Escuela_ID_Escuela\n" +
"       and r.Inscripcion_Alumno_ID_Alumno=i.Alumno_ID_Alumno\n" +
"       and r.Inscripcion_Evento_Evento_ID=i.Evento_Evento_ID)";
            dat=this.rid.queryForList(sql1);
            //Aqui el sql solo muestra los eventos que no hayan pasado 
            if(dat!=null)
                mav.addObject("ins",dat);
        mav.setViewName("Resultados");
        return mav;
    }
    @RequestMapping(value="Coordinador/Resultados/IngresaBoleta.html", method=RequestMethod.GET)
    public ModelAndView bol(){   
        mav.setViewName("BoletaRes");
        return mav;
    }
    @RequestMapping(value="Coordinador/Resultados/IngresaBoleta.html", method=RequestMethod.POST)
    public ModelAndView bolr(Boleta bl){   
        
        AlumnoID=bl.getBoleta();
        String s="SELECT DISTINCT p.ID_Persona, p.Nombre, p.Ap_Pat, p.Ap_Mat, es.Escuela, prog.Programa, a.ID_Alumno " +
                "from persona p, Alumno a, escuela_has_prog_academico ep, escuela es, prog_academico prog, Inscripcion i, Evento e, Pruebas pr, Act_Deportiva d " +
                "where p.ID_Persona=a.Persona_ID_Persona " +
                "  and es.ID_Escuela=ep.Escuela_ID_Escuela " +
                "  and prog.ID_Prog_Academico=ep.Prog_Academico_ID_Prog_Academico " +
                "  and a.Escuela_has_Prog_Academico_Escuela_ID_Escuela=ep.Escuela_ID_Escuela " +
                "  and a.Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico=ep.Prog_Academico_ID_Prog_Academico " +
                "  and pr.Act_Deportiva_ID_Deporte=d.ID_Deporte " +
                "  and e.Pruebas_ID_Pruebas=pr.ID_Pruebas " +
                "  and i.Alumno_ID_Alumno=a.ID_Alumno " +
                "  and i.Evento_Evento_ID=e.Evento_ID "
                + "and i.Alumno_ID_Alumno='"+AlumnoID+"'";
        
        dat= this.rid.queryForList(s);
        String pr="SELECT i.Evento_Evento_ID, e.Pruebas_ID_Pruebas, pr.Prueba, d.Disciplina " +
"                from persona p, Alumno a, escuela_has_prog_academico ep, escuela es, prog_academico prog, Inscripcion i, Evento e, Pruebas pr, Act_Deportiva d " +
"                where p.ID_Persona=a.Persona_ID_Persona " +
"                  and es.ID_Escuela=ep.Escuela_ID_Escuela " +
"                  and prog.ID_Prog_Academico=ep.Prog_Academico_ID_Prog_Academico " +
"                  and a.Escuela_has_Prog_Academico_Escuela_ID_Escuela=ep.Escuela_ID_Escuela " +
"                  and a.Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico=ep.Prog_Academico_ID_Prog_Academico " +
"                  and pr.Act_Deportiva_ID_Deporte=d.ID_Deporte " +
"                  and e.Pruebas_ID_Pruebas=pr.ID_Pruebas " +
"                  and i.Alumno_ID_Alumno=a.ID_Alumno " +
"                  and i.Evento_Evento_ID=e.Evento_ID " +
"                and i.Alumno_ID_Alumno='"+AlumnoID+"'";
//        String sql="select ID_Alumno from Alumno where ID_Alumno="+AlumnoID;
//        String bol=dat.toString();
//        mav.addObject("bole",bol.substring(12, 22));
        dat2=this.rid.queryForList(pr);
        String sa="select i.Alumno_ID_Alumno, p.ID_Persona, p.Nombre, e.Escuela, ad.Disciplina, ev.Pruebas_ID_Pruebas, pr.Prueba, r.Lugar_Obtenido, r.Marca, ev.Nombre_Evento \n" +
"	FROM Resultados r\n" +
"    inner join (Inscripcion i, Escuela e, Evento ev, Pruebas pr, Act_Deportiva ad, Persona p, Alumno a )\n" +
"    on (p.ID_Persona=a.Persona_ID_Persona\n" +
"       and pr.Act_Deportiva_ID_Deporte=ad.ID_Deporte\n" +
"       and pr.ID_Pruebas=ev.Pruebas_ID_Pruebas\n" +
"       and a.ID_Alumno=i.Alumno_ID_Alumno\n" +
"       and ev.Evento_ID=i.Evento_Evento_ID\n" +
"       and e.ID_Escuela=i.Escuela_ID_Escuela\n" +
"       and r.Inscripcion_Alumno_ID_Alumno=i.Alumno_ID_Alumno\n" +
"       and r.Inscripcion_Evento_Evento_ID=i.Evento_Evento_ID)";
            es=this.rid.queryForList(sa);
            //Aqui el sql solo muestra los eventos que no hayan pasado 
        mav.addObject("alum",es);
        mav.addObject("alu",dat);
        mav.addObject("prueba",dat2);
        mav.setViewName("redirect:../Resultados/AgregarResultado.html");
        return mav;
    }
    
    ////////////////////////////////// Operadores CRUD //////////////////////////////////////////////////////
    //Scripts para Agregar Deportes
    @RequestMapping(value="Coordinador/Resultados/AgregarResultado.html", method=RequestMethod.GET)
    public ModelAndView Agrega(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("Error");
        }else{
            String sa="select i.Alumno_ID_Alumno, p.ID_Persona, p.Nombre, e.Escuela, ad.Disciplina, ev.Pruebas_ID_Pruebas, pr.Prueba, r.Lugar_Obtenido, r.Marca, ev.Nombre_Evento \n" +
"	FROM Resultados r\n" +
"    inner join (Inscripcion i, Escuela e, Evento ev, Pruebas pr, Act_Deportiva ad, Persona p, Alumno a )\n" +
"    on (p.ID_Persona=a.Persona_ID_Persona\n" +
"       and pr.Act_Deportiva_ID_Deporte=ad.ID_Deporte\n" +
"       and pr.ID_Pruebas=ev.Pruebas_ID_Pruebas\n" +
"       and a.ID_Alumno=i.Alumno_ID_Alumno\n" +
"       and ev.Evento_ID=i.Evento_Evento_ID\n" +
"       and e.ID_Escuela=i.Escuela_ID_Escuela\n" +
"       and r.Inscripcion_Alumno_ID_Alumno=i.Alumno_ID_Alumno\n" +
"       and r.Inscripcion_Evento_Evento_ID=i.Evento_Evento_ID)";
            es=this.rid.queryForList(sa);
            //Aqui el sql solo muestra los eventos que no hayan pasado 
        mav.addObject("alum",es);
            mav.setViewName("AgregarResultado");
        }
        return mav;
    }
    @RequestMapping(value="Coordinador/Resultados/AgregarResultado.html", method=RequestMethod.POST)
    public ModelAndView Agrega( Resultado re)throws Exception{
            String che="select DISTINCT Inscripcion_Alumno_ID_Alumno, Inscripcion_Evento_Evento_ID from Resultados where Inscripcion_Alumno_ID_Alumno="+re.getBoleta()+" and Inscripcion_Evento_Evento_ID="+re.getEv_ID();
//            String che1="select DISTINCT Inscripcion_Evento_Evento_ID from Resultados where Inscripcion_Alumno_ID_Alumno="+re.getBoleta()+" and Inscripcion_Evento_Evento_ID="+re.getEv_ID();
        try{
            ct=cn.Connect();
            ps=ct.prepareStatement(che);
            rs=ps.executeQuery();
            if(rs!=null && rs1!=null){
                while(rs.next() && rs1.next()){
                co =rs.getString("Inscripcion_Alumno_ID_Alumno");
                a=rs.getString("Inscripcion_Evento_Evento_ID");
                }
            }
        }catch(Exception e){
        }
        if(a==null && co==null){
            String sql="insert into Resultados (Lugar_Obtenido, Marca, Inscripcion_Alumno_ID_Alumno, Inscripcion_Evento_Evento_ID) values (?,?,?,?)";
            this.rid.update(sql,re.getPosicion(), re.getMarca(), re.getBoleta(), re.getEv_ID());
            
//            return new ModelAndView ("redirect:../Coordinador/Resultados.html");
            mav.setViewName("redirect:../Coordinador/Resultados.html");
            mav.addObject("mjs", "<div style='color: green;'>Los resultados se registraron correctamente.</div>");
            return mav;
        }else{
             //            return new ModelAndView ("redirect:../Coordinador/Resultados.html");ModelAndView mv=new ModelAndView("/AgregarResultado.html");
            mav.setViewName("redirect:../Coordinador/Resultados.html");
            mav.addObject("mjs", "<div style='color: red;'>Esta información ya esta registrada.</div>");
        return mav;  
        }
    }
    @RequestMapping(value="Coordinador/Resultados/Resultadosiguiente.html", method=RequestMethod.GET)
    public ModelAndView sig(HttpServletRequest re){
          HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("Error404");
        }else{
            mav.setViewName("Resultadonext");
        }
        return mav;
    }
    
    //Scripts para ediciÃ³n de Usuarios
    @RequestMapping(value="Coordinador/Resultados/EditarResultado.html", method=RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest re)throws SQLException{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
            mav.setViewName("Error404");
        }else{
            ResulID=Integer.parseInt(re.getParameter("ResulID"));
            
            String ed="select i.Alumno_ID_Alumno, p.ID_Persona, p.Nombre, p.Ap_Pat, p.Ap_Mat, e.Escuela, prog.Programa, ad.Disciplina, pr.ID_Pruebas, pr.Prueba, r.Lugar_Obtenido, r.Marca, ev.Nombre_Evento \n" +
"	FROM Resultados r\n" +
"    inner join (Inscripcion i, Escuela e, Evento ev, Pruebas pr, Act_Deportiva ad, Persona p, Alumno a, prog_academico prog)\n" +
"    on (p.ID_Persona=a.Persona_ID_Persona\n" +
"       and pr.Act_Deportiva_ID_Deporte=ad.ID_Deporte\n" +
"       and pr.ID_Pruebas=ev.Pruebas_ID_Pruebas\n" +
"       and a.ID_Alumno=i.Alumno_ID_Alumno\n" +
"       and a.Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico=prog.ID_Prog_Academico \n" +
"       and ev.Evento_ID=i.Evento_Evento_ID\n" +
"       and e.ID_Escuela=i.Escuela_ID_Escuela\n" +
"       and r.Inscripcion_Alumno_ID_Alumno=i.Alumno_ID_Alumno\n" +
"       and r.Inscripcion_Evento_Evento_ID=i.Evento_Evento_ID "+
"            AND p.ID_Persona="+ResulID+")";
String sa="select i.Alumno_ID_Alumno,p.ID_Persona, p.Nombre, e.Escuela, ad.Disciplina, pr.Prueba, r.Lugar_Obtenido, r.Marca, ev.Nombre_Evento \n" +
"	FROM Resultados r\n" +
"    inner join (Inscripcion i, Escuela e, Evento ev, Pruebas pr, Act_Deportiva ad, Persona p, Alumno a )\n" +
"    on (p.ID_Persona=a.Persona_ID_Persona\n" +
"       and pr.Act_Deportiva_ID_Deporte=ad.ID_Deporte\n" +
"       and pr.ID_Pruebas=ev.Pruebas_ID_Pruebas\n" +
"       and a.ID_Alumno=i.Alumno_ID_Alumno\n" +
"       and ev.Evento_ID=i.Evento_Evento_ID\n" +
"       and e.ID_Escuela=i.Escuela_ID_Escuela\n" +
"       and r.Inscripcion_Alumno_ID_Alumno=i.Alumno_ID_Alumno\n" +
"       and r.Inscripcion_Evento_Evento_ID=i.Evento_Evento_ID)";
            es=this.rid.queryForList(sa);
            //Aqui el sql solo muestra los eventos que no hayan pasado 
        mav.addObject("alum",es);
//        String sqles="select Escuela from Escuela where ID_Escuela=7";
        dat = this.rid.queryForList(ed);
//        es=this.rid.queryForList(sqles);
        mav.addObject("alu",dat);
        
            mav.setViewName("EditarResultado");
        }
        return mav;
    }
    @RequestMapping(value="Coordinador/Resultados/EditarResultado.html", method=RequestMethod.POST)
    public ModelAndView Editar(Usuario u, Persona p, Contacto c, Eventos ev){
        
        String sr="update Resultados set Lugar_Obtenido=?, Marca=? where =";
//        String sqlu="update Usuario set Nombre_U=?, Password_U=? where Persona_ID_Persona="+ResulID;
//        this.rid.update(sqlu, u.getNombre_U(), u.getPassword_U());
//        String sql="update Persona set Nombre=?, Ap_Pat=?, Ap_Mat=?, Tipo_Sexo_ID_Tipo_Sexo=?, CURP=?, Fecha_Nac=?, NSS=?, Municipio_ID_Municipio=?, Municipio_Estados_ID_estado=(select DISTINCT Estados_ID_estado from Municipio where ID_Municipio="+p.getMunicipio()+") where ID_Persona="+ResulID;
//        this.rid.update(sql, p.getNombre(), p.getAppat(), p.getApmat(), p.getSexo(), p.getCURP(), p.getNacimiento(), p.getNSS(), p.getMunicipio());
//        
//        String sqlcon="select ID_contacto from Contacto where Persona_ID_Persona="+ResulID;
//        try{
//            ct=cn.Connect();
//            ps=ct.prepareStatement(sqlcon);
//            rs=ps.executeQuery();
//            if(rs!=null){
//                while(rs.next())
//                co =rs.getString("ID_Contacto");
//                
//            }
//        }catch(Exception e){
//        }
//        String sqltf="update Telefono_fijo set Telefono=? where Contacto_ID_Contacto="+co;
//            this.rid.update(sqltf, c.getTel_fijo());
//            String sqltc="update Telefono_Celular set Celular=? where Contacto_ID_Contacto="+co;
//            this.rid.update(sqltc, c.getTel_cel());
//            String sqlc="update Email set Correo=? where Contacto_ID_Contacto="+co;
//            this.rid.update(sqlc, c.getCorreo());

        ModelAndView mv=new ModelAndView ("redirect:../Resultados.html");
//        mv.addObject("mjs", "<div style='color: green;'>Se han actualizado los datos correctamente</div>");
        return mv;
    }
}
