<%-- 
    Document   : deletarUsuario
    Created on : 28/02/2016, 17:16:07
    Author     : jederson
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag1"%>
<div class="container">
    <body class="templatemo-bg-image-1">
            <div class="col-md-12">			
                <form class="form-horizontal templatemo-login-form-2" role="form" action="DeletarUsuario" method="post">

                    <div class="row">
                        <div class="col-md-12">
                            <h1>Excluir Perfil</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="templatemo-one-signin col-md-6">
                            <div class="form-group">
                                <div class="col-md-12">		          	
                                    <label for="username" class="control-label">E-mail</label>
                                    <div class="templatemo-input-icon-container">
                                        <i class="fa fa-user"></i>
                                        <input name="email" type = "email"  class="form-control" id="email" value="${sessionScope.usuario.email}" required readonly="true">
                                    </div>		            		            		            
                                </div>              
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <label for="password" class="control-label">Password</label>
                                    <div class="templatemo-input-icon-container">
                                        <i class="fa fa-lock"></i>

                                        <input name="password" type = "password" class = "form-control" id = "password" placeholder = "senha" required>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="submit" value="Continuar" class="btn btn-warning">
                                </div>
                            </div>

                        </div>
                        <div class="templatemo-other-signin col-md-6">
                            <label class="margin-bottom-15">
                                Prezado(a) ${sessionScope.usuario.apelido}, realmente deseja excluir seu perfil. Se sim confirme sua senha.
                            </label>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <a href="index.jsp"><input type="button" value="Cancelar" class="btn btn-danger"></a>
                                </div>
                            </div>
                            
                        </div>   
                    </div>
                    <div class="row">

                        <div class="col-md-12">
                            <div class="mensagem">
                                <h1>
                                    <tag1:statusUsuarioSenha/>
                                </h1>
                            </div>                            
                        </div>

                    </div>
                </form>	

            </div>
        </div>
