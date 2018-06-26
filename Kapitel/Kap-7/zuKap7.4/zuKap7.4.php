<?php
// Dateien, die gezippt werden sollen
require('../files/zuKap7.4-Files.php');

// Bibliothek zum Zippen
require_once('../../../Formatter/meinZipper.php');
require_once('../../../Formatter/meinPrettyfier.php');

//meinPrettyfier($files);
meinZipper('zuKap7.4.zip', $files);
?>
