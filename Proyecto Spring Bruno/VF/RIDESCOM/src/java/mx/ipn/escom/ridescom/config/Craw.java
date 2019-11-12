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

    public Craw() {
        
    }
        
        public Connection c() throws IOException {
		Connection con = (Jsoup.connect(logi));
		con.method(Connection.Method.GET).timeout(30000).execute();
		return con;
	}
	public Response r() throws IOException {
		Connection con=c();
		Connection.Response res=con.execute();
		cookies = res.cookies();
		cookies.putAll(res.cookies());
		return res;
	}
//	public Map<String,String> coo() throws IOException{
//		Response res=r();
//		cookies = res.cookies();
//		cookies.putAll(res.cookies());
//		return cookies;
//	}
	
	public Document d() throws IOException {
		Response res=r();
		Document doc = res.parse();
		return doc;
	}
	public HashMap<String, String> ca() throws IOException {
		Document doc=d();
		Element img = doc.getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage");  	 
	  	 String a = img.absUrl("src");
//	  	 cookies=r().cookies();
		Connection.Response resultImageResponse = Jsoup.connect(a)
	            .cookies(cookies)
	            .ignoreContentType(true)
	            .method(Connection.Method.GET).timeout(30000).execute();
		System.out.println(cookies);
		FileOutputStream out = (new FileOutputStream(new java.io.File("abc.jpg")));
	    out.write(resultImageResponse.bodyAsBytes());
	    out.close();
	    System.out.println("Ingrese datos de usuario CLAVE_CAPTCHA");
	    System.out.println(cookies);
//		return out;
//	}
//	public HashMap<String, String> formf() throws IOException {
		Elements fields = doc.select("input");
	    HashMap<String,String> formFields = new HashMap<String, String>();
	    for (Element field : fields ){
	        formFields.put(field.attr("name"), field.attr("value"));
	    } 
	    System.out.println(formFields);
	    System.out.println(cookies);
	    return formFields;
	}
	public String regno;
	public String passwd;
	public String capt;

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

    public String getCapt() {
        return capt;
    }

    public void setCapt(String capt) {
        this.capt = capt;
    }

    public Craw(String regno, String passwd, String capt) {
        this.regno = regno;
        this.passwd = passwd;
        this.capt = capt;
    }

        
	public String vrfcd() throws Exception {
		
            Scanner s=new Scanner(System.in);
	    //Parametros de entrada del Form LOGIN.JSP
	    String cac = s.nextLine();
	    capt=cac;
	    return cac;
	}
        public void getData(String usu, String pass, String clave) throws Exception{
		HashMap<String, String> formFields = ca();
//	    Parametros de entrada del Form LOGIN.JSP
//	    String regno = "2015630297";
//	    String passwd = "Brunox04$"; 
//	    String vrfcd = s.nextLine();
//	    System.out.println(vrfcd);
	    formFields.put("ctl00$leftColumn$LoginUser$UserName", usu);
	    formFields.put("ctl00$leftColumn$LoginUser$Password", pass);
	    formFields.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", clave);
//	    cookies=r().cookies();
	    System.out.println(cookies);
		Connection conn = Jsoup.connect(saes+"/Default.aspx?ReturnUrl=%2falumnos%2fdefault.aspx")
	            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
	            .cookies(cookies)
	            .timeout(0)
	            .data(formFields)
	            .data("ctl00$leftColumn$LoginUser$LoginButton","Iniciar")
	            .method(Connection.Method.POST);
		
		System.out.println(cookies);
	    Connection.Response response = conn.execute();
	    response.cookies().get(logi);

	    //This will get you cookies
	    Map<String, String> loginCookies = response.cookies();
	    //Map<String, String> datcookie = response.cookies();
	    System.out.println(loginCookies);
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
		    System.out.println("LO SENTIMOS "+nombre+" NO ESTAS INSCRITO");
	    }

	        
	    FileWriter fr = new FileWriter("response.html");
	    PrintWriter pw= new PrintWriter(fr);
	    pw.println(docs.toString());
	    pw.close();
	    fr.close();
	}
}
 