package model.enitity;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	private String item; //餐點
	private Integer price; // 價格
	
	//private static final Map<String, Integer> PRICE_MAP = Map.of("牛肉麵", 150, "陽春麵", 60, "番茄麵", 100);
	
}




