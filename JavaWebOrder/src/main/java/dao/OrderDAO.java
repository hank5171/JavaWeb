package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.enitity.Order;

public class OrderDAO {
	
	//利用 List 來模擬資料庫 (稱為:InMemoryDatabase)
	private static List<Order> orders = new CopyOnWriteArrayList<>(); 
		
	public void save(Order order) {
		orders.add(order); 
	}
	
	// 取得所有歷史資料
	public List<Order> findAll(){
		return orders;
	}
	
	// 刪除一筆資料
	public void remove(int index) {
		orders.remove(index);
	}
	
	// 修改一筆資料
	public void update(int index, Order newOrder) {
		orders.set(index, newOrder);
	}
	
	// 取得單筆資料
	public Order getOrder(int index) {
		return orders.get(index);
	}
}
