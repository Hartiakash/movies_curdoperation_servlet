package demo200;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/fetchallmovie")
public class fetchall extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logics lg=new logics();
		List<add_movie> movie=lg.manager.createQuery("select x from add_movie x").getResultList();
		
		if(movie.isEmpty())
		{
			resp.getWriter().print("<h1>no movies found</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		}else {
			req.setAttribute("movie", movie);
			req.getRequestDispatcher("fetch.jsp").include(req, resp);
		}
	}

}
