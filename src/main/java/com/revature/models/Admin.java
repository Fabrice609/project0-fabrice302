package com.revature.models;

public class Admin {

	private int Adminid;

	public int getAdminid() {
		return Adminid;
	}

	public void setAdminid(int adminid) {
		Adminid = adminid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Adminid;
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
		Admin other = (Admin) obj;
		if (Adminid != other.Adminid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admin [Adminid=" + Adminid + "]";
	}

	public Admin(int adminid) {
		super();
		Adminid = adminid;
	}
	
	
	
	
}
