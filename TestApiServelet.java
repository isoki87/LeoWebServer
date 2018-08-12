package com.leo.servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * OBJECTIVE 1: GET, hardcode APIKey into the variable to return
 * This will make sure my servlet is working
 * 
 * OBJECTIVE 2: GET, find the APIKey from the folder, return APIKey
 * This will make sure I can properly hide my APIKey, and that I can access the files in the ROOT folder
 * 
 * OBJECTIVE 3: POST, this api take the JSON from frontend and return it with an API key as part of its parameters
 * This will ensure I can generate a JSON that's ready to be passed to Google's API 
 * https://stackoverflow.com/questions/1413129/modify-request-parameter-with-servlet-filter
 * 
 * OBJECTIVE 4: POST, this api will perform OBJ 3, pass it to a second API, which will pass back the expected return JSON if key parameters matches my key to the first api,
 *              first api will then pass this object to my frontend
 * The second api is a mock Google Cloud API, the second api will first be called individually to make sure it works and its response is valid, this objective ensures that
 * I can properly dispatch a POST method from my imageapi, since my api key has to be wrapped in the backend 
 * https://stackoverflow.com/questions/32225246/send-post-request-within-the-processrequest-method-of-a-servlet
 * 
 * OBJECTIVE 5: Get a successful 200 status from Google Cloud API, showing the expected responses for sample image
 */
@WebServlet("/testapi")
public class TestApiServelet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, FileNotFoundException, IOException{
		String APIKey = getAPIKey();
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(APIKey);
	}
	
	private String getAPIKey() throws IOException, FileNotFoundException {
		String keyPath = "../resources/CloudVisionAPI/CloudVisionAPIKey.txt";
		FileReader fr = new FileReader(keyPath);
		BufferedReader r = new BufferedReader(fr);
		String APIKey = r.readLine();		
		r.close();
		fr.close();
		return APIKey;
	}

}
