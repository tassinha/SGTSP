

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * CakePHP Component
 * @author rthemis
 */
<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST')
{
    $targ_w = $targ_h = 150;
    $jpeg_quality = 90;
 
    $src = 'demo_files/pool.jpg';
    $img_r = imagecreatefromjpeg($src);
    $dst_r = ImageCreateTrueColor( $targ_w, $targ_h );
 
    imagecopyresampled($dst_r,$img_r,0,0,$_POST['x'],$_POST['y'],
    $targ_w,$targ_h,$_POST['w'],$_POST['h']);
 
    header('Content-type: image/jpeg');
    imagejpeg($dst_r,null,$jpeg_quality);
 
    exit;
}
 
// Se não for uma requisição de POST, exiba a página abaixo:
 
?><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
 
        <script src="http://deepliquid.com/Jcrop/js/jquery.Jcrop.min.js"></script>
        <script src="../js/jquery.Jcrop.js"></script>
        <link rel="stylesheet" href="../css/jquery.Jcrop.css" type="text/css" />
        <link rel="stylesheet" href="demo_files/demos.css" type="text/css" />
 
        <script language="Javascript">
 
            $(function(){
 
                $('#cropbox').Jcrop({
                    aspectRatio: 1,
                    onSelect: updateCoords
                });
 
            });
 
            function updateCoords(c)
            {
                $('#x').val(c.x);
                $('#y').val(c.y);
                $('#w').val(c.w);
                $('#h').val(c.h);
            };
 
            function checkCoords()
            {
                if (parseInt($('#w').val())) return true;
                alert('Selecione a área para recorte.');
                return false;
            };
 
        </script>
 
    </head>
 
    <body>
 
    <div id="outer">
    <div class="jcExample">
    <div class="article">
 
        <h1>Crop jQuery</h1>
 
     
        <img src="demo_files/pool.jpg" id="cropbox" />
 
     
        <form action="crop.php" method="post" onsubmit="return checkCoords();">
            <input type="hidden" id="x" name="x" />
            <input type="hidden" id="y" name="y" />
            <input type="hidden" id="w" name="w" />
            <input type="hidden" id="h" name="h" />
            <input type="submit" value="Crop Image" />
        </form>
 
    </div>
    </div>
    </div>
    </body>
 
</html>


