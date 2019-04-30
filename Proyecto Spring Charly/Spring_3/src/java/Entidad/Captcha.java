/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Captcha {
     public static void main(String[] args) throws Exception {
	Connection conn = Jsoup.connect("https://www.saes.escom.ipn.mx/");
	Document d = conn.get();

	Element captcha = d.select("#c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage").first();
	if (captcha == null) {
	    throw new RuntimeException("Unable to find captcha...");
	}

	// Fetch the captcha image
	Connection.Response response = Jsoup //
	        .connect(captcha.absUrl("src")) // Extract image absolute URL
	        .cookies(conn.response().cookies()) // Grab cookies
	        .ignoreContentType(true) // Needed for fetching image
	        .execute();

     FileOutputStream out = (new FileOutputStream(new java.io.File("img\\cap.jpg")));
     out.write(response.bodyAsBytes()); 
     out.close();
	
	// Load image from Jsoup response
	ImageIcon image = new ImageIcon(ImageIO.read(new ByteArrayInputStream(response.bodyAsBytes())));

	// Show image
	//JOptionPane.showMessageDialog(null, image, "Captcha image", JOptionPane.PLAIN_MESSAGE);	

    	Connection con = (Jsoup.connect("https://www.saes.escom.ipn.mx/default.aspx"));
    	con.method(Connection.Method.GET);
    	Connection.Response res=con.execute();
    	//res.statusCode();
    	//if(res.contentType()) {}
    	String a = res.parse().getElementById("c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage").attr("src");
    	if (a == null) {
    	    throw new RuntimeException("No se pudo encontrar captcha");
    	}
    	//Imprime src del captcha traido.
    	String ca = "https://www.saes.escom.ipn.mx" +a;
    	System.out.println(ca); 
	} 
}
