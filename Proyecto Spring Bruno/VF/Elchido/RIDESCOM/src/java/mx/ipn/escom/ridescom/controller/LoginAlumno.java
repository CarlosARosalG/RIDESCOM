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
import java.io.FileWriter;
import java.io.PrintWriter;
//import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.config.Connect;
import mx.ipn.escom.ridescom.config.Craw;
import mx.ipn.escom.ridescom.model.Crawler;
import mx.ipn.escom.ridescom.model.CrawlerDAO;
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
    Conexion con=new Conexion();
//    Connection con;
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
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
//    CrawlerDAO crdao=new CrawlerDAO();
    
    List dat;
    
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
	    FileOutputStream out = (new FileOutputStream(new java.io.File("abc.jpg")));
	    out.write(resultImageResponse.bodyAsBytes());
	    out.close();
	    System.out.println("Ingrese datos de usuario BOLETA/PASSWORD/CLAVE_CAPTCHA");
//	    System.out.println(cookies);
            Elements fields = doc.select("input");
	    HashMap<String,String> formFields = new HashMap<String, String>();
	    for (Element field : fields ){
	        formFields.put(field.attr("name"), field.attr("value"));
	    }
            setForm(formFields);
//            downloadCaptcha();
            mav.setViewName("LoginAlumno");
        }
        return mav;
    }
    @RequestMapping(value="LoginAlumno.html", method=RequestMethod.POST)
    public ModelAndView log(HttpServletRequest req, HttpServletResponse resp, Craw cw) throws Exception{
        
        String accion=req.getParameter("btn");
        if(accion.equalsIgnoreCase("Entrar")){
        String usuario=req.getParameter("User");
        String pass=req.getParameter("Password");
        String capt=req.getParameter("Captcha");
        System.out.println("Entra usuario" + usuario + pass+ capt);
        //String jefe= "DDyFD";
        if(capt==null || capt.equals(" ")){
            mav.setViewName("redirect:/LoginAlumno.html");
                    mav.addObject("mjs", "<div style='color: red;'>ERROR, usuario o contraseña invalido. null</div>"); 
        }else{
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
//                // validate the Captcha to check we're not dealing with a bot
//    Captcha captcha = Captcha.load(req, "basicExample");
//    boolean isHuman = captcha.validate(capt);
//    
//    if (isHuman) {
//        mav.setViewName("redirect:/LoginAlumno.html");
//        mav.addObject("mjs", "<div style='color: red;'>ES HUMANO</div>"); 
//    } else {
//     mav.setViewName("redirect:/LoginAlumno.html");
//        mav.addObject("mjs", "<div style='color: red;'>Que pedo?</div>"); 
//    }
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
	    //Map<String, String> datcookie = response.cookies();

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
	    
	    
	    Element f = docs.select("span#ctl00_mainCopy_Lbl_Mensaje").first();
	    String fail=f.text();
//	    System.out.println(f.text());
//	    String [] completo = nombre.split(" ");
//
//	    String name1 = completo[0];
//     	String name2 = completo[1];
//     	String appat = completo[2];
//     	String apmat = completo[3];
//     	
//
//     	String Names = name1.concat(" ").concat(name2);
//     	System.out.println("Apellido Paterno: "+appat);
//     	System.out.println("Apellido Materno: "+apmat);
//     	System.out.println("Nombres: " +Names);
	    

       
	    if(fail.isEmpty()) {
	    	//Aquí se escanea el comprobante del alumno que inició sesión
		    Element e = docs.select("table#ctl00_mainCopy_GV_Horario td").first();
		    String grupo=e.text();
		    System.out.println(nombre+" ESTÁS INSCRITO EN: " +grupo);
		    FileWriter datos = new FileWriter("alumno.txt");
		    PrintWriter pd= new PrintWriter(datos);
		    pd.println(nombre);
		    pd.close();
		    datos.close();
		    FileWriter grup = new FileWriter("grupo.txt");
		    PrintWriter pg= new PrintWriter(grup);
		    pg.println(grupo);
		    pg.close();
		    grup.close();
                    mav.setViewName("redirect:/LoginAlumno.html");
                    mav.addObject("mjs", "<div style='color: red;'>Login correcto,"+nombre+" estás inscrito</div>"); 
	    }else {
	    	FileWriter datos = new FileWriter("alumno.txt");
		    PrintWriter pd= new PrintWriter(datos);
		    pd.println(nombre);
		    pd.close();
		    datos.close();
		    FileWriter grup = new FileWriter("grupo.txt");
		    PrintWriter pg= new PrintWriter(grup);
		    pg.println(fail);
		    pg.close();
		    grup.close();
                    mav.setViewName("redirect:/LoginAlumno.html");
                    mav.addObject("mjs", "<div style='color: red;'>SORRY, no estás inscrito</div>"); 
		    System.out.println("LO SENTIMOS "+nombre+" NO ESTAS INSCRITO");
	    }

	        
	    FileWriter fr = new FileWriter("response.html");
	    PrintWriter pw= new PrintWriter(fr);
	    pw.println(docs.toString());
	    pw.close();
	    fr.close();
                }
        }
        }else{
            mav.setViewName("redirect:/LoginAlumno.html");
        }
        return mav;
    }
    
    @RequestMapping(value="Privacidad.html")
    ModelAndView term(){
        mav.setViewName("Condiciones");
        return mav;
    }
    
}