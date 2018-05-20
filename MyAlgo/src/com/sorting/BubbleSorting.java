package com.sorting;

public class BubbleSorting {
	public void bubbleSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

	public void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSorting ob = new BubbleSorting();
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		ob.bubbleSort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
	}

}
