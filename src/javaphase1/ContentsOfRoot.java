package javaphase1;

import java.io.File;

public class ContentsOfRoot {

	static void RecursivePrint(File[] arr, int index, int level) {

		if (index == arr.length) // terminate condition 
			return;

		for (int i = 0; i < level; i++) // tabs for internal levels
			System.out.print("\t");

		if (arr[index].isFile()) // for files
			System.out.println(arr[index].getName());

		else if (arr[index].isDirectory()) // for sub-directories 
		{
			System.out.println("[" + arr[index].getName() + "]");

			RecursivePrint(arr[index].listFiles(), 0, level + 1); // recursion for sub-directories
		}

		RecursivePrint(arr, ++index, level);  // recursion for main directory
	}
}
