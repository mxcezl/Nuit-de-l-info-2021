<?php
  use PHPMailer\PHPMailer\PHPMailer;
  use PHPMailer\PHPMailer\Exception;
  require 'PHPMailer-master/src/Exception.php';
  require 'PHPMailer-master/src/PHPMailer.php';
  require 'PHPMailer-master/src/SMTP.php';

  $mail = new PHPMailer();
  $mail->IsSMTP();

  $mail->SMTPDebug  = 0;  
  $mail->SMTPAuth   = TRUE;
  $mail->SMTPSecure = "tls";
  $mail->Port       = 587;
  $mail->Host       = "smtp.gmail.com";
  $mail->Username   = "meilleursvoeux20@gmail.com";
  $mail->Password   = "meilleursVoeux20?";

  $mail->IsHTML(true);
  $mail->AddAddress("mathis.fossey@outlook.com");
  $mail->SetFrom("meilleurs voeux 2.0");
  $mail->AddCC("meilleursvoeux20@gmail.com");
  $mail->Subject = "Joyeuses Fetes !!";

  $mail->MsgHTML(file_get_contents('beefree-4ep22d652is.html')); 
  if(!$mail->Send()) {
    echo "Error while sending Email.";
    var_dump($mail);
  } else {
    echo "Email sent successfully";
  }
?>
