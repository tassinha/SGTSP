<%-- 
    Document   : menu
    Created on : 16/09/2013, 19:19:53
    Author     : josimar
<jsp:include page="/constants.jsp" />
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                 <p class="navbar-text pull-right">
                        <c:if test="${UsuarioLogado!=null}">
                            Logado Como: <a href="#" class="navbar-link"></a>  

                            <strong style="color: #FFFBEF"> <c:out value="${UsuarioLogado.nome}"/> </strong> - 
                            <a href="FazerLogout" title="Sair" > Sair</a> 
                        </c:if>
                    </p>    
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="#">SGTSP/${param.menu}</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li  <c:if test="${param.menu=='home'}"> class="active" </c:if>><a href="index.jsp?menu=home">Home</a></li>
                            <li <c:if test="${param.menu=='cadprof'}"> class="active" </c:if>><a href="CadastrarProfessor.jsp?menu=cadprof">Atualizar Dados</a></li>
                            <li <c:if test="${param.menu=='upload'}"> class="active" </c:if>><a href="upload_arq_html.jsp?menu=upload">Upload Aquivo HTML</a></li>
                            <li <c:if test="${param.menu=='solicitacao'}"> class="active" </c:if>><a href="solicitacao.jsp?menu=solicitacao">Solicitação</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>
