package mx.ipn.escom.ridescom.config;

import java.io.BufferedReader;

//import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
        public String capt() throws IOException{
         Element img = d().getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage");  	 
  	 String a = img.absUrl("src");
            return a;
        }
        public HashMap<String,String> form()throws IOException{
            Elements fields = d().select("input");
	    HashMap<String,String> formFields = new HashMap<String, String>();
	    for (Element field : fields ){
	        formFields.put(field.attr("name"), field.attr("value"));
	    }
            return formFields;
        }
        public void log(String regno, String passwd, String vrfcd)throws IOException{
  
	    form().put("ctl00$leftColumn$LoginUser$UserName", regno);
	    form().put("ctl00$leftColumn$LoginUser$Password", passwd);
	    form().put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd);
	    
        }
        public Response postear()throws IOException{
            Connection conn = Jsoup.connect(saes+"/Default.aspx?ReturnUrl=%2falumnos%2fdefault.aspx")
	            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
	            .cookies(cookie())
	            .timeout(0)
	            .data(form())
	            .data("ctl00$leftColumn$LoginUser$LoginButton","Iniciar")
	            .method(Connection.Method.POST);
            Connection.Response response = conn.execute();
            response.cookies().get(logi);
            return response;
        }
        public Map<String, String> logincookie() throws IOException{
            Map<String, String> loginCookies = postear().cookies();
            return loginCookies;
        }
        public Document dn()throws IOException{
            Document docn = Jsoup.connect("https://www.saes.escom.ipn.mx/Alumnos/default.aspx")
	          .cookies(logincookie())
	          .get();
            return docn;
        }
        public Document ds()throws IOException{
            Document docs = Jsoup.connect("https://www.saes.escom.ipn.mx/Alumnos/Reinscripciones/Comprobante_Horario.aspx")
		          .cookies(logincookie())
		          .get();
            return docs;
        }
        public String nombre() throws IOException{
            Element n = dn().getElementById("ctl00_mainCopy_FormView1_nombrelabel");	    
	    String nombre = n.text();
            return nombre;
        }
        public String grupo() throws IOException{
            Element e = ds().select("table#ctl00_mainCopy_GV_Horario td").first();
            String grupo=e.text();
            return grupo;
        }
}
