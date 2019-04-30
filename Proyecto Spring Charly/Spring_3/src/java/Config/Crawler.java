/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.io.IOException;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;



public class Crawler {
    public static String saes = "https://www.saes.escom.ipn.mx";
    private static Connection.Response response;
    public Map<String, String> cookies;
    
    private String regno;
    private String passwd;
    private String vrfcd;
    
    public String craw() throws IOException{
        
        Connection con = (Jsoup.connect(saes));
    	con.method(Connection.Method.GET);
        con.get();
    	Connection.Response res=con.execute();
    	
    	String a = res.parse().getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage").attr("src");
    	if (a == null) {
    	    throw new RuntimeException("No se pudo encontrar captcha");
    	}
    	//Imprime src del captcha traido.
    	String ca = saes+a;
        return ca;
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
    
    public void getData(String regno, String passwd, String vrfcd) throws IOException{

                String di="principal.htm";
                String ini="iniciosesion.htm";
                
		Connection conn = Jsoup.connect(saes+"/Default.aspx?ReturnUrl=%2falumnos%2fdefault.aspx")
	            .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0")
	            .cookies(cookies)
	            .timeout(0)
	            .data("ctl00$leftColumn$LoginUser$UserName", regno)
                    .data("ctl00$leftColumn$LoginUser$Password", passwd)
                    .data("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd)
                    .data("ctl00$leftColumn$LoginUser$LoginButton","Iniciar")
	            .method(Connection.Method.POST);
                    conn.execute();
                /*if(regno!= null ){
                    if(passwd != null){
                        if(vrfcd!=null){
                            conn.execute();
                            return di;
                        }else{
                            return ini;
                        }
                    }else{
                            return ini;
                        }
                    
                }else{
                            return ini;
                        }*/
                
    }
    
    public static int getStatusConnectionCode(String saes) {
		//Response response = null;
		
	    try {
	    	response = Jsoup.connect(saes).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
	    } catch (IOException ex) {
	    	System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
	    }
	    return response.statusCode();
	}
    
    public static void status() throws Exception{
	    
	    int codigo = getStatusConnectionCode(saes+"/Alumnos/default.aspx");
	    if(codigo==200){
	    	while(codigo==200) {
	    		System.out.println("en sesion");
	    	}
		}else {
			System.out.println("Valio");
		}
    }
}