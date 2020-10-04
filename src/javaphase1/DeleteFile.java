package javaphase1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DeleteFile {

	public static void deleteFile() throws IOException {

		Scanner reader = new Scanner(System.in);

		System.out.println("Enter path of the File to be Deleleted"); // asking the user to input the path of the file to be deleted
		String dir = reader.nextLine(); // reading the input
		File file = new File(dir); // passing the input string  to create a File  object

		if (file.delete()) { // calling the Delete method of the File Class
			System.out.println("File deleted successfully"); // if true
		} else {
			System.out.println("Failed to delete the file"); // if false
		}

	}
}
