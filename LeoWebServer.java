import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class LeoWebServer {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new FileServlet("/home.html")),"/");
        context.addServlet(new ServletHolder(new FileServlet("/rhyme.html")),"/rhyme");
        context.addServlet(new ServletHolder(new FileServlet("/sudoku.html")),"/sudoku");
        context.addServlet(new ServletHolder(new RhymeApiServlet()),"/rhymeapi");

		server.start();
		server.join();
	}
}