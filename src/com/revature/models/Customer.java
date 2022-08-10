package com.revature.models;

public class Customer {

	private int customerid;
	private String firstName;
	private String lastName;
	private double customerSpendings;
	private String customerSelection;
	
	
	public Customer(int customerid, String firstName, String lastName, double customerSpendings,
			String customerSelection) {
		super();
		this.customerid = customerid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerSpendings = customerSpendings;
		this.customerSelection = customerSelection;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getCustomerSpendings() {
		return customerSpendings;
	}

	public void setCustomerSpendings(double customerSpendings) {
		this.customerSpendings = customerSpendings;
	}

	public String getCustomerSelection() {
		return customerSelection;
	}

	public void setCustomerSelection(String customerSelection) {
		this.customerSelection = customerSelection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerSelection == null) ? 0 : customerSelection.hashCode());
		long temp;
		temp = Double.doubleToLongBits(customerSpendings);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + customerid;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Customer other = (Customer) obj;
		if (customerSelection == null) {
			if (other.customerSelection != null)
				return false;
		} else if (!customerSelection.equals(other.customerSelection))
			return false;
		if (Double.doubleToLongBits(customerSpendings) != Double.doubleToLongBits(other.customerSpendings))
			return false;
		if (customerid != other.customerid)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", customerSpendings=" + customerSpendings + ", customerSelection=" + customerSelection + "]";
	}
	
	
	
	
}
