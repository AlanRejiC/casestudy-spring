package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;


@Service("cartService")
public class CartService {

	
	private CartDao cartDao;
	
	public CartDao getCartDao() {
		return cartDao;
	}
	@Autowired
	void setCartDao(CartDao cartDao)
	{
		this.cartDao=cartDao;
	}
	
	List<MenuItem> getAllCartItems(long userId) throws CartEmptyException
	{
			return cartDao.getAllCartItems(userId);
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
