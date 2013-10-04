<%-- 
    Document   : index
    Created on : 29/09/2013, 19:59:43
    Author     : Ge
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
    <head>
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="<c:url value='css/bootstrap-responsive.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='css/bootstrap-responsive.min.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='css/bootstrap.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='css/bootstrap.min.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='css/LoginCSS.css'/>"/>

        <script type="text/javascript" src="<c:url value='http://code.jquery.com/jquery.js'/>"></script> 
        <script type="text/javascript" src="<c:url value='js/bootstrap.js'/>"></script> 
        <script type="text/javascript" src="<c:url value='js/bootstrap.min.js'/>"></script>
        <script type="text/javascript">
            function carregando(){
                document.getElementById("box").innerHTML = "<h4>Por Favor Aguarde... Tentando autenticar no LDAP</h4><h4><img src=\"img\loading.gif\"></h4>";
            }
            
        </script>

    </head>
    <body>
        <div id="box">
            <form action="Login" method="POST" class="form-horizontal" accept-charset="ISO-8859-1" onsubmit="carregando()">
                <fieldset >
                    <c:if test="${erroLogin!=null}">
                        <h5 class="row">${erroLogin}</h5>
                    </c:if>
                    <label for="username">Usuário</label>
                    <div>
                        <div class="input-prepend">
                            <span class="add-on">
                                <i class="icon-user"></i>
                            </span>
                            <input id="username" name="username" type="text" class="span3">
                        </div>
                    </div>
                    <label for="password">Senha</label>
                    <div>
                        <div class="input-prepend">
                            <span class="add-on">
                                <i class="icon-lock"></i>
                            </span>
                            <input type="hidden" name="ok" value="login"/>
                            <input id="password" name="password" type="password" class="span3">
                            <div class="controls">
                                <br /> 
                                <button type="submit" class="btn-large btn-info">Login</button>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>

