<%-- 
    Document   : pesquisaUsuario
    Created on : 02/03/2016, 19:52:42
    Author     : jederson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <body>

        <div class="row-fluid">
            <div class="offset3 span6 offset3 tentando">
                <table class="table  table-hover" style="border-style: hidden;">

                    <thead>
                        <tr>
                            <th>Imagem</th>
                            <th>Nome completo</th>               
                            <th>Apelido</th>
                            <th>Email</th>                             
                            <th>Cidade</th>
                            <th>Estado</th>
                            <th>Data de Nascimento</th>                                                   

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="user">
                            <tr>
                                <td><img src="<c:out value="${user.foto}" />" width="100" height="100"></td> 
                                <td><c:out value="${user.nome}" /></td>
                                <td><c:out value="${user.apelido}"/></td>                         
                                <td><c:out value="${user.email}" /></td>
                                <td><c:out value="${user.tipo}" /></td>
                                <td><c:out value="${user.cidade}" /></td> 
                                <td><c:out value="${user.estado}" /></td>  
                                <td><c:out value="${user.dataNascimento}" /></td>       
                            </tr>               
                        </c:forEach>
                    </tbody>
                </table>                
            </div>
        </div>
        
