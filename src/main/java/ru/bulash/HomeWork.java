package ru.bulash;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.Random;

public class HomeWork {
	public static void main(String[] args) {
		HomeWork homeWork = new HomeWork();

		// Задание 1
		System.out.println("Задание 1");
		homeWork.step1(25);
		System.out.println();

		// Задание 2
		System.out.println("Задание 2");
		homeWork.step2(100);
		System.out.println();

		// Задание 3
		System.out.println("Задание 3");
		homeWork.step3();
		System.out.println();

		// Задание 4
		System.out.println("Задание 4");
		homeWork.step4(18);
		System.out.println();

		// Задание 5
		System.out.println("Задание 5");
		homeWork.step5(15, 24);
		System.out.println();

		// Задание 6
		System.out.println("Задание 6");
		homeWork.step6(25, 100);
		System.out.println();

		// Задание 7
		System.out.println("Задание 7");
		homeWork.step7(25, 15);
		System.out.println();

		// Задание 8
		System.out.println("Задание 8");
		homeWork.step8(25, 50, -3);
		System.out.println();
	}

	// 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
	private void step1(int length) {
		int[] arr = new int[length];
		Random random = new Random();

		// Заполнить случайными 0 или 1
		for (int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(2);

		System.out.println("Исходный массив: " + Arrays.toString(arr));

		int[] mirror = arr.clone();
		for (int i = 0; i < mirror.length; i++)
			mirror[i] = (mirror[i] == 1 ? 0 : 1);
		System.out.println("Преобразованный массив: " + Arrays.toString(mirror));
	}

	// 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
	private void step2(int length) {
		int[] arr = new int[length];

		for (int i = 0; i < arr.length; i++)
			arr[i] = i + 1;

		System.out.println("Заполненный массив: " + Arrays.toString(arr));
	}

	// 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
	private void step3() {
		int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

		System.out.println("Исходный массив: " + Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++)
			if (arr[i] < 6)
				arr[i] *= 2;
		System.out.println("Преобразованный массив: " + Arrays.toString(arr));
	}

	/*
	4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
	заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы
	одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
	*/
	private void step4(int dimension) {
		int[][] arr = new int[dimension][dimension];

		System.out.println("Исходный массив:");
		for (int[] ints : arr) {
			Arrays.fill(ints, 0);    // Arrays.fill работает только по одному измерению :-(
			System.out.println(Arrays.toString(ints));
		}
		// Заполняем диагонали
		System.out.println("Заполненный по диагоналям:");
		for (int idx1 = 0, idx2 = arr.length - 1; idx1 < arr.length; idx1++, idx2--) {
			arr[idx1][idx1] = 1;
			arr[idx1][idx2] = 1;
			System.out.println(Arrays.toString(arr[idx1]));
		}
	}

	// 5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
	private void step5(int len, int initialValue) {
		int[] arr = new int[len];
		Arrays.fill(arr, initialValue);
		System.out.println("Заполненный массив: " + Arrays.toString(arr));
	}

	// 6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
	private void step6(int length, int bound) {
		int[] arr = new int[length];
		Random random = new Random();

		for (int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(bound);
		System.out.println("Исходный массив: " + Arrays.toString(arr));

		int max = Integer.MIN_VALUE, max_idx = -1;
		int min = Integer.MAX_VALUE, min_idx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				max_idx = i;
			}
			if (arr[i] < min) {
				min = arr[i];
				min_idx = i;
			}
		}
		if(max_idx != -1) System.out.printf("Найдено максимальное значение %d (индекс элемента = %d)\n", max, max_idx);
		if(min_idx != -1) System.out.printf("Найдено минимальное значение %d (индекс элемента = %d)\n", min, min_idx);
	}

	// 7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
	// если в массиве есть место, в котором сумма левой и правой части массива равны.
	private void step7(int length, int bound) {
		int[] arr = new int[length];
		Random random = new Random();

		for (int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(bound);

		int[] arr1 = new int[] {1, 2, 3, 4, 6, 3, 1};

		// Правильнее будет использовать сгенерированный массив arr, но в нем равенство сумм левой и правой частей - элемент везения
		System.out.println("Исходный массив: " + Arrays.toString(arr1));

		boolean found = this.step7body(arr1);
		if (!found) System.out.println("Нет варианта равенства сумм левой и правой частей");
	}

	private boolean step7body(int[] arr) {
		int all = Arrays.stream(arr).sum();
		int left = 0;	// Указатель анализа изначально стоит левее первого элемента
		int right = all;
		boolean found = false;

		for (int i = 0; i < arr.length - 1; i++) {
			left += arr[i];		// Сумма левой части увеличивается на текущий элемент
			right -= arr[i];	// Сумма правой части уменьшается на текущий элемент
			if (left == right) {
				found = true;
				int[] leftArray = Arrays.copyOfRange(arr, 0, i + 1);
				int[] rightArray = Arrays.copyOfRange(arr, i + 1, arr.length);

				System.out.printf("Равенство левая часть sum(%s) = правая часть sum(%s) = %d\n",
						Arrays.toString(leftArray), Arrays.toString(rightArray), left);
				break;
			}
		}

		return found;
	}

	/*
	8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или
	отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
	Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один
	вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
	При каком n в какую сторону сдвиг можете выбирать сами.
	 */
	private void step8(int length, int bound, int steps) {
		int[] arr = new int[length];
		Random random = new Random();

		for (int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(bound);
		//int[] arr1 = {1, 2, 3, 4, 5};
		System.out.println("Исходный массив: " + Arrays.toString(arr));

		this.step8body(arr, steps);
	}

	private void step8body(int[] arr, int steps) {
		if (steps == 0) return;	// Нечего делать

		for (int step = 0; step < Math.abs(steps); step++) {
			int shift = Integer.MAX_VALUE;
			int current;

			if (steps > 0) {	// Сдвиг вправо на 1 шаг
				for (int from = 0, to = 1; from < arr.length; from++, to++, to %= arr.length) {
					if (shift == Integer.MAX_VALUE) shift = arr[from];
					current = arr[to];
					arr[to] = shift;
					shift = current;
				}
			} else {	// Сдвиг влево на 1 шаг
				for (int from = arr.length - 1, to = from - 1; from >= 0; from--, to--, to = to < 0 ? arr.length + to : to ) {
					if (shift == Integer.MAX_VALUE) shift = arr[from];
					current = arr[to];
					arr[to] = shift;
					shift = current;
				}
			}
		}

		System.out.printf("Исходный массив, циклически сдвинутый на %c%d (%s): %s\n", steps > 0 ? '+' : '-', Math.abs(steps), steps >0 ? "вправо" : "влево", Arrays.toString(arr));
	}
}