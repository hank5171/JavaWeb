package model.NewIce;

import java.util.List;
import java.util.Map;

//主餐
public class NewMainDish {
	
	private String name ; //主餐名稱
	private int price; //價格
	//價目表
	private static final Map<String, Integer> PRICE_MAP = Map.of("剉冰", 50, "豆花", 40);
	
	public NewMainDish(String name) {
		this.name = name;
		this.price = PRICE_MAP.get(name);
	}

	public String getName() {
		return name ;
	}

	public int getPrice() {
		return price;
	}
}
