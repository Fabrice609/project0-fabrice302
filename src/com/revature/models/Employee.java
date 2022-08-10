package com.revature.models;

import java.sql.PreparedStatement;

public class Employee {

	private int employeeid;
	private String empFirstName;
	private String empLastName;
	private double hourlyRate;
	
	public Employee(int employeeid, String empFirstName, String empLastName, double hourlyRate) {
		super();
		this.employeeid = employeeid;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.hourlyRate = hourlyRate;	
	}
	
	public Employee() {
		
	}


	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", hourlyRate=" + hourlyRate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empFirstName == null) ? 0 : empFirstName.hashCode());
		result = prime * result + ((empLastName == null) ? 0 : empLastName.hashCode());
		result = prime * result + employeeid;
		long temp;
		temp = Double.doubleToLongBits(hourlyRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Employee other = (Employee) obj;
		if (empFirstName == null) {
			if (other.empFirstName != null)
				return false;
		} else if (!empFirstName.equals(other.empFirstName))
			return false;
		if (empLastName == null) {
			if (other.empLastName != null)
				return false;
		} else if (!empLastName.equals(other.empLastName))
			return false;
		if (employeeid != other.employeeid)
			return false;
		if (Double.doubleToLongBits(hourlyRate) != Double.doubleToLongBits(other.hourlyRate))
			return false;
		return true;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	
	
	
	
}
