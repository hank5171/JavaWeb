package comtroller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.OrderDTO;
import model.dto.ProductDTO;
import service.OrderService;
import service.ProductService;

@WebServlet("/order/update")
public class OrderUpdateServlet extends HttpServlet{

	private OrderService orderService = new OrderService();
	private ProductService productService = new ProductService();
	// 根據 index 呈現修改表單

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductDTO> productDTOs = productService.findAll();
		String index = req.getParameter("index");
		// 重導到指定的jsp 並帶上 index
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/update.jsp");
		req.setAttribute("index", index);
		req.setAttribute("productDTOs", productDTOs);
		rd.forward(req, resp);
	}
	/*	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    List<ProductDTO> productDTOs = productService.findAll();
	    String index = req.getParameter("index");
	    
	    // 獲取當前訂單信息
	    OrderDTO currentOrder = orderService.findByIndex(Integer.parseInt(index));
	    String currentItem = currentOrder.getItem(); // 假設OrderDTO有getItem方法
	    
	    // 設置相關屬性
	    req.setAttribute("index", index);
	    req.setAttribute("currentItem", currentItem);  // 添加這行，傳遞當前商品名稱
	    req.setAttribute("productDTOs", productDTOs);
	    
	    // 重導到指定的jsp
	    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/update.jsp");
	    rd.forward(req, resp);
	}
*/	
	
	
	// 修改表單
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String index = req.getParameter("index");
		String item = req.getParameter("item");
		OrderDTO orderDTO = orderService.updateOrder((Integer.parseInt(index)), item);
		
		//重導到指定jsp 並戴上歷史反饋資料(OrderDTO)
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/result.jsp");
		req.setAttribute("orderDTO", orderDTO);
		rd.forward(req, resp);
	}
}
