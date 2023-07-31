<?php 
    if(!mysqli_connect('localhost','root','ma84ad11&*')){
        echo 'connexion impossible ';
        exit();
    }
    else{
        echo 'connexion réussie ';
        $connexion = mysqli_connect('localhost','root','eisti0001');
        if(!mysqli_select_db($connexion, 'majorang')){
            echo 'sélection échouée de la bdd';
        }
        else{
            echo 'sélection de la bdd réussie ';
        };
    }
    

  

    
    include "varSession.php";
    foreach ($_SESSION["categories"] as $cat ){
        foreach($cat as $filiere){
            $img=$filiere["img"];
            $titre = $filiere["titre"];
            $auteurs = $filiere["auteurs"];
            $infos = $filiere["infos"];
            $description = $filiere["description"];
            $stock = $filiere["stock"];
            $prix = $filiere["prix"];

            echo $img;
            echo $titre;
            echo $auteurs;
            echo $infos;
            echo $description;
            echo $stock;
            echo $prix;

            $requete = "INSERT INTO manuels VALUES ('".$titre."','".$img."','".$auteurs."','".$infos."','".$description."','".$stock."','".$prix."')";
            if(!mysqli_query($connexion, $requete)){
                echo 'requête non exécutée ';
            }
            else{
                echo 'requête exécutée ';
                $result = mysqli_query($connexion, $requete);
            }
            
            $result = mysqli_query($connexion, $requete);
        }
    }
            
            

        
        
    
