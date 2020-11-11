package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String args[])
	{
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}
	
	static void testAddCartItem()
	{
		CartDao cartDao=new CartDaoCollectionImpl();
		cartDao.addCartItem(1,100123);
		cartDao.addCartItem(1,100100);
		List<MenuItem> mm=null;
		try {
		mm=cartDao.getAllCartItems(1);
		for(MenuItem mn:mm)
		System.out.println(mn.getId()+" "+mn.getName()+" "+mn.getCategory()+" "+mn.getPrice()+" "+mn.getDateOfLaunch());
		}
		catch(Exception e)
		{
			System.out.println("Cart Empty");
		}
		
	}
	
	static void testGetAllCartItems()
	{
		CartDao cartDao=new CartDaoCollectionImpl();
		List<MenuItem> mm=null;
		try {
		mm=cartDao.getAllCartItems(1);
		for(MenuItem mn:mm)
		System.out.println(mn.getId()+" "+mn.getName()+" "+mn.getCategory()+" "+mn.getPrice()+" "+mn.getDateOfLaunch());
		}
		catch(Exception e)
		{
			System.out.println("Cart Empty");
		}
	}
	
	static void testRemoveCartItem()
	{
		CartDao cartDao=new CartDaoCollectionImpl();
		cartDao.removeCartItem(1,100123);
		List<MenuItem> mm=null;
		try
		{
			mm=cartDao.getAllCartItems(1);
			for(MenuItem mn:mm)
			System.out.println(mn.getId()+" "+mn.getName()+" "+mn.getCategory()+" "+mn.getPrice()+" "+mn.getDateOfLaunch());
		}
		catch(Exception e)
		{
			System.out.println("Cart Empty");
		}
	}
}