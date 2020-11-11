package com.cognizant.truyum.service;

import java.util.List;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartService {

	private CartDao cartDao;
	
	List<MenuItem> getAllCartItems(long userId) throws CartEmptyException
	{
		return null;
	}
	
	void setCartDao(CartDao cartDao)
	{
		
	}
	
	void addCartItem(long userId,long menuItemId)
	{
		
	}
	
	void removeCartItem(long userId,long menuItemId)
	{
		
	}
}
