package com.rahul.datehandling.crmo;

import java.util.HashMap;

public class DateHandling {
	
	
	
	public static HashMap<Integer, String> monthMap()
	{
		HashMap<Integer, String> monthMap = new HashMap<Integer, String>();
		monthMap.put(1, "January");
		monthMap.put(2, "February");
		monthMap.put(3, "March");
		monthMap.put(4, "April");
		monthMap.put(5, "May");
		monthMap.put(6, "June");
		monthMap.put(7, "July");
		monthMap.put(8, "August");
		monthMap.put(9, "September");
		monthMap.put(10, "October");
		monthMap.put(11, "November");
		monthMap.put(12, "December");
		
		return monthMap;
		
	}

}
