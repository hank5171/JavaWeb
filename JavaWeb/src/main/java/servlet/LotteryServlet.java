package servlet;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lottery")
public class LotteryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 生成樂透號嗎
		Random rs = new Random(); //隨機數物件
		Set<Integer> numbers = new LinkedHashSet<>(); //放樂透號碼的容器
		while (numbers.size() < 5) {
			int number = rs.nextInt(39) + 1;
			numbers.add(number);
		}
		// 透過 resp 將資料顯示在瀏覽器
		//resp.getWriter().print(numbers);
		// 2. 生成調度氣(分派器)
		RequestDispatcher rd = req.getRequestDispatcher("/lottery2.jsp");
		// 3. 傳遞樂透號嗎
		req.setAttribute("numbers", numbers); // 裝配要傳遞的內容
		rd.forward(req, resp);

		
	}
}
