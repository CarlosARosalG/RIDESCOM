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
    public Map<String, String> cookies;

	private static String saes = "https://www.saes.escom.ipn.mx/";
	private static String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
	public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";

	//Mapea los campos que se solicitan, USUARIO, CONTRASEÑA y CAPTCHA, ademas de descargar el captcha.
	public HashMap<String,String> downloadCaptcha()throws Exception {
	    
		Connection con = (Jsoup.connect(logi));
		con.method(Connection.Method.GET).timeout(30000).execute();
		Connection.Response res=con.execute();
		cookies = res.cookies();
		cookies.putAll(res.cookies());
	
   	Document doc = con.get();

   	Element img = doc.getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage");  	 
  	 String a = img.absUrl("src");
   	
   	//Extraer script html del captcha
   	Elements sc = doc.select("div[id=c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImageDiv]");
   	String as = sc.outerHtml();

	    Elements fields = doc.select("input");
	    HashMap<String,String> formFields = new HashMap<String, String>();
	    for (Element field : fields ){
	        formFields.put(field.attr("name"), field.attr("value"));
	    }

   //Descarga la imagen obtenida de la URL del CAPTCHA.
   	Connection.Response resultImageResponse = Jsoup.connect(a)
	            .cookies(cookies)
	            .ignoreContentType(true)
	            .method(Connection.Method.GET).timeout(30000).execute();

	//Crea la imagen del captcha y la guarda.
	    FileOutputStream out = (new FileOutputStream(new java.io.File("abc.jpg")));
	    out.write(resultImageResponse.bodyAsBytes());
	    out.close();
	    System.out.println("Ingrese datos de usuario BOLETA/PASSWORD/CLAVE_CAPTCHA");
	    System.out.println(res.contentType());
	    return formFields;
	}
	
	

	//Realiza lectura y envio de datos insertados al login
	public void getData(String usuario, String pass, String capt) throws Exception{
            HashMap<String, String> formFields = downloadCaptcha();
            String regno = usuario;
	    String passwd = pass; 
//	    String vrfcd = capt;

            Scanner s=new Scanner(System.in);
	    String vrfcd = s.nextLine();
	    formFields.put("ctl00$leftColumn$LoginUser$UserName", regno);
	    formFields.put("ctl00$leftColumn$LoginUser$Password", passwd);
	    formFields.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd);
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

	    
	    //Aquí se escanea el nombre del alumno que inició sesión
	    Element n = docn.getElementById("ctl00_mainCopy_FormView1_nombrelabel");
	    
	    String nombre = n.text();


       //Aquí se escanea el comprobante del alumno que inició sesión
	    Element e = docs.select("table#ctl00_mainCopy_GV_Horario td").first();
	    String grupo=e.text();
	    if(grupo.isEmpty()) {
	    	String noin="LO SENTIMOS NO ESTÁS INSCRITO";
	    	System.out.println(noin);
	    }else {
	    	System.out.println("ERES: " +nombre);
	        System.out.println("ESTÁS INSCRITO EN: " +e.text());
	    }
	}

	//Corre la lectura de campos para logear
//	private void run(String user, String pass, String capt) throws Exception, IOException {
//	    HashMap<String, String> formFields = downloadCaptcha();
//
//	    BufferedReader cr = new BufferedReader(new InputStreamReader(System.in));
//	    BufferedReader dr = new BufferedReader(new InputStreamReader(System.in));
//	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//	    //Parametros de entrada del Form LOGIN.JSP
//	    String regno = user;
//	    String passwd = pass; 
//	    String vrfcd = capt;
//
//	    formFields.put("ctl00$leftColumn$LoginUser$UserName", regno);
//	    formFields.put("ctl00$leftColumn$LoginUser$Password", passwd);
//	    formFields.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd);
//
//	    //System.out.println(formFields);
//	    getData(formFields);
//	}



//	public static void main(String[] args) throws Exception {
//
//	    Craw main = new Craw();
//	    	main.run();
//	   }
}
 