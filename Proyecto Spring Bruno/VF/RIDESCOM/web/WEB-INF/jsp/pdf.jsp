<%-- 
    Document   : pdf
    Created on : 2/10/2019, 03:04:45 AM
    Author     : spy51
--%>

<%@page import="mx.ipn.escom.ridescom.config.ConectaCedula"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page import="javax.servlet.ServletResponse"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%--<%@include file="conjas.jsp"%>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PDF</title>
    </head>
    <body>
        <%
            ConectaCedula cc=new ConectaCedula();
            File reportfile =new File(application.getRealPath("WEB-INF/jsp/Cedula.jasper"));
            Map<String, Object> parameter = new HashMap<String, Object>();
            
            String dat=request.getParameter("iddeporte");
            parameter.put("Deporte",dat);
            byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameter, cc.getConexion());
            
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputstream = response.getOutputStream();
            outputstream.write(bytes, 0, bytes.length);
            
            outputstream.flush();
            outputstream.close();
        %>
    </body>
</html>
