package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CoffeeOrder;

@WebServlet("/coffeeOrder")
public class coffeeOrederServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1.設定編碼
		resp.setCharacterEncoding("UTF-8"); 
		resp.setContentType("text/html;charset=UTF-8");
		//2.傳入參數
		String type = req.getParameter("type");
		String size = req.getParameter("size");
		String sugar = req.getParameter("sugar");
		
		if (type == null || size == null || sugar == null) {
			resp.getWriter().print("參數輸入不正確");
			return;
		}
		//進行商業邏輯
		CoffeeOrder Order = new CoffeeOrder(type,size,sugar);
		//resp.getWriter().print(Order.getInfo());
	
		//建立分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_order.jsp");
		req.setAttribute("coffeeOrder", Order);
		rd.forward(req, resp);
	}
}
