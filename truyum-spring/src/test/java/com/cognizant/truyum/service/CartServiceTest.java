package com.cognizant.truyum.service;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartServiceTest {

	private CartService cartService;
	private SimpleDateFormat formatter = null;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Before
	public void intializeService() {
		ApplicationContext context = new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) context).scan("com.cognizant.truyum");
		((AnnotationConfigApplicationContext) context).refresh();
		cartService = (CartService) context.getBean("cartService");
		formatter = (SimpleDateFormat) context.getBean("sdf");
	}

	@Test
	public void testCartIsEmpty() throws CartEmptyException
	{
		exceptionRule.expect(Exception.class);
		cartService.getAllCartItems(1); // cart is empty
	}
	
	@Test
	public void testCartItemIsAdded() {
		cartService.addCartItem(1, 10001);
		try {
			assertTrue(cartService.getAllCartItems(1).size()==1);
			List<MenuItem> menuList=cartService.getAllCartItems(1);
			assertTrue(menuList.get(0).getId()==10001);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testCartItemisRemoved()
	{
		cartService.addCartItem(1, 10001);
		cartService.addCartItem(1, 10002);
		try {
			assertTrue(cartService.getAllCartItems(1).size()==2); // 2 elements are present
			List<MenuItem> menuList=cartService.getAllCartItems(1);
			assertTrue(menuList.get(0).getId()==10001);
			assertTrue(menuList.get(1).getId()==10002); // Both elements are present
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cartService.removeCartItem(1, 10002);
		try {
			assertTrue(cartService.getAllCartItems(1).size()==1); // 1 element is present,1 is removed
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
