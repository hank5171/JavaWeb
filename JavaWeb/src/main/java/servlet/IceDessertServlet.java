package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Guestbook;
import model.IceDessert;

@WebServlet("/ice")
public class IceDessertServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/ice_dessert_form.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mainDish = req.getParameter("mainDish");
		String[] toppings = req.getParameterValues("toppings");
		
		IceDessert iceDessert = new IceDessert(mainDish, toppings);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/ice_dessert_result.jsp");
		req.setAttribute("iceDessert", iceDessert);
		rd.forward(req, resp);
	}
	
}



