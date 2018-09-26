package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;

import domain.Dynamic;

public class oftenUtils {
	public static String getTime(){
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");    
		String datetime = tempDate.format(new java.util.Date()); 
		return datetime;
	};
	
	public static String getUUID(){
		return UUID.randomUUID().toString();		
	}
}
