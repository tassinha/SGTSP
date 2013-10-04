<%-- 
    Document   : principal
    Created on : 04/10/2013, 14:10:38
    Author     : Henrique
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
