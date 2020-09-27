package com.cs.iit.sar.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCreated {

	public static String getDateOrTime(String pattern) {
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = new Date();
		return dateFormat.format(date);
	}
}
