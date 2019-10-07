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
    Crawler cr=new Crawler();
    public String regno;
    public String passwd;
    public String vrfcd;
    
    HashMap<String,String> formField;
	public static Map<String, String> cookies;

	private static final String saes = "https://www.saes.escom.ipn.mx/";
	private static final String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
	public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";
	
        public void sas(){
            if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
 
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI(saes);
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    Logger.getLogger(Craw.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        }
        
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
        
        public String capt() throws IOException, URISyntaxException{
            
         Element img = d().getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage");  	 
  	 String a = img.absUrl("src");
            return a;
        }
        public Response im() throws IOException, URISyntaxException{
            Connection.Response resultImageResponse = Jsoup.connect(capt())
	            .cookies(cookie())
	            .ignoreContentType(true)
	            .method(Connection.Method.GET).timeout(30000).execute();
            return resultImageResponse;
        }
        public void ima() throws FileNotFoundException, IOException, URISyntaxException{
        try ( //Crea la imagen del captcha y la guarda.
                FileOutputStream out = new FileOutputStream(new java.io.File("abc.jpg"))) {
            out.write(im().bodyAsBytes());
        }catch(Exception e){
        }
        }
        
        public HashMap<String,String> form()throws IOException{
            Elements fields = d().select("input");
	    HashMap<String,String> formFields =new HashMap<>();

	    for (Element field : fields ){
	        formFields.put(field.attr("name"), field.attr("value"));
	    }
            return formFields;
        }
        
        public HashMap<String, String> log(String regno, String passwd, String vrfcd)throws IOException{
        HashMap<String,String> formFields = form();
//            BufferedReader cr = new BufferedReader(new InputStreamReader(System.in));
//	    BufferedReader dr = new BufferedReader(new InputStreamReader(System.in));
//	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//            regno=cr.readLine();
//            passwd=dr.readLine();
            Scanner sc=new Scanner(vrfcd);
            vrfcd=sc.findInLine(vrfcd);
	    formFields.put("ctl00$leftColumn$LoginUser$UserName", regno);
	    formFields.put("ctl00$leftColumn$LoginUser$Password", passwd);
	    formFields.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd);
            return formFields;
        }
}
 