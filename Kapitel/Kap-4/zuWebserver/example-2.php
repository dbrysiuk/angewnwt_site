<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link rel="stylesheet" href="../../../Layout/CSS/style.css">
<meta charset="ISO-8859-1">
<title>Webserver Beispiel 2</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("../../../Layout/header.php");
include ("../../../Layout/navigation.php");
?>

<body id="http">
<main>
<h3>Plenk'sches Beispiel 2 GET: Input</h3>
<hr>
<article>
<p>Sie schicken dem Server eine Zahl und der Server schickt Ihnen den doppelten Wert zur&uuml;ck.</p>

<p>Gleitkommazahlen wollen einen Punkt, kein Komma!</p>

<form action="example-2-antwort.php" method="get">
<p><input type="text" name="clientInput"></p>
<p><input type="submit" name="action" value="Abschicken"></p>
</form>

</article>
</main>
</body>

<?php 
include ("../../../Layout/footer.php");
?>
</html>