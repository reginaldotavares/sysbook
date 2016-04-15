<%-- 
    Document   : user
    Created on : 10/04/2016, 10:39:06
    Author     : jederson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
    <div class="container-fluid">
        <h1>${convidado.apelido}</h1>
        <img src="${convidado.foto}" alt="${convidado.apelido}" class="img-circle img-responsive" width="80" height="60">
    </div>
    <!--
    <nav class="navbar navbar-left">
        <div class="container-fluid ">    
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Descrição</a></li>
                    <c:if test="${convidado.id != sessionScope.usuario.id}">
                    <li><a href="#">Amizade</a></li>                    
                        <c:if test="${sessionScope.usuario.tipo == true}">
                        <li><a href="#admin">Admin</a></li> 
                        </c:if>        
                    </c:if>
            </ul>
        </div>
    </nav>    
    -->
    <div class="container">
        <div id="description">
            <h2>Descrição</h2>
            <fieldset>                
                <strong>Nome: ${convidado.nome}</strong><br>
                Data Nascimento:${convidado.dataNascimento}        
            </fieldset> 
            <fieldset>
                Cidade: ${convidado.cidade}
                <br>
                Estado: ${convidado.estado}
            </fieldset>          

        </div>
        <c:if test="${convidado.id != sessionScope.usuario.id}">
            <div id="amizade">
                <h2>Amizade</h2>
                <a href="#"><button type="button" class="btn btn-default">Enviar Solicitação de Amizade</button></a>
            </div>
        </c:if>
        <c:if test="${convidado.tipo == false}">
            <div id="adm">
                <h2>Permissões</h2>
                <a href="TornarAdmin?id=${convidado.id}"><button type="button" class="btn btn-default">Tornar Administrador</button></a>
            </div>
        </c:if>
    </div>