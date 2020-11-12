package com.cognizant.truyum;

import java.util.List;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.MenuItemService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		/*ApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");
		MenuItemDao testDemo = (MenuItemDao) xml.getBean("menuItemImpl");
		List<MenuItem> menuItemList = testDemo.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList)
			System.out.println(menuItem);
		MenuItemService mm=(MenuItemService) xml.getBean("menuItemService");
		menuItemList = mm.getMenuListAdmin();
		for (MenuItem menuItem : menuItemList)
			System.out.println(menuItem);*/
		CartService cs=new CartService();
		cs.getCartDao().addCartItem(1, 10001);
	}
}
