<%-- 
    Document   : menu
    Created on : 29/09/2013, 23:47:24
    Author     : Ge
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
  <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                 <p class="navbar-text pull-right">
                        <c:if test="${ProfessorLogado!=null}">
                            Logado Como: <a href="#" class="navbar-link"></a>  

                            <strong style="color: #FFFBEF"> <c:out value="${ProfessorLogado.nome}"/> </strong> - 
                            <a href="../FazerLogout" title="Sair" > Sair</a> 
                        </c:if>
                    </p>    
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="#">SGTSP</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li><a href="principal.jsp">Início</a></li>                          
                            <li><a href="upload.jsp">Upload Aquivo HTML</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>
