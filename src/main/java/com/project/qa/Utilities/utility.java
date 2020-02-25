package com.project.qa.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

public class utility {
	
	public static String RandomName() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		String name = person.getFirstName();
		return name;
	}
	

	public static String getRandomEmailID() {
		Fairy fairy = Fairy.create();
		String saltStr = fairy.textProducer().randomString(3);
		String Name = RandomName();
		String emailid = Name + saltStr + "@gmail.com";
		return emailid;
	}

	public static String randPassword() {
		Fairy fairy = Fairy.create();
		int RandomNumb = fairy.baseProducer().randomBetween(10000000, 90000000);
		String Numb = String.valueOf(RandomNumb);
		String Password = "Test#@" + Numb;
		return Password;
	}

	public static String getRandomNickName() {
		Fairy fairy = Fairy.create();
		String saltStr = fairy.textProducer().randomString(3);
		String Name = RandomName();
		String RandomName = Name + saltStr;
		return RandomName;
	}

	public static String getRandomString_20L() {
		Fairy fairy = Fairy.create();
		String saltStr = fairy.textProducer().randomString(20);
		return saltStr;
	}
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		String output = sdf.format(c.getTime());
		return output;
	}
	public static String getCurrentDateWithTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy HH:mm");
		Date date = new Date();
		String Date = dateFormat.format(date);
		return Date;
	}
	public static String getSentence_L(int length) {
		Fairy fairy = Fairy.create();
		String saltStr = fairy.textProducer().sentence();
		String str1 = saltStr.replaceAll("[,.?-]", "");
		String upToNCharacters = str1.substring(0, Math.min(str1.length(), length));
		String upToNCharactersTrim = upToNCharacters.trim();
		return upToNCharactersTrim;
	}
	public static String addDaysToCurrentDate(int day)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, day); // Adding  days
		String output = sdf.format(c.getTime());
		return output;
		
	}
	
}
