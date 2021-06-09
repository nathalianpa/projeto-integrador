<%-- 
    Document   : login
    Created on : 26 de mai. de 2021, 22:16:27
    Author     : Nathalia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link href="indexformatacao.css" type="text/css" rel="stylesheet" />
        <title>Controle de Acesso</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300&display=swap" rel="stylesheet">

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    </head>
    <body>

        <div class="wrapper fadeInDown">
            <div id="formContent">

                <div class="fadeIn first">
                    <h1>GERENCIAMENTO PETSHOP FELIZ</h1>
                </div>
                <form  method="post" action="${pageContext.request.contextPath}/EfetuarLogin">
                    <input type="text" id="login" class="fadeIn second" name="login" placeholder="username">
                    <input type="password" id="senha" class="fadeIn third" name="senha" placeholder="password">
                    <input type="submit" class="fadeIn fourth" value="Log In">
                </form>
   
                

            </div>
        </div>
    
    </body>
                                    <div class="dog">
        <img src="./images/cachorro.png" alt="Italian Trulli"  width="300px" height="200px">
                    </div>
 <div id="formFooter">
                      <p>Pet Feliz - TADS 2021</p>

                </div>
</html>