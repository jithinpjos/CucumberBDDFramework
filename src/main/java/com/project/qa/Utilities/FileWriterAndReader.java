package com.project.qa.Utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterAndReader {
	static String directory = System.getProperty("user.dir");	
	static String fileName = "Data.txt";
	static String absolutePath = directory + File.separator + fileName;
	static String Data;
	
public static void writeToFile(String Data) throws IOException {
	// write the content in file 
	File file = new File(directory+"/testData//Data.txt");
	file.createNewFile();
	System.out.println(directory);
	System.out.println(absolutePath);
	try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
	    String fileContent = Data;
	    bufferedWriter.write(fileContent);
	} catch (IOException e) {
	    // exception handling
	}
}

public static  String readFromFile() {
	// read the content from file
	try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
		String line = bufferedReader.readLine();
	    while(line != null) {
	    	 Data=line;
	       // System.out.println(line);
	     line = bufferedReader.readLine();
	 
	    }
	} catch (FileNotFoundException e) {
	    // exception handling
	} catch (IOException e) {
	    // exception handling
	}
	
	return Data;	
}

public static String readOpportunity() {
	Data=readFromFile();
	String[] Opportunity=Data.split(":", 2);
	return Opportunity[0];
}
public static String readWorkOrder() {
	Data=readFromFile();
	String[] Opportunity=Data.split(":", 2);
	return Opportunity[1];
}
}