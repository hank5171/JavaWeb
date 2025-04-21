package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PhonePlan;

@WebServlet("/phone")
public class PhoneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/phone_form.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String phoneCall = req.getParameter("phoneCall");
		String phoneOnline = req.getParameter("phoneOnline");
		
		PhonePlan phonePlan = new PhonePlan(phoneCall, phoneOnline);
	
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/phone_result.jsp");
		req.setAttribute("phonePlan", phonePlan);
		rd.forward(req, resp);
	}
	
}
