package com.cognizant.truyum.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String dat)
	{
		DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		try {
			
				date=formatter.parse(dat);
		}
		catch(ParseException e)
		{
			DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			try {
			date=format.parse(dat);
			}
			catch(Exception m)
			{
				m.printStackTrace();
			}
		}
		return date;
	}
}