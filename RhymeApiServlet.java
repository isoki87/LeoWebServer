import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RhymeApiServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("POST is called");
		System.out.println(req.getParameter("word"));
		String word = req.getParameter("word");
		String result = "";
		if ((word != null) && (word.length() != 0)) {
			StringConverter sc = new StringConverter();
			result = sc.convertStr(word);
		}
		System.out.println(result);
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println(result);
	}

}
