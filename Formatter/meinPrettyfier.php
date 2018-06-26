<?php
function meinPrettyfier($FileArray) {
	
	// loop through each file
	foreach ( $FileArray as $file ) {
	
		//  file lesen
		$print_file = file_get_contents ( $file );
	
		// Ueberschrift ausgeben
		print '<h4 id=';
		print basename($file );
		print '>';
		print basename($file );
		print '</h4>';
				
		// Datei ausgeben		
		print '<pre class="prettyprint">';
		print $print_file;
		print '</pre>';
	}
}
?>
