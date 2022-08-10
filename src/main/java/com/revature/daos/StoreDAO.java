package com.revature.daos;

import java.util.List;

import com.revature.models.Store;

public interface StoreDAO {
	
	public abstract void insertStore(Store store);
	
	public abstract Store getStoreById(int id);
	
	//public abstract void countStore(int store);
	
	List<Store>getAllStores();
	
	
}
