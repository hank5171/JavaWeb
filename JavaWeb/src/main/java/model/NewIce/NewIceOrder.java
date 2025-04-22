package model.NewIce;

import model.NewIce.*;

public class NewIceOrder {
	private NewMainDish mainDish;
	private NewTopping topping;
	private int totalPrice;
	
	public NewIceOrder(String mainDishName, String[] toppingArray) {
		this(new NewMainDish(mainDishName), new NewTopping(toppingArray));
	}
	
	public NewIceOrder(NewMainDish mainDish, NewTopping topping) {
		this.mainDish = mainDish;
		this.topping = topping;
		this.totalPrice = mainDish.getPrice() + topping.calculateToppingPrice();
	}

	public NewMainDish getMainDish() {
		return mainDish;
	}

	public NewTopping getTopping() {
		return topping;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
	
}
/*
	public IceOrder(String mainDishName, String[] toppingArray) {
		this(new MainDish(mainDishName), new Topping(toppingArray));
	}
	
	public IceOrder(MainDish mainDish, Topping topping) {
		this.mainDish = mainDish;
		this.topping = topping;
		this.totalPrice = mainDish.getPrice() + topping.calculateToppingPrice();
	}

	public MainDish getMainDish() {
		return mainDish;
	}

	public Topping getTopping() {
		return topping;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

*/