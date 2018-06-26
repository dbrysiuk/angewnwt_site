<!DOCTYPE html>
<html lang="de">
<head>
<link href="../../Layout/CSS/style.css" type="text/css" rel="stylesheet">
<link href="../../Layout/CSS/prettify.css" type="text/css" rel="stylesheet">
<script src="../../Script/prettify.js" type="text/javascript"></script>
<!-- Quelle: https://github.com/google/code-prettify -->
<meta charset="UTF-8">
<title>Kapitel 9: Web Services</title>
<meta content="Dennis Brysiuk" name="author">
</head>

<?php
include ("/Layout/header.php");
include ("/Layout/navigation.php");
?>

<body id="webservices" onload="prettyPrint()">

<main>
    <h3>zu Kapitel 9.2 (SOAP Service)</h3>
    <hr>
    <article> <a href="zuKap9.2/zuKap9.2.php"><button type="button">
        		<span>Quellcodes herunterladen</span>
	    </button></a>
	<?php include ("/Layout/buttonAnleitung.php")?>
<p>Für Kapitel 9.2 ...</p>
</article> </main>

<main>
    <h3>zu Kapitel 9.4 (RESTful Service)</h3>
    <hr>
    <article> <a href="zuKap9.4/zuKap9.4.php"><button type="button">
                <span>Quellcodes herunterladen</span>
            </button></a>
        <?php include ("/Layout/buttonAnleitung.php")?>
        <p>Für Kapitel 9.4 ...</p>
    </article> </main>

<main>
    <h3>zu Kapitel 9.4.2 (RESTful Service HTML)</h3>
    <hr>
    <article> <a href="zuKap9.4.2/zuKap9.4.2.php"><button type="button">
                <span>Quellcodes herunterladen</span>
            </button></a>
        <?php include ("/Layout/buttonAnleitung.php")?>
        <p>Für Kapitel 9.4.2 ...</p>
    </article> </main>

<main>
    <h3>zu Kapitel 9.5 (Eigenbau)</h3>
    <hr>
    <article> <a href="zuKap9.5/zuKap9.5.php"><button type="button">
                <span>Quellcodes herunterladen</span>
            </button></a>
        <?php include ("/Layout/buttonAnleitung.php")?>
        <p>Für Kapitel 9.5 ...</p>
    </article> </main>

<main id="9.2">
<h3>Vorschau der Java-Klassen zu Kapitel 9.2</h3>
<hr>
<article class="javacode">
<?php
require 'files/zuKap9.2-Files-Vorschau.php';
require_once '../../Formatter/meinPrettyfier.php';
meinPrettyfier($files)
?>
</article>
</main>

<main id="9.4">
    <h3>Vorschau der Java-Klassen zu Kapitel 9.4</h3>
    <hr>
    <article class="javacode">
        <?php
        require 'files/zuKap9.4-Files-Vorschau.php';
        require_once '../../Formatter/meinPrettyfier.php';
        meinPrettyfier($files)
        ?>
    </article>
</main>

<main id="9.4.2">
    <h3>Vorschau der Java-Klassen zu Kapitel 9.4.2</h3>
    <hr>
    <article class="javacode">
        <?php
        require 'files/zuKap9.4.2-Files-Vorschau.php';
        require_once '../../Formatter/meinPrettyfier.php';
        meinPrettyfier($files)
        ?>
    </article>
</main>

<main id="9.5">
    <h3>Vorschau der Java-Klassen zu Kapitel 9.5</h3>
    <hr>
    <article class="javacode">
        <?php
        require 'files/zuKap9.5-Files-Vorschau.php';
        require_once '../../Formatter/meinPrettyfier.php';
        meinPrettyfier($files)
        ?>
    </article>
</main>

</body>

<?php
include ("/Layout/footer.php");
?>