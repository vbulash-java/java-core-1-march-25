package ru.bulash;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ClassWork {
	public static final String SOME_VALUE = "14";

	public static void main(String[] args) {
		//System.out.println(SOME_VALUE);
//		int[] arr = createArrayWithRandomValues(25, -10, 10);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(search(arr, -10));

		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите диапазон значений через пробел: ");
		int low = scanner.nextInt();
		int high = scanner.nextInt();

		int[] arr = createArrayWithRandomValues(25, low, high);

		System.out.println("Угадайте число в этом массиве: ");
		int guess = scanner.nextInt();
		int result = search(arr, guess);
		System.out.println(result < 0 ? "Не угадал" : "Угадал");
		System.out.println(Arrays.toString(arr));
	}

	public static int[] createArrayWithRandomValues(int length) {
		int[] arr = new int[length];
		Random random = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt();
			//System.out.println(arr[i]);
		}
		return arr;
	}

	public static int[] createArrayWithRandomValues(int length, int lowBound, int highBound) {
		int range = highBound - lowBound + 1;
		int[] arr = new int[length];
		Random random = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(range) + lowBound;
			//System.out.println(arr[i]);
		}
		return arr;
	}

	public static int search(int[] arr, int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value)
				return i;
		}
		return -1;
	}
}
