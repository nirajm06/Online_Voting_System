<%-- 
    Document   : showimage
    Created on : 25 Oct, 2024, 10:27:31 PM
    Author     : ratho
--%>

<%@page import="db.DBConnecter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- showimage.jsp --%>
<%@ page import="java.sql.*, java.io.*" %>
<%
    String candidateName = request.getParameter("name");
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        con = DBConnecter.getConnection();  // Ensure DBConnecter has a getConnection() method
        stmt = con.createStatement();
        String query = "SELECT image FROM candidate1 WHERE name='" + candidateName + "'";
        rs = stmt.executeQuery(query);
        if (rs.next()) {
            byte[] imgData = rs.getBytes("image"); // Extract byte data of the image
            response.setContentType("image/jpeg");
            OutputStream o = response.getOutputStream();
            o.write(imgData);
            o.flush();
            o.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (con != null) con.close();
    }
%>

