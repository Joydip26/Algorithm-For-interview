package com.search;

public class LinearSearch {

	public int linearSearch(int arr[], int search) {

		for (int i = 0; i < arr.length; i++) {
			if (search == arr[i])
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		LinearSearch lnrsearch = new LinearSearch();
		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 10;
		int result = lnrsearch.linearSearch(arr, x);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at " + "index " + result);
	}
}
