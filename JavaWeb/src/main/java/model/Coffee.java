package model;

public class Coffee {
	private Integer coffee;
	private Integer milk;
	private String coffeeType;
	private String coffeeResult;
	
	public Coffee(String coffee, String milk) {
		this.coffee = Integer.parseInt(coffee);
		this.milk = Integer.parseInt(milk);
		setcoffeeType();
		setCoffeeResult();
	}

	public String getcoffeeType() {
		return coffeeType;
	}
/*
	public void setcoffeeType() {
		if(milk == coffee) {
			this.coffeeType = "標準卡布奇諾";
		}else if (milk >= 3*coffee) {
			this.coffeeType = "濃郁的拿鐵";
		}else if (milk >= 1.5*coffee) {
			this.coffeeType = "平衡的拿鐵咖啡";
		}else if (coffee >= 3*milk) {
			this.coffeeType = "濃縮咖啡";
		}else {
			this.coffeeType = "普通咖啡";
		}
	}
*/
	public void setcoffeeType() {
	    double ratio = (double) milk / coffee;

	    if (milk.equals(coffee)) {
	        this.coffeeType = "標準卡布奇諾";
	    } else if (ratio >= 3.0) {
	        this.coffeeType = "濃郁的拿鐵";
	    } else if (ratio >= 1.5) {
	        this.coffeeType = "平衡的拿鐵咖啡";
	    } else if (1 / ratio >= 3.0) {
	        this.coffeeType = "濃縮咖啡";
	    } else {
	        this.coffeeType = "普通咖啡";
	    }
	}

	
	public Integer getCoffee() {
		return coffee;
	}

	public Integer getMilk() {
		return milk;
	}

	public void setCoffeeResult() {
		switch (coffeeType) {
			case "濃郁的拿鐵" :
				this.coffeeResult ="牛奶的比例遠高於咖啡，味道偏向牛奶。";
				break;
			case "平衡的拿鐵咖啡" :
				this.coffeeResult ="牛奶與咖啡的比例較為平衡，風味溫和。";
				break;
			case "標準卡布奇諾" :
				this.coffeeResult ="牛奶與咖啡的比例恰到好處，典型的卡布奇諾。";
				break;
			case "濃縮咖啡" :
				this.coffeeResult ="咖啡的比例遠高於牛奶，口感濃烈，偏向純咖啡。";
				break;
			case "普通咖啡" :
				this.coffeeResult ="牛奶與咖啡的比例較為普通，適合日常飲用。";	
				break;
		}
	}

	public String getCoffeeResult() {
		return coffeeResult;
	}
}
