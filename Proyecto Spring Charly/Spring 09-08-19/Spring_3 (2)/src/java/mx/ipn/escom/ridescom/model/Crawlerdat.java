/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.model;

/**
 *
 * @author Carlos A. Rosales
 */
public class Crawlerdat {
    String regno;
    String passwd;
    String vrfcd;

    public Crawlerdat() {
    }

    public Crawlerdat(String regno, String passwd, String vrfcd) {
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
    
    
}
