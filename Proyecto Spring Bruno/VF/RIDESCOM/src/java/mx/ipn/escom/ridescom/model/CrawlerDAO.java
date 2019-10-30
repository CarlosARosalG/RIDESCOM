/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


import java.io.PrintWriter;
import java.net.URISyntaxException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import mx.ipn.escom.ridescom.config.Craw;

import org.jsoup.Connection;
//import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author spy51
 */
public class CrawlerDAO {
    	Craw crw=new Craw();
	public static Map<String, String> cookies;

	private static String saes = "https://www.saes.escom.ipn.mx/";
	private static String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
	public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";
        
        public Connection conectar() throws IOException{
            Connection con = (Jsoup.connect(logi));
		con.method(Connection.Method.GET).timeout(30000).execute();
            return con;   
        }
        public Response res() throws IOException{
            Connection.Response res=conectar().execute();
            return res;
        }
        public Map<String, String> cookie() throws IOException{
            cookies = res().cookies();
            cookies.putAll(res().cookies());
            return cookies;
        }
        public Document d()throws IOException{
            Document doc = conectar().get();
            return doc;
        }
        
        public FileOutputStream ima() throws FileNotFoundException, IOException, URISyntaxException{
         Element img = d().getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage");  	 
  	 String a = img.absUrl("src");
        
            cookie();
            Connection.Response resultImageResponse = Jsoup.connect(a)
	            .cookies(cookie())
	            .ignoreContentType(true)
	            .method(Connection.Method.GET).timeout(30000).execute();
                FileOutputStream out = new FileOutputStream(new java.io.File("captcha.jpg"));
                out.write(resultImageResponse.bodyAsBytes());
                out.close();
                return out;
        }
	public  Crawler valida(String regno, String passwd, String vrfcd){
            Crawler cr=new Crawler();
            try{
                
//                Connection con = (Jsoup.connect(logi));
//		con.method(Connection.Method.GET).timeout(30000).get();
//		Connection.Response res=con.execute();
//		cookies = res.cookies();
//		cookies.putAll(res.cookies());
//	
//   	Document doc = res.parse();
//
//   	Element img = doc.getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage");  	 
//  	 String a = img.absUrl("src");
//   	
//   	//Extraer script html del captcha
//   	Elements sc = doc.select("div[id=c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImageDiv]");
//   	String as = sc.outerHtml();
//
	    Elements fields = d().select("input");
	    HashMap<String,String> formFields = new HashMap<>();
	    for (Element field : fields ){
	        formFields.put(field.attr("name"), field.attr("value"));
	    }

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
	    if(e!=null) {
	    String grupo=e.text();
	    if(grupo.isEmpty()) {
//	    	String noin="LO SENTIMOS NO ESTÁS INSCRITO";
//	    	System.out.println(noin);
	    }else {
                cr.setNombre(nombre);
                cr.setGrupo(grupo);
                cr.setUser(regno);
                cr.setPassword(passwd);
//                System.out.println("ERES: " +nombre);
//	        System.out.println("ESTÁS INSCRITO EN: " +e.text());
	    }}else {
	        System.out.println("nel");
	    }
            }catch(Exception ex){
            }
            return cr;
        }
}
