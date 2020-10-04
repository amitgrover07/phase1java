package javaphase1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DeleteFile {

	public static void deleteFile() throws IOException {

		Scanner reader = new Scanner(System.in);

		System.out.println("Enter path of the File to be Deleleted");
		String dir = reader.nextLine();
		File file = new File(dir);

		if (file.delete()) {
			System.out.println("File deleted successfully");
		} else {
			System.out.println("Failed to delete the file");
		}

	}
}
