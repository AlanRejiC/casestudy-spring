package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Service("cartService")
public class CartService {

	@Autowired
	private CartDao cartDao;
	
	public CartDao getCartDao() {
		return cartDao;
	}

	List<MenuItem> getAllCartItems(long userId) throws CartEmptyException
	{
		return cartDao.getAllCartItems(1);
	}
	
	void setCartDao(CartDao cartDao)
	{
		
	}
	
	void addCartItem(long userId,long menuItemId)
	{
		//System.out.println(cartDao);
		cartDao.addCartItem(userId, menuItemId);
	}
	
	void removeCartItem(long userId,long menuItemId)
	{
		cartDao.removeCartItem(userId, menuItemId);
	}
}
