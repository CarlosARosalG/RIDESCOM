/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.config;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author spy51
 */
public class imagen {
    
    public void main() throws FileNotFoundException, IOException{
        Craw craw=new Craw();
            FileOutputStream out = new FileOutputStream(new java.io.File("abc.jpg"));
            out.write(craw.im().bodyAsBytes());
            out.close();
    }
}
