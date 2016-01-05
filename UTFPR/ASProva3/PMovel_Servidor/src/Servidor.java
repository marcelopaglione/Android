import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

/*
 * Marcelo Ortiz Paglione Junior
 * RA: 1256300
 */

public class Servidor {
	public static void main(String[] args) {
		try {
			HttpServer server = HttpServerFactory.create("http://localhost:4000/");
			server.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
