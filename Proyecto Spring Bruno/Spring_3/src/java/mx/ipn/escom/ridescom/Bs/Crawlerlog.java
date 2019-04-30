/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.Bs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Connection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service("Crawlerlog")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class Crawlerlog {
    public Map<String, String> cookies;
	 //private String regno = USUARIO; //my regno
	 //private String passwd = PASSWORD; //my pass
	public static String saes = "https://www.saes.escom.ipn.mx";
	public static String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
	public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";
	 
        String regno;
        String passwd;
        String vrfcd;
        
        
        
	//Mapea los campos que se solicitan, USUARIO, CONTRASEÑA y CAPTCHA, ademas de descargar el captcha.
	public String downloadCaptcha()throws Exception {
            Connection.Response response;
            
            Connection con = (Jsoup.connect(logi));
            con.method(Connection.Method.GET);
            Connection.Response res=con.execute();
            String a = res.parse().getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage").attr("src");
            if (a == null) {
        	    throw new RuntimeException("No se pudo encontrar captcha");
        	}
        	//Imprime src del captcha traido.
        	String ca = saes+a;
               

            return ca;
        }
        
	//Realiza lectura y envio de datos insertados al login
	public void getData(HashMap<String, String> formFields) throws Exception{
	    
		 
		Connection conn = Jsoup.connect(saes+"/Default.aspx?ReturnUrl=%2falumnos%2fdefault.aspx")
	            .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0")
	            .cookies(cookies)
	            .timeout(0)
	            .data(formFields)
	            //.data("LBD_VCID_c_default_ctl00_leftcolumn_loginuser_logincaptcha","id_captcha")
	            //.data("LBD_BackWorkaround_c_default_ctl00_leftcolumn_loginuser_logincaptcha", "1")
	            .data("ctl00$leftColumn$LoginUser$LoginButton","Iniciar")
	            .method(Connection.Method.POST);
          Connection.Response response = conn.execute();
	    cookies = response.cookies();
	    //response.cookies().get(logi);
	    //System.out.println(response.cookies());
	    //Document doc= response.parse();
	    
	    /*Elements e = doc.select("a.ctl00_mainmenu_1 item ctl00_mainmenu_3 selected ctl00_mainmenu_6");
	        System.out.println(e.attr("abs:href"));
	        System.out.println(e.text());
	        System.out.println();*/
	}

	//Corre la lectura de campos para logear
	public void run() throws Exception, IOException {
	    //HashMap<String, String> formFields = downloadCaptcha();
            HashMap<String,String> formFields = new HashMap<String, String>();

	    /*BufferedReader cr = new BufferedReader(new InputStreamReader(System.in));
	    BufferedReader dr = new BufferedReader(new InputStreamReader(System.in));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));*/
	    
	    //Parametros de entrada del Form LOGIN.JSP
	    
            
             this.regno = getRegno();
	     this.passwd = getPasswd(); 
	     this.vrfcd = getVrfcd();

	    formFields.put("ctl00$leftColumn$LoginUser$UserName", regno);
	    formFields.put("ctl00$leftColumn$LoginUser$Password", passwd);
	    formFields.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd);
	    
            
	    //System.out.println(formFields);
	    //getData(formFields);

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

	/*Checa el estado de conexion de la pagina principal del saes
	private static int getStatusConnectionCode(String saes) {
		Response response = null;
		
	    try {
	    	response = Jsoup.connect(saes).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
	    } catch (IOException ex) {
	    	System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
	    }
	    return response.statusCode();
	}*/
	
	//Checa el estado de conexion del usuario logeado
	/*public static int StatusConnectionCode(String user) {
		Response resp = null;
		
	    try {
	    	resp = Jsoup.connect(user).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
	    } catch (IOException ex) {
	    	System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
	    }
	    return resp.statusCode();
	}
	
	/*public static void main(String[] args) throws Exception {
	    
	    Crawlerlog main = new Crawlerlog();
	    
	    
	    int codigo = getStatusConnectionCode(logi);
	    int cod = StatusConnectionCode(user);
	    //int no = cod+1;
	    
	    if(codigo==200){
	    	main.run();
	    	/*if(cod==200){
	    	 * 	while(cod==200) {
	    			System.out.println("en sesion");
	    		
	    			if(cod!=200) {
	    				break;
	    			}
	    		}*
		}else {
			System.out.println("Valio");
		}
	   }*/
}
