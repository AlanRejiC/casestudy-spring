package com.cognizant.truyum.model;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuItem {
	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		ApplicationContext xml=new ClassPathXmlApplicationContext("spring-config.xml");
		SimpleDateFormat formatter =(SimpleDateFormat) xml.getBean("sdf");
		return "MenuItem [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", active="
				+ active + ", freeDelivery=" + freeDelivery + ", dateOfLaunch=" + formatter.format(dateOfLaunch) + "]";
	}
	private long id;
	private String name,category;
	private float price;
	private boolean active,freeDelivery;
	private Date dateOfLaunch;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isFreeDelivery() {
		return freeDelivery;
	}
	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}
	public MenuItem(long id, String name, String category, float price, boolean active, boolean freeDelivery,
			Date dateOfLaunch) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.active = active;
		this.freeDelivery = freeDelivery;
		this.dateOfLaunch = dateOfLaunch;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
}