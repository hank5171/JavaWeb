package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import org.apache.jasper.compiler.Node.DoBodyAction;
import org.apache.tomcat.util.digester.Rule;
import org.apache.tomcat.util.digester.Rules;

import model.CoffeeT.CoffeeRule;

public class PhonePlan {
	private	Integer phoneCall;
	private Double phoneOnline;

	static class PhoneRule{
		// 網路類型名稱
		private String phoneOnlineType;
		// 網路價格描述
		private Integer price;
		// 條件判斷邏輯
		private BiPredicate<Integer, Double> condition;
		
		public PhoneRule(String phoneOnlineType, Integer price, BiPredicate<Integer,Double> condition) {
			this.phoneOnlineType= phoneOnlineType;
			this.price = price;
			this.condition = condition;
		}
		
		public boolean matches(Integer phoneCall, Double phoneOnline) {
			return condition.test(phoneCall, phoneOnline);
		}
		
		public String getResult(){
			return phoneOnlineType + ": $" + price;
		}
	}
		// 可以儲存所有網路規則的清單
		private static final List<PhoneRule> rules = new ArrayList<>();
		
		/*
		 * 通話 > 1000 分鐘 or 流量 > 50 GB → 商務型($1499)

		通話 > 500 分鐘 and 流量 > 10 GB → 一般用戶型($660)

		流量 < 1 GB and 通話 < 200 分鐘 → 長輩節省型($200)
		*/
	
		//類別資料初始化區段
		static {
			rules.add(new PhoneRule("商務型", 1499, (min, gb) -> min > 1000 ||  gb > 50));
			rules.add(new PhoneRule("一般用戶型", 660, (min, gb) -> min > 500 &&  gb > 10));
			rules.add(new PhoneRule("長輩節省型", 200, (min, gb) -> gb < 1 && min < 200 ));
		}
	
	// PhonePlan 建構子
	public PhonePlan(Integer phoneCall, Double phoneOnline) {
		this.phoneCall = phoneCall;
		this.phoneOnline = phoneOnline;
	}

		
	public PhonePlan(String phoneCall, String phoneOnline) {
			//this(Double.parseDouble(milk), Double.parseDouble(coffee));
			this.phoneCall = Integer.parseInt(phoneCall);
			this.phoneOnline = Double.parseDouble(phoneOnline);
	}
		
	public String getPhoneOnlineType() {
		return rules.stream()
				.filter(rule -> rule.matches(phoneCall, phoneOnline))
				.findFirst()
				.map(PhoneRule::getResult)
				.orElse("無適合方案");
	}
	
	// Getter
	public Integer getPhoneCall() {
		return phoneCall;
	}
	
	public Double getPhoneOnline() {
		return phoneOnline;
	}
}


