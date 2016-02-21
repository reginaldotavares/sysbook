<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <body>

        <div class="row-fluid">
            <div class="offset3 span6 offset3 tentando">
                <table class="table  table-hover">

                    <thead>
                        <tr>
                            <th>Nome completo</th>               
                            <th>Apelido</th>
                            <th>Email</th> 
                            <th>Tipo</th>
                            <th>Cidade</th>
                            <th>Estado</th>
                            <th>Data de Nascimento</th>
                            <th>Imagem</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="user">
                            <tr>
                                <td><c:out value="${user.nome}" /></td>
                                <td><c:out value="${user.apelido}"/></td>                         
                                <td><c:out value="${user.email}" /></td>
                                <td><c:out value="${user.tipo}" /></td>
                                <td><c:out value="${user.cidade}" /></td> 
                                <td><c:out value="${user.estado}" /></td>  
                                <td><c:out value="${user.dataNascimento}" /></td>
                                <td><img src="<c:out value="${user.foto}" />" width="100" height="100"></td> 

                            </tr>               
                        </c:forEach>
                    </tbody>
                </table>

                <section>
                    <article>
                        <a href="index.jsp">Voltar</a>
                    </article>
                </section>
            </div>
