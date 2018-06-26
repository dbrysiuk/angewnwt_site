<?php
// Dateien, die gezippt werden sollen
require('../files/zuKap4.7-Files.php');

// Bibliothek zum Zippen
require_once('../../../Formatter/meinZipper.php');
require_once('../../../Formatter/meinPrettyfier.php');

//meinPrettyfier($files);
meinZipper('zuKap4.7.zip', $files);
?>
