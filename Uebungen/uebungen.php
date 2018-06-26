<?php
// Dateien, die gezippt werden sollen
require('files/uebungen-Files.php');

// Bibliothek zum Zippen
require_once('../Formatter/meinZipper.php');
require_once('../Formatter/meinPrettyfier.php');

//meinPrettyfier($files);
meinZipper('loesungsvorschlaege.zip', $files);
?>
