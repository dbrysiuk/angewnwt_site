<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link rel="stylesheet" href="../../../Layout/CSS/style.css">
<meta charset="ISO-8859-1">
<title>Webserver Beispiel 1</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("../../../Layout/header.php");
include ("../../../Layout/navigation.php");
?>

<body id="http">
<main>
<h3>Plenk'sches Beispiel 1: Zufallszahl</h3>
<hr>
<article>

Wir erzeugen und zeigen in der n&auml;chsten Zeile eine Zufallszahl zwischen 12 und 34 an:<br>
<?php
$intMin = 12;
$intMax = 34;
$zufall = rand($intMin,$intMax);
echo $zufall;
?>
</article>
</main>
</body>

<?php 
include ("../../../Layout/footer.php");
?>
</html>