import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogServlet extends HttpServlet {
	
	HashMap<String, String> userbase = new HashMap<String, String>(); 
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter(); 
		String username = req.getParameter("usr"); 
		String password = req.getParameter("pass"); 
		
		userbase.put("barohit", "Password123"); 
		if (userbase.containsKey(username)) {
			if (userbase.get(username).equals(password)) {
				out.println("Congratulations, you have logged in!");
			} else {
				out.println("Sorry, this password is incorrect"); 
			}
		} else {
			out.println("Sorry, this user does not exist"); 
		}
		RequestDispatcher rd = req.getRequestDispatcher("Validate.jsp"); 
		rd.forward(req, res); // so this is just like forwarding to another servlet. 
	}

}
