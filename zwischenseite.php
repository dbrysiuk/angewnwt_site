<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link rel="stylesheet" href="Layout/CSS/style.css">
<meta charset="ISO-8859-1">
<title>Auf Wiedersehen!</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("Layout/header.php");
include ("Layout/navigation.php");
?>

<body id="zwischenseite">
<main>
<h3>Sie verlassen das offizielle Angebot der Hochschule Hof.</h3>
<hr>
<article>
<p>Bitte klicken Sie auf den folgenden Verweis um die von Ihnen gewünschten Inhalte anzuzeigen:</p>

<?php
echo "<a href=", $_GET['urlfwd']," target=_blank>", $_GET['urlfwd'], "</a>";
?>

</article> </main></body>

<?php 
include ("Layout/footer.php");
?>
</html>