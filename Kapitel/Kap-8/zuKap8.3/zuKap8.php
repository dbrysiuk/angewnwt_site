<?php
// Dateien, die gezippt werden sollen
require('../files/zuKap8-Files.php');

// Bibliothek zum Zippen
require_once('../../../Formatter/meinZipper.php');
require_once('../../../Formatter/meinPrettyfier.php');

//meinPrettyfier($files);
meinZipper('zuKap8.3.zip', $files);
?>
