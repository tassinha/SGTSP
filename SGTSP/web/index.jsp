<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${UsuarioLogado==null}">
    <c:redirect url="Login.jsp"/>
</c:if>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="head.jsp"/>
    </head>

    <body>
        <c:import url="menu.jsp?menu=home"/>
        <div class="container">

            <!-- Modal -->
            <div style="width: 300px;" id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <form action="Solicitacao" method="post">
                    <div style="padding: 50px 30px 30px 30px"> 
                        <script>
                            document.getElementById("aula").onclick;
                        </script>
                        <INPUT TYPE="radio" NAME="OPCAO" VALUE="troca"> Troca </br> 
                        <INPUT TYPE="radio" NAME="OPCAO" VALUE="substituicao"> Substituição </br>
                        <INPUT TYPE="radio" NAME="OPCAO" VALUE="todos"> Troca/Substiuição 
                    </div>
                    <div class="modal-footer">
                        <button class="btn" data-dismiss="modal" aria-hidden="true">Fechar</button>
                        <button  type="submit" class="btn btn-primary">Solicitar</button>
                </form>
            </div>
        </div>
        <!-- Main hero unit for a primary marketing message or call to action -->
        <div class="hero-unit">
            <div style="float: left">
                <p>Dados do Professor</p>
            </div>
            <div id="datetimepicker" class="input-append date" style="float: right">
                <input type="text"></input>
                <span class="add-on">
                    <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                </span>
            </div>
        </div>
        <div class="hero-unit" style="margin-top: 5px">

            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
            <p><a data-toggle="modal" href="#myModal" onclick="setAttribute('aula', '2m2'" >Launch demo modal</a></p>
                     
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
    <script type="text/javascript"
            src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
    </script> 
    <script type="text/javascript"
            src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
    </script>
    <script type="text/javascript"
            src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
            src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
    </script>
    <script type="text/javascript">
        $('#datetimepicker').datetimepicker({
            format: 'dd/MM/yyyy hh:mm:ss',
            language: 'pt-BR'
        });
    </script>
</body>
</html>


