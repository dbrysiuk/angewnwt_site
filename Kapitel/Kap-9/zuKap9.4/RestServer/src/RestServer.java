package restServer;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class RestServer
{
	/*
	 * JAX-RS ist in Java SE (Standard  Edition) NICHT enthalten, sondern nur in Java EE (Enterprise Edition).
	 * Als Referenzimplementierung wird hier Jersey eingesetzt.
	 * 
	 * Zusaetzlich wird ein einfacher Webserver benoetigt (in diesen Beispiel: Grizzly)
	 * 
	 * URLs zu den Biblioteken:
	 * - https://jersey.github.io/
	 * - https://javaee.github.io/grizzly/
	 */

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		String baseUrl = "http://localhost:4434";

		// Webserver erzeugen und mit unserem Service verbinden
		final HttpServer webServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUrl),
				new ResourceConfig(VerwaltungService.class), false);

		// Methode zum Beenden des Webservers beim Beenden des Java-Programms bei der Java-Runtime registrieren 
		Runtime.getRuntime().addShutdownHook(
				new Thread(new Runnable() {
					@Override
					public void run() {
						webServer.shutdownNow();
					}
				}));

		// Webserver starten
		webServer.start();

		System.out.println(String.format(
				"\nGrizzly-HTTP-Server gestartet mit der URL: %s\n"
						+ "Stoppen des Grizzly-HTTP-Servers mit:      Strg+C\n",
						baseUrl + VerwaltungService.webContextPath));

		// Warten bis das Java-Programm beendet wird (durch Ctrl-C)
		Thread.currentThread().join();
	}
}
