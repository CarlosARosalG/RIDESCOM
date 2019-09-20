/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.config;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//public class Crawler {
//	
//	public Map<String, String> cookies;
//	 //private String regno = USUARIO; //my regno
//	 //private String passwd = PASSWORD; //my pass
//	private static String saes = "https://www.saes.escom.ipn.mx";
//	private static String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
//	public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";
//	 
//	//Mapea los campos que se solicitan, USUARIO, CONTRASEÑA y CAPTCHA, ademas de descargar el captcha.
//            public String downloadCaptcha()throws Exception {
//	    
////		Connection.Response response = Jsoup.connect(logi)
////	            //.cookies(cookies)
////				.timeout(300000)
////	            .userAgent("Mozilla/5.0")
////	            .method(Connection.Method.GET).execute();
////		//cookies.putAll(response.cookies());
////	    cookies = response.cookies();
////	    Document doc = response.parse();
//		Connection con = (Jsoup.connect(logi));
//    	con.method(Connection.Method.GET).timeout(30000).execute();
//    	Connection.Response res=con.execute();
//    	cookies = res.cookies();
//    	cookies.putAll(res.cookies());
////    	Connection.Response conn = con;
//    	//String a = res.parse().getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage").attr("src");
//    	//if (a == null) {
//    	//    throw new RuntimeException("No se pudo encontrar captcha");
//    	//}
//    	//Imprime src del captcha traido.
//    	//String ca = "https://www.saes.escom.ipn.mx" +a;
//    	Document doc = con.get();
//
//    	 Element img = doc.getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage");
//
//    	 String a = img.absUrl("src");
//
//	    Elements fields = doc.select("input");
//	    HashMap<String,String> formFields = new HashMap<String, String>();
//	    for (Element field : fields ){
//	        formFields.put(field.attr("name"), field.attr("value"));
//	    }
//
////    	String a = doc.getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage").select("img").attr("src");
////    	if (a == null) {
////    	    throw new RuntimeException("No se pudo encontrar captcha");
////    	}
////    	String ca = saes+a;
//
//    //Descarga la imagen obtenida de la URL del CAPTCHA.
//    	Connection.Response resultImageResponse = Jsoup.connect(a)
//	            .cookies(cookies)
//	            .ignoreContentType(true)
//	            .method(Connection.Method.GET).timeout(30000).execute();
//	    cookies.putAll(resultImageResponse.cookies());
////	    Document doc1= resultImageResponse.parse();
////	    String cp = doc1.select("img").attr("src");
//
//
//	//Crea la imagen del captcha y la guarda.
//	    FileOutputStream out = (new FileOutputStream(new java.io.File("abc.jpg")));
//	    out.write(resultImageResponse.bodyAsBytes());
//	    out.close();
//
//	    //System.out.println("Captcha Fetched from: " +a);
//	    //System.out.println("Captcha Fetched from: " +cp);
//	    //System.out.println(formFields);	
//
//
//	    return a;
//	}
//
//            
//            
//        String regno;
//        String passwd;
//        String vrfcd;
//
//    public String getRegno() {
//        return regno;
//    }
//
//    public void setRegno(String regno) {
//        this.regno = regno;
//    }
//
//    public String getPasswd() {
//        return passwd;
//    }
//
//    public void setPasswd(String passwd) {
//        this.passwd = passwd;
//    }
//
//    public String getVrfcd() {
//        return vrfcd;
//    }
//
//    public void setVrfcd(String vrfcd) {
//        this.vrfcd = vrfcd;
//    }
//        
//        
//        
//	//Realiza lectura y envio de datos insertados al login
//	public void getData(HashMap<String, String> formFields) throws Exception{
//		Connection conn = Jsoup.connect(saes+"/Default.aspx?ReturnUrl=%2falumnos%2fdefault.aspx")
//	            .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0")
//	            .cookies(cookies)
//	            .timeout(0)
//	            .data(formFields)
//                    .data("ctl00$leftColumn$LoginUser$UserName", getRegno());
//                    .data("ctl00$leftColumn$LoginUser$Password", getPasswd());
//                    .data("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", getVrfcd());
//	            //.data("LBD_VCID_c_default_ctl00_leftcolumn_loginuser_logincaptcha","id_captcha")
//	            //.data("LBD_BackWorkaround_c_default_ctl00_leftcolumn_loginuser_logincaptcha", "1")
//	            .data("ctl00$leftColumn$LoginUser$LoginButton","Iniciar")
//	            .method(Connection.Method.POST);
//	    //Document d = Jsoup.connect("https://www.saes.escom.ipn.mx/Alumnos/default.aspx").userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0")
//	            //.cookies(con.cookies()).get();
//	    //System.out.println(d.body().text().toString());
//
//	    Connection.Response response = conn.execute();
//	    //cookies = response.cookies();
//	    response.cookies().get(logi);
//	    //System.out.println(response.cookies());
//	    //Document doc= response.parse();
//	    
//	    //System.out.print(doc);
//	    
//	    //This will get you cookies
//	    Map<String, String> loginCookies = response.cookies();
//	    Map<String, String> datcookie = response.cookies();
//
//	    //And this is the easiest way I've found to remain in session
//	    Document docn = Jsoup.connect("https://www.saes.escom.ipn.mx/Alumnos/default.aspx")
//	          .cookies(loginCookies)
//	          .get();
//	    
//	    Document docs = Jsoup.connect("https://www.saes.escom.ipn.mx/Alumnos/Reinscripciones/Comprobante_Horario.aspx")
//		          .cookies(loginCookies)
//		          .get();
//
//	    
////	    Document dats = Jsoup.connect("https://www.saes.escom.ipn.mx/Alumnos/info_alumnos/Default.aspx")
////        	.cookies(datcookie)
////        	.get();
//	    //System.out.println(docs);
//	    
//	    //Aquí se escanea el nombre del alumno y boleta que inició sesión
//	    Element n = docn.getElementById("ctl00_mainCopy_FormView1_nombrelabel");
//	    Element b = docn.getElementById("ctl00_leftColumn_LoginNameSession");
//	    
//	    System.out.println("# de Boleta: " +b.text());
//	    
//	    String nombre = n.text();
//	    
//	    String [] completo = nombre.split(" ");
//
//	    if(completo.length== 5) {
//	    	String name1 = completo[0];
//	    	String name2 = completo[1];
//	    	String name3 = completo[2];
//	    	String appat = completo[3];
//	    	String apmat = completo[4];
//	    	
//	    	String names = name1.concat(" ").concat(name2).concat(" ").concat(name3);
//	    	
//	    	System.out.println("Apellido Paterno: "+appat);
//	        System.out.println("Apellido Materno: "+apmat);
//	        System.out.println("Nombres: " +names);
//	    }else if(completo.length==4) {
//	    	String name1 = completo[0];
//	    	String name2 = completo[1];
//	    	String appat = completo[2];
//	    	String apmat = completo[3];
//	    	
//	    	String names = name1.concat(" ").concat(name2);
//	    	
//	    	System.out.println("Apellido Paterno: "+appat);
//	        System.out.println("Apellido Materno: "+apmat);
//	        System.out.println("Nombres: " +names);
//	    }else {
//	    	for(int i=0; i<completo.length; i++) {
//	        	System.out.println(completo[i]);
//	        }
//	    }
//	    
//
//        //Aquí se escanea el comprobante del alumno que inició sesión
//	    Element e = docs.select("table#ctl00_mainCopy_GV_Horario td").first();
//	        System.out.println("Grupo inscrito: " +e.text());
////	        System.out.println();
//
//	        
//	    FileWriter fr = new FileWriter("principal.html");
//	    PrintWriter pw= new PrintWriter(fr);
//	    pw.println(docs.toString());
//	    //System.out.println(dats.toString());
//	    pw.close();
//	    fr.close();
//	}
//
//	//Corre la lectura de campos para logear
//	private void run() throws Exception, IOException {
//	    //HashMap<String, String> formFields = downloadCaptcha();
//
////	    BufferedReader cr = new BufferedReader(new InputStreamReader(System.in));
////	    BufferedReader dr = new BufferedReader(new InputStreamReader(System.in));
////	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////
////	    //Parametros de entrada del Form LOGIN.JSP
////	    String regno = cr.readLine();
////	    String passwd = dr.readLine(); 
////	    String vrfcd = br.readLine();
////
////	    formFields.put("ctl00$leftColumn$LoginUser$UserName", regno);
////	    formFields.put("ctl00$leftColumn$LoginUser$Password", passwd);
////	    formFields.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd);
////
////	    //System.out.println(formFields);
////	    getData(formFields);
//
//	}
//
//	//Checa el estado de conexion de la pagina principal del saes
//	private static int getStatusConnectionCode(String saes) {
//		Response response = null;
//
//	    try {
//	    	response = Jsoup.connect(saes).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
//	    } catch (IOException ex) {
//	    	System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
//	    }
//	    return response.statusCode();
//	}
//
//	//Checa el estado de conexion del usuario logeado
//	public static int StatusConnectionCode(String user) {
//		Response resp = null;
//
//	    try {
//	    	resp = Jsoup.connect(user).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
//	    } catch (IOException ex) {
//	    	System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
//	    }
//	    return resp.statusCode();
//	}
//        
//        
//
////	public static void main(String[] args) throws Exception {
////
////	    Crawler main = new Crawler();
////
////
////	    int codigo = getStatusConnectionCode(logi);
////	    int cod = StatusConnectionCode(user);
////	    int no = cod+1;
////
////	    if(codigo==200){
////	    	main.run();
////	    	/*if(cod==200){
////	    	  	while(cod==200) {
////	    			System.out.println("en sesion");
////
////	    			if(cod!=200) {
////	    				break;
////	    			}
////	    		}*/
////		}else {
////			System.out.println("Valio");
////		}
////	   }
//
//}
