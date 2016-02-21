<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag1"%>
<div class="container">
    <body class="templatemo-bg-image-1">
            <div class="col-md-12">			
                <form class="form-horizontal templatemo-login-form-2" role="form" action="Login" method="post">

                    <div class="row">
                        <div class="col-md-12">
                            <h1>Login</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="templatemo-one-signin col-md-6">
                            <div class="form-group">
                                <div class="col-md-12">		          	
                                    <label for="username" class="control-label">E-mail</label>
                                    <div class="templatemo-input-icon-container">
                                        <i class="fa fa-user"></i>
                                        <input name="email" type = "email"  class="form-control" id="email" placeholder = "e-mail" required>
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
                                    <input type="submit" value="LOG IN" class="btn btn-warning">
                                </div>
                            </div>

                        </div>
                        <div class="templatemo-other-signin col-md-6">
                            <label class="margin-bottom-15">
                                Se você não tem um cadastro, com um click você pode fazer o seu! <a rel="nofollow" href="cadastrar.jsp">SisLivros</a>. 

                            </label>
                            <a class="btn btn-block btn-social btn-facebook margin-bottom-15">
                                <i class="fa fa-facebook"></i> Entrar com Facebook
                            </a>
                            <a class="btn btn-block btn-social btn-twitter margin-bottom-15">
                                <i class="fa fa-twitter"></i> Entrar com Twitter
                            </a>
                            <a class="btn btn-block btn-social btn-google-plus">
                                <i class="fa fa-google-plus"></i> Entrar com Google
                            </a>
                        </div>   
                    </div>
                    <div class="row">

                        <div class="col-md-12">
                            <div class="mensagem">
                                <h1>
                                    <tag1:statusUsuarioSenha/>
                                </h1>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <a href="index.jsp">Sair</a>
                                </label>
                            </div>
                        </div>

                    </div>
                </form>	

            </div>
        </div>
