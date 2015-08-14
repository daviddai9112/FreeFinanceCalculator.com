package controller;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import databeans.CSV;

public class CsvFileWriter {
//	public static void main(String[] args){
//		
//		//Create new students objects
//		CSV csv1 = new CSV("home-shit",25);
//		CSV csv2 = new CSV("heasfdasd-shit",25);
//		CSV csv3 = new CSV("hot",25);
//		CSV csv4 = new CSV("home-shit",25);
//		CSV csv5 = new CSV("home-shit",25);
//		
//		//Create a new list of student objects
//		List<CSV> csvlist = new ArrayList<CSV>();
//		csvlist.add(csv1);
//		csvlist.add(csv2);
//		csvlist.add(csv3);
//		csvlist.add(csv4);
//		csvlist.add(csv5);
//		writeCsvFile(csvlist);
//	}
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_NAME = "visit-sequences.csv";
	

	public static void writeCsvFile(List<CSV> csvlist) {
		

		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(FILE_NAME);
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (CSV csv : csvlist) {
				fileWriter.append(csv.getPath());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(csv.getAmount()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			
			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {

				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}
}
