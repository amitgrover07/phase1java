package javaphase1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

	public static void main(String[] args) //main method
	{
		System.out.println("\nWelcome to File Management System using Java, Developed by Amit Grover");

		Scanner in = new Scanner(System.in);
		int option = 0;
		char proceed = 'N';
		try {
			do {
				String menu = "\nPlease select from the below options."
						+ "\n1 (1) See the list of Directories and Files."
						+ "\n2 (2) Creata a Directory or create a file under Existing Directory."
						+ "\n3 (3) Delete a File." + "\n4 (4) Delete a Directory." + "\n5 (5) Search a File."
						+ "\n0 (0) Exit Application.";
				System.out.println(menu);

				option = in.nextInt();

				if (option == 1) {
					String maindirpath = "Root";

					File maindir = new File(maindirpath);

					if (maindir.exists() == false) {
						maindir.mkdir();
					}

					if (maindir.exists() && maindir.isDirectory()) {

						File arr[] = maindir.listFiles();

						System.out.println("===============================================");
						System.out.println("Files under main directory : " + maindir);
						System.out.println("===============================================");

						ContentsOfRoot.RecursivePrint(arr, 0, 0);
					} else {
						System.out.println("No Such Directory Found");
					}

				}

				else if (option == 2) {
					try {
						System.out.println("Do you want to proceed with this option(Y/N)");
						proceed = in.next().charAt(0);
					} catch (Exception e) {
						System.out.print("Enter Character only");
						main(args);
					}
					if (proceed == 'y' || proceed == 'Y') {
						try {
							FileAdder.AddingFile();
						} catch (IOException e1) {

							System.out.println(e1);
						}
					} else {
						main(args);
					}
				}

				else if (option == 3) {
					try {
						System.out.println("Do you want to proceed with this option(Y/N)");
						proceed = in.next().charAt(0);
					} catch (Exception e) {
						System.out.print("Enter Character only");
						main(args);
					}
					if (proceed == 'y' || proceed == 'Y') {
						try {
							DeleteFile.deleteFile();
						} catch (IOException e) {

							System.out.println(e);
						}
					} else {
						main(args);
					}
				} else if (option == 4) {
					try {
						System.out.println("Do you want to proceed with this option(Y/N)");
						proceed = in.next().charAt(0);
					} catch (Exception e) {
						System.out.print("Enter Character only");
						main(args);
					}
					if (proceed == 'y' || proceed == 'Y') {
						Scanner reader = new Scanner(System.in);

						System.out.println("Enter path of the Directory to be Deleleted");
						String dir = reader.nextLine();
						File file = new File(dir);
						try {
							DeleteDirectory.recursiveDelete(file);
						} catch (IOException e) {

							System.out.println(e);
						}
					} else {
						main(args);
					}

				} else if (option == 5) {
					try {
						System.out.println("Do you want to proceed with this option(Y/N)");
						proceed = in.next().charAt(0);
					} catch (Exception e) {
						System.out.print("Enter Character only");
						main(args);
					}
					if (proceed == 'y' || proceed == 'Y') {

						System.out.println("\nEnter the name of the file to Search\n");
						Scanner reader1 = new Scanner(System.in);
						String dir1 = reader1.nextLine();
						String filename = dir1.toString();

						FileSearch fileSearch = new FileSearch();

						fileSearch.searchDirectory(new File("Root"), filename.toLowerCase());

						int count = fileSearch.getResult().size();
						if (count == 0) {
							System.out.println("\nNo result found!");
						} else {
							System.out.println("\nFound " + count + " result!\n");
							for (String matched : fileSearch.getResult()) {
								System.out.println("Found : " + matched);
							}
						}
					} else {
						main(args);
					}

				}

				else if (option == 0) {
					System.out.println("Thank you for using Java Fie Manager Systsem");
					System.exit(0);

					break;
				} else {
					System.out.println("\n\nWrong Choice\n\n");
				}

			} while (option != 0);
		} catch (Exception e) {
			System.out.println("Enter the Nummeric Value only");
			main(args);
		}


	}

}
