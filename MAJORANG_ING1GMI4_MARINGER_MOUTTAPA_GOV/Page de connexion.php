<?php 
    session_start();
    include "varSession.php";
?>

<?php
if(isset($_POST['mailformcon']))
{
    if(!empty($_POST['email']) AND !empty($_POST['mdp']))
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
        
    }
    else
    {
        $msg = "Tous les champs doivent être complétés";
    }
}
?>

<?php 
    if (isset($_POST["mailformcon"])) {
        $lien = mysqli_connect('localhost', 'root', 'ma84ad11&*');
        mysqli_select_db($lien, 'majorang');

        $email = $_POST['email'];
        $mdp = $_POST['mdp'];

        $r = "SELECT * FROM utilisateurs WHERE email = '$email' AND mdp = '$mdp'";
        $res = mysqli_query($lien, $r);
        $n = mysqli_num_rows($res);
        if ($n == 1) {
            $lignes = mysqli_fetch_array($res);
            $_SESSION['email'] = $lignes['email'];
            $_SESSION['mdp'] = $lignes['mdp'];
            echo "<script>alert(\"Vous êtes connecté!\")</script>";
            //header("Location:index1.php");
        }
        else {
            echo "<script>alert(\"Mot de passe ou adresse mail incorrect!\")</script>";
        }
        


    }
?>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Page de connexion</title>
    <link rel="stylesheet" href="css/Page de connexion.css" />
    <script src="https://kit.fontawesome.com/d58657efb2.js" crossorigin="anonymous"></script>
    
</head>
<body>
    <?php include "nav.php";?>
    

    <form method="POST" action=""> 
        <h1> Page de connexion</h1>
        <br />
        <br />
        <label for="email" > Entrez votre mail : </label>
        <input type="text" id="email" name="email" placeholder="Votre email" value="<?php if(isset($_POST['email'])) { echo $_POST['email']; } ?>"/> 
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


        <label for="mdp"> Entrez votre mot de passe : </label>   <! Un mot de passe contenant au moins 1 majuscules, 1 minuscule, 1 chiffres et d'une longueur d'au moins 10 >
        <input type="password" id="mdp" name="mdp" placeholder="Votre mot de passe" value="<?php if(isset($_POST['mdp'])) { echo $_POST['mdp']; } ?>" />
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
        
        <br/><br/>

        <?php 
        if (isset($msg))
        {
            echo '<font color="red">'.$msg.'</font>';
        }
        ?>


    <!script src="js/Page de connexion.js"> <!/script>

        <br />
        <br />
        <a href="Page inscription.php"> Pas encore inscrit?</a>
        <br />
        <br />
        <br />
        <div class="centrer">
            <input type="submit" value="Valider" name="mailformcon"/>  <!button type ="submit">
        </div>
        
    </form>
    
    <br />
    <br />
    <br />  
    
    <?php include "footer.php"?> 


</body>
</html>
