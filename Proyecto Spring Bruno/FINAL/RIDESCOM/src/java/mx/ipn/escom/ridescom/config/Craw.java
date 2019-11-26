package mx.ipn.escom.ridescom.config;


//import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
    public HashMap<String, String> form;

	private static String saes = "https://www.saes.escom.ipn.mx/";
	private static String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
	public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";

    public String regno;
        public String passwd;
        public String vrfcd;

        public Craw() {
    }

    public Craw(Map<String, String> cookies, HashMap<String, String> form, String regno, String passwd, String vrfcd) {
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
	//Mapea los campos que se solicitan, USUARIO, CONTRASEÑA y CAPTCHA, ademas de descargar el captcha.
	public void con() throws IOException {
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
	    FileOutputStream out = (new FileOutputStream(new java.io.File("../../../Users/spy51/Desktop/Ride/RIDESCOM/web/resources/img/abc.jpg")));
	    out.write(resultImageResponse.bodyAsBytes());
	    out.close();
//	    System.out.println(cookies);
            Elements fields = doc.select("input");
	    HashMap<String,String> formFields = new HashMap<String, String>();
	    for (Element field : fields ){
	        formFields.put(field.attr("name"), field.attr("value"));
	    }
            setForm(formFields);
	}
}
 