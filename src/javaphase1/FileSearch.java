package javaphase1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {
	private String fileNameToSearch;
	private List<String> result = new ArrayList<String>(); // using List  to store the result 

	public String getFileNameToSearch() {
		return fileNameToSearch;
	}

	public void setFileNameToSearch(String fileNameToSearch) {
		this.fileNameToSearch = fileNameToSearch;
	}

	public List<String> getResult() {
		return result;
	}

	public void searchDirectory(File directory, String fileNameToSearch) {

		setFileNameToSearch(fileNameToSearch);

		if (directory.isDirectory()) {
			search(directory); //Using recursion to search the Directory
		} else {
			System.out.println(directory.getPath() + " is not a directory!");
		}
	}

	private void search(File file) {

		if (file.isDirectory()) {
			System.out.println("Searching directory ... " + file.getPath()); // retrieving the list of directories

			if (file.canRead()) {
				for (File temp : file.listFiles()) {
					if (temp.isDirectory()) {
						search(temp); //using recursion to search for the file
					} else {
						if (getFileNameToSearch().equals(temp.getName().toLowerCase())) {
							result.add(temp.getPath().toString()); // adding the result to the list
						}

					}
				}

			} else {
				System.out.println(file.getAbsoluteFile() + "Permission Denied");
			}
		}

	}

}
