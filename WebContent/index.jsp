<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
   
    <title>Projeto - Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="css/Style Cadastro.css">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="js/Cadastro.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">Registrar</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" method="post" action="controller.do" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="login" id="username" tabindex="1" class="form-control" placeholder="Login Usuario" value="">
									</div>
									<div class="form-group">
										<input type="password" name="senha" id="password" tabindex="2" class="form-control" placeholder="Senha">
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Lembrar-me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<button type="submit" tabindex="4" class="form-control btn btn-login" name="command" value="LoginUsuario"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>Login</button>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="http://phpoll.com/recover" tabindex="5" class="forgot-password">Esqueceu a senha?</a>
												</div>
											</div>
										</div>
									</div>
								</form>
								<form id="register-form" action="controller.do" method="post" role="form" style="display: none;">
									<div class="form-group">
										<input type="text" name="nome" id="nome" tabindex="1" class="form-control" placeholder="Nome" value="">
									</div>
									<div class="form-group">
										<input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email " value="">
									</div>
									<div class="form-group">
										<input type="text" name="login" id="login" tabindex="1" class="form-control" placeholder="Login " value="">
									</div>
									<div class="form-group">
										<input type="password" name="senha" id="senha" tabindex="2" class="form-control" placeholder="Senha">
									</div>
									<div class="form-group">
										<input type="password" name="senha" id="senha" tabindex="2" class="form-control" placeholder="Confirme a senha">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="command" value="ManterRegistro" id="register-submit" tabindex="4" class="form-control btn btn-register" >
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>

