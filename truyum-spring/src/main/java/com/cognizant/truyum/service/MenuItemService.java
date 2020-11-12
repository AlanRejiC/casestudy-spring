package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
@Service("menuItemService")
public class MenuItemService {
	@Autowired 
	private MenuItemDao menuItemDao;
	
	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}


	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public void setMenuItemDao()
	{
		ApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemDao=(MenuItemDao) xml.getBean("menuItemImpl");
	}
	
	public List<MenuItem> getMenuListAdmin()
	{
		/*List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList)
			System.out.println(menuItem);*/
		return menuItemDao.getMenuItemListAdmin(); 
	}
	
	public List<MenuItem> getMenuListCustomer()
	{
		/*List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList)
			System.out.println(menuItem);*/
		return menuItemDao.getMenuItemListCustomer();
	}
	
	public MenuItem getMenuItem(long userId)
	{
		return menuItemDao.getMenuItem(userId);
	}
	
	public void editMenuItem(MenuItem menuItem)
	{
		menuItemDao.modifyMenuItem(menuItem);
	}
}
