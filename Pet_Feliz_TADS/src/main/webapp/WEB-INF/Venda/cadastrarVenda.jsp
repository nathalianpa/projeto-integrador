<%-- 
    Document   : cadastrarVenda
    Created on : 5 de mai. de 2021, 22:42:20
    Author     : Nathalia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.senac.sp.petfeliz.pi3.model.Produto"%>
<%@page import="br.senac.sp.petfeliz.pi3.dao.ProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="formatacao.css"/>
        <title>Venda</title>
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

                <legend>Cadastrar Venda</legend>
        
        <form method="post" action="${pageContext.request.contextPath}/CadastrarVenda">
        <div class="form-group">
                        <label class="col-md-4 control-label" for="id_funcionario">ID do Funcionario</label>
                        <div class="col-md-4">
                            <input id="endereco" name="id_funcionario" type="number" class="form-control input-md">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="id_cliente">ID do Cliente</label>
                        <div class="col-md-4">
                            <input id="bairro" name="id_cliente" type="number" class="form-control input-md">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="id_produto">ID do Produto</label>
                        <div class="col-md-4">
                            <input id="cidade" name="id_produto" type="number" class="form-control input-md">
                        </div>
                    </div>
        
        <div class="form-group">
                        <label class="col-md-4 control-label" for="quantidade">Quantidade</label>
                        <div class="col-md-4">
                            <input id="cidade" name="quantidade" type="number" class="form-control input-md">
                        </div>
                    </div>
        <label class="col-md-4 control-label" for="button1id">
                            
                            
                    </label>
                <button type="submit" class="btn btn-success">Salvar</button>   
                                <button type="reset" class="btn btn-primary">Limpar</button>
                                <button type="reset"  class="btn btn-success" onclick="window.location.href = 'menu.jsp';">Voltar</button>
                            
        </form>
            </fieldset>
    </body>
</html>
