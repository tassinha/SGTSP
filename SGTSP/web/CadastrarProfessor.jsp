<%-- 
    Document   : CadastrarProfessor
    Created on : 19/08/2013, 20:08:08
    Author     : Eduardo Albertini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>    
        <script type="text/javascript" src="js/bootstrap-fileupload.js"></script>    
        <script type="text/javascript" src="js/bootstrap-fileupload.min.js"></script>     
        <link href="css/bootstrap-fileupload.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-fileupload.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Atualizar Dados do Cadastro</title>
    </head>
    <body>
        <label for="username">Nome</label>
        <div>
            <div class="input-prepend">
                <input id="username" name="username" type="text" class="span5" disabled="disabled" value="TEXTO NÃO ALTERÁVEL" />
            </div>
        </div>
        <label for="email">Email</label>
        <div>
            <div>
                <input id="email" name="email" type="text" class="span5" disabled="disabled" />
            </div>
        </div>
        <label>Assinatura</label>
        <div class="fileupload fileupload-new" data-provides="fileupload">
            <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&text=sem+imagem" /></div>
            <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
            <div>
                <span class="btn btn-file"><span class="fileupload-new">Carregar Assinatura</span><span class="fileupload-exists">Alterar</span><input type="file" /></span>
                <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remover</a>
            </div>
        </div>
        <label>Horário</label>
        <div class="fileupload fileupload-new" data-provides="fileupload">
            <span class="btn btn-file"><span class="fileupload-new">Carregar Horário</span><span class="fileupload-exists">Alterar</span><input type="file" /></span>
            <span class="fileupload-preview"></span>
            <a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">×</a>
        </div>

    </body>
</html>
