package com.cognizant.truyum.dao;


import java.util.*;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	
	public MenuItemDaoCollectionImpl(List<MenuItem> menuItemList) {
		super();
		this.menuItemList = menuItemList;
	}

	private List<MenuItem> menuItemList;
	
	

	public MenuItemDaoCollectionImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> lst =new ArrayList<MenuItem>();
		for(MenuItem mm:menuItemList)
		{	 
			//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			Date date = new Date();
			if(mm.getDateOfLaunch().compareTo(date)<=0)
			{
				if(mm.isActive())
				{
					lst.add(mm);
				}
			}
		}
		return lst;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		for(int i=0;i<menuItemList.size();i++)
		{
			if(menuItemList.get(i).getId()==menuItem.getId())
			{
				menuItemList.set(i,menuItem);
			}
		}
		
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		int n=0;
		for(int i=0;i<menuItemList.size();i++)
		{
			if(menuItemList.get(i).getId()==menuItemId)
			{
				 n=i;
			}
		}
		return menuItemList.get(n);
	}

}