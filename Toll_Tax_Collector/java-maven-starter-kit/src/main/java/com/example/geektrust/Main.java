package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private Solution sol = new Solution();
	
	public void getDetails(String[] arr) {
		
		
	}
	
	
	
    public static void main(String[] args) {
       Main mn = new Main();
       // Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream("sample_input/input1.txt");
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
            	 String inputCommand = sc.nextLine();
            	 String[] arr = inputCommand.split(" ");
            	 mn.getDetails( arr );
            	 
            	 System.out.println(inputCommand);
            }
           
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }
      
    }
}
