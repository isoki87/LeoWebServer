import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FileServlet extends HttpServlet {

	final String path;
	public FileServlet(String path) {
		this.path = path;
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		BufferedReader reader = new BufferedReader(new FileReader("HTML_Resources" + path));
		String line;
		while ((line = reader.readLine()) != null) {
			response.getWriter().println(line);
		}
		reader.close();
	}
}
