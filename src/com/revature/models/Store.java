package com.revature.models;

public class Store {

	private int storeid;
	private String storeName;
	private String foodName;
	private double foodPrice;
	
	public Store(int storeid, String storeName, String foodName, double foodPrice) {
		super();
		this.storeid = storeid;
		this.storeName = storeName;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}
	
	public Store() {
		super();
	}
	
	public int getStoreid() {
		return storeid;
	}

	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(foodPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
		result = prime * result + storeid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		if (foodName == null) {
			if (other.foodName != null)
				return false;
		} else if (!foodName.equals(other.foodName))
			return false;
		if (Double.doubleToLongBits(foodPrice) != Double.doubleToLongBits(other.foodPrice))
			return false;
		if (storeName == null) {
			if (other.storeName != null)
				return false;
		} else if (!storeName.equals(other.storeName))
			return false;
		if (storeid != other.storeid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Store [storeid=" + storeid + ", storeName=" + storeName + ", foodName=" + foodName + ", foodPrice="
				+ foodPrice + "]";
	}
	
	
	
	
}
