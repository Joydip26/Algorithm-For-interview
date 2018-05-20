package com.array;

import java.util.Arrays;

public class ZigZag {
	static int arr[] = new int[] { 4, 3, 7, 8, 6, 2, 1 };
	static int temp = 0;

	static void zigZag() {
		for (int i = 1; i < arr.length - 1; i = i + 2) {
			if (arr[i - 1] > arr[i]) {
				temp = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = temp;
			}
			if (arr[i] < arr[i + 1]) {
				temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		zigZag();
		System.out.println(Arrays.toString(arr));
	}

}
