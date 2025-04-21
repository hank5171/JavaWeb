package model;

public class User {
	private String userName;// from 表單欄位
	private String gender;	// from 表單欄位
	private Integer age;	// from 表單欄位
	private double height;	// from 表單欄位
	private double weight;	// from 表單欄位
	private Double bmiValue; //自建欄位
	private String bmiresult; //自建欄位
	
	// 建構子封裝
	public User(String userName, String gender, String age, String height, String weight) {
		this.userName = userName;
		this.gender = gender;
		this.age = Integer.parseInt(age);
		this.height = Double.parseDouble(height);
		this.weight = Double.parseDouble(weight);
		// 計算BMI值
		this.bmiValue = this.weight / Math.pow(this.height/100, 2);
		//診斷
		setBmiresult();
	}

	public String getUserName() {
		return userName;
	}

	public String getGender() {
		return gender;
	}

	public Integer getAge() {
		return age;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}

	public Double getBmiValue() {
		return bmiValue;
	}	
	

	
	public String getBmiresult() {
		return bmiresult;
	}

	public void setBmiresult() {
		double min = 0, max = 0; 
		switch(gender){
			case "male" :
				min = 17.4;
				max = 23.3;
				break;
				
			case "female" :	
				min = 17.1;
				max = 22.7;
				break;
		}
		String bmiresult = bmiValue < min ? "過瘦" : bmiValue > max ? "過胖" : "正常";
		this.bmiresult = bmiresult;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + "," + "gender=" + gender + "," + "age=" + age + "," + "height=" + height  + "weight=" + weight + "," + "bmiValue=" + bmiValue;
	}
}
