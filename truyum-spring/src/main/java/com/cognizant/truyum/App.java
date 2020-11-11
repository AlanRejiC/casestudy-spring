package com.cognizant.truyum;

import java.util.List;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");
		List<MenuItem> menuItemList = (List<MenuItem>) xml.getBean("menuItems");
		for (MenuItem menuItem : menuItemList)
			System.out.println(menuItem);
	}
}
