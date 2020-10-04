package javaphase1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileAdder {

	static void AddingFile() throws IOException {

		Scanner reader = new Scanner(System.in);
		boolean success = false;

		System.out.println("Enter path of directory to create");

		String dir = reader.nextLine();

		File directory = new File(dir);
		if (directory.exists()) {
			System.out.println("Directory already exists ...");
		}

		else {
			System.out.println("Directory not exists, creating now");
			success = directory.mkdir();
			if (success) {
				System.out.printf("Successfully created new directory :  " + dir);

			} else {
				System.out.printf("Failed to create new directory: " + dir);
			}
		}
		System.out.println("\n");
		System.out.println("Enter file name to be created ");
		String filename = reader.nextLine();

		File f = new File(dir + "/" + filename);
		if (f.exists()) {
			System.out.println("File already exists");
		} else {
			System.out.println("No such file exists, creating now");
			f.createNewFile();
			success = true;
			if (success) {
				System.out.printf("Successfully created new file: " + f+"\n");

			} else {
				System.out.printf("Failed to create new file: " + f+"\n");
			}
		}

	}
}
