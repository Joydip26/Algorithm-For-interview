package com.sorting;

public class MergeSort {

	public void mearge(int arr[], int start, int end, int mid) {
		int n1 = mid - start + 1;
		int n2 = end - mid;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[start + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[mid + 1 + j];

		int i = 0, j = 0;

		int k = start;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

	public void sort(int arr[], int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			mearge(arr, start, end, mid);
		}
	}

	public void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		MergeSort ms = new MergeSort();
		System.out.println("Given Array");
		ms.printArray(arr);

		ms.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		ms.printArray(arr);
	}
}
