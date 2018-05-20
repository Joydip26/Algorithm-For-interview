package com.dynamicprogramming;

public class MaximumSumSubsequence {

	private int maxSumDynamic(int[] arr) {
		// TODO Auto-generated method stub
		int T[] = new int[arr.length];

		for (int i = 0; i < T.length; i++) {
			T[i] = arr[i];
		}

		for (int i = 1; i < T.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					T[i] = Math.max(T[i], T[j] + arr[i]);
				}
			}
		}

		int max = T[0];
		for (int i = 1; i < T.length; i++) {
			if (T[i] > max) {
				max = T[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSumSubsequence mss = new MaximumSumSubsequence();
		int arr[] = { 1, 101, 10, 2, 3, 100, 4 };
		int r = mss.maxSumDynamic(arr);
		System.out.print(r);
	}

}
