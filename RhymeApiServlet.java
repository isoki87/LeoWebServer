package com.leo.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.rhyme.RhymeProvider;

/**
 * Servlet implementation class RhymeApiServlet
 */
@WebServlet("/rhymeapi")
public class RhymeApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = URLDecoder.decode(request.getParameter("word"), "UTF-8");
	  //System.out.println(new File(".").getAbsoluteFile());
		ArrayList<String> list = new ArrayList<>();
		if ((word != null) && (word.length() != 0)) {
			RhymeProvider rp = new RhymeProvider("../resources/RhymeBank/WordBank.txt");
			rp.initialize();
			list = rp.findRhyme(word);
		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		for(int i = 0; i < list.size(); i++) {
			response.getWriter().println(list.get(i) + "<br>");
		}
	}

}
