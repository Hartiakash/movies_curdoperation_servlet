package demo200;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class delete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mname=req.getParameter("mname");
		logics log=new logics();
		add_movie name=log.manager.find(add_movie.class, mname);
		log.transaction.begin();
		log.manager.remove(name);
		log.transaction.commit();
		resp.getWriter().print("<h1> movie is deleted</h1>");
		req.getRequestDispatcher("fetch.jsp").include(req, resp);
		
	}

}
