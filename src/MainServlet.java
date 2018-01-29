import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = -6225874209073502177L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userinput = request.getParameter("userinput");
		String username = request.getParameter("username");
		
		String useroutput = "1234";
		PrintWriter out = response.getWriter();
		out.println("<html> \n" 
				+ "<head> \n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n"
				+ "<title>JSP response page</title> \n" 
				+ "</head> \n" 
				+ "<body> \n" 
				+ "<h1> Hello, "
				+ username
				+ "</h1> \n"
				+ "<h2>Your input is</h2>"
				+ "<p>"
				+ userinput
				+ "</p> \n"
				+ "<h2>Output is</h2>"
				+ "<p>"
				+ useroutput
				+ "</p> \n" 
				+ "</body> \n" + "</html>");
	}
}
