<?php
    
    require './Exception.php';
    require './PHPMailer.php';
    require './SMTP.php';

    use PHPMailer\PHPMailer\PHPMailer;
    use PHPMailer\PHPMailer\SMTP;
    use PHPMailer\PHPMailer\Exception;

    $nom = $_POST["nom"];
    $prenom = $_POST["prenom"];
    $email = $_POST["email"];
    $objet = $_POST["objet"];
    $message = $_POST["message"];
    // sexe et profession??

    $to = 'arnaudleathierry@gmail.com';
    $body = "
        <b>Nom et prénom :</b> $nom $prenom <br/><br/>
        <b>Adresse mail :</b> $email <br/><br/>
        <b>Message :</b> $message" ;

    $mail = new PHPMailer();
    $mail->isSMTP();
    $mail->Host = "smtp.gmail.com";
    $mail->SMTPAuth = "true";
    $mail->SMTPSecure = "tls";
    $mail->Port = "587";
    $mail->Username = 'arnaudleathierry@gmail.com';
    $mail->Password = 'alt123dev';
    $mail->Subject = $objet;
    $mail->setFrom($email);
    $mail->isHTML(true);
    $mail->Body = $body;
    $mail->addAddress($to);

    $mail->send(); 
    
    if($mail->Send()){
        header("Location:Page de contact.php");
    }
    else{
        echo "Erreur: le message n'a pas pu être envoyer.";
    }
    $mail->smtpClose();
?>