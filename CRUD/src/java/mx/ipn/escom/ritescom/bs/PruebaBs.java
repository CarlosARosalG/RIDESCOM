/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ritescom.bs;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author spy51
 */
@Service("pruebaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PruebaBs { //Aqui va Codigo Crawler
    public String pruba() throws FileNotFoundException, IOException{
        
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

     FileOutputStream out = (new FileOutputStream(new java.io.File("img/cap.jpg")));
     out.write(response.bodyAsBytes()); 
     out.close();
        
        return "prueba";
    }
}
