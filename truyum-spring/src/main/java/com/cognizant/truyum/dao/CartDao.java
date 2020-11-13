package com.cognizant.truyum.dao;



import java.util.List;

import com.cognizant.truyum.model.MenuItem;
/**
 * 
 * @author arkdb
 * This is the interface CartDao which has to be implemented
 *
 */
public interface CartDao {

	 void addCartItem(long userId,long menuItemId);
	 List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;
	 void removeCartItem(long userId,long menuItemId);
	
}