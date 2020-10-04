package javaphase1;

import java.io.File;
import java.io.IOException;

public class DeleteDirectory {

	public static void recursiveDelete(File file) throws IOException {
		if (!file.exists())
			return;

		if (file.isDirectory()) {
			for (File f : file.listFiles()) {

				recursiveDelete(f);
			}
		}

		file.delete();
		System.out.println("Deleted file/folder: " + file.getAbsolutePath());

	}
}
