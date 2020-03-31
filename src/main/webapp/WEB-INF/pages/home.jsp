<%-- 
    Document   : home
    Created on : 17/02/2019, 05:52:38 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persona</title>
    </head>
    <body>
        <div style="text-align: center">
            <h1>Persona Lista</h1>
            <table style="border: 1">
                <th>Id</th>
                <th>Documento</th>
                <th>Nombre</th>
                <th>Apellido</th>    
                <th>Activo</th>    
                <th>Fecha</th>
                
                <c:forEach var="persona" items="${myListPersona}">
                    <tr>
                        <td>${persona.idPersona}</td>
                        <td>${persona.strNumeroDocumento}</td>
                        <td>${persona.strNombre}</td>
                        <td>${persona.strApellido}</td>
                        <td>${persona.bitActivo}</td>
                        <td>${persona.dtmFechaCreacion}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
