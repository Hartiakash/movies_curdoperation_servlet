package demo200;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.text.Document;
@WebServlet("/add_movie12")
@MultipartConfig
public class mainclass extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mname=req.getParameter("mname");
		String description=req.getParameter("textarea");
		Part p=req.getPart("mimage");
		InputStream i=p.getInputStream();
		byte[] arr=new byte[i.available()];
		i.read(arr);
		String mlanguage=req.getParameter("mlanguage");
		int mrating=Integer.parseInt(req.getParameter("mrating"));
		
		
		add_movie add=new add_movie();
		add.setMname(mname);
		add.setDescription(description);
		add.setMimage(arr);
		add.setMlanguage(mlanguage);
		add.setMrating(mrating);
		
		logics l=new logics();
		l.addMovie(add);
		resp.getWriter().print("<h1>data inserted</h1>");
		req.getRequestDispatcher("home.html").include(req, resp);
		
		
		
		
	}
	

}
