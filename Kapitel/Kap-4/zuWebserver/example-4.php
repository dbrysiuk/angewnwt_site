<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link rel="stylesheet" href="../../../Layout/CSS/style.css">
<meta charset="ISO-8859-1">
<title>Webserver Beispiel 3</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("../../../Layout/header.php");
include ("../../../Layout/navigation.php");
?>

<body id="http">
<main>
<h3>Plenk'sches Beispiel 4: Zufallszahl mit Login</h3>
<hr>
<article>
<p>Wir erzeugen und zeigen in der n&auml;chsten Zeile eine Zufallszahl zwischen 12 und 34 an, jedoch nur dann, wenn man sich in der URL als Benutzer "Hans" mit Passwort "Wurscht" authentifiziert.</p>
<p>F&uuml;r die erfolgreiche Ausf&uuml;hrung des Skriptes m&uuml;sste die URL wie folgt aussehen: <i>http://angewnwt.hof-university.de/example-4.php?username=Hans&password=Wurscht</i>
<p>

<?php

$user = $_GET["username"];
$pass = $_GET["password"];

if($user=="Hans" && $pass=="Wurscht") {

	$intMin = 12;
	$intMax = 34;
	$zufall = rand($intMin,$intMax);
	echo "Zufallszahl: " . $zufall;

} else {
	echo "Falscher Benutzername oder Passwort!";
}

?>

</article>
</main>
</body>

<?php 
include ("../../../Layout/footer.php");
?>
</html>