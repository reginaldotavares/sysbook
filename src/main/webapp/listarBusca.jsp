<%-- 
    Document   : listarBusca
    Created on : 03/03/2016, 12:13:50
    Author     : jederson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <body>

        <div class="row-fluid test">
            
            <div class="offset3 span6 offset3 tentando">
                <table class="table  table-hover">

                    <thead>
                        
                            <th>Imagem</th>
                            <th>Nome completo</th>               
                            <th>Apelido</th>
                            <th>Email</th> 
                            <th>Cidade</th>
                            <th>Estado</th>

                        
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="user">
                            <tr>
                                <td><img src="<c:out value="${user.foto}" />" width="50" height="50"></td> 
                                <td><c:out value="${user.nome}" /></td>
                                <td><c:out value="${user.apelido}"/></td>                         
                                <td><c:out value="${user.email}" /></td>
                                <td><c:out value="${user.cidade}" /></td> 
                                <td><c:out value="${user.estado}" /></td>  

                            </tr>               
                        </c:forEach>
                    </tbody>
                </table>                
            </div>
        </div>

