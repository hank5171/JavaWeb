package cart.dao;

import java.util.List;

import cart.model.entity.Order;
import cart.model.entity.OrderItem;

public interface OrderDAO {
	// 建立訂單主檔, 回傳訂單編號
	Integer addOder(Integer userId);
	// 建立訂單項目(訂單明細檔)
	void addOrderItem(Integer orderId, Integer productId, Integer quantity);
	
	// 查詢使用者訂單
	List<Order> findAllOrdersByUserId(Integer userId);
	// 查詢Order明細
	List<OrderItem> findAllItemsByOrderId(Integer orderId);
	
	
}
