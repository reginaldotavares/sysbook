<%-- 
    Document   : header
    Created on : 14/01/2016, 11:13:24
    Author     : jederson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name=description content=""/>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="icon" href="images/book.ico" type="image/x-icon">
        <title>Sys Livros -  Sua rede social sobre livros</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/bootstrap-responsive.css"/>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-social.css" rel="stylesheet" type="text/css">	
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/style.css">
        <link href="css/estilo2.css" rel="stylesheet" type="text/css" />
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <script src="js/respond.min.js"></script>
        <script src="js/jquery.min_1.js"></script>
        <script src="js/responsiveslides.min.js"></script>
        <script src="js/javaScript.js"></script>
        <script  src="js/jquery.js"></script>
        <script  src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>                
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="index.jsp"><span class="glyphicon glyphicon-home"></span> Home</a>
                        </li>  
                        <c:if test="${sessionScope.usuario != null}">
                            <li>
                                <a  id="boasvindas" href="#">Olá , ${sessionScope.usuario.apelido} </a>
                            </li>
                        </c:if>  
                    </ul>
                    <ul class="nav navbar-nav navbar-right">                                         
                        <li>
                            <a href="#"><span class="glyphicon glyphicon-book"></span> Livros</a>
                        </li>

                        <c:if test="${sessionScope.usuario == null}">
                            <li>
                                <a href="cadastrar.jsp"><span class="glyphicon glyphicon-user"></span> Cadastrar</a>
                            </li>
                            <li>
                                <a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                            </li>
                        </c:if>

                            <c:if test="${sessionScope.usuario != null}">                                
                            <li>
                                <a href="#"><span class="glyphicon glyphicon-user"></span><span class="glyphicon glyphicon-user"></span>Amigos</a>
                            </li>
                            <li>
                                <a href="#"><span class="glyphicon glyphicon-globe"></span> Grupos</a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Perfil <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-flag"></span> Ver Solicitações de Amizade</a>
                                    </li>
                                    <li>
                                        <a href="updateUsuario.jsp"><span class="glyphicon glyphicon-cog"></span> Editar Perfil</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-remove"></span> Excluir Perfil</a>
                                    </li>
                                    <li>
                                        <a href="Logout"><span class="glyphicon glyphicon-log-out btn bg-danger"></span> Logout</a>
                                    </li>
                                </ul>
                            </li>
                        </c:if>
                        <li>
                            <form action="#" method="post" class="navbar-form pull-right">
                                <!--<input type="text" name="pesquisa" class="span3">-->
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search for...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="button"><span  class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                                    </span>
                                </div>
                                <!--                        <button type="submit" class="btn">Search<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>-->
                            </form>
                        </li>
                        <c:if test="${sessionScope.usuario.tipo == true}">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Administração <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li class="dropdown-header"><span class="glyphicon glyphicon-book"></span> Livro</li>
                                    <li>
                                        <a href="CadastrarLivros"><span class="glyphicon glyphicon-plus-sign"></span> Cadastrar</a>
                                    </li>
                                    <li class="dropdown-header"><span class="glyphicon glyphicon-user"></span> Usuário</li>
                                    <li>
                                        <a href="ListarUsuarios"><span class="glyphicon glyphicon-list"></span> Listar</a>
                                    </li>                                    
                                </ul>
                        </li>
                        </c:if>
                    </ul>



                </div>

            </div>
        </nav>
    </body>
</html>
