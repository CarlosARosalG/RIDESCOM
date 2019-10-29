package mx.ipn.escom.ridescom.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

//import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.*;
import javax.print.DocFlavor;
import mx.ipn.escom.ridescom.model.Crawler;
import org.jsoup.Connection;
//import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//import crawler.webcrawler;

public class Craw {
//    String usuario;
//    String pass;
//    String vrfcd;
//
//    public Craw() {
//    }
//
//    public Craw(String usuario, String pass, String vrfcd) {
//        this.usuario = usuario;
//        this.pass = pass;
//        this.vrfcd = vrfcd;
//    }
//
//    public String getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(String usuario) {
//        this.usuario = usuario;
//    }
//
//    public String getPass() {
//        return pass;
//    }
//
//    public void setPass(String pass) {
//        this.pass = pass;
//    }
//
//    public String getVrfcd() {
//        return vrfcd;
//    }
//
//    public void setVrfcd(String vrfcd) {
//        this.vrfcd = vrfcd;
//    }
    
    public Map<String, String> cookies;

	private static String saes = "https://www.saes.escom.ipn.mx/";
	private static String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
	public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";
        
        
	//Mapea los campos que se solicitan, USUARIO, CONTRASEÃ‘A y CAPTCHA, ademas de descargar el captcha.
	public Document downloadCaptcha()throws Exception {
	    
		Connection con = (Jsoup.connect(logi));
		con.method(Connection.Method.GET).timeout(30000).execute();
		Connection.Response res=con.execute();
		cookies = res.cookies();
		cookies.putAll(res.cookies());
	
   	Document doc = con.get();

   	Element img = doc.getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage");  	 
  	 String a = img.absUrl("src");

//	    Elements fields = doc.select("input");
//	    HashMap<String,String> formFields = new HashMap<String, String>();
//	    for (Element field : fields ){
//	        formFields.put(field.attr("name"), field.attr("value"));
//	    }
////            String regno = usuario;
////	    String passwd = pass; 
////	    String vrfcd = capt;
//
//            Scanner s=new Scanner(System.in);
//	    vrfcd = s.nextLine();
//	    formFields.put("ctl00$leftColumn$LoginUser$UserName", usuario);
//	    formFields.put("ctl00$leftColumn$LoginUser$Password", pass);
//	    formFields.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd);

   //Descarga la imagen obtenida de la URL del CAPTCHA.
   	Connection.Response resultImageResponse = Jsoup.connect(a)
	            .cookies(cookies)
	            .ignoreContentType(true)
	            .method(Connection.Method.GET).timeout(30000).execute();

	//Crea la imagen del captcha y la guarda.
	    FileOutputStream out = (new FileOutputStream(new java.io.File("../../../Users/spy51/Desktop/Ride/RIDESCOM/web/resources/img/abc.jpg")));
	    out.write(resultImageResponse.bodyAsBytes());
	    out.close();
	    System.out.println("Ingrese datos de usuario BOLETA/PASSWORD/CLAVE_CAPTCHA");
	    System.out.println(res.contentType());
	    return doc;
	}
	
	public HashMap<String, String> parametros(String usuario, String pass, String vrfcd) throws Exception{
            Elements fields = downloadCaptcha().select("input");
	    HashMap<String,String> formFields = new HashMap<String, String>();
	    for (Element field : fields ){
	        formFields.put(field.attr("name"), field.attr("value"));
	    }
//            String regno = usuario;
//	    String passwd = pass; 
//	    String vrfcd = capt;

//            Scanner s=new Scanner(System.in);
//	    vrfcd = s.nextLine();
	    formFields.put("ctl00$leftColumn$LoginUser$UserName", usuario);
	    formFields.put("ctl00$leftColumn$LoginUser$Password", pass);
	    formFields.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd);
            return formFields;
        }

	//Realiza lectura y envio de datos insertados al login
	public void getData(String regno, String passwd, String captcha) throws Exception{
            HashMap<String, String> formFields = parametros(regno, passwd, captcha);
//            String regno = usuario;
//	    String passwd = pass; 
////	    String vrfcd = capt;
//
//            Scanner s=new Scanner(System.in);
//	    String vrfcd = s.nextLine();
//	    formFields.put("ctl00$leftColumn$LoginUser$UserName", regno);
//	    formFields.put("ctl00$leftColumn$LoginUser$Password", passwd);
//	    formFields.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd);
		Connection conn = Jsoup.connect(saes+"/Default.aspx?ReturnUrl=%2falumnos%2fdefault.aspx")
	            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
	            .cookies(cookies)
	            .timeout(0)
	            .data(formFields)
	            .data("ctl00$leftColumn$LoginUser$LoginButton","Iniciar")
	            .method(Connection.Method.POST);

	    Connection.Response response = conn.execute();
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

	    
	    //AquÃ­ se escanea el nombre del alumno que iniciÃ³ sesiÃ³n
	    Element n = docn.getElementById("ctl00_mainCopy_FormView1_nombrelabel");
	    String nombre = n.text();
            
            Element f = docs.select("span#ctl00_mainCopy_Lbl_Mensaje").first();
	    String fail=f.text();

       
	    if(fail.isEmpty()) {
	    	//Aquí se escanea el comprobante del alumno que inició sesión
		    Element e = docs.select("table#ctl00_mainCopy_GV_Horario td").first();
		    String grupo=e.text();
		    System.out.println(nombre+" ESTÁS INSCRITO EN: " +grupo);
	    	
	    }else {
		    System.out.println("LO SENTIMOS "+nombre+" NO ESTAS INSCRITO");
	    }
	}
}
 