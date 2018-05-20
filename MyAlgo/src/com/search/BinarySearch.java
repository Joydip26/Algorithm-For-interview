package com.search;

public class BinarySearch {
	public int binarySearch(int arr[], int start, int end, int serach) {
		int mid = (start + end) / 2;
		if (serach == arr[mid]) {
			return mid;
		} else if (serach > mid) {
			return binarySearch(arr, mid, end, serach);
		} else {
			return binarySearch(arr, start, mid, serach);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearch ob = new BinarySearch();
		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 10;
		int result = ob.binarySearch(arr, 0, arr.length, x);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at " + "index " + result);
	}

}
