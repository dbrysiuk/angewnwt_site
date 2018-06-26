<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link href="../../Layout/CSS/style.css" type="text/css" rel="stylesheet">
<link href="../../Layout/CSS/prettify.css" type="text/css" rel="stylesheet">
<script src="../../Script/prettify.js" type="text/javascript"></script>
<!-- Quelle: https://github.com/google/code-prettify -->
<meta charset="ISO-8859-1">
<title>Kapitel 7: TCP / IP</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("../../Layout/header.php");
include ("../../Layout/navigation.php");
?>

<body id="tcp" onload="prettyPrint()">
<main>
<h3>zu Kapitel 7 (Wireshark-Beispiele)</h3>
<hr>
<article> <a href="zuKap7/zuKap7.php"><button type="button">
		<span>Wireshark-Aufzeichnungen herunterladen</span>
	</button></a>
<p>Im diesem ZIP-Archiv befinden sich Wireshark-Aufzeichnungen zu den Abbildungen 7.2, 7.3 und 7.4 
(Verbindungsaufbau, Datenübertragung und Verbindungsabbau), sowie zu Kapitel 7.4 
(gepufferte und ungepufferte Datenstreams).</p>
</article> 
</main>

<main>
<h3>zu Kapitel 7.4 (Client / Server)</h3>
<hr>
<article> 
	<a href="zuKap7.4/zuKap7.4.php"><button type="button">
		<span>Quellcodes herunterladen</span>
	</button></a>
	<?php include ("../../Layout/buttonAnleitung.php")?>
<p> Für Kapitel 7.4 stehen uns die Klassen <a href=#BeispielClient.java><i>BeispielClient</i></a> und <a href=#BeispielServer.java><i>BeispielServer</i></a>, 
sowie <a href=#BeispielClientGepuffert.java><i>BeispielClientGepuffert</i></a> und <a href=#BeispielServerGepuffert.java><i>BeispielServerGepuffert</i></a> zur Verfügung. Die letzten beiden verfügen dabei im Vergleich 
zu den ersten über einen gepufferten OutputStream (<code>BufferedOutputStream</code>).</p> 
<p>Am Ende der Seite finden Sie eine <a href=#7.4>Vorschau</a>
der sich im Archiv befindlichen Java-Klassen.</p>
</article> 
</main>

<main>
<h3>zu Kapitel 7.5 (Studentenverwaltung)</h3>
<hr>
<article> 
	<a href="zuKap7.5/zuKap7.5.php"><button type="button">
		<span>Quellcodes herunterladen</span>
	</button></a>
	<?php include ("../../Layout/buttonAnleitung.php")?>
<p>Für Kapitel 7.5 (Studentenverwaltung) stehen uns im Vergleich zu dem Archiv aus Kapitel 3.3 mit dem Interface <a href=#LesenSchreiben.java><i>LesenSchreiben</i></a>, 
sowie den Klassen <a href=#TextIO.java><i>TextIO</i></a>, <a href=#BinaerIO.java><i>BinaerIO</i></a>, <a href=#JSON_IO.java><i>JSON_IO</i></a>, <a href=#Leistung.java><i>Leistung</i></a>, <a href=#Student.java><i>Student</i></a>, <a href=#Util.java><i>Util</i></a> und 
<a href=#Verwaltung.java><i>Verwaltung</i></a> zusätzlich die Klassen <a href=#NetzwerkIO.java><i>NetzwerkIO</i></a>, <a href=#NetzwerkIOServer.java><i>NetzwerkIOServer</i></a> und <a href=#NetzwerkIODemoServer.java><i>NetzwerkIODemoServer</i></a> zur Verfügung, 
mit welchen sich die erzeugten Studentendaten nun auch über eine Netzwerkverbindung mit TCP/IP übertragen lassen.</p>
<p>Das entsprechende Ausgabeformat kann in der Klasse <i>Verwaltung</i> gewählt werden. 
Das verlinkte Archiv enthält bereits je eine erzeugte Text-, Binär- und JSON-Datei.</p>
<p>Am Ende der Seite finden Sie eine <a href=#7.5>Vorschau</a> der sich im Archiv befindlichen Java-Klassen.</p>
</article> 
</main>

<main id="7.4">
<h3>Vorschau der Java-Klassen zu Kapitel 7.4</h3>
<hr>
<article class="javacode">
<?php
require 'files/zuKap7.4-Files.php';
require_once '../../Formatter/meinPrettyfier.php';
meinPrettyfier($files)
?>
</article>
</main>

<main id="7.5">
<h3>Vorschau der Java-Klassen zu Kapitel 7.5</h3>
<hr>
<article class="javacode">
<?php
require 'files/zuKap7.5-Files-Vorschau.php';
require_once '../../Formatter/meinPrettyfier.php';
meinPrettyfier($files)
?>
</article>
</main>
</body>

<?php 
include ("../../Layout/footer.php");
?>
</html>