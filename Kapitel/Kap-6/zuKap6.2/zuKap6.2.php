<?php
// Dateien, die gezippt werden sollen
require('../files/zuKap6.2-Files.php');

// Bibliothek zum Zippen
require_once('../../../Formatter/meinZipper.php');
require_once('../../../Formatter/meinPrettyfier.php');

//meinPrettyfier($files);
meinZipper('zuKap6.2.zip', $files);
?>