///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package mx.ipn.escom.ridescom.config;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
///**
// *
// * @author spy51
// */
//public class Crawp {
//    Craw crw=new Craw();
//    
//    private static String saes = "https://www.saes.escom.ipn.mx/";
//    private static String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
//    public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";
//    
//    public HashMap<String,String> form()throws IOException{
//            Elements fields = crw.d().select("input");
//	    HashMap<String,String> formFields =new HashMap<>();
////            formFields.put("ctl00$leftColumn$LoginUser$UserName", regno);
////	    formFields.put("ctl00$leftColumn$LoginUser$Password", passwd);
////	    formFields.put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd);
//	    for (Element field : fields ){
//	        formFields.put(field.attr("name"), field.attr("value"));
//	    }
//            return formFields;
//        }
//        
//        public HashMap<String, String> log(String regno, String passwd, String vrfcd)throws IOException{
//        //HashMap<String,String> formFields = form();
//	    form().put("ctl00$leftColumn$LoginUser$UserName", regno);
//	    form().put("ctl00$leftColumn$LoginUser$Password", passwd);
//	    form().put("ctl00$leftColumn$LoginUser$CaptchaCodeTextBox", vrfcd);
////            this.regno=regno;
////            this.passwd=passwd;
////            this.vrfcd=vrfcd;
//            return form();
//        }
//        
//        public Connection postear()throws Exception{
//            
//            Connection conn = Jsoup.connect(saes+"/Default.aspx?ReturnUrl=%2falumnos%2fdefault.aspx")
//	            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
//	            .cookies(crw.cookie())
//	            .timeout(0)
//	            .data(form())//Aquí debe de ir los parametros insertados en log()
//	            .data("ctl00$leftColumn$LoginUser$LoginButton","Iniciar")
//	            .method(Connection.Method.POST);
//            return conn;
////            Connection.Response response = conn.execute();
////            response.cookies().get(logi);
//        }
//        public Connection.Response postthen() throws Exception{
//            Connection.Response response = postear().execute();
//            response.cookies().get(logi);
//            return response;
//        }
//        public Map<String, String> logincookie() throws Exception{
//            Map<String, String> loginCookies = postthen().cookies();
//            return loginCookies;
//        }
//        public Document dn()throws Exception{
//            Document docn = Jsoup.connect("https://www.saes.escom.ipn.mx/Alumnos/default.aspx")
//	          .cookies(logincookie())
//	          .get();
//            return docn;
//        }
//        public Document ds()throws Exception{
//            Document docs = Jsoup.connect("https://www.saes.escom.ipn.mx/Alumnos/Reinscripciones/Comprobante_Horario.aspx")
//		          .cookies(logincookie())
//		          .get();
//            return docs;
//        }
//        public String nombre() throws Exception{
//            Element n = dn().getElementById("ctl00_mainCopy_FormView1_nombrelabel");	    
//	    String nombre = n.text();
//            return nombre;
//        }
//        public String grupo() throws Exception{
//            Element e = ds().select("table#ctl00_mainCopy_GV_Horario td").first();
//            String grupo=e.text();
//                return grupo;
//        }
//}
