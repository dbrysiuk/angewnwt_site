<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link href="../../Layout/CSS/style.css" type="text/css" rel="stylesheet">
<link href="../../Layout/CSS/prettify.css" type="text/css" rel="stylesheet">
<script src="../../Script/prettify.js" type="text/javascript"></script>
<!-- Quelle: https://github.com/google/code-prettify -->
<meta charset="ISO-8859-1">
<title>Kapitel 4: HTML</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("../../Layout/header.php");
include ("../../Layout/navigation.php");
?>

<body id="html" onload="prettyPrint()">
<main>
<h3>zu Kapitel 4.7 (Wireshark-Beispiel)</h3>
<hr>
<article> <a href="zuKap4.7/zuKap4.7.php"><button type="button">
		<span>Wireshark-Aufzeichnung herunterladen</span>
	</button></a>
<p>Im diesem ZIP-Archiv befindet sich die Wireshark-Aufzeichnung zu Kapitel 4.7 mit der Kommunikation zwischen Webbrowser und 
Webserver beim Aufruf einer Webseite.</p>
</article> </main>

<main id="Kap4.8">
<h3>zu Kapitel 4.8 (SPS Webserver Teil 1)</h3>
<hr>
<article> <a href="../Kap-5/zuKap5.7/zuKap5.7.php"><button type="button">
		<span>Begleitmaterial herunterladen</span>
	</button></a>
	<?php include ("../../Layout/buttonAnleitung.php")?>
<p>Das Begleitmaterial zu Kapitel 4.8 umfasst das Java-Programm <a href=#SiemensAnmeldungAbruf.java>SiemensAnmeldungAbruf</a> für den Zugriff auf den Webserver einer SPS, sowie 
die HTML-Dokumente <i>Zaehler.html</i>, über welches sich der Zählerstand setzen und ändern lässt und <i>Zaehlerzusatz.html</i>, in welchem der Zählerstand steht.</p>
<p>Der Ablauf des Programms beginnt mit der Übermittlung von Benutzername und Passwort mittels einer POST-Anfrage, anschließend wird das Dokument <i>Zaehlerzusatz.html</i> vom Webserver abgerufen und der Zählerstand extrahiert.</p>
<p>Desweiteren befindet sich zur Ergänzung im ZIP-Archiv die Wireshark-Aufzeichnung  der Kommunikation mit dem SPS-Webserver und das SPS-Projekt <i>1513_Buch_Plenk_2_WWW.zap13</i>, welches eine Variable 
im Sekundentakt hochzählt. Das Dokument <i>Zaehlerzusatz.html</i> aktualisiert sich ebenfalls sekündlich und zeigt daher immer den aktuellen Zählerstand an.</p>
<p>Der Inhalt dieses ZIP-Archivs zu ist identisch mit dem von <a href="../Kap-5/http.php#Kap5.7">Kapitel 5.7</a> (SPS Webserver Teil 2).
</article> </main>

<main>
<h3>zu den Übungsaufgaben (Webserver)</h3>
<hr>
<article> 
	<p>Die folgenden Beispielseiten mit unterschiedlichen Funktionalitäten dienen zur Beobachtung und Verfolgung einer Datenübertragung zwischen Server und Webbrowser.</p>
	
	<a href="zuWebserver/example-1.php"><button type="button" class=grau>
		<span>Beispiel 1: Zufallszahl</span>
	</button></a><br>
	<a href="zuWebserver/example-2.php"><button type="button" class=grau>
		<span>Beispiel 2: Verdopplung eines Eingabewertes (GET)</span>
	</button></a><br>
	<a href="zuWebserver/example-3.php"><button type="button" class=grau>
		<span>Beispiel 3: Verdopplung eines Eingabewertes (POST)</span>
	</button></a><br>
	<a href="zuWebserver/example-4.php?username=Hans&password=Wurscht"><button type="button" class=grau>
		<span>Beispiel 4: Zufallszahl mit Benutzername und Passwort per GET-Request</span>
	</button></a><br>
	<a href="zuWebserver/login-form.php"><button type="button" class=grau>
		<span>Beispiel 5: Zufallszahl mit Login per POST-Request und Session-Cookie</span>
	</button></a><br>
</article> </main>

<main>
<h3>Vorschau der Java-Klasse zu Kapitel 4.8</h3>
<hr>
<article class="javacode">
<?php
require '../Kap-5/files/zuKap5.7-Files-Vorschau.php';
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