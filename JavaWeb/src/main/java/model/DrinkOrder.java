package model;

import java.util.Map;

public class DrinkOrder {
	private String type;
	private String size;
	private boolean ice;
	private Integer price;
	
	private static final Map<String, Map<String, Integer>> priceTable = Map.of(
			"greenTea",Map.of("S", 30, "M", 50,"L", 50),
			"blackTea",Map.of("S", 45, "M", 55,"L", 65),
			"milkTea",Map.of("S", 40, "M", 45,"L", 60)
			);

	//有無冰塊對照表
	private static final Map<Boolean,String> iceTable = Map.of(true, "有加冰", false, "無加冰");
	
	
	
	public DrinkOrder(String type, String size, String ice) {
		this.type = type;
		this.size = size;
		this.ice = Boolean.parseBoolean(ice);
		this.price = priceTable.get(type).get(size);
	} 
	
	public String getInfo(){
		String iceText = iceTable.get(ice);
		return String.format("您點了一杯  %s （%s，%s)， 價格: %d 元",type,size,iceText,price);
	}

	public String getType() {
		return type;
	}

	public String getSize() {
		return size;
	}

	public boolean isIce() {
		return ice;
	}

	public Integer getPrice() {
		return price;
	}
}
