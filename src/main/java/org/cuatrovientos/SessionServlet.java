package org.cuatrovientos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1: Get the Session object
		  boolean create = true;         
	      HttpSession session = request.getSession(create);
	 
	   // Step 2: Get the session data value
	      Integer ival = (Integer)              
	      session.getAttribute ("sessiontest.counter");         
	      if (ival == null) ival = new Integer (1);         
	      else ival = new Integer (ival.intValue () + 1);           
	      session.setAttribute ("sessiontest.counter", ival);       

	   // Step 3: Output the page
	      response.setContentType("text/html"); 
	      PrintWriter out = response.getWriter(); 
	      out.println("<html>");  
	      out.println("<head><title>Session Tracking Test</title></head>");
	      out.println("<body>");
	      out.println("<h1>Session Tracking Test</h1>");
	      out.println ("You have hit this page " + ival + " times" + "<br>");
	      out.println ("Your " + request.getHeader("Cookie"));
	      out.println("</body></html>");    
	   }		

}
