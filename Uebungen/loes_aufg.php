<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link href="../Layout/CSS/style.css" type="text/css" rel="stylesheet">
<link href="../Layout/CSS/prettify.css" type="text/css" rel="stylesheet">
<script src="../Script/prettify.js" type="text/javascript"></script>
<!-- Quelle: https://github.com/google/code-prettify -->
<meta charset="ISO-8859-1">
<title>Lösungen Übungsaufgaben</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("/Layout/header.php");
include ("/Layout/navigation.php");
?>

<body id="loes" onload="prettyPrint()">
<main>
<h3>Lösungsvorschläge zu Übungsaufgaben</h3>
<hr>
<article> 
<a href="uebungen.php"><button type="button">
		<span>Lösungsvorschläge herunterladen</span>
</button></a>
<?php include("/Layout/buttonAnleitung.php") ?>
<p>Das ZIP-Archiv beinhaltet Lösungsvorschläge zu den Übungsaufgaben im Buch in Form von <b>Java-Quellcodes</b> und <b>Wireshark-Aufzeichnungen</b>.</p>

<p>Im Folgenden finden Sie zudem eine Vorschau, der enthalteten Quellcodes:</p>

<table>
  <tr>
    <th>Kapitel 2</th>
    <th>Kapitel 3</th>
    <th>Kapitel 5</th>
    <th>Kapitel 7</th>
    <th>Kapitel 8</th>
    <th>Kapitel 9</th>
  </tr>
  <tr>
    <td><a href=#Loes_Aufg_2_1.java><button type="button" class="sitelinks"><span>Loes_Aufg_2_1</span></button></a><br></td>
    <td><a href=#Loes_Aufg_3_1.java><button type="button" class="sitelinks"><span>Loes_Aufg_3_1</span></button></a><br></td>
    <td><a href=#Loes_Aufg_5_1.java><button type="button" class="sitelinks"><span>Loes_Aufg_5_1</span></button></a><br></td>
    <td><a href=#Loes_Aufg_7_1Client.java><button type="button" class="sitelinks"><span>Loes_Aufg_7_1Client</span></button></a><br></td>
 	<td><a href=#Loes_Aufg_8_1.java><button type="button" class="sitelinks"><span>Loes_Aufg_8_1</span></button></a><br></td>

    <td><a href=#><button type="button" class="sitelinks"><span>Loes_Aufg_9_1</span></button></a><br></td>
  </tr>
  <tr>
 	 <td><a href=#Loes_Aufg_2_2.java><button type="button" class="sitelinks"><span>Loes_Aufg_2_2</span></button></a><br></td>
 	 <td></td>
 	 <td><a href=#Loes_Aufg_5_2a.java><button type="button" class="sitelinks"><span>Loes_Aufg_5_2a</span></button></a><br></td>
 	 <td><a href=#Loes_Aufg_7_1Server.java><button type="button" class="sitelinks"><span>Loes_Aufg_7_1Server</span></button></a><br></td>
 	 <td><a href=#Loes_Aufg_8_2.java><button type="button" class="sitelinks"><span>Loes_Aufg_8_2</span></button></a><br></td>
  </tr>
  <tr>
  	 <td><a href=#Loes_Aufg_2_3a.java><button type="button" class="sitelinks"><span>Loes_Aufg_2_3a</span></button></a><br></td>
  	 <td></td>
  	 <td><a href=#Loes_Aufg_5_2b.java><button type="button" class="sitelinks"><span>Loes_Aufg_5_2b</span></button></a><br></td>
  	 <td><a href=#Loes_Aufg_7_2Client.java><button type="button" class="sitelinks"><span>Loes_Aufg_7_2Client</span></button></a><br></td>
  </tr>
  <tr>
  	 <td><a href=#Loes_Aufg_2_3b.java><button type="button" class="sitelinks"><span>Loes_Aufg_2_3b</span></button></a><br></td>
  	 <td></td>
  	 <td><a href=#Loes_Aufg_5_3.java><button type="button" class="sitelinks"><span>Loes_Aufg_5_3</span></button></a><br></td>
  	 <td><a href=#Loes_Aufg_7_2Server.java><button type="button" class="sitelinks"><span>Loes_Aufg_7_2Server</span></button></a><br></td>
  </tr>
  <tr>
  	 <td><a href=#Loes_Aufg_2_4.java><button type="button" class="sitelinks"><span>Loes_Aufg_2_4</span></button></a><br></td>
  </tr>
  <tr>
  	 <td><a href=#Loes_Aufg_2_5.java><button type="button" class="sitelinks"><span>Loes_Aufg_2_5</span></button></a><br></td>
  </tr>
</table>
</article> 
</main>

<main>
<h3>Vorschau der Java-Klassen in den Lösungsvorschlägen</h3>
<hr>
<section class="javacode">
<?php
require 'files/uebungen-Files-Vorschau.php';
require_once '../Formatter/meinPrettyfier.php';
meinPrettyfier($files)
?>
</section>
</main>
</body>

<?php 
include ("/Layout/footer.php");
?>
</html>