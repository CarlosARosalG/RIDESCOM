/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

//import com.mysql.jdbc.Connection;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.captcha.botdetect.web.servlet.Captcha;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
//import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Apc;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.config.Connect;
import mx.ipn.escom.ridescom.config.Craw;
import mx.ipn.escom.ridescom.model.Crawler;
import mx.ipn.escom.ridescom.model.CrawlerDAO;
import mx.ipn.escom.ridescom.model.Nombre;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class LoginAlumno {
    ModelAndView mav=new ModelAndView();
    Conexion cone=new Conexion();
    Nombre ap=new Nombre();
    JdbcTemplate rid=new JdbcTemplate(cone.ConectaRID());
//    PreparedStatement ps;
//    ResultSet rs;
    Craw cw=new Craw();
    
    Connect cn=new Connect();
    java.sql.Connection ct;
    ResultSet rs;
    PreparedStatement ps;
    String ro;
    
    Usuario us=new Usuario();
    Crawler cra=new Crawler();
    UsuarioDAO udao=new UsuarioDAO();

    Apc com=new Apc();
    
    List dat;
    
    //Lista de compuestos
    public String comp="DEL";
    public String comp1="DE";
    public String comp2="LA";
    public String comp3="LOS";
    public String comp4="Y";
    public String comp5="DOS";
    public String comp6 ="A";
    public String comp7 ="LAS";
    
    public Map<String, String> cookies;
    public HashMap<String, String> form;

	private static String saes = "https://www.saes.escom.ipn.mx/";
	private static String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
	public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";

    public String regno;
        public String passwd;
        public String vrfcd;

    public LoginAlumno() {
    }

    public LoginAlumno(Map<String, String> cookies, HashMap<String, String> form, String regno, String passwd, String vrfcd) {
        this.cookies = cookies;
        this.form = form;
        this.regno = regno;
        this.passwd = passwd;
        this.vrfcd = vrfcd;
    }

    public HashMap<String, String> getForm() {
        return form;
    }

    public void setForm(HashMap<String, String> form) {
        this.form = form;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getVrfcd() {
        return vrfcd;
    }

    public void setVrfcd(String vrfcd) {
        this.vrfcd = vrfcd;
    }
    @RequestMapping(value="LoginAlumno.html", method=RequestMethod.GET)
    public ModelAndView log(HttpServletRequest req) throws IOException, Exception{
        HttpSession session = req.getSession();
        String ur="select Roles_ID_Roles from usuario where Nombre_U='"+session.getAttribute("Nombre_U")+"';";
         try{
            ct=cn.Connect();
            ps=ct.prepareStatement(ur);
            rs=ps.executeQuery();
            if(rs!=null ){
                while(rs.next() ){
                ro =rs.getString("Roles_ID_Roles");
                }
            }
        }catch(Exception e){
        }
        if(session.getAttribute("Nombre_U")!= null){
            if(ro.equals("1")){
            mav.setViewName("redirect:/DDyFD.html");
            }else if(ro.equals("2")){
            mav.setViewName("redirect:/Coordinador.html");
            }else if(ro.equals("3")){
            mav.setViewName("redirect:/Alumno.html");    
            }
        }else{
            File ima=new File("../../../Users/spy51/Desktop/Ride/RIDESCOM/web/resources/img/abc.jpg");
            ima.delete();
            Connection con = (Jsoup.connect(logi));
		con.method(Connection.Method.GET).timeout(30000).execute();
	
		Connection.Response res=con.execute();
		cookies = res.cookies();
		cookies.putAll(res.cookies());
                setCookies(cookies);
//   	Document doc = con.get();
		Document doc=res.parse(); 
		
   	Element img = doc.getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage");  	 
  	 String a = img.absUrl("src");
         

   //Descarga la imagen obtenida de la URL del CAPTCHA.
   	Connection.Response resultImageResponse = Jsoup.connect(a)
	            .cookies(getCookies())
	            .ignoreContentType(true)
	            .method(Connection.Method.GET).timeout(30000).execute();
              
	//Crea la imagen del captcha y la guarda.
	    FileOutputStream out = (new FileOutputStream(new java.io.File("../../../Users/spy51/Desktop/Ride/RIDESCOM/web/resources/img/abc.jpg")));
	    out.write(resultImageResponse.bodyAsBytes());
	    out.close();
            
            
            Elements fields = doc.select("input");
	    HashMap<String,String> formFields = new HashMap<String, String>();
	    for (Element field : fields ){
	        formFields.put(field.attr("name"), field.attr("value"));
	    }
            setForm(formFields);
            
                mav.setViewName("LoginAlumno");
            
        }
        return mav;
    }
    java.sql.Connection cta;
    ResultSet rsa;
    PreparedStatement psa;
    String da;
    java.sql.Connection ctp;
    ResultSet rsp;
    PreparedStatement psp;
    String dp;
    String dp1;
    String dp2;
    String dp3;
    String dp4;
    String dp5;
    
    String dtn;
    String bole;
    @RequestMapping(value="LoginAlumno.html", method=RequestMethod.POST)
    public ModelAndView log(HttpServletRequest req, HttpServletResponse resp, Craw cw) throws IOException{
        
        String accion=req.getParameter("btn");
        if(accion.equalsIgnoreCase("Entrar")){
        String usuario=req.getParameter("User");
        String pass=req.getParameter("Password");
        String capt=req.getParameter("Captcha");
        if(capt==null || capt.equals(" ")){
            mav.setViewName("redirect:/LoginAlumno.html");
                    mav.addObject("mjs", "<div style='color: red;'>ERROR, usuario o contraseña invalido.</div>"); 
        }else{
            
                //Aqui deberia ir el crawler
                HashMap<String,String> fi=getForm();
                    fi.put("ctl00$leftColumn$LoginUser$UserName",usuario);
                    fi.put("ctl00$leftColumn$LoginUser$Password", pass);
                    fi.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", capt);
                    Connection.Response conn = Jsoup.connect(saes+"/Default.aspx?ReturnUrl=%2falumnos%2fdefault.aspx")
	            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
	            .cookies(getCookies())
	            .timeout(0)
	            .data(fi)
	            .method(Connection.Method.POST).execute();
		
    //		System.out.println(conn);
                Connection.Response response = conn;
                response.cookies().get(logi);

                //This will get you cookies
                Map<String, String> loginCookies = response.cookies();

                //And this is the easiest way I've found to remain in session
                Document docn = Jsoup.connect("https://www.saes.escom.ipn.mx/Alumnos/default.aspx")
                      .cookies(loginCookies)
                      .get();

                Document docs = Jsoup.connect("https://www.saes.escom.ipn.mx/Alumnos/Reinscripciones/Comprobante_Horario.aspx")
                              .cookies(loginCookies)
                              .get();

                //Aquí se escanea el nombre del alumno que inició sesión
                Element n = docn.getElementById("ctl00_mainCopy_FormView1_nombrelabel");
                String nombre = n.text();
                String [] completo = nombre.split(" ");
                int t=completo.length;

                Element f = docs.select("span#ctl00_mainCopy_Lbl_Mensaje").first();
                String fail=f.text();
                
                    if(fail.isEmpty()) {
                        //Aquí se escanea el comprobante del alumno que inició sesión
                            Element e = docs.select("table#ctl00_mainCopy_GV_Horario td").first();
                            String grupo=e.text();
                                //Checo si ya tengo usuario y boleta guardado
                                String ud="select ID_Alumno from persona p inner join (alumno a, usuario u) on (p.ID_Persona=a.Persona_ID_Persona and p.ID_Persona=u.Persona_ID_Persona) where ID_Alumno='"+usuario+"'and Nombre_U='"+usuario+"' and Password_U='"+pass+"'";
                                try{
                                   cta=cn.Connect();
                                   psa=cta.prepareStatement(ud);
                                   rsa=psa.executeQuery();
                                   if(rsa!=null ){
                                       while(rsa.next() ){
                                       da =rsa.getString("ID_Alumno");
                                       }
                                   }
                               }catch(Exception ex){
                               }
                                if(da!=null){
                                    String dpa="select Password_U, Tipo_Sexo_ID_Tipo_Sexo, CURP, Fecha_Nac, Municipio_ID_Municipio, Municipio_Estados_ID_Estado from persona p inner join (alumno a, usuario u) on (p.ID_Persona=a.Persona_ID_Persona and p.ID_Persona=u.Persona_ID_Persona) where ID_Alumno='"+usuario+"'and Nombre_U='"+usuario+"'";
                                    try{
                                       ctp=cn.Connect();
                                       psp=ctp.prepareStatement(dpa);
                                       rsp=psp.executeQuery();
                                       if(rsp!=null ){
                                           while(rsp.next() ){
                                           dp =rsp.getString("Tipo_Sexo_ID_Tipo_Sexo");
                                           dp1 =rsp.getString("CURP");
                                           dp2 =rsp.getString("Fecha_Nac");
                                           dp3 =rsp.getString("Municipio_ID_Municipio");
                                           dp4 =rsp.getString("Municipio_Estados_ID_Estado");
                                           dp5 =rsp.getString("Password_U");
                                           }
                                       }
                                   }catch(Exception ex){
                                   }
                                    if(dp!=null&&dp1!=null&&dp2!=null&&dp3!=null&&dp4!=null){
                                        if(dp5.equals(pass)){
                                            us=udao.validar(usuario, pass);
                                            if(us.getNombre_U()!= null){
                                                if(us.getRol()==3){
                                                    HttpSession session=req.getSession();
                                                    session.setAttribute("Nombre_U", usuario); //user
                                                    return new ModelAndView("redirect:/Alumno.html");
                                                }else{
                                                    return new ModelAndView("redirect:/Error404.html");
                                                }
                                            }else{
                                                mav.addObject("mjs", "<div style='color: red;'>ERROR, usuario o contraseña invalido.</div>"); 
                                                mav.setViewName("redirect:/LoginAlumno.html");
                                            }
                                        }else{
                                            String sqlu="update Usuario set Password_U=? where Nombre_U="+usuario;
                                        this.rid.update(sqlu,pass);
                                        us=udao.validar(usuario, pass);
                                            if(us.getNombre_U()!= null){
                                                if(us.getRol()==3){
                                                    HttpSession session=req.getSession();
                                                    session.setAttribute("Nombre_U", usuario); //user
                                                    return new ModelAndView("redirect:/Alumno.html");
                                                }else{
                                                    return new ModelAndView("redirect:/Error404.html");
                                                }
                                            }else{
                                                mav.addObject("mjs", "<div style='color: red;'>ERROR, usuario o contraseña invalido.</div>"); 
                                                mav.setViewName("redirect:/LoginAlumno.html");
                                            }
                                        }
                                    }else{
                                        mav.addObject("mjs", "<div style='color: red;'>Por favor complete el formulario</div>"); 
                                        mav.setViewName("redirect:/InfoAlumno.html");
                                    }
                                    //Empiezo a guardar el nombre y boleta del alumno.
                                    
                                }else{
                                    switch (t) {
			
                                    case 2://Caso para Nombre y 1 apellido.

                                    String nl = completo[0];
                                    String a = completo[1];
                                    dtn="insert into Persona(Nombre, Ap_Pat) values(?,?)";
                                    this.rid.update(dtn,nl,a);
                                    bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                    this.rid.update(bole, usuario, grupo);
                                    mav.setViewName("redirect:/InfoAlumno.html");
                                    break;

                                    case 3: //Caso para nombre, ap paterno, ap materno / nombre y 1 apellido compuesto (Caso 2)

                                    String n1 = completo[0];
                                    String a1 = completo[1];
                                    String a2 = completo[2];

                                    if(a1.compareTo(comp)==0||a1.compareTo(comp1)==0||a1.compareTo(comp2)==0||a1.compareTo(comp3)==0||a1.compareTo(comp4)==0||a1.compareTo(comp5)==0||a1.compareTo(comp6)==0||a1.compareTo(comp7)==0) {

                    /*Caso 2*/		String cp= a1.concat(" ").concat(a2);
                                        dtn="insert into Persona(Nombre, Ap_Pat) values(?,?)";
                                        this.rid.update(dtn,n1,cp);
                                        bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                        this.rid.update(bole, usuario, grupo);
                                        mav.setViewName("redirect:/InfoAlumno.html");
                                        //Apellido Paterno Compuesto de 2
                    /*Caso 3*/	}else {
                                        dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                        this.rid.update(dtn,n1,a1,a2);
                                        bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                        this.rid.update(bole, usuario, grupo);
                                        mav.setViewName("redirect:/InfoAlumno.html");
                                    }
                            break;

                                    case 4://Caso para 2 nombres y 2 apellidos // 1 nombre, 1 apellido y 1 apellido compuesto

                                            String na = completo[0];
                                            String app = completo[1]; //Compuesto de Ap_Paterno // Nombre 2
                                            String c1 = completo[2]; //Compuesto de Ap_Materno // Puede ser Ap_Paterno // Resante de Ap_Paterno 
                                            String apcm = completo[3]; // Ap_Materno // Restante de Ap_Materno

                                            if(app.compareTo(comp)==0||app.compareTo(comp1)==0||app.compareTo(comp2)==0||app.compareTo(comp3)==0||app.compareTo(comp4)==0||app.compareTo(comp5)==0||app.compareTo(comp6)==0||app.compareTo(comp7)==0) {
                    /*Caso 2*/		if(c1.compareTo(comp)==0||c1.compareTo(comp1)==0||c1.compareTo(comp2)==0||c1.compareTo(comp3)==0||c1.compareTo(comp4)==0||c1.compareTo(comp5)==0||c1.compareTo(comp6)==0||c1.compareTo(comp7)==0) {

                                                            String apc1=app.concat(" ").concat(c1).concat(" ").concat(apcm);
                                                            
                                                            dtn="insert into Persona(Nombre, Ap_Pat) values(?,?)";
                                                            this.rid.update(dtn,na,apc1);
                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                            this.rid.update(bole, usuario, grupo);
                                                            //Apellido Paterno Compuesto de 3
                                                            mav.setViewName("redirect:/InfoAlumno.html");
                    /*Caso 3*/		}else {
                                                            String apc1=app.concat(" ").concat(c1);
                                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                            this.rid.update(dtn,na,apc1,apcm);
                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                            this.rid.update(bole, usuario, grupo);
                                                            // Apellido Paterno Compuesto de 2    
                                                            mav.setViewName("redirect:/InfoAlumno.html");
                                                    }
                    /*Caso 3*/	}else if(c1.compareTo(comp)==0||c1.compareTo(comp1)==0||c1.compareTo(comp2)==0||c1.compareTo(comp3)==0||c1.compareTo(comp4)==0||c1.compareTo(comp5)==0||c1.compareTo(comp6)==0||c1.compareTo(comp7)==0) {

                                                    String apc1= c1.concat(" ").concat(apcm);
                                                    dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                    this.rid.update(dtn,na,app,apc1);
                                                    bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                    this.rid.update(bole, usuario, grupo);
                                                    //Apellido Materno Compuesto de 2
                                                    mav.setViewName("redirect:/InfoAlumno.html");

                    /*Caso 4*/	}else {

                                            String names = na.concat(" ").concat(app);
                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                            this.rid.update(dtn,names,c1,apcm);
                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                            this.rid.update(bole, usuario, grupo);
                                            // Apellido Paterno
                                            // Apellido Materno
                                            //2 Nombres
                                            mav.setViewName("redirect:/InfoAlumno.html");
                                            }
                                    break;

                                    case 5://Caso para 3 Nombres, 1 Apellido Paterno y 1 Apellido Materno // 2 Nombres, Ap_Paterno compuesto y Ap_Materno // 1 Nombre Ap_Paterno compuesto y Ap_Materno

                                            String nam = completo[0]; 
                                            String nam1 = completo[1]; //Posible compuesto // Nombre 2
                                            String ap = completo[2]; //Posible compuesto // Nombre 3
                                            String am = completo[3]; //Posible compuesto /Posible Apellido paterno
                                            String am1 = completo[4];

                    /*Caso 4*/	if(nam1.compareTo(comp)==0||nam1.compareTo(comp1)==0||nam1.compareTo(comp2)==0||nam1.compareTo(comp3)==0||nam1.compareTo(comp4)==0||nam1.compareTo(comp5)==0||nam1.compareTo(comp6)==0||nam1.compareTo(comp7)==0) {
                                                    if(ap.compareTo(comp)==0||ap.compareTo(comp1)==0||ap.compareTo(comp2)==0||ap.compareTo(comp3)==0||ap.compareTo(comp4)==0||ap.compareTo(comp5)==0||ap.compareTo(comp6)==0||ap.compareTo(comp7)==0) {
                    /*Caso 2*/			if(am.compareTo(comp)==0||am.compareTo(comp1)==0||am.compareTo(comp2)==0||am.compareTo(comp3)==0||am.compareTo(comp4)==0||am.compareTo(comp5)==0||am.compareTo(comp6)==0||am.compareTo(comp7)==0){

                                                                    String cp1=nam1.concat(" ").concat(ap).concat(" ").concat(am).concat(" ").concat(am1);
                                                                    dtn="insert into Persona(Nombre, Ap_Pat) values(?,?)";
                                                                    this.rid.update(dtn,nam,cp1);
                                                                    bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                                    this.rid.update(bole, usuario, grupo);
                                                                    // Apellido Paterno compuesto de 4
                                                                    // Nombres
                                                                    mav.setViewName("redirect:/InfoAlumno.html");
                                                            }else {
                                                                    String cp1 =nam1.concat(" ").concat(ap).concat(" ").concat(am);
                                                                    dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                                    this.rid.update(dtn,nam,cp1,am1);
                                                                    bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                                    this.rid.update(bole, usuario, grupo);
                                                                    // Apellido Paterno compuesto de 3
                                                                    // Apellido Materno
                                                                    // Nombres
                                                                    mav.setViewName("redirect:/InfoAlumno.html");
                                                            }
                    /*Caso 4*/		}else if(am.compareTo(comp)==0||am.compareTo(comp1)==0||am.compareTo(comp2)==0||am.compareTo(comp3)==0||am.compareTo(comp4)==0||am.compareTo(comp5)==0||am.compareTo(comp6)==0||am.compareTo(comp7)==0){

                                                            String cp1 =nam1.concat(" ").concat(ap);
                                                            String cp2=am.concat(" ").concat(am1);
                                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                            this.rid.update(dtn,nam,cp1,cp2);
                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                            this.rid.update(bole, usuario, grupo);
                                                            // Apellido Paterno compuesto de 2
                                                            // Apellido Materno compuesto de 2
                                                            // Nombre
                                                            mav.setViewName("redirect:/InfoAlumno.html");
                    /*Caso 4*/		}else {
                                                            String cp1 = ap.concat(" ").concat(am);
                                                            String nams = nam.concat(" ").concat(nam1);
                                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                            this.rid.update(dtn,nams,cp1,am1);
                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                            this.rid.update(bole, usuario, grupo);
                                                            //Apellido Paterno compuesto de 2
                                                            //Apellido Materno
                                                            //2 Nombres
                                                            mav.setViewName("redirect:/InfoAlumno.html");
                                                    }
                    /*Caso 5*/	}else if(ap.compareTo(comp)==0||ap.compareTo(comp1)==0||ap.compareTo(comp2)==0||ap.compareTo(comp3)==0||ap.compareTo(comp4)==0||ap.compareTo(comp5)==0||ap.compareTo(comp6)==0||ap.compareTo(comp7)==0) {
                                                    if(am.compareTo(comp)==0||am.compareTo(comp1)==0||am.compareTo(comp2)==0||am.compareTo(comp3)==0||am.compareTo(comp4)==0||am.compareTo(comp5)==0||am.compareTo(comp6)==0||am.compareTo(comp7)==0){

                                                            String cp2 =ap.concat(" ").concat(am).concat(" ").concat(am1);
                                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                            this.rid.update(dtn,nam,nam1,cp2);
                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                            this.rid.update(bole, usuario, grupo);
                                                            // Apellido Paterno
                                                            // Apellido Materno compuesto de 3
                                                            // Nombre
                                                            mav.setViewName("redirect:/InfoAlumno.html");
                    /*Caso 4*/		}else {
                                                            String cp1 = ap.concat(" ").concat(am);
                                                            String nams = nam.concat(" ").concat(nam1);
                                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                            this.rid.update(dtn,nams,cp1,am1);
                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                            this.rid.update(bole, usuario, grupo);
//////////////////////////////////////////////////////////////Apellido Paterno compuesto de 2
                                                            //Apellido Materno
                                                            // 2 Nombres
                                                            mav.setViewName("redirect:/InfoAlumno.html");
                                                    }
                    /*Caso 4*/	}else if(am.compareTo(comp)==0||am.compareTo(comp1)==0||am.compareTo(comp2)==0||am.compareTo(comp3)==0||am.compareTo(comp4)==0||am.compareTo(comp5)==0||am.compareTo(comp6)==0||am.compareTo(comp7)==0) {

                                                    String nams=nam.concat(" ").concat(nam1);
                                                    String cp2=am.concat(" ").concat(am1);
                                                    dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                    this.rid.update(dtn,nams,ap,cp2);
                                                    bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                    this.rid.update(bole, usuario, grupo);
                                                    //Apellido Paterno
                                                    //Apellido Materno compuesto de 2
                                                    // 2 Nombres
                                                    mav.setViewName("redirect:/InfoAlumno.html");
                    /*Caso 5*/	}else {
                                                    String nams =nam.concat(" ").concat(nam1).concat(" ").concat(ap);
                                                    dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                    this.rid.update(dtn,nams,am,am1);
                                                    bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                    this.rid.update(bole, usuario, grupo);
                                                    mav.setViewName("redirect:/InfoAlumno.html");
                                            }
                                    break;

            /*Caso Extremo*/case 6: //4 Nombres 2 apellidos / 2 Nombres 2 apellidos compuestos 

                                                    String name = completo[0]; 
                                                    String name1 = completo[1]; //Nombre #2 // Nombre #2 // Nombre #2  // Posible compuesto // 
                                                    String name2 = completo[2]; //Nombre #3 // Nombre #3 // Posible compuesto // Posible compuesto // 
                                                    String name3 = completo[3]; //Nombre #4 // Posible compuesto // Apellido Paterno // Apellido Paterno //  
                                                    String apa = completo[4]; //Apellido Paterno // Posible compuesto // Posible compuesto // Posible compuesto
                                                    String ama = completo[5]; //Apellido Materno // Apellido Materno // Apellido Materno // Apellido Materno // 

                    /*Caso 3*/		if(name1.compareTo(comp)==0 || name1.compareTo(comp1)==0 || name1.compareTo(comp2)==0 || name1.compareTo(comp3)==0 || name1.compareTo(comp4)==0 || name1.compareTo(comp5)==0 || name1.compareTo(comp6)==0 || name1.compareTo(comp7)==0) {
                                                            if(name2.compareTo(comp)==0 || name2.compareTo(comp1)==0 || name2.compareTo(comp2)==0 || name2.compareTo(comp3)==0 || name2.compareTo(comp4)==0 || name2.compareTo(comp5)==0 || name2.compareTo(comp6)==0 || name2.compareTo(comp7)==0) {
                                                                    if(name3.compareTo(comp)==0 || name3.compareTo(comp1)==0 || name3.compareTo(comp2)==0 || name3.compareTo(comp3)==0 || name3.compareTo(comp4)==0 || name3.compareTo(comp5)==0 || name3.compareTo(comp6)==0 || name3.compareTo(comp7)==0) {
                    /*Caso 2:extremo*/			if(apa.compareTo(comp)==0||apa.compareTo(comp1)==0||apa.compareTo(comp2)==0||apa.compareTo(comp3)==0||apa.compareTo(comp4)==0||apa.compareTo(comp5)==0||apa.compareTo(comp6)==0||apa.compareTo(comp7)==0) {

                                                                                    String apc1 =name1.concat(" ").concat(name2).concat(" ").concat(name3).concat(" ").concat(apa).concat(" ").concat(ama);
                                                                                    dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?)";
                                                                                    this.rid.update(dtn,name,apc1);
                                                                                    bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                                                    this.rid.update(bole, usuario, grupo);
                                                                                    // Apellido Paterno compuesto de 5;
                                                                                    // Nombre
                                                                                    mav.setViewName("redirect:/InfoAlumno.html");

                                                                            }else {

                                                                            String apc1 =name1.concat(" ").concat(name2).concat(" ").concat(name3).concat(" ").concat(apa);
                                                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                                            this.rid.update(dtn,name,apc1,ama);
                                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                                            this.rid.update(bole, usuario, grupo);
                                                                            // Apellido Paterno compuesto de 4;
                                                                            // Apellido Materno
                                                                            // Nombre
                                                                            mav.setViewName("redirect:/InfoAlumno.html");
                                                                            }

                    /*Caso 3*/				}else {

                                                                            String apc1=name1.concat(" ").concat(name2).concat(" ").concat(name3);
                                                                            String apc2=apa.concat(" ").concat(ama);
                                                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                                            this.rid.update(dtn,name,apc1,apc2);
                                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                                            this.rid.update(bole, usuario, grupo);
                                                                            // Apellido Paterno compuesto de 3;
                                                                            // Apellido Materno compuesto de 2
                                                                            // Nombre
                                                                            mav.setViewName("redirect:/InfoAlumno.html");
                                                                    }
                    /*Caso 3*/			}else if(name3.compareTo(comp)==0 || name3.compareTo(comp1)==0 || name3.compareTo(comp2)==0 || name3.compareTo(comp3)==0 || name3.compareTo(comp4)==0 || name3.compareTo(comp5)==0 || name3.compareTo(comp6)==0 || name3.compareTo(comp7)==0) {
                                                                    if(apa.compareTo(comp)==0||apa.compareTo(comp1)==0||apa.compareTo(comp2)==0||apa.compareTo(comp3)==0||apa.compareTo(comp4)==0||apa.compareTo(comp5)==0||apa.compareTo(comp6)==0||apa.compareTo(comp7)==0) {

                                                                            String apc1 =name1.concat(" ").concat(name2);
                                                                            String apc2=name3.concat(" ").concat(apa).concat(" ").concat(ama);
                                                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                                            this.rid.update(dtn,name,apc1,apc2);
                                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                                            this.rid.update(bole, usuario, grupo);
                                                                            // Apellido Paterno compuesto de 2;
                                                                            // Apellido Materno compuesto de 3
                                                                            // Nombre
                                                                            mav.setViewName("redirect:/InfoAlumno.html");
                                                                    }
                                                            }

                    /*Caso 4*/		}else if(name2.compareTo(comp)==0 || name2.compareTo(comp1)==0 || name2.compareTo(comp2)==0 || name2.compareTo(comp3)==0 || name2.compareTo(comp4)==0 || name2.compareTo(comp5)==0 || name2.compareTo(comp6)==0 || name2.compareTo(comp7)==0) {
                                                                    if(name3.compareTo(comp)==0 || name3.compareTo(comp1)==0 || name3.compareTo(comp2)==0 || name3.compareTo(comp3)==0 || name3.compareTo(comp4)==0 || name3.compareTo(comp5)==0 || name3.compareTo(comp6)==0 || name3.compareTo(comp7)==0) {
                                                                            if(apa.compareTo(comp)==0||apa.compareTo(comp1)==0||apa.compareTo(comp2)==0||apa.compareTo(comp3)==0||apa.compareTo(comp4)==0||apa.compareTo(comp5)==0||apa.compareTo(comp6)==0||apa.compareTo(comp7)==0) {

                                                                                    String apc2 =name2.concat(" ").concat(name3).concat(" ").concat(apa).concat(" ").concat(ama);
                                                                                    dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                                                    this.rid.update(dtn,name,name1,apc2);
                                                                                    bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                                                    this.rid.update(bole, usuario, grupo);
                                                                                    // Apellido Paterno
                                                                                    // Apellido Materno compuesto de 4
                                                                                    //Nombre
                                                                                    mav.setViewName("redirect:/InfoAlumno.html");
                                                                            }else {

                                                                                    String apc1=name2.concat(" ").concat(name3).concat(" ").concat(apa);
                                                                                    String names=name.concat(" ").concat(name1);
                                                                                    dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                                                    this.rid.update(dtn,names,apc1,ama);
                                                                                    bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                                                    this.rid.update(bole, usuario, grupo);
                                                                                    // Apellido Paterno
                                                                                    // Apellido Materno compuesto de 4
                                                                                    //2 Nombres
                                                                                    mav.setViewName("redirect:/InfoAlumno.html");
                                                                            }
                    /*Caso 4*/				}else if (apa.compareTo(comp)==0||apa.compareTo(comp1)==0||apa.compareTo(comp2)==0||apa.compareTo(comp3)==0||apa.compareTo(comp4)==0||apa.compareTo(comp5)==0||apa.compareTo(comp6)==0||apa.compareTo(comp7)==0) {

                                                                            String apc1=name2.concat(" ").concat(name3);
                                                                            String apc2=apa.concat(" ").concat(ama);
                                                                            String names=name.concat(" ").concat(name1);
                                                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                                            this.rid.update(dtn,names,apc1,apc2);
                                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                                            this.rid.update(bole, usuario, grupo);
                                                                            // Apellido Paterno compuesto de 2;
                                                                            // Apellido Materno compuesto de 2
                                                                            //2 Nombres
                                                                            mav.setViewName("redirect:/InfoAlumno.html");
                                                                    }else {

                                                                            String apc2=name2.concat(" ").concat(name3).concat(" ").concat(apa).concat(" ").concat(ama);
                                                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                                            this.rid.update(dtn,name,name1,apc2);
                                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                                            this.rid.update(bole, usuario, grupo);
                                                                            // Apellido Paterno ;
                                                                            // Apellido Materno compuesto de 4
                                                                            // Nombre DEBE SER DE 2 
                                                                            mav.setViewName("redirect:/InfoAlumno.html");
                                                                    }

                    /*Caso 4*/		}else if(name3.compareTo(comp)==0 || name3.compareTo(comp1)==0 || name3.compareTo(comp2)==0 || name3.compareTo(comp3)==0 || name3.compareTo(comp4)==0 || name3.compareTo(comp5)==0 || name3.compareTo(comp6)==0 || name3.compareTo(comp7)==0) {
                                                            if(apa.compareTo(comp)==0||apa.compareTo(comp1)==0||apa.compareTo(comp2)==0||apa.compareTo(comp3)==0||apa.compareTo(comp4)==0||apa.compareTo(comp5)==0||apa.compareTo(comp6)==0||apa.compareTo(comp7)==0) {

                                                                    String names = name.concat(" ").concat(name1);
                                                                    String apc2=name3.concat(" ").concat(apa).concat(" ").concat(ama);
                                                                    dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                                    this.rid.update(dtn,names,name2,apc2);
                                                                    bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                                    this.rid.update(bole, usuario, grupo);
                                                                    // Apellido Paterno ;
                                                                    // Apellido Materno compuesto de 3
                                                                    // 2 Nombres
                                                                    mav.setViewName("redirect:/InfoAlumno.html");
                                                            }else {

                                                                    String names = name.concat(" ").concat(name1).concat(" ").concat(name2);
                                                                    String apc2=name3.concat(" ").concat(apa);
                                                                    dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                                    this.rid.update(dtn,names,apc2,ama);
                                                                    bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                                    this.rid.update(bole, usuario, grupo);
                                                                    // Apellido Paterno compuesto de 2;
                                                                    // Apellido Materno
                                                                    // 3 Nombres
                                                                    mav.setViewName("redirect:/InfoAlumno.html");
                                                            }
                                                    }else if(apa.compareTo(comp)==0||apa.compareTo(comp1)==0||apa.compareTo(comp2)==0||apa.compareTo(comp3)==0||apa.compareTo(comp4)==0||apa.compareTo(comp5)==0||apa.compareTo(comp6)==0||apa.compareTo(comp7)==0) {

                                                            String names =name.concat(" ").concat(name1).concat(" ").concat(name2);
                                                            String apc2 = apa.concat(" ").concat(ama);
                                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                            this.rid.update(dtn,names,name3,apc2);
                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                            this.rid.update(bole, usuario, grupo);
                                                            
                                                            mav.setViewName("redirect:/InfoAlumno.html");
                    /*Caso 6*/		}else {
                                                            String names =name.concat(" ").concat(name1).concat(" ").concat(name2).concat(" ").concat(name3);
                                                            dtn="insert into Persona(Nombre, Ap_Pat, Ap_Mat) values(?,?,?)";
                                                            this.rid.update(dtn,names,apa,ama);
                                                            bole="insert into Alumno(ID_Alumno, Inscrito, Persona_ID_Persona, Escuela_has_Prog_Academico_Escuela_ID_Escuela, Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) values(?,?,(select MAX(ID_Persona)from Persona),7,18)";
                                                            this.rid.update(bole, usuario, grupo);

                                                            mav.setViewName("redirect:/InfoAlumno.html");
                                                    }

                                                    break;
                            }
                                    mav.setViewName("redirect:/InfoAlumno.html");
                                }
                            
                    }else {
                            mav.addObject("mjs", "<div style='color: red;'>LO SENTIMOS NO ESTÁS INSCRITO, VUELVE CUANDO LO ESTÉS</div>"); 
                            mav.setViewName("LoginAlumno");
                    }
        }
        }else{
            mav.setViewName("redirect:/LoginAlumno.html");
        }
        return mav;
    }
    
//    @RequestMapping(value="Privacidad.html")
//    ModelAndView term(){
//        mav.setViewName("Condiciones");
//        return mav;
//    }
    
}