/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import mx.ipn.escom.ridescom.config.ConectaCedula;
import mx.ipn.escom.ridescom.model.Ced;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author spy51
 */
public class genera {
    Ced c=new Ced();
    private static final String path = "src\\java\\mx\\ipn\\escom\\ridescom\\cedula\\CedulaInscripcion.jasper";
    
    public Connection conc(){
        ConectaCedula con = new ConectaCedula();
            java.sql.Connection conn = con.getConexion();
        return conn;
    }
    public Map jas(){
        Map parametro = new HashMap();
        parametro.put("ACT_ID", c.getIddeporte()); //Reemplazar el 4 por el valor del input
        return parametro;
    }
    public JasperReport rep() throws JRException{
        JasperReport reporte = null;
        reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
        return reporte;
    }
    public JasperPrint prin() throws JRException{
        JasperPrint jprint = JasperFillManager.fillReport(rep(), jas(), conc());
        return jprint;
    }
    public void vie() throws JRException{
         JasperViewer view = new JasperViewer(prin(), false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
    }

}
