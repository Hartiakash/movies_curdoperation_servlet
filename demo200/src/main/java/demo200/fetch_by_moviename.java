package demo200;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fetchbymname")
public class fetch_by_moviename extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mname=req.getParameter("mname");
		logics l=new logics();
		add_movie a=l.fetchStudent(mname);
		resp.getWriter().print("<h1>moviename : "+a.getMname()+"</h1>");
		resp.getWriter().print("<h1>Description : "+a.getDescription()+"</h1>");
		
		resp.getWriter().print("<h1>Language : "+a.getMlanguage()+"</h1>");
		resp.getWriter().print("<h1>Rating : "+a.getMrating()+"</h1>");
		req.getRequestDispatcher("home.html").include(req, resp);
		
	}

}
