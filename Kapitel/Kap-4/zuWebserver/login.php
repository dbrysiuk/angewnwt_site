<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link rel="stylesheet" href="../../../Layout/CSS/style.css">
<meta charset="ISO-8859-1">
<title>Webserver Beispiel 5</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("../../../Layout/header.php");
include ("../../../Layout/navigation.php");
?>

<body id="http">
<main>
<h3>Plenk'sches Beispiel 5: Zufallszahl mit Anmeldeseite (POST)</h3>
<hr>
<article>

<?php

session_start();

$post_user = $_POST["username"];
$post_pass = $_POST["password"];

if($post_user!="") {
	$user = $post_user;
	$pass = $post_pass;
	$_SESSION['user'] = $user;
	$_SESSION['pass'] = $pass;
} else {
	$user = $_SESSION['user'];
	$pass = $_SESSION['pass'];
}


if(($user=="Hans" && $pass=="Wurscht") || ($user=="Erika" && $pass=="Mustermann")) {

        $intMin = 12;
        $intMax = 34;
        $zufall = rand($intMin,$intMax);
        echo "<p>Sie sind authentifiziert.</p>";
        echo "<p>Ihre pers&ouml;hnliche Zufallszahl lautet: $zufall</p>";

} else {
        echo "Falscher Benutzername oder Passwort!";
}

?>

<p>Der folgende Link funktioniert, falls das Session-Cookie akzeptiert wurde. Sie m&uuml;ssen sich dann nicht mehr neu anmelden.<br>
Neue Zufallszahl: <a href="login.php">hier klicken</a>.</p>

<p><a href="login-form.php">Zur&uuml;ck zum Login-Formular</a>.</p>

</article>
</main>
</body>

<?php 
include ("../../../Layout/footer.php");
?>
</html>