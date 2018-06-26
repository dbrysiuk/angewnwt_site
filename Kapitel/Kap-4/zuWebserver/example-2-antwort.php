<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="de">
<head>
<link rel="stylesheet" href="../../../Layout/CSS/style.css">
<meta charset="ISO-8859-1">
<title>Webserver Beispiel 2</title>
<meta content="Philipp Schmalz" name="author">
</head>

<?php
include ("../../../Layout/header.php");
include ("../../../Layout/navigation.php");
?>

<body id="http">
<main>
<h3>Plenk'sches Beispiel 2 GET: Output</h3>
<hr>
<article>
<p>
Sie schickten dem Server die Zahl 
<?php echo $_GET["clientInput"]; ?> 
und der Server verdoppelt diese Zahl:
<?php 
$input = $_GET["clientInput"]; 
$output = 2 * $input;
echo $output;
?>
</p>
</article>
</main>
</body>

<?php 
include ("../../../Layout/footer.php");
?>
</html>