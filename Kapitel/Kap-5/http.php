<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link href="../../Layout/CSS/style.css" type="text/css" rel="stylesheet">
<link href="../../Layout/CSS/prettify.css" type="text/css" rel="stylesheet">
<script src="../../Script/prettify.js" type="text/javascript"></script>
<!-- Quelle: https://github.com/google/code-prettify -->
<meta charset="ISO-8859-1">
<title>Kapitel 5: HTTP</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("/Layout/header.php");
include ("/Layout/navigation.php");
?>

<body id="http" onload="prettyPrint()">
<main>
<h3>zu Kapitel 5.6 (GET und POST)</h3>
<hr>
<article> <a href="zuKap5.6/zuKap5.6.php"><button type="button">
		<span>Quellcodes herunterladen</span>
	</button></a>
	<?php include ("/Layout/buttonAnleitung.php")?>
<p>Für Kapitel 5.6 stehen uns die Klassen <a href=#HTTPClient_GET.java><i>HTTPClient_GET</i></a> und <a href=#HTTPClient_POST.java><i>HTTPClient_POST</i></a> zur Verfügung, 
mit denen eine Get- bzw. Post-Anfrage an einen Server gesendet, Daten abgerufen und ausgegeben werden können. 
Bei der Klasse <i>HTTPClient_POST</i> werden mit der Anfrage außerdem zusätzliche Daten in Form vom Name-Wert-Paaren 
(im Beispiel Benutzername und Passwort) an den Server übermittelt.</p>
<p>Zur Verwendung der beiden Klassen wird die Bibliothek <i>HTTPClient</i> benötigt. 
Die Bibliothek ist unter <a href="zwischenseite.php?urlfwd=http://hc.apache.org">http://hc.apache.org</a> abrufbar. 
Alle benötigten Verweise sind bereits in den Klassen vorhanden. 
Kapitel 5.6.1 im Buch beschreibt, wie die Bibliothek zu einem Eclipse-Projekt hinzugefügt werden kann.</p>
<p>An Ende dieser Seite finden Sie eine Vorschau der Java-Klassen.</p>
</article> </main>

<main id="Kap5.7">
<h3>zu Kapitel 5.7 (SPS Webserver Teil 2)</h3>
<hr>
<article> 
	<a href="zuKap5.7/zuKap5.7.php"><button type="button">
		<span>Begleitmaterial herunterladen</span>
	</button></a>
	<?php include ("/Layout/buttonAnleitung.php")?>
<p>Das Begleitmaterial zu Kapitel 5.7 umfasst das Java-Programm <a href=#SiemensAnmeldungAbruf.java>SiemensAnmeldungAbruf</a> für den Zugriff auf den Webserver einer SPS, sowie 
die HTML-Dokumente <i>Zaehler.html</i>, über welches sich der Zählerstand setzen und ändern lässt und <i>Zaehlerzusatz.html</i>, in welchem der Zählerstand steht.</p>
<p>Der Ablauf des Programms beginnt mit der Übermittlung von Benutzername und Passwort mittels einer POST-Anfrage, anschließend wird das Dokument <i>Zaehlerzusatz.html</i> vom Webserver abgerufen und der Zählerstand extrahiert.</p>
<p>Desweiteren befindet sich zur Ergänzung im ZIP-Archiv die Wireshark-Aufzeichnung  der Kommunikation mit dem SPS-Webserver und das SPS-Projekt <i>1513_Buch_Plenk_2_WWW.zap13</i>, welches eine Variable 
im Sekundentakt hochzählt. Das Dokument <i>Zaehlerzusatz.html</i> aktualisiert sich ebenfalls sekündlich und zeigt daher immer den aktuellen Zählerstand an.</p>
<p>Der Inhalt dieses ZIP-Archivs zu ist identisch mit dem von <a href="../Kap-4/html.php#Kap4.8">Kapitel 4.8</a> (SPS Webserver Teil 1).
</article> </main>

<main>
<h3>zu Kapitel 5.8 (JSON-Datei über HTTP abrufen)</h3>
<hr>
<article> 
	<a href="zuKap5.8/zuKap5.8.php"><button type="button">
		<span>Quellcodes herunterladen</span>
	</button></a>
	<?php include ("/Layout/buttonAnleitung.php")?>
<p>Für Kapitel 5.8 stehen uns die Klassen <a href=#HTTP_GET_JSON.java><i>HTTP_GET_JSON</i></a>, <a href=#Student.java><i>Student</i></a> 
und <a href=#Leistung.java><i>Leistung</i></a> zur Verfügung. 
Sie ermöglichen uns, JSON-Daten per HTTP-GET-Anfrage von einem Server abzurufen und optisch ansprechend auf der Konsole auszugeben.</p>
<p>Zur Verwendung der Klasse <i>HTTP_GET_JSON</i> wird die Bibliothek <i>Gson</i> benötigt, welche Daten aus dem <code>InputStreamReader</code> heraus 
direkt in das JSON-Format umsetzen kann. Die Bibliothek ist unter  
<a href="zwischenseite.php?urlfwd=http://code.google.com/p/google-gson">http://code.google.com/p/google-gson</a> abrufbar. Alle benötigten Verweise sind bereits in der Klasse vorhanden. 
Abbildung 3.1 im Buch zeigt, wie die Bibliothek zu einem Eclipse-Projekt hinzugefügt werden kann.</p>
</article> </main>

<main>
<h3>zu den Übungsaufgaben (Webserver)</h3>
<hr>
<article> 
	<p>Die folgenden Beispielseiten mit unterschiedlichen Funktionalitäten dienen zum Testen der von uns programmierten HTTP-Clients.</p>
	
	<a href="../Kap-4/zuWebserver/example-1.php"><button type="button" class=grau>
		<span>Beispiel 1: Zufallszahl</span>
	</button></a><br>
	<a href="../Kap-4/zuWebserver/example-2.php"><button type="button" class=grau>
		<span>Beispiel 2: Verdopplung eines Eingabewertes (GET)</span>
	</button></a><br>
	<a href="../Kap-4/zuWebserver/example-3.php"><button type="button" class=grau>
		<span>Beispiel 3: Verdopplung eines Eingabewertes (POST)</span>
	</button></a><br>
	<a href="../Kap-4/zuWebserver/example-4.php?username=Hans&password=Wurscht"><button type="button" class=grau>
		<span>Beispiel 4: Zufallszahl mit Benutzername und Passwort per GET-Request</span>
	</button></a><br>
	<a href="../Kap-4/zuWebserver/login-form.php"><button type="button" class=grau>
		<span>Beispiel 5: Zufallszahl mit Login per POST-Request und Session-Cookie</span>
	</button></a><br>
</article> </main>

<main>
<h3>Vorschau der Java-Klassen zu Kapitel 5.6</h3>
<hr>
<article class="javacode">
<?php
require 'files/zuKap5.6-Files.php';
require_once '../../Formatter/meinPrettyfier.php';
meinPrettyfier($files)
?>
</article>
</main>

<main>
<h3>Vorschau der Java-Klasse zu Kapitel 5.7</h3>
<hr>
<article class="javacode">
<?php
require 'files/zuKap5.7-Files-Vorschau.php';
require_once '../../Formatter/meinPrettyfier.php';
meinPrettyfier($files)
?>
</article>
</main>

<main>
<h3>Vorschau der Java-Klassen zu Kapitel 5.8</h3>
<hr>
<article class="javacode">
<?php 
require 'files/zuKap5.8-Files.php';
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