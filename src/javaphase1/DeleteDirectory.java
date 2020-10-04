package javaphase1;

import java.io.File;
import java.io.IOException;

public class DeleteDirectory {

	public static void recursiveDelete(File file) throws IOException { // throws the IOException, will be handles by the class using the Method
		if (!file.exists()) // checking for the existence of file based on file object passed by user
			return;

		if (file.isDirectory()) { // if file is a Directory
			for (File f : file.listFiles()) { // using for each loop to get all the files under the directory

				recursiveDelete(f); // using recursion to delete the files
			}
		}

		file.delete(); // delete the file
		System.out.println("Deleted file/folder: " + file.getPath());

	}
}
