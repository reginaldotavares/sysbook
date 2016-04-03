<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <body>

        <div class="row-fluid">
            <div class="offset3 span6 offset3 tentando">
                <table class="table  table-hover">

                    <thead>
                        <tr>
                            <th>Imagem</th>
                            <th>Nome completo</th>               
                            <th>Apelido</th>
                            <th>Email</th> 
                            <th>Cidade</th>
                            <th>Estado</th>
                            <th>Data de Nascimento</th>
                            <th>Tipo</th>
                                                        

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="user">
                            <tr>
                                <td><img src="<c:out value="${user.foto}" />" width="100" height="100"></td> 
                                <td><c:out value="${user.nome}" /></td>
                                <td><c:out value="${user.apelido}"/></td>                         
                                <td><c:out value="${user.email}" /></td>
                                <td><c:out value="${user.cidade}" /></td> 
                                <td><c:out value="${user.estado}" /></td>  
                                <td><c:out value="${user.dataNascimento}" /></td>
                                <c:if test="${user.tipo==true}">
                                    <td>Admin</td>
                                </c:if>
                                <c:if test="${user.tipo==false}">
                                    <td>Básico <a href="TornarAdmin?<c:out value="${user.email}"/>" title="Tornar Admin"><span class="glyphicon glyphicon-cog"</a></td>
                                </c:if>
                                
                            </tr>               
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
