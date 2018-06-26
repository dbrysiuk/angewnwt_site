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

<p>Sie m&ouml;chten eine Zufallszahl erzeugen? Dann m&uuml;ssen Sie sich zun&auml;chst amelden. Bitte geben Sie ihren Benutzernamen und ihr Passwort ein.</p>
<p>G&uuml;ltige Kombinationen f&uuml;r Benutzername/Passwort sind Hans/Wurscht oder Erika/Mustermann.

<p>
<form action="login.php" method="post">
        <label for="text">Benutzername:</label> <input id="text" type="text" name="username"><br>
        <label for="password">Passwort:</label> <input id="password" type="password" name="password"><br>
        <input type="submit" value="anmelden">
</form>

</article>
</main>
</body>

<?php 
include ("../../../Layout/footer.php");
?>
</html>