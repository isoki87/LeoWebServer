import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class SudokuHandler extends ServletContextHandler{
	
	
	@Override
    public void doHandle( String target,
                        Request baseRequest,
                        HttpServletRequest request,
                        HttpServletResponse response ) throws IOException,
                                                      ServletException {
		if(target.equals("/sudoku")){
			response.setContentType("text/html; charset=utf-8");
		    response.setStatus(HttpServletResponse.SC_OK);
		    BufferedReader reader = new BufferedReader(new FileReader("HTML_Resources/sudoku.html"));
	        String line;
	        while((line = reader.readLine()) != null){
	        	response.getWriter().println(line);
	        }
	        reader.close();
		    baseRequest.setHandled(true);
		} 
    }
}
