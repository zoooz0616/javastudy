package ch06.miniproject;

public class Food {
	String foodName;
	int count;
	String expDate;
	String etc;

	public Food() {}

	public Food(String foodName, int count, String expDate, String etc) {
		super();
		this.foodName = foodName;
		this.count = count;
		this.expDate = expDate;
		this.etc = etc;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
	
}
