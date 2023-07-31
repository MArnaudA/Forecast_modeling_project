<?php include "varSession.php";
    session_start();?>


<?php
if(isset($_POST['mailforminscr']))
{
    if(!empty($_POST['email']) AND !empty($_POST['mdp']) AND !empty($_POST['mdpc']))
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
        
        $regexMdp = preg_match('%^(?=.{6,}$)(?=(?:.*?[A-Z]){1})(?=.*?[a-z])(?=(?:.*?[0-9]){1}).*$%', $_POST['mdp']);
        if($regexMdp)
        {
            $msgMdp = 'Le mot de passe est Valide';
        }
        else
        {
            $msgMdp = 'Le mot de passe est non Valide (minimum 6 caractères, 1 majuscule, 1 chiffre)';
        }

        $regexMdpc = preg_match('%^(?=.{6,}$)(?=(?:.*?[A-Z]){1})(?=.*?[a-z])(?=(?:.*?[0-9]){1}).*$%', $_POST['mdpc']);
        if($regexMdpc AND $_POST['mdp'] == $_POST['mdpc'])
        {
            $msgMdpc = 'Le mot de passe est Valide';
        }
        else
        {
            $msgMdpc = 'Le mot de passe est non Valide';
        }

    }
    else
    {
        $msg = "Tous les champs doivent être complétés";
    }
}
?>

<?php
    if(isset($_POST['mailforminscr'])) {
        include('varSession.php');

        $lien = mysqli_connect('localhost', 'root', 'ma84ad11&*');
        mysqli_select_db($lien, 'majorang');

        $email = $_POST["email"];
        $mdp = $_POST["mdp"];

        $r = "SELECT * FROM utilisateurs WHERE email = '$email'";
        $res = mysqli_query($lien, $r);
        $n = mysqli_num_rows($res);
        if ($n == 1) {
            echo "<script>alert(\"Il existe déjà un compte avec cette adresse mail.\")</script>";
        }
        else {
            $insert = "INSERT INTO utilisateurs VALUES ('$email', '$mdp')";
            mysqli_query($lien,$insert);
            echo "<script>alert(\"Vous etes inscrit.\")</script>";
        }
        
        $r2 = "SELECT * FROM utilisateurs WHERE email = '$email'";
        $res = mysqli_query($lien, $r2);
        $lignes = mysqli_fetch_array($res);
        $_SESSION['email'] = $lignes['email'];  
        $_SESSION['mdp'] = $lignes['mdp'];
    }
?>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Page d'inscription</title>
    <link rel="stylesheet" href="css/Page inscription.css" />
    <script src="https://kit.fontawesome.com/d58657efb2.js" crossorigin="anonymous"></script>
</head>
<body>
    <?php 
        include "nav.php";
    ?>

    <form method="POST" action="">  <! form action="traitement.php" method ="post" id ="formInscription">
        <h1> Page d'inscription</h1>
        <br />
        <br />
        <br />
        <label for="email"> Entrez votre mail d'inscription : </label>
        <input type="text" id="email" name="email" value="<?php if(isset($_POST['email'])) { echo $_POST['email']; } ?>"/> 
        <br />
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
        <label for="mdp"> Entrez votre mot de passe : </label>
        <input type="password" id="mdp" name="mdp" value="<?php if(isset($_POST['mdp'])) { echo $_POST['mdp']; } ?>"/>
        <br />
        <br />
        <span id ="errorMdp"></span>

        <?php 
        if (isset($msgMdp) AND $regexMdp)
        {
            echo '<font color="green">'.$msgMdp.'</font>';
        }
        elseif(isset($msgMdp))
        {
            echo '<font color="red">'.$msgMdp.'</font>';
        }
        ?>

        <br />
        <br />
        <label for="mdpc"> Confirmez votre mot de passe : </label>
        <input type="password" id="mdpc" name="mdpc" value="<?php if(isset($_POST['mdpc'])) { echo $_POST['mdpc']; } ?>"/>
        <br />
        <br />
        <span id ="errorMdpc"></span>

        <?php 
        if (isset($msgMdpc) AND $regexMdpc AND $_POST['mdp'] == $_POST['mdpc'] )
        {
            echo '<font color="green">'.$msgMdpc.'</font>';
        }
        elseif(isset($msgMdpc))
        {
            echo '<font color="red">'.$msgMdpc.'</font>';
        }
        ?>

        <br />
        <br />
        <a href="Page de connexion.php">Déjà inscrit?</a>
        <br />
        <br />

        <!script src="js/Page inscription.js"> <!/script>

        <br />

        <?php 
        if (isset($msg))
        {
            echo '<font color="red">'.$msg.'</font>';
        }
        ?>
        
        <div class="centrer">
            <input type="submit" value="Valider" name="mailforminscr"/> <!button type="submit"><!/button>
        </div>
    </form>

    <br />
    <br />
    <br />

    <?php include "footer.php"?>    
</body>
</html>