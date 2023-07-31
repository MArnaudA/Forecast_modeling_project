<?php include "varSession.php";?>
<div class="menu">
    

    <h1>Manuels</h1>
    <ul>
        <?php
            foreach ($_SESSION['categories'] as $cat => $value){
            $str = '<li><a href="produits.php?cat='.$cat.'">'.$cat.'</a></li>';
            echo $str;
            }
        ?>
        
    </ul>
    <br>
    
</div>