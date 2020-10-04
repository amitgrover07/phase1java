package javaphase1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileAdder {

	static void AddingFile() throws IOException { // throws the IOException, will be handles by the class using the Method

		Scanner reader = new Scanner(System.in);
		boolean success = false;

		System.out.println("Enter path of directory to create"); // asking the user to enter the path where to create the file

		String dir = reader.nextLine(); // reading the input from user

		File directory = new File(dir); //passing the string to create a File object
		if (directory.exists()) { // Checks if directory exists or not
			System.out.println("Directory already exists ...");
		}

		else {
			System.out.println("Directory not exists, creating now"); // if directory doesn't exists then create the directory
			success = directory.mkdir(); // upon successful directory creation success will change to true
			if (success) {
				System.out.printf("Successfully created new directory :  " + dir); // displaying message upon successful creation

			} else {
				System.out.printf("Failed to create new directory: " + dir); // else display the message of failure
			}
		}
		System.out.println("\n");
		System.out.println("Enter file name to be created "); // asking the user to enter the name of the file to be created
		String filename = reader.nextLine();

		File f = new File(dir + "/" + filename); // passing the name of the file along with the directory which was created earlier as File object
		if (f.exists()) { // Checks if file exists or not
			System.out.println("File already exists");
		} else {
			System.out.println("No such file exists, creating now"); // if file doesn't exists then create the file
			f.createNewFile(); // upon successful directory creation success will be assigned value as true
			success = true;
			if (success) {
				System.out.printf("Successfully created new file: " + f+"\n"); // displaying message upon successful creation

			} else {
				System.out.printf("Failed to create new file: " + f+"\n"); // else display the message of failure
			}
		}

	}
}
