<%-- 
    Document   : principal
    Created on : 29/09/2013, 23:10:38
    Author     : Ge
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<c:if test="${ProfessorLogado==null}">
    <c:redirect url="../index.jsp"/>
</c:if>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="head.jsp"/>
        <link type="text/css" rel="stylesheet" href="<c:url value='/css/bootstrap-combined.min.css'/>"/>
        
        <script type="text/javascript" src="<c:url value='/js/funcoes.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/js/bootstrap-datetimepicker.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/js/bootstrap-datetimepicker.pt-BR.js'/>"></script>
    </head>

    <body>
        <c:import url="menu.jsp?menu=home"/>
        <div class="container">

            <!-- Modal -->
            <div style="width: 300px;" id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <form action="Solicitacao" method="post">
                    <div style="padding: 50px 30px 30px 30px"> 
                        <script>
                            document.getElementById("horario").onclick;
                        </script>
                        <INPUT TYPE="radio" NAME="OPCAO" VALUE="troca"> Troca </br> 
                        <INPUT TYPE="radio" NAME="OPCAO" VALUE="substituicao"> Substituição </br>
                        <INPUT TYPE="radio" NAME="OPCAO" VALUE="todos"> Troca/Substiuição

                    </div>
                    <div class="modal-footer">
                        <button class="btn" data-dismiss="modal" aria-hidden="true">Fechar</button>
                        <button  type="submit" class="btn btn-primary">Solicitar</button>
                    </div>
                </form>
            </div>
            <!-- Main hero unit for a primary marketing message or call to action -->
            <div class="hero-unit">
                <div class="error">
                    <p>${mensagem}</p>
                </div>
                <div class="titulo">
                    <h1>HORÁRIO</h1>
                </div>

            </div>
            <div class="hero-unit" style="margin-top: 5px">
                <table class="tabela">
                    <tr>
                        <td><h3>Turma</h3></td>
                        <td><h3>Disciplina</h3></td>
                        <td><h3>Descrição</h3></td>
                        <td><h3>Horário</h3></td>
                    </tr>
                    <c:forEach items="${sessionScope.aulas}" var="aulas" varStatus="todasaulas"> 
                        <tr>
                            <td>${aulas.getTurma().getCodigo()}</td>
                            <td>${aulas.getDiciplina().getCodigo()}</td>
                            <td>${aulas.getDiciplina().getNome()}</td>
                            <td><a data-toggle="modal" href="#myModal${aulas.id}" onclick="setHorario(${aulas.getHora()});"/>${aulas.getHora()}</a></td>
                        </tr>
                        <div style="width: 300px;" id="myModal${aulas.id}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <form action="Solicitacao" method="post">
                                <div style="padding: 50px 30px 30px 30px"> 
                                    <script>
                                        document.getElementById("horario").onclick;
                                    </script>
                                    <INPUT TYPE="radio" NAME="OPCAO" VALUE="troca"> Troca </br> 
                                    <INPUT TYPE="radio" NAME="OPCAO" VALUE="substituicao"> Substituição </br>
                                    <INPUT TYPE="radio" NAME="OPCAO" VALUE="todos"> Troca/Substiuição
                                    <input type="hidden" name="horario" value="${aulas.getHora()}"/>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn" data-dismiss="modal" aria-hidden="true">Fechar</button>
                                    <button  type="submit" class="btn btn-primary">Solicitar</button>
                                </div>
                            </form>
                        </div>
                    </c:forEach> 
                </table>   
                <div>
                    ${mensagemprofessor}
                </div>
            </div>
            <div class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Modal title</h4>
                        </div>
                        <div class="modal-body"> 
                            <p>One fine body&hellip;</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <footer>
                <p>&copy; Company 2013</p>
            </footer>

        </div> <!-- /container -->

        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap-transition.js"></script>
        <script src="js/bootstrap-alert.js"></script>
        <script src="js/bootstrap-modal.js"></script>
        <script src="js/bootstrap-dropdown.js"></script>
        <script src="js/bootstrap-scrollspy.js"></script>
        <script src="js/bootstrap-tab.js"></script>
        <script src="js/bootstrap-tooltip.js"></script>
        <script src="js/bootstrap-popover.js"></script>
        <script src="js/bootstrap-button.js"></script>
        <script src="js/bootstrap-collapse.js"></script>
        <script src="js/bootstrap-carousel.js"></script>
        <script src="js/bootstrap-typeahead.js"></script>
        <script src="js/bootstrap-fileupload.js"></script>    
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap-transition.js"></script>
        <script src="js/bootstrap-alert.js"></script>
        <script src="js/bootstrap-modal.js"></script>
        <script src="js/bootstrap-dropdown.js"></script>
        <script src="js/bootstrap-scrollspy.js"></script>
        <script src="js/bootstrap-tab.js"></script>
        <script src="js/bootstrap-tooltip.js"></script>
        <script src="js/bootstrap-popover.js"></script>
        <script src="js/bootstrap-button.js"></script>
        <script src="js/bootstrap-collapse.js"></script>
        <script src="js/bootstrap-carousel.js"></script>
        <script src="js/bootstrap-typeahead.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>
        <script type="text/javascript">
            $('#datetimepicker').datetimepicker({
                format: 'dd/MM/yyyy hh:mm:ss',
                language: 'pt-BR'
            });
        </script>
    </body>
</html>
