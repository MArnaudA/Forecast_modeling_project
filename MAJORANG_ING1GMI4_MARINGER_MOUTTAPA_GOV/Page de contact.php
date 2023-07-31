<?php include "varSession.php";
session_start();?>

<?php
if(isset($_POST['mailform']))
{
    if(!empty($_POST['nom']) AND !empty($_POST['prenom']) AND !empty($_POST['email']) AND !empty($_POST['objet']))
	{
        $regexEmail = preg_match('%^[a-zA-Z0-9.-_]+[@]{1}[a-zA-Z0-9.-_]+[.]{1}[a-z]{2,10}$%', $_POST['email']);
        if($regexEmail)
        {
            $msgEmail = 'Adresse email Valide'; 
        }
        else
        {
            $msgEmail = ' Adresse email non Valide';
            
        }

        $regexNom = preg_match('%^[a-zA-Z]+[a-zA-Z]+$%', $_POST['nom']);
        if($regexNom)
        {
            $msgNom = 'Nom Valide'; 
        }
        else
        {
            $msgNom = ' Nom non Valide';
            
        }

        $regexPrenom = preg_match('%^[a-zA-Z]+[a-zA-Z]+$%', $_POST['prenom']);
        if($regexPrenom)
        {
            $msgPrenom = 'Prenom Valide'; 
        }
        else
        {
            $msgPrenom = ' Prenom non Valide';
            
        }
        

    }
    else
    {
        $msg = "Tous les champs doivent être complétés";
    }
}
?>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Page de contact</title>
    <link rel="stylesheet" href="css/Page de contact.css" />
    <script src="https://kit.fontawesome.com/d58657efb2.js" crossorigin="anonymous"></script>
</head>
<body>
    <?php 
        include "nav.php";
    ?>

    <form method="POST" action="action=./envoimail.php">  <! form action="traitement.php" method ="post" id ="formContact">
        <h1>Formulaire de contact</h1>
        <br /><br /><br />
        <label class="informations" for="nom"> Nom :</label>
        <input class="informations" type="text" name="nom" id="nom" placeholder="Votre nom" value="<?php if(isset($_POST['nom'])) { echo $_POST['nom']; } ?>"/>

        <br />
        <span id ="errorNom"></span>
        <?php 
        if (isset($msgNom) AND $regexNom)
        {
            echo '<font color="green">'.$msgNom.'</font>';
        }
        elseif(isset($msgNom))
        {
            echo '<font color="red">'.$msgNom.'</font>';
        }
        ?>
        <br /><br />

        <label class="informations" for="prenom"> Prénom : </label>
        <input class="informations" type="text" name="prenom" id="prenom" placeholder="Votre prenom" value="<?php if(isset($_POST['prenom'])) { echo $_POST['prenom']; } ?>"/>

        <br />
        <span id ="errorPrenom"></span>
        <?php 
        if (isset($msgPrenom) AND $regexPrenom)
        {
            echo '<font color="green">'.$msgPrenom.'</font>';
        }
        elseif(isset($msgPrenom))
        {
            echo '<font color="red">'.$msgPrenom.'</font>';
        }
        ?>
        <br /><br />

        <label class="informations" for="email"> E-mail : </label>
        <input class="informations" type="text" name="email" id="email" placeholder="Votre email" value="<?php if(isset($_POST['email'])) { echo $_POST['email']; } ?>" />


        <br />
        <span id ="errorEmail"></span>

        <?php 
        if (isset($msgEmail) AND $regexEmail)
        {
            echo '<font color="green">'.$msgEmail.'</font>';
        }
        elseif(isset($msgEmail))
        {
            echo '<font color="red">'.$msgEmail.'</font>';
        }
        ?>

        <br />
        <br />
        <br /><br />

        <label class="informations" for="objet" name="objet" id="objet"> Objet du message: </label>
        <input class="informations" type="text" name="objet" id="objet" value="<?php if(isset($_POST['objet'])) { echo $_POST['objet']; } ?>" />

        <br />
        <span id ="errorObjet"></span>
        <br /><br />

        <label class="informations" for="message">Message :</label>
        <textarea class="informations" id="message" name="message" rowx="15" cols="10"></textarea>

        <br />
        <span id ="errorMessage"></span>
        <br />

        <p> Vous êtes : </p>
        <label class="informations" for="homme"> Un homme </label>
        <input class="informations" type="radio" id="homme" name="domaine" />
        <br />
        <span id ="errorObjet"></span>
        <br />

        <label class="informations" for="femme"> Une femme </label>
        <input class="informations" type="radio" id="femme" name="domaine" />
        <br /><br />
        <span id ="errorProfesseur"></span>
        <br />

        <label for="metier-select"> Vous êtes : </label>
        <select name="metiers" id="metier-select">
            <option value=""> Choisissez une option</option>
            <option value="etudiant">Un étudiant</option>
            <option value="prof">Un professeur de l'enseignement supérieur</option>
            <option value="autre"> Autre</option>
        </select>

        <!script src="js/Page de contact.js"> <!/script>
        <br/><br/>

        <?php 
        if (isset($msg))
        {
            echo '<font color="red">'.$msg.'</font>';
        }
        ?>

        <br /><br />
        <div class="centrer">
            <input type="submit" value="Valider" name="mailform"/>  <!button type="submit"> <!/button>
        </div>
 
    </form>
    <br />
    <br />
    <br />
    <?php include "footer.php"?>          
</body>
</html>