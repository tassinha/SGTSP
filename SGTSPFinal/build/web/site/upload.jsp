<%-- 
    Document   : upload
    Created on : 29/09/2013, 23:11:01
    Author     : Ge
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
 <c:import url="head.jsp"/>
    </head>

    <body>

        <c:import url="menu.jsp?menu=upload"/>

        <div class="container">
            <form class="form-horizontal"  action="ProcessaHorario" method="post" ENCTYPE="multipart/form-data" accept-charset="UTF-8">
           
            <h3 class="content-section">Upoad Arquivo Hor�rio</h3>
  
          
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
