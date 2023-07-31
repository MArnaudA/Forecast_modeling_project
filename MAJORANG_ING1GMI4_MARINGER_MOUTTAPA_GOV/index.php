<?php
    session_start();
    $Session_ID = session_id();
?>
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Page d'accueil</title>
    <link rel="stylesheet" href="css/Page accueil.css" />
    <script src="https://kit.fontawesome.com/d58657efb2.js" crossorigin="anonymous"></script>
</head>
<body>

    <?php include "nav.php";?>
    <header>
        <h1>Majorang</h1>
        <h2>La solution pour majorer votre classe et vos concours!</h2>
    </header>

    <div class="main">

    <?php include "menuVertical.php";?>

        <h4>
            <br><br><br><br>
            Sur notre site, vous pourrez trouver tous les livres qu'il vous faut
            pour vous préparer aux mieux face aux concours ! Nous vous proposons des livres pour toutes les filières scientifiques.
            Certains de ces livres sont communs à plusieurs filières, tandis que d'autres sont plus spécifiques et ne concernent qu'une seule filière.
            Tous les livres contiennent un cours détaillé et immersif qui saura rendre service au jeune préparationnaire en lui apportant clarté et concision.
            Les exercices contenus dans les livres permettront d'aborder directement et de façon ciblée chaque partie du cours.
            Les exercices sont tous corrigés pour revoir les eventuelles erreurs commises ou pour se donner des pistes de réflexions.
            Enfin, nous vous proposons des exercices de concours pour solliciter au mieux les connaissances acquises dans le format qui vous attendra.
            Nous vous donnons tous éléments pour réussir, alors saisissez votre chance et majorez !
            Pour commencer, sélectionnez l'année à laquelle vous êtes dans la barre de navigation en haut.
            <br><br><br><br>
        </h4>
    </div>

    <?php include "footer.php"?>

    
