package com.dynamicprogramming;

public class LongestIncreasingSubsequence {

	int max = 0;

	public int lisDynamic(int arr[]) {

		int solution[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			solution[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (solution[j] + 1 > solution[i]) {
						solution[i] = solution[j] + 1;
						if (solution[i] > max) {
							max = solution[i];
						}
					} else {
						solution[i] = j;
						if (solution[i] > max) {
							max = solution[i];
						}
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 4, -1, 0, 6, 2, 3 };
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int result = lis.lisDynamic(arr);
		System.out.println(result);
	}

}
