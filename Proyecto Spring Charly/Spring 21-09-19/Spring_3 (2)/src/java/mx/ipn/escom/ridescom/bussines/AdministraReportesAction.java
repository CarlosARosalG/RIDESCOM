/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.bussines;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import util.ExcelExport;

//import com.becasipn.persistence.model.Beca;
//import com.becasipn.persistence.model.Periodo;



/**
 *
 * @author Carlos A. Rosales
 */
public class AdministraReportesAction {
    
    private InputStream excelStream;
    private String becas;
    
    public String descargar() {
        String ERROR = "Error";
        if (becas == null || "".equals(becas)){
//            addActionError(getText("admin.reporte.no.programa.beca"));
            String mensaje = "reporte sin datos";
            System.out.println(mensaje);
            return ERROR;
        }
        List<Object[]> datosReporte = getDaos().getAlumnoDao().reporteFundacion(periodoId, becas, origenRecursosId);
        if (datosReporte.isEmpty() || datosReporte == null) {
//            addActionError(getText("admin.reporte.sin.datos"));
            String mensaje1 = "reporte sin datos";
            return ERROR;
        }
        //Periodo
        Periodo periodo = getDaos().getPeriodoDao().findById(periodoId);
        //Beca
        String[] becaArreglo = becas.split(",");
        String programaBeca = "";
        for (int i = 0; i < becaArreglo.length; i++) {
            Beca beca = getDaos().getBecaDao().findById(new BigDecimal(becaArreglo[i]));
            programaBeca = programaBeca + beca.getClave() + (i+1 == becaArreglo.length ? "" : "-");
        }

        ExcelExport excelExport = new ExcelExport();
        String[] encabezado = new String[]{"CURP", "MATRÍCULA", "APELLIDO PATERNO", "APELLIDO MATERNO", "NOMBRE(S)", "NAC. (DÍA)", "NAC. (MES)", "NAC. (AÑO)", "GENERO"
                , "ESTADO CIVIL", "ESTADO / DOMICILIO", "DIR. (MUN o DEL)", "DIR. (COLONIA)", "DIR. (CALLE)", "DIR. (NUMERO INTERNO)", "DIR. (NUMERO EXTERNO)"
                , "C.P.", "TELÉFONO 1", "TELÉFONO 2", "CORREO ELECTRÓNICO 1", "CORREO ELECTRÓNICO 2", "EST. (INSTITUCIÓN)", "EST. (ESC/FAC/PROG)", "CARRERA", "NIVEL_EDUCATIVO"
                , "TIPO DE BECA", "NÚMERO DE SEMESTRE", "SEMESTRE Ó CUATRIMESTRE", "NÚMERO DE DURACIÓN DE ESTUDIOS", "DURACIÓN DE ESTUDIOS", "PROMEDIO ESCOLAR"
                , "ACTIVIDAD DEPORTIVA", "EVENTO", "CATEGORIA"};
        setContentDisposition("attachment; filename=\"ReporteFundacion" + periodo.getClave() + programaBeca +".xlsx\"");
        excelStream = excelExport.construyeExcel(encabezado, datosReporte);
        return "archivo";
    }
}
