<%-- 
    Document   : relatorioVenda
    Created on : 11 de mai. de 2021, 22:15:48
    Author     : Nathalia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.senac.sp.petfeliz.pi3.model.Venda"%>
<%@page import="br.senac.sp.petfeliz.pi3.dao.VendaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="formatacao.css"/>
        <title>Relatório de Venda</title>
        <meta charset="UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
    </head>
    <body>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        
        <div class="form-horizontal">
            <fieldset>

                <legend>Relatório de Vendas</legend>
                
        <table border= 1>
            
            <tr>
                <td align=middle width=100>ID da Venda</td>
                <td align=middle width=100>ID do Funcionario</td>
                <td align=middle width=100>ID do cliente</td>
                <td align=middle width=100>ID do Produto</td>
                <td align=middle width=100>Quantidade</td>
                <td align=middle width=100>Data da Venda</td>
                                           
            </tr>
            
            <c:forEach var="venda" items="${vendas}" varStatus="id">
                <tr>
                    <td align=middle width=100>${venda.getId()}</td>
                    <td align=middle width=100>${venda.getId_funcionario()}</td>
                    <td align=middle width=100>${venda.getId_cliente()}</td>
                    <td align=middle width=100>${venda.getId_produto()}</td>
                    <td align=middle width=100>${venda.getQuantidade()}</td>
                    <td align=middle width=100>${venda.getDt_venda()}</td>                    
                </tr>
            </c:forEach>
                
        </table>       
                
            </fieldset>
            
        </div>
        
    </body>
    
</html>
