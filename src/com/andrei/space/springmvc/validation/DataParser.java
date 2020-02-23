package com.andrei.space.springmvc.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataParser {
	
	//private static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	private static DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
	/*public static LocalDate parseDate(String dateString) throws ParseException {
		
		LocalDate date=(Date)format.parse(dateString);
		return date;
	}*/
	
	public static String formatDate(LocalDate date) {
		String result=null;
		
		if(date!=null) {
			result=date.format(format);
		}
		
		return result;
	}
}
