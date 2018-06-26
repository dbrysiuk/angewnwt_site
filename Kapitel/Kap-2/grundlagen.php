<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link href="../../Layout/CSS/style.css" type="text/css" rel="stylesheet">
<link href="../../Layout/CSS/prettify.css" type="text/css" rel="stylesheet">
<script src="../../Script/prettify.js" type="text/javascript"></script>
<!-- Quelle: https://github.com/google/code-prettify -->
<meta charset="ISO-8859-1">
<title>Kapitel 2: Grundlagen</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("../../Layout/header.php");
include ("../../Layout/navigation.php");
?>

<body id="grundlagen" onload="prettyPrint()">
<main>
<h3>zu Kapitel 2.2 (Studentenverwaltung)</h3>
<hr>
<article> <a href="zuKap2.2/zuKap2.php"><button type="button">
		<span>Quellcodes herunterladen</span>
	</button></a> 
	<?php include ("../../Layout/buttonAnleitung.php")?>
<p>Für Kapitel 2.2 stehen uns das Interface <a href=#LesenSchreiben.java><i>LesenSchreiben</i></a>,
	sowie die Klassen <a href=#TextIO.java><i>TextIO</i></a>, <a href=#BinaerIO.java><i>BinaerIO</i></a>, 
	<a href=#Leistung.java><i>Leistung</i></a>, <a href=#Student.java><i>Student</i></a>, 
	<a href=#Util.java><i>Util</i></a> und <a href=#Verwaltung.java><i>Verwaltung</i></a> zur Verfügung, 
	mit denen zufällig erzeugte Stundentendaten in eine Textdatei (über die Klasse <i>TextIO</i>) oder eine 
	Binärdatei (über die Klasse <i>BinaerIO</i>) geschrieben werden können.</p>
<p>Dazu werden in der Klasse <i>Util</i> Instanzen der Klasse <i>Student</i> und je
	ein dazugehöriges Array von Instanzen der Klasse <i>Leistung</i> mit zufällig
	ausgewählten Daten erzeugt und eine Dateihandlerinstanz der für das
	entsprechende Ausgabeformat benötigten Klasse erstellt. Anschließend
	werden die Daten in einen <code>OutputStreamWriter</code> (bei einer Textdatei) bzw.
	einen <code>DataOutputStream</code> (bei einer Binärdatei), jeweils gekoppelt mit
	einem <code>FileOutputStream</code>, geschrieben.</p>
<p>Im Anschluss wird die erstellt Datei wieder eingelesen und mit den
	ursprünglichen Daten verglichen, um Fehler beim Schreibvorgang
	auszuschließen.</p>
<p>Das entsprechende Ausgabeformat kann in der Klasse <i>Verwaltung</i>
	gewählt werden. Dem hier verlinkten Archiv liegt bereits zu
	beiden Formaten je eine erzuegte Datei bei.</p>
<p>Am Ende dieser Seite finden Sie eine <a href=#2.2>Vorschau</a> der Java-Klassen.</p>
</article> </main>

<main>
<h3>zu den Übungsaufgaben</h3>
<hr>
<article> 
	<a href="files/dlUTF8-Demo.php"><button type="button">
		<span>UTF-8-Demo.txt herunterladen</span>
	</button></a>
<p>Die UTF8-Demo-Datei enthält beispielhaft ausgewählte Zeichen in
	UTF-8-Codierung. Die Datei muss in einem UTF-8-fähigen Editor geöffnet
	werden, damit sie korrekt dargestellt werden kann.</p>
<a href="files/dlBinaerDatei.php"><button type="button">
		<span>BinaerDatei herunterladen</span>
	</button></a>
<p>Die Binärdatei enthält die Studentendaten aus Kapitel 2.2 im
	Binärformat.</p>
</article> </main>

<main id="2.2">
<h3>Vorschau der Java-Klassen zu Kapitel 2.2</h3>
<hr>
<article class="javacode">
<?php
require 'files/zuKap2-Files-Vorschau.php';
require_once '../../Formatter/meinPrettyfier.php';
meinPrettyfier($files)
?>
</article>
</main>
</body>

<?php 
include ("../../Layout/footer.php");
?>