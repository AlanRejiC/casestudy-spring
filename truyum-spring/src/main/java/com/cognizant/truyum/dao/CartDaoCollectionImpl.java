package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;


public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<Long,Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();
		// TODO Auto-generated constructor stub
		if(userCarts==null)
		{
			HashMap<Long,Cart> hmap=new HashMap<Long,Cart>();
			//hmap.put(1,new new MenuItem(104566,"Biriyani","main dish",130,false,true,DataUtil.convertToDate("17/10/2021")));
			userCarts=hmap;
		}
	}

	@Override
	public void addCartItem(long userId, long MenuItemId) {
		// TODO Auto-generated method stub
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem mi =menuItemDao.getMenuItem(MenuItemId);
		boolean check=false;
		for(Map.Entry<Long,Cart> mm:userCarts.entrySet())
		{
			if(mm.getKey()==userId)
			{
				mm.getValue().getMenuItemList().add(mi);
				check=true;
			}
		}
		if(!check)
		{
			List<MenuItem> mo=new ArrayList<MenuItem>();
			mo.add(mi);
			Cart c=new Cart(mo,0);
			userCarts.put(userId,c);
			
		}
		
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		List<MenuItem> mi=null;
		double tot=0;
		for(Map.Entry<Long,Cart> mm:userCarts.entrySet())
		{
			if(mm.getKey()==userId)
			{
				mi=mm.getValue().getMenuItemList();
			}
		}
		if(mi.size()==0)
		{
			throw new CartEmptyException();
		}
		else
		{
			for(MenuItem menuitem:mi)
			{
				tot+=menuitem.getPrice();
			}
		}
		userCarts.put(userId,new Cart(mi,tot));
		return mi;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		List<MenuItem> mi=null;
		double tot=0;
		for(Map.Entry<Long,Cart> mm:userCarts.entrySet())
		{
			if(mm.getKey()==userId)
			{
				mi=mm.getValue().getMenuItemList();
				tot=mm.getValue().getTotal();
			}
		}
		int i=0;
		int n=0;
		for(MenuItem menuitem:mi)
		{
			if(menuitem.getId()==menuItemId)
				n=i;
			i++;
		}
		mi.remove(n);
		userCarts.put(userId,new Cart(mi,tot));
		
		
		
	}
	

}