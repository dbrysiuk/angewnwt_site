<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link rel="stylesheet" href="../Layout/CSS/style.css">
<meta charset="ISO-8859-1">
<title>Quellcodes importieren</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("../Layout/header.php");
include ("../Layout/navigation.php");
?>

<body id="quellcodesImport">
<main>
<h3>Anleitung: Quellcodes in Eclipse importieren</h3>
<hr>
<article> 
<p>Nachdem Sie ein ZIP-Archiv mit Quellcodes heruntergeladen haben, entpacken Sie es an einen Ort Ihrer Wahl.</p>
<p>Stellen Sie vor dem Importieren sicher, dass in Eclipse ein Java Projekt angelegt ist, in welchem die gewünschten Klassen abgelegt
werden können. Um ein neues Java Projekt anzulegen, wählen Sie <b>File</b> -> <b>New</b> -> <b>Java Projekt</b>. Vergeben Sie einen aussagekräftigen Namen und klicken Sie
auf <b>Finish</b>.</p>

<p> Steht ein entsprechendes Projekt zur Verfügung, öffnen Sie in Eclipse den Importdialog über <b>File</b> -> <b>Import</b>, 
wählen Sie unter der der Kategorie <b>General</b> 
den Punkt <b>File System</b> aus und klicken Sie auf <b>Next ></b>.
</p>

<br>
<figure>
<a href=../Images/Import1.png><img src="../Images/Import1.png" alt="Importdialog" class="small"></a>
<figcaption>Zu importierende Ressource wählen</figcaption>
</figure>
<br>

<p>Klinken Sie hinter <b>From directory:</b> auf <b>Browse...</b>. Navigieren Sie nun zu dem <i>entpackten</i> Ordner, 
markieren Sie ihn und klicken Sie auf <b>Öffnen</b>.
</p>

<br>
<figure>
<a href=../Images/Import2.png><img src="../Images/Import2.png" alt="Entpackten Ordner auswählen" class="medium"></a>
<figcaption>Entpackten Ordner als Quellverzeichnis festlegen</figcaption>
</figure>
<br>

<p>Im Rechten der beiden Felder unter dem Quellverzeichnis sehen Sie nun alle sich in dem Ordner befindlichen Quellcodes.
Markieren Sie die, die Sie importieren wollen, mit einem Haken.
</p>

<br>
<figure>
<a href=../Images/Import3.png><img src="../Images/Import3.png" alt="Quellcodes auswählen" class="large"></a>
<figcaption>Gewünschte Quellcodes auswählen</figcaption>
</figure>
<br>

<p> Bei <b>Into folder:</b> wählen Sie nun das Zielverzeichnis für die Quellcodes in Ihrem aktuellen Workspace aus. Klicken Sie dazu wieder
auf <b>Browse...</b>. Sie sehen nun eine Liste der Java Projekte in Ihrem Workspace. Klicken Sie auf den Pfeil neben dem Projekt, in 
welches Sie die Quellcodes importieren möchten und wählen Sie den Ordner <b>src</b> aus.
</p>

<br>
<figure>
<a href=../Images/Import4.png><img src="../Images/Import4.png" alt="Zielverzeichnis wählen" class="extrasmall"></a>
<figcaption>Zielprojekt definieren</figcaption>
</figure>
<br>


<p>Klicken Sie auf <b>Finish</b>. Die Quellcodes sind nun erfolgreich in Eclipse importiert und können verwendet werden.</p>
</article> </main></body>

<?php 
include ("../Layout/footer.php");
?>
</html>