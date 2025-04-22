package model;

import java.util.Arrays;

public class IceDessert {
	private String mainDish;
	private String[] toppings;
	private int price;
	
	public IceDessert(String mainDish, String[] toppings) {
		this.mainDish = mainDish;
		this.toppings = (toppings != null) ?  toppings : new String[0];
		setPrice(mainDish);
	}

	public int getPrice() {
		return price;
	}

	private void setPrice(String mainDish) {
		if(mainDish.equals("豆花")) {
			this.price = 40 + 10 * (toppings.length);
		}else {
			this.price = 50 + 10 * (toppings.length);
		}
	}

	public String getMainDish() {
		return mainDish;
	}

	@Override
	public String toString() {
		return "🍧冰果店的點餐 主餐 = [" + mainDish + "]  加料 = " + Arrays.toString(toppings) + " 總價 = " + price;
	}

	public String[] getToppings() {
		return toppings;
	}
	
	public String getToppingsAsString() {
	    return toppings.length == 0 ? "無" : String.join(", ", toppings);
	}
}
