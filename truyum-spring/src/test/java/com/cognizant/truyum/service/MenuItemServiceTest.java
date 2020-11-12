package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemServiceTest {

	private MenuItemService menuItemService;
	private SimpleDateFormat formatter=null;
	
	@Before
	public void intializeService()
	{
		//ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		ApplicationContext context=new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) context).scan("com.cognizant.truyum");
		((AnnotationConfigApplicationContext) context).refresh();
		menuItemService =(MenuItemService) context.getBean("menuItemService");
		//menuItemService.setMenuItemDao(); // interface injection into menuItemDao
		formatter = (SimpleDateFormat) context.getBean("sdf");
	}
	
	@Test
	public void testGetMenuItemListAdminSize()
	{
		assertTrue(menuItemService.getMenuListAdmin().size()==5);
	}
	
	@Test
	public void testGetMenuItemListAdminContainsSandwich()
	{
		List<MenuItem> menuList=menuItemService.getMenuListAdmin();
		boolean check=false;
		for(MenuItem temp:menuList)
		{
			if(temp.getName().equals("Sandwich"))
			{
				assertEquals(temp.getCategory(),"Appetizer");
				try {
					assertEquals(temp.getDateOfLaunch(),formatter.parse("15/10/2015"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				assertEquals(temp.getId(),10001);
				assertEquals(temp.getName(),"Sandwich");
				assertEquals(temp.getPrice(),130,0);
				assertEquals(temp.isActive(),true);
				assertEquals(temp.isFreeDelivery(),false);
				check=true;
				
			}
		}
		assertTrue("Menu Item not present",check);
	}
	
	@Test
	public void testGetMenuItemListCutomerSize()
	{
		assertTrue(menuItemService.getMenuListCustomer().size()==3);
	}
	
	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries()
	{
		List<MenuItem> menuList=menuItemService.getMenuListCustomer();
		boolean check=false;
		for(MenuItem temp:menuList)
		{
			if(temp.getName().equals("Fries"))
			{
				check=true;
				
			}
		}
		assertTrue("Menu Item is present",!check);
	}
	
	@Test
	public void testGetMenuItemListCustomerNotContainsBrownie()
	{
		List<MenuItem> menuList=menuItemService.getMenuListCustomer();
		boolean check=false;
		for(MenuItem temp:menuList)
		{
			if(temp.getName().equals("Brownie"))
			{
				check=true;
				
			}
		}
		assertTrue("Menu Item is present",!check);
	}
	
	@Test
	public void testGetMenuItem()
	{
		MenuItem menuItem =menuItemService.getMenuItem(10003);
		assertEquals(menuItem.getId(),10003);
	}
	
	@Test
	public void testModifyMenuItem()
	{
		MenuItem menuItem=null;
		try {
			menuItem=new MenuItem(10005,"Kuzhi Mandi","Main Dish",300,true,true,formatter.parse("11/11/2011"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		menuItemService.editMenuItem(menuItem);
		List<MenuItem> menuList=menuItemService.getMenuListAdmin();
		boolean check=false;
		for(MenuItem temp:menuList)
		{
			//System.out.println(temp.getId());
			if(temp.getId()==10005)
			{
				assertEquals(temp.getCategory(),"Main Dish");
				try {
					assertEquals(temp.getDateOfLaunch(),formatter.parse("11/11/2011"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				assertEquals(temp.getId(),10005);
				assertEquals(temp.getName(),"Kuzhi Mandi");
				assertEquals(temp.getPrice(),300,0);
				assertEquals(temp.isActive(),true);
				assertEquals(temp.isFreeDelivery(),true);
				check=true;
				//System.out.println("hello");
				
			}
		}
		assertTrue("Menu Item is not present",check);
		
	}
}
