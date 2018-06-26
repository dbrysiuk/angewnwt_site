<?php
// Dateien, die gezippt werden sollen
require('../files/zuKap9.5-Files.php');

// Bibliothek zum Zippen
require_once('../../../Formatter/meinZipper.php');
require_once('../../../Formatter/meinPrettyfier.php');

//meinPrettyfier($files);
meinZipper('zuKap9.5.zip', $files);
?>