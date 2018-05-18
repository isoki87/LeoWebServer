import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.SudokuBoard;
import com.leo.SudokuSolver;

public class SudokuApiServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String diff = URLDecoder.decode(req.getParameter("difficulty"), "UTF-8");
		int[][] b
		if ((word != null) && (word.length() != 0)) {
			RhymeProvider rp = new RhymeProvider("WordBank.txt");
			rp.initialize();
			list = rp.findRhyme(word);
		}
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		for(int i = 0; i < list.size(); i++) {
			resp.getWriter().println(list.get(i) + "<br>");
		}
	}
}
