<%-- 
    Document   : PDF
    Created on : 1/10/2019, 10:16:09 PM
    Author     : spy51
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>

<%@page import="javax.servlet.ServletResponse"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@include file="conjas.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cedula</title>
    </head>
    <body>
        <%
            File reportfile =new File(application.getRealPath("Cedula.jasper"));
            Map<String, Object> parametro = new HashMap<String, Object>();
            byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parametro, con);
            
            response.setContentType("application/PDF");
            response.setContentLength(bytes.length);
            ServletOutputStream outputstream = response.getOutputStream();
            outputstream.write(bytes, 0, bytes.length);
            
            outputstream.flush();
            outputstream.close();
        %>
    </body>
</html>
