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
					String maindirpath = "Root"; //Providing the path for the main Directory

					File maindir = new File(maindirpath);

					if (maindir.exists() == false) { //checking if main Directory exist?
						maindir.mkdir(); //if not then create main Directory
					}

					if (maindir.exists() && maindir.isDirectory()) { //checking if main Directory exists and is a directory?

						File arr[] = maindir.listFiles(); // creating the array of File object type

						System.out.println("===============================================");
						System.out.println("Files under main directory : " + maindir);
						System.out.println("===============================================");

						ContentsOfRoot.RecursivePrint(arr, 0, 0); // calling the method from ContentsOfRoot class
					} else {
						System.out.println("No Such Directory Found");
					}

				}

				else if (option == 2) {
					try {
						System.out.println("Do you want to proceed with this option(Y/N)"); // Asking the user to continue or not
						proceed = in.next().charAt(0);
					} catch (Exception e) {
						System.out.print("Enter Character only");
						main(args); // calling the main method again to give choice to the user
					}
					if (proceed == 'y' || proceed == 'Y') { // if 'Y' pressed by the user
						try {
							FileAdder.AddingFile(); //calling the Addfile method from FileAdder class 
						} catch (IOException e1) {

							System.out.println(e1); // catching exception if any gets created
						}
					} else {
						main(args); // calling the main method again to give choice to the user
					}
				}

				else if (option == 3) {
					try {
						System.out.println("Do you want to proceed with this option(Y/N)"); // Asking the user to continue or not
						proceed = in.next().charAt(0);
					} catch (Exception e) {
						System.out.print("Enter Character only");
						main(args); // calling the main method again to give choice to the user
					}
					if (proceed == 'y' || proceed == 'Y') { // if 'Y' pressed by the user
						try {
							DeleteFile.deleteFile(); // calling the deleteFile method from DeleteFile class
						} catch (IOException e) { // catching exception if any gets created

							System.out.println(e);
						}
					} else {
						main(args); // calling the main method again to give choice to the user
					}
				} else if (option == 4) {
					try {
						System.out.println("Do you want to proceed with this option(Y/N)"); // Asking the user to continue or not
						proceed = in.next().charAt(0);
					} catch (Exception e) {
						System.out.print("Enter Character only");
						main(args); // calling the main method again to give choice to the user
					}
					if (proceed == 'y' || proceed == 'Y') { // if 'Y' pressed by the user
						Scanner reader = new Scanner(System.in);

						System.out.println("Enter path of the Directory to be Deleleted"); // asking the user for path of directory to be deleted
						String dir = reader.nextLine(); // getting the input
						File file = new File(dir); // passing the input string to be used as File object
						try {
							DeleteDirectory.recursiveDelete(file); //calling the recursiveDelete method from DeleteDirectory class upon passing file object
						} catch (IOException e) { // catching exception if any gets created

							System.out.println(e);
						}
					} else {
						main(args); // calling the main method again to give choice to the user
					}

				} else if (option == 5) {
					try {
						System.out.println("Do you want to proceed with this option(Y/N)"); // Asking the user to continue or not
						proceed = in.next().charAt(0);
					} catch (Exception e) {
						System.out.print("Enter Character only");
						main(args); // calling the main method again to give choice to the user
					}
					if (proceed == 'y' || proceed == 'Y') {  // if 'Y' pressed by the user

						System.out.println("\nEnter the name of the file to Search\n");
						Scanner reader1 = new Scanner(System.in);
						String dir1 = reader1.nextLine();
						String filename = dir1.toString();

						FileSearch fileSearch = new FileSearch(); // creating the object of the FileSearch Class

						fileSearch.searchDirectory(new File("Root"), filename.toLowerCase()); // Passing root as the Directory and entered file name by user

						int count = fileSearch.getResult().size();
						if (count == 0) {
							System.out.println("\nNo result found!");
						} else {
							System.out.println("\nFound " + count + " result!\n"); // counting the number of results found
							for (String matched : fileSearch.getResult()) {
								System.out.println("Found : " + matched); // Printing the found results
							}
						}
					} else {
						main(args);
					}

				}

				else if (option == 0) { // exiting the application
					System.out.println("Thank you for using Java Fie Manager Systsem");
					System.exit(0);

					break;
				} else {
					System.out.println("\n\nWrong Choice\n\n");
				}

			} while (option != 0); // loop will keep on running till false
		} catch (Exception e) {
			System.out.println("Enter the Nummeric Value only");
			main(args); // calling the main method again to give choice to the user
		}


	}

}
