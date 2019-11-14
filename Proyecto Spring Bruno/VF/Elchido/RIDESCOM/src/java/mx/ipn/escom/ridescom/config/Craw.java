package mx.ipn.escom.ridescom.config;


//import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

	private static String saes = "https://www.saes.escom.ipn.mx/";
	private static String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
	public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";

	//Mapea los campos que se solicitan, USUARIO, CONTRASEÑA y CAPTCHA, ademas de descargar el captcha.
	public Connection con() throws IOException {
		Connection con = (Jsoup.connect(logi));
		con.method(Connection.Method.GET).timeout(30000).execute();
		return con;
	}
	public Response res() throws IOException {
		Connection.Response res=con().execute();
		return res;
	}
	public Elements downloadCaptcha()throws Exception {
		cookies = res().cookies();
		cookies.putAll(res().cookies());

//   	Document doc = con.get();
		Document doc=res().parse(); 
		
   	Element img = doc.getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage");  	 
  	 String a = img.absUrl("src");

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
//	    System.out.println(cookies);
            Elements fields = doc.select("input");
	    return fields;
	}
        public String regno;
        public String passwd;
        public String vrfcd;

    public Craw() {
    }

    public Craw(String regno, String passwd, String vrfcd) {
        this.regno = regno;
        this.passwd = passwd;
        this.vrfcd = vrfcd;
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
        
	public void forms(Elements fields)throws Exception {
	    HashMap<String,String> formFields = new HashMap<String, String>();
	    for (Element field : fields ){
	        formFields.put(field.attr("name"), field.attr("value"));
	    }
	    
	    formFields.put("ctl00$leftColumn$LoginUser$UserName",this.regno);
	    formFields.put("ctl00$leftColumn$LoginUser$Password", this.passwd);
	    formFields.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", this.vrfcd);
	    getData(formFields);
//		return formFields;
	}
//	public HashMap<String, String> algo() throws Exception{
//		HashMap<String,String> form=forms();
//	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
////	    //Parametros de entrada del Form LOGIN.JSP
//	    System.out.println("Boleta:");
//	    String regno = br.readLine();
//	    
//	    System.out.println("Contraseña:");
//	    String passwd = br.readLine();
//	    
//	    System.out.println("Clave Captcha:");
//	    String vrfcd = br.readLine();
//	    
//	    form.put("ctl00$leftColumn$LoginUser$UserName", regno);
//	    form.put("ctl00$leftColumn$LoginUser$Password", passwd);
//	    form.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd);
////		getData(form);
//		return form;
//	}

	//Realiza lectura y envio de datos insertados al login
	public void getData(HashMap<String, String> formFields) throws Exception{
//		HashMap<String, String> formFields = forms();
		System.out.println(formFields);
		Connection.Response conn = Jsoup.connect(saes+"/Default.aspx?ReturnUrl=%2falumnos%2fdefault.aspx")
	            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
	            .cookies(cookies)
	            .timeout(0)
	            .data(formFields)
//	            .data("ctl00$leftColumn$LoginUser$UserName", regno)
//	    	    .data("ctl00$leftColumn$LoginUser$Password", passwd)
//	    	    .data("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd)
//	            .data("ctl00$leftColumn$LoginUser$LoginButton","Iniciar")
	            .method(Connection.Method.POST).execute();
		
//		System.out.println(conn);
	    Connection.Response response = conn;
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
	    
	    
	    Element f = docs.select("span#ctl00_mainCopy_Lbl_Mensaje").first();
	    String fail=f.text();
//	    System.out.println(f.text());
//	    String [] completo = nombre.split(" ");
//
//	    String name1 = completo[0];
//     	String name2 = completo[1];
//     	String appat = completo[2];
//     	String apmat = completo[3];
//     	
//
//     	String Names = name1.concat(" ").concat(name2);
//     	System.out.println("Apellido Paterno: "+appat);
//     	System.out.println("Apellido Materno: "+apmat);
//     	System.out.println("Nombres: " +Names);
	    

       
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
 