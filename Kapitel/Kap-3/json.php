<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link href="../../Layout/CSS/style.css" type="text/css" rel="stylesheet">
<link href="../../Layout/CSS/prettify.css" type="text/css" rel="stylesheet">
<script src="../../Script/prettify.js" type="text/javascript"></script>
<!-- Quelle: https://github.com/google/code-prettify -->
<meta charset="ISO-8859-1">
<title>Kapitel 3: JSON</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("../../Layout/header.php");
include ("../../Layout/navigation.php");
?>

<body id="json" onload="prettyPrint()">
<main>
<h3>zu Kapitel 3.3 (my1stJSON)</h3>
<hr>
<article> <a href="zuKap3.3/zuKap3.3.php"><button type="button">
		<span>Quellcode herunterladen</span>
	</button></a>
	<?php include ("../../Layout/buttonAnleitung.php")?>
<p>Zu Kapitel 3.3 steht uns die Klasse <a href=#my1stJSON.java><i>my1stJSON</i></a> zur Verfügung, das die Datei <i>JSON-Beispiel.json</i>
einliest. Diese Datei muss in dem Verzeichnis liegen, in dem die .class-Datei des Programms liegt.</p>
<p>Zur Verwendung der Klasse <i>my1stJSON</i> wird die Bibliothek <i>Gson</i> benötigt, welche Daten aus der Java-Struktur heraus 
direkt in das JSON-Format umsetzen kann und umgekehrt. Die Bibliothek ist unter  
<a href="zwischenseite.php?urlfwd=http://code.google.com/p/google-gson">http://code.google.com/p/google-gson</a> abrufbar. Alle benötigten Verweise sind bereits in der Klasse vorhanden. 
Abbildung 3.1 im Buch zeigt, wie die Bibliothek zu einem Eclipse-Projekt hinzugefügt werden kann.</p>
<p>Am Ende der Seite finden Sie eine <a href=#3.3>Vorschau</a> der Klasse.
</article> </main>

<main>
<h3>zu Kapitel 3.4 (Studentenverwaltung)</h3>
<hr>
<article> <a href="zuKap3.4/zuKap3.4.php"><button type="button">
		<span>Quellcodes herunterladen</span>
	</button></a>
	<?php include ("../../Layout/buttonAnleitung.php")?>
<p>In Kapitel 2 (Grundlagen) standen uns das Interface <a href=#LesenSchreiben.java><i>LesenSchreiben</i></a>, 
sowie die Klassen <a href=#TextIO.java><i>TextIO</i></a>, <a href=#BinaerIO.java><i>BinaerIO</i></a>, <a href=#Leistung.java><i>Leistung</i></a>, <a href=#Student.java><i>Student</i></a>, <a href=#Util.java><i>Util</i></a> und <a href=#Verwaltung.java><i>Verwaltung</i></a> zur Verfügung, 
mit denen zufällig erzeugte Stundentendaten in eine Textdatei oder eine Binärdatei geschrieben werden können.</p>
<p>Für Kapitel 3.4 ist das Archiv um die Klasse <a href=#JSON_IO.java><i>JSON_IO</i></a> erweitert, mit der die erzeugten Studentendaten nun auch 
als JSON-Datei abgespeichert werden können. Die Daten werden dabei, wie bei der Erzeugung einer Textdatei, 
in einen <code>OutputStreamWriter</code>, gekoppelt mit einem <code>FileOutputStream</code>, geschrieben. Der grundlegende Ablauf des 
Programms ist identisch.</p>
<p>Das entsprechende Ausgabeformat kann in der Klasse <i>Verwaltung</i> gewählt werden. 
Das verlinkte Archiv enthält zu jedem Ausgabeformat bereits je eine erzeugte Datei.</p>
<p>Zur Verwendung der Klasse <i>JSON_IO</i> wird die Bibliothek <i>Gson</i> benötigt, welche Daten aus der Java-Struktur heraus 
direkt in das JSON-Format umsetzen kann und umgekehrt. Die Bibliothek ist unter  
<a href="zwischenseite.php?urlfwd=http://code.google.com/p/google-gson">http://code.google.com/p/google-gson</a> abrufbar. Alle benötigten Verweise sind bereits in der Klasse vorhanden. 
Abbildung 3.1 im Buch zeigt, wie die Bibliothek zu einem Eclipse-Projekt hinzugefügt werden kann.</p>
<p>Am Ende der Seite finden Sie eine <a href=#3.4>Vorschau</a> der Klassen.
</article> </main>

<main id="3.3">
<h3>Vorschau der Java-Klassen zu Kapitel 3.3</h3>
<hr>
<article class="javacode">
<?php
require 'files/zuKap3.3-Files.php';
require_once '../../Formatter/meinPrettyfier.php';
meinPrettyfier($files)
?>
</article>
</main>

<main id="3.4">
<h3>Vorschau der Java-Klassen zu Kapitel 3.4</h3>
<hr>
<article class="javacode">
<?php
require 'files/zuKap3.4-Files-Vorschau.php';
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