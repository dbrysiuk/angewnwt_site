<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link href="../../Layout/CSS/style.css" type="text/css" rel="stylesheet">
<link href="../../Layout/CSS/prettify.css" type="text/css" rel="stylesheet">
<script src="../../Script/prettify.js" type="text/javascript"></script>
<!-- Quelle: https://github.com/google/code-prettify -->
<meta charset="ISO-8859-1">
<title>Kapitel 8: UDP / IP</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("/Layout/header.php");
include ("/Layout/navigation.php");
?>

<body id="udp" onload="prettyPrint()">
<main>
<h3>zu Kapitel 8.3 (Sender / Empfänger)</h3>
<hr>
<article> <a href="zuKap8.3/zuKap8.php"><button type="button">
		<span>Quellcodes herunterladen</span>
	</button></a>
	<?php include ("/Layout/buttonAnleitung.php")?>
<p>Für Kapitel 8.3 stehen uns die Klassen <a href=#BeispielUDPPartner1.java><i>BeispielUDPPartner1</i></a> und <a href=#BeispielUDPPartner2.java><i>BeispielUDPPartner2</i></a> zur Verfügung, 
mit denen Daten über UDP/IP ausgetauscht werden können.</p>
<p>Partner2 sendet im Sekundentakt ein Datagramm mit einem Integer-Wert an eine IP-Adresse und einen Port. 
Partner1 empfängt die Datagramme auf diesem Port.</p>
</article> 
</main>

<main>
<h3>Vorschau der Java-Klassen zu Kapitel 8.3</h3>
<hr>
<article class="javacode">
<?php
require 'files/zuKap8-Files.php';
require_once '../../Formatter/meinPrettyfier.php';
meinPrettyfier($files)
?>
</article>
</main>
</body>

<?php 
include ("/Layout/footer.php");
?>
</html>