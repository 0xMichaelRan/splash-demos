import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		String[] lines = userinput.split(System.getProperty("line.separator"));
		
		// first input is boardDimension
		String[] dimensionArray = lines[0].split(" ");
		Pair boardDimension = new Pair(Integer.parseInt(dimensionArray[0].trim()), Integer.parseInt(dimensionArray[1].trim()));
		
		// second input is initialPosition 
		String[] initPositionArray = lines[1].split(" ");
		Pair initialPosition = new Pair(Integer.parseInt(initPositionArray[0].trim()), Integer.parseInt(initPositionArray[1].trim()));
		 
		// third input is movementString
		String movementString = lines[2].trim().toUpperCase();
		
		// final input is list of walls as pairs
		List<Pair> walls = new ArrayList<Pair>();
		for (int i = 3; i < lines.length; i++) {
			String[] wallLocationArray = lines[i].split(" ");
			Pair wallLocation = new Pair(Integer.parseInt(wallLocationArray[0].trim()), Integer.parseInt(wallLocationArray[1].trim()));
			walls.add(wallLocation);
		}
		
		Solution ins = new Solution(boardDimension, initialPosition, movementString, walls);
		
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
				+ ins.getFinalLocation().x + " " + ins.getFinalLocation().y
				+ "</p> \n" 
				+ "<p>"
				+ ins.getTotalCoinsCollected()
				+ "</p> \n" 
				+ "</body> \n" + "</html>");
	}
	
}
