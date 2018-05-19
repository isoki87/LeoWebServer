import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.sudoku.SudokuBoard;
import com.leo.sudoku.SudokuGenerator;


@SuppressWarnings("serial")
public class SudokuApiServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		SudokuBoard board = new SudokuBoard();
		SudokuGenerator sudGen = new SudokuGenerator();
		sudGen.populateBoard(board);
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				resp.getWriter().print(board.check(i, j));
			}
		}
	}
}
