<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
        <c:import url="head.jsp"/>
    </head>

    <body>

        <c:import url="menu.jsp?menu=cadprof"/>

        <div class="container">
            <form action="ProcessaHorario" method="post" ENCTYPE="multipart/form-data" accept-charset="UTF-8" onsubmit="enviando()">

                <!-- Main hero unit for a primary marketing message or call to action -->
                <div class="hero-unit">
                    <label for="username">Nome</label>
                    <div>
                        <div class="input-prepend">
                            <input id="username" name="username" type="text" class="span5" disabled="disabled" value="${UsuarioLogado.nome}" />
                        </div>
                    </div>
                    <label for="email">Email</label>
                    <div>
                        <div>
                            <input id="email" name="email" type="text" class="span5" disabled="disabled" value="${UsuarioLogado.email}" />
                        </div>
                    </div>
                    <label>Assinatura</label>
                    <div class="fileupload fileupload-new" data-provides="fileupload">
                        <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&text=nenhuma+imagem" /></div>
                        <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                        <div>
                            <span class="btn btn-file"><span class="fileupload-new">Carregar Assinatura</span><span class="fileupload-exists">Alterar</span><input type="file" id="arquivo" name="arquivo" /></span>
                            <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remover</a>
                        </div>
                    </div>
                    <label>Horário</label>
                    <div class="fileupload fileupload-new" data-provides="fileupload">
                        <span class="btn btn-file"><span class="fileupload-new">Carregar Horário</span><span class="fileupload-exists">Alterar</span><input type="file" id="arquivo" name="arquivo" /></span>
                        <span class="fileupload-preview"></span>
                        <a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">×</a>
                    </div>
                    <input type="submit" class="btn-info" value="Salvar"/>

                </div>
            </form>

            <!-- Example row of columns -->


            <hr>

            <footer>
                <p>&copy; Company 2013</p>
            </footer>

        </div> <!-- /container -->

        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery.min.js"></script>
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

    </body>
</html>


