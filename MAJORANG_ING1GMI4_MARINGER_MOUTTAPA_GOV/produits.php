<?php 
include "varSession.php";
session_start();
$cat = $_GET["cat"]; /* la filière que l'on récupère dans le lien*/
$filiere=$_SESSION["categories"][$cat]; /* on récupère l'array associé à la matière dans la cariable de session*/
?>

<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>Produits</title>
    <link rel="stylesheet" href="css/Catalogue.css">
    <script src="https://kit.fontawesome.com/d58657efb2.js" crossorigin="anonymous"></script>
</head>

<body>

        
<?php include "nav.php";?>

    <section class="main">
        <?php include "menuVertical.php";?>
        <?php
        $cat = $_GET["cat"]; 
        echo(
        '<div class="manuels">
            <div class="titre">Manuels de '.$cat.'</div>
            <table class="tableau">'
        );
        ?>
        <?php 
            $i=1;
            foreach($filiere as $value){
                
                $img=$value["img"];
                $titre=$value["titre"];
                $auteurs=$value["auteurs"];
                $infos=$value["infos"];
                $description=$value["description"];
                $stock=$value["stock"];
                $prix=$value["prix"];

                echo(
                    
                    '<tr>
                        <td class="left"><img src="Images/'.$img.'" alt=""></td>
                        <td class="right">
                            <h1>'.$titre.'</h1>
                            <h2>'.$auteurs.'</h2>
                            <h3>'.$infos.'</h3>
                            <p>'.$description.'</p>
                        </td>
                        <td class="quantite">Quantité en stock: <h3 class="valeur" id="'.($i+1).'">'.$stock.'</h3></td>
                        <td class="commande">
                            Quantité commandée:
                            <div class="gerercom">
                                <button class="boutonmoins" onclick="moins('.$i.')">-</button>
                                <h3 class="commande" id="'.$i.'">0</h3>
                                <button class="boutonplus" onclick="plus('.$i.','.($i+1).')">+</button>
                            </div>
                            <button class="ajout">Ajouter au panier</button>
                        </td>
                        <td class="price"><p>'.$prix.' €</p></td>
                    </tr>'
                );
                $i=$i+2;
            }
                ?>

                


            </table>
            <br>
            <button onclick="toggle(); change();" id="stockbutton" value="Afficher">Afficher les quantités restantes</button>
            <br><br><br>
        </div>

    </section>
    <script src="js/Test.js"></script>

    <?php include "footer.php";?>
</body>
</html>