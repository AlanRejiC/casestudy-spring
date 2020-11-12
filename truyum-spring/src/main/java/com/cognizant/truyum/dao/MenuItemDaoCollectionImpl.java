package com.cognizant.truyum.dao;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;



@Component
@ImportResource("classpath:spring-config.xml")
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	@Autowired
	private List<MenuItem> menuItemList;
	public MenuItemDaoCollectionImpl(List<MenuItem> menuItemList) {
		super();
		this.menuItemList = menuItemList;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

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