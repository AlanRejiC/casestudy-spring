package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
@ImportResource("classpath:spring-config.xml")
public class CartDaoCollectionImpl implements CartDao {
	@Autowired
	private HashMap<Long,Cart> userCarts;


	public HashMap<Long, Cart> getUserCarts() {
		return userCarts;
	}

	public void setUserCarts(HashMap<Long, Cart> userCarts) {
		this.userCarts = userCarts;
	}

	@Override
	public void addCartItem(long userId, long MenuItemId) {
		// TODO Auto-generated method stub
		//System.out.println(userCarts);
		ApplicationContext context = new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) context).scan("com.cognizant.truyum");
		((AnnotationConfigApplicationContext) context).refresh();
		MenuItemDao menuItemDao = (MenuItemDao) context.getBean(MenuItemDaoCollectionImpl.class);
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
		if(mi.size()==0 || mi==null)
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