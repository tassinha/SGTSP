<%-- 
    Document   : upload_arq_html
    Created on : 09/09/2013, 10:03:59
    Author     : josimar
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>SGTSP - Upload</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Le styles -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-fileupload.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.js"></script>
        <![endif]-->

        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
        <link rel="shortcut icon" href="ico/favicon.png">
    </head>

    <body>

        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="#">SGTSP</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li><a href="index.jsp">Home</a></li>
                           <li><a href="CadastrarProfessor.jsp">Cadastrar Professor</a></li>
                            <li class="active" ><a href="upload_arq_html.jsp">Upload Aquivo HTML</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div class="container">
            <form class="form-horizontal"  action="ProcessaHorario" method="post" ENCTYPE="multipart/form-data" accept-charset="UTF-8" onsubmit="enviando()">
           
            <h3 class="content-section">Upoad Arquivo Horário</h3>
  
          
            <div class="control-group">
                <label class="control-label" for="arquivo" >Arquivo</label>
                <div class="controls">
                    <input type="file" id="arquivo" name="arquivo"  >
                </div>
            </div>

        
           
          
            <div class="control-group">
                <div class="controls">
                    <input type="hidden" name="action" value="cadastra_subcategoria"/>
                    <button type="submit" class="btn btn-primary">Salvar</button>
                </div>
            </div>
        </form>
           
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

    </body>
</html>



