package javaphase1;

import java.io.File;

public class ContentsOfRoot {

	static void RecursivePrint(File[] arr, int index, int level) {

		if (index == arr.length)
			return;

		for (int i = 0; i < level; i++)
			System.out.print("\t");

		if (arr[index].isFile())
			System.out.println(arr[index].getName());

		else if (arr[index].isDirectory()) {
			System.out.println("[" + arr[index].getName() + "]");

			RecursivePrint(arr[index].listFiles(), 0, level + 1);
		}

		RecursivePrint(arr, ++index, level);
	}
}
