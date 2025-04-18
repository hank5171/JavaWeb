package homeWork;

import java.util.Map;

public class DrinkOrderMain {
	public static void main(String[] args) {
		//價格對照表
		/*
		  Key value 可以用map
		  {"greenTea":{"S", 30}, {"M", 50}, {"L", 50}}
		  {"blackTea":{"S", 45}, {"M", 55}, {"L", 65}}
		  {"milkTea":{"S", 40}, {"M", 45}, {"L", 60}}
		 */

		Map<String, Map<String, Integer>> priceTable = Map.of(
				"greenTea",Map.of("S", 30, "M", 40,"L", 50),
				"blackTea",Map.of("S", 45, "M", 55,"L", 65),
				"milkTea",Map.of("S", 40, "M", 45,"L", 60)
				);
		
		System.out.println(priceTable);
		System.out.println(priceTable.get("greenTea").get("M"));
	}
}
