package com.company.lockedme.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LockedMeOperations {
	public static final String filePath = "C:\\Users\\User\\Desktop\\Phase 1 Project\\files";
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("****************************************");
		System.out.println("\tWelcome to LockedMe.com\t");
		System.out.println("\tDeveloped By Mukul Reksh\t");
		System.out.println("****************************************");
		
		while (true) {
			displayMeny();
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				displayAllFiles();
				break;
			}case 2 :{
				createAFile();
				break;
			}case 3 :{
				deleteAFile();
				break;
			}case 4 :{
				searchAFile();
				break;
			}case 5 :{
				System.out.println("thanks for visting the application will c u soon");
				System.out.println("********************************************************");
				return;
			}
			default:
				System.out.println("incorrect value entered");
				break;
			}
		}
	}
	
	public static void displayMeny() {
		System.out.println("Please check the Display menu#");
		System.out.println("1.TO Display ALL the Files");
		System.out.println("2.TO Create a new File");
		System.out.println("3.TO Delete a File");
		System.out.println("4.To Search a file");
		System.out.println("5.TO Exit the Application");
	}
	
	public static void displayAllFiles() {
		File[] allFiles = new File(filePath).listFiles();
		
		if(allFiles.length > 0) {
			for(File file:allFiles) {
				System.out.println(file.getName());
			}
		}else {
			System.out.println("no files found");
		}
		
	}
	
	public static void createAFile() {
		try {
			System.out.println("enter the filename:");
			String filename = sc.next();
			System.out.println("enter how many lines you want to write:");
			int linesToWrite = sc.nextInt();
			File file = new File(filePath + "\\" + filename);
			FileWriter writer = new FileWriter(file);
			sc.nextLine();
			for(int i = 1;i <= linesToWrite ; i++) {
				System.out.println("enter the " + i +"th line");
				String content = sc.nextLine();
				writer.write(content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("some error occured");
		}
		System.out.println("file created succesfully");
	}

	public static void deleteAFile() {
		System.out.println("enter the file name");
		sc.nextLine();
		String fileName = sc.nextLine();
		File result =  new File(filePath +"\\" + fileName);
		if(result.exists()) {
			if(result.delete()) {
				System.out.println("file deleted successfully");
			}else {
				System.out.println("some error occured");
			}
			
		}else {
			System.out.println("file not founnd");
		}
	}
	
	public static void searchAFile() {
		System.out.println("enter the file name");
		sc.nextLine();
		String fileName = sc.nextLine();
		File result =  new File(filePath +"\\" + fileName);
		if(result.exists()) {
			System.out.println("file found");
		}else {
			System.out.println("file not founnd");
		}

	}
	
	
}
