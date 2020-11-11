package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service("menuItemService")
public class MenuItemService {
	@Autowired
	private MenuItemDao menuItemDao;
	
	void setMenuItemDao()
	{
		ApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemDao=(MenuItemDao) xml.getBean("menuItems");
	}
	
	List<MenuItem> getMenuListAdmin()
	{
		return menuItemDao.getMenuItemListAdmin(); 
	}
	
	List<MenuItem> getMenuListAdminCustomer()
	{
		return null;
	}
	
	MenuItem getManuItem(long userId)
	{
		return null;
	}
	
	void editMenuItem(MenuItem menuItem)
	{
	}
}
