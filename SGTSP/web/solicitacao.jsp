<%-- 
    Document   : solicitacao
    Created on : 20/09/2013, 19:58:10
    Author     : joao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="aulaDao" class="br.edu.utfpr.sgtsp.daos.AulaDao"  scope="request" />
<html>
    <head>
        <c:import url="head.jsp"/>
    </head>
    <body>

        <c:import url="menu.jsp?menu=solicitacao"/>

        <div class="container">
            <h1>Solicitação</h1>

            <div class="control-group">
               
                <form action="Solicitacao" method="post">

                    <INPUT TYPE="radio" NAME="OPCAO" VALUE="troca"> Troca </br>
                    <INPUT TYPE="radio" NAME="OPCAO" VALUE="substituicao"> Substituição </br>
                    <INPUT TYPE="radio" NAME="OPCAO" VALUE="todos"> Troca/Substiuição

                    
                    <select>
                        <c:forEach items="${aulaDao.getAulasPorProfessor(professor)}" var="a" varStatus="status">
                            
                        <option></option>
                        </c:forEach>
                    </select>
                    
                    <div class="controls">
                        <input type="hidden" name="action" value="cadastra_subcategoria"/> </br>
                        <button type="submit" class="btn btn-primary">Solicitar</button>
                    </div>
                </form>
            </div>

        </div>

    </body>
</html>
