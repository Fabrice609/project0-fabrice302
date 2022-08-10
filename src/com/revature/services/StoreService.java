package com.revature.services;

import java.util.List;

import com.revature.daos.StoreDAO;
import com.revature.daos.StoreDAOImpl;
import com.revature.models.Store;

public class StoreService {
	
	private StoreDAO storeDao = new StoreDAOImpl();
	
	public List<Store> storeDisplay(){
		return storeDao.getAllStores();		
	}
	
	public Store getAStore(int id) {
		return storeDao.getStoreById(id);	
		}
	
	public void newStore(Store store) {
		storeDao.insertStore(store);
	}
	
	//public void countAllStore(Store store) {
		//store.Dao.countStore(store);
	//}
}
