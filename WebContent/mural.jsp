<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt">
<head>
   
    <title>Mural</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
      <link rel="stylesheet" type="text/css" href="css/Mural.css">
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    
    
    <style>

.myBox {
border: none;
padding: 5px;
width: 100%;
height: 300px;
overflow: scroll;
margin-bottom: 20px;
margin-top: 20px;
}

/* Scrollbar styles */
::-webkit-scrollbar {
width: 12px;
height: 12px;
}
::-webkit-scrollbar-track {
border: 1px solid yellowgreen;
border-radius: 2px;
}

::-webkit-scrollbar-thumb {
background: yellowgreen;  
border-radius: 2px;
}

::-webkit-scrollbar-thumb:hover {
background: #88ba1c;  
}
    </style>
</head>
<body>
<h2><center>Mural de Sugestões</center></h2>

<div class="myBox">

<ol class="activity-feed">
<c:forEach var="area" items="${lista}">
  <li class="feed-item">
  
    <div class="text">ID: ${area.id}</div>
    <div class="text">Titulo ${area.titulo}</div>
    <div class="text">Conteudo ${area.conteudo}</div>

  </li>
      </c:forEach>
  </ol>
  </div>
  
  ${login.login}
  
  ${login.id}
 <div id="main" class="container">
        <form action="" method="post">
            <!-- area de campos do form -->

            <div class="row">
                <div class="form-group col-md-4">
                  	<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn-primary" value="Criar Post">
                </div>

                <div class="form-group col-md-4">
                   <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn-primary" value="Meus Posts">
                </div>
                 <div class="form-group col-md-4">
                  <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn-primary" value="Deslogar">
                </div>
            </div>
            <hr />
        </form>
    </div>

	
<script type="text/javascript">

</script>
</body>
</html>
