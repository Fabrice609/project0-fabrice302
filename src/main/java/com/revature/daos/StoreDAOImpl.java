package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Store;
import com.revature.utils.ConnectionUtil;

public class StoreDAOImpl implements StoreDAO {
			
	public Store getFoodByName(String name) {
		try(Connection conn =ConnectionUtil.getConnection()){
			String sql ="SELECT * FROM store WHERE food_name = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
		
			if(result.next()) {
				//Store store = new Store();
				//store.getStoreName(result.getString("store_name"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
		public Store getStoreById(int id) {
				try(Connection conn = ConnectionUtil.getConnection()){
					String sql = "SELECT * FROM store WHERE store_id = "+id+";";
					Statement statement = conn.createStatement();
					 ResultSet result = statement.executeQuery(sql);
					
					if(result.next()) {
						
						Store store = new Store(
								result.getInt("store_id"),
								result.getString("store_name"),
								result.getString("food_name"),
								result.getDouble("food_price")
								);
					
					return store;
					}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

						
				public List<Store>getAllStores(){
			try (Connection conn = ConnectionUtil.getConnection()){
				String sql = "SELECT * FROM store;";
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(sql);
				
				 List<Store>storeList = new LinkedList<Store>();
			
				while(result.next()) {					
					Store store = new Store(
							result.getInt("store_id"),
							result.getString("store_name"),
							result.getString("food_name"),
							result.getDouble("food_price")
							);
					
					storeList.add(store);
				}
				return storeList;
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public  void insertStore(Store store) {
			try(Connection conn = ConnectionUtil.getConnection()){
				String sql = "INSERT INTO store (store_name, food_name, food_price) "
						+"  VALUES(?, ?, ?);";
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				int count =0;
				statement.setString(++count, store.getStoreName());
				statement.setString(++count, store.getFoodName());
				statement.setDouble(++count, store.getFoodPrice());
				
				statement.execute();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}

		
//		

				}
		




