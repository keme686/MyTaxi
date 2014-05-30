package prova.server;

import java.io.IOException;

import javax.ws.rs.Path;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

/**
 * 
 * @author kemele
 *
 */
@Path("/rest")
public class StandaloneServer
{
	
	/**
	 *  storage.local server
	 *  
	 * @param args
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
    public static void main(String[] args) throws IllegalArgumentException, IOException
    {
    	String protocol = "http://";
        String port = ":5900/";
        String hostname ="localhost"; //"127.0.0.1";// InetAddress.getLocalHost().getHostAddress();
      //  if (hostname.equals("127.0.0.1")) {
       //     hostname = "localhost";
        //}
        String baseUrl = protocol + hostname + port;
        final HttpServer server = HttpServerFactory.create(baseUrl);
        server.start();
        System.out.println("Server is listening on: " + baseUrl + "\n [kill the process to exit]");
        System.out.println("DATA STORAGE SERVER:");
    }
}
