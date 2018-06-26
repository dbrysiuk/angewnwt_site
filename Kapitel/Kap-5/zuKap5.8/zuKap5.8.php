<?php
// Dateien, die gezippt werden sollen
require('../files/zuKap5.8-Files.php');

// Bibliothek zum Zippen
require_once('../../../Formatter/meinZipper.php');
require_once('../../../Formatter/meinPrettyfier.php');

//meinPrettyfier($files);
meinZipper('zuKap5.8.zip', $files);
?>
