package com.leo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.sudoku.SudokuBoard;
import com.leo.sudoku.SudokuGenerator;

/**
 * Servlet implementation class Sudoku
 */
@WebServlet("/sudokuapi")
public class SudokuApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SudokuBoard board = new SudokuBoard();
		SudokuGenerator sudGen = new SudokuGenerator();
		sudGen.populateBoard(board);
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				response.getWriter().print(board.check(i, j));
			}
		}
	}
}
