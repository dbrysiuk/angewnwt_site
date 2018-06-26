<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link href="../../Layout/CSS/style.css" type="text/css" rel="stylesheet">
<link href="../../Layout/CSS/prettify.css" type="text/css" rel="stylesheet">
<script src="../../Script/prettify.js" type="text/javascript"></script>
<!-- Quelle: https://github.com/google/code-prettify -->
<meta charset="ISO-8859-1">
<title>Kapitel 6: OPC UA</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("/Layout/header.php");
include ("/Layout/navigation.php");
?>

<body id="opc" onload="prettyPrint()">
<main>
<h3>zu Kapitel 6.2 (OPC UA mit Java)</h3>
<hr>
<article> <a href="zuKap6.2/zuKap6.2.php"><button type="button">
		<span>Quellcode herunterladen</span>
	</button></a>
	<?php include ("/Layout/buttonAnleitung.php")?>
<p>Für Kapitel 6.2 steht uns die Klasse <a href=#OPCDemoClient.java><i>OPCDemoClient</i></a> zur Verfügung. 
Dabei handelt es sich um einen OPC UP Client, der es erlaubt, eine Verbindung zu einem Server aufzubauen, in dessen
Adressraum nach einem Node zu suchen und darauf zuzugreifen. Außerdem enthält das Archiv ein einfaches SPS-Demoprojekt, 
welches, ähnlich dem in Kapitel 4.8 und 5.7 vorgestellten, einen Zähler regelmäßig inkrementiert und im Beispiel den Server darstellt.</p>
<p>Zur Verwendung der Klasse wird eine Bibliothek der Firma <i>Prosys</i> benötigt, welche unter  
<a href="zwischenseite.php?urlfwd=https://www.prosysopc.com/products/opc-ua-java-sdk/">https:// www.prosysopc.com/products/opc-ua-java-sdk/</a> abrufbar ist. Alle benötigten Verweise sind bereits in der Klasse vorhanden. 
Abbildung 6.3 im Buch zeigt, wie die Bibliothek zu einem Eclipse-Projekt hinzugefügt werden kann.</p>
</article> 
</main>

<main>
<h3>Vorschau der Java-Klasse zu Kapitel 6.2</h3>
<hr>
<article class="javacode">
<?php
require 'files/zuKap6.2-Files-Vorschau.php';
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