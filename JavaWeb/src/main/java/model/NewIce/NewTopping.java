package model.NewIce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.ice.Topping;

//附餐陣列
public class NewTopping {
	private List<String> toppings ;  //配料集合
	private static final int TOPPING_PRICE = 10;
	
	public NewTopping(String[] toppingArray) {
		this.toppings = (toppingArray == null) ? null : Arrays.asList(toppingArray);
	}
	
	public List<String> getToppings() {
		return toppings;
	}
	
	// 計算配料總金額
	public int calculateToppingPrice() {
		return (toppings == null) ? 0 : toppings.size() * TOPPING_PRICE;
	}
}

