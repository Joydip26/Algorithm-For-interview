package com.dynamicprogramming;

public class SubsetSum {

	private int subsetvalues(int arr[], int ival, int jval, int subset) {
		int fst = 0, sec = 0;
		int count = 0;
		for (int j = 0; j < arr.length; j++) {
			if (ival != arr[j]) {
				if (jval != arr[j]) {
					if (count < (subset - 1)) {
						fst = fst + arr[j];
					} else {
						sec = sec + arr[j];
					}
					count++;
				}
			}
		}
		return Math.abs((fst + ival) - (sec + jval));
	}

	private int subsetvalue(int arr[], int ival, int subset) {
		int fst = 0, sec = 0;
		int count = 0;
		for (int j = 0; j < arr.length; j++) {
			if (ival != arr[j]) {
				if (count < (subset - 1)) {
					fst = fst + arr[j];
				} else {
					sec = sec + arr[j];
				}
				count++;
			}
		}
		return Math.abs((fst + ival) - (sec));
	}

	private int minsubsetDynamic(int input[], int subset) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			int ival = input[i];
			if (subset == 1) {
				int values = subsetvalue(input, ival, subset);
				if (min > values) {
					min = values;
				}
			} else {
				for (int j = 0; j < input.length; j++) {
					int jval = input[j];
					int values = subsetvalues(input, ival, jval, subset);
					if (min > values) {
						min = values;
					}
				}
			}
		}
		return min;

	}

	private boolean subsetDynamic(int input[], int total) {
		boolean T[][] = new boolean[input.length + 1][total + 1];
		for (int i = 0; i <= input.length; i++) {
			T[i][0] = true;
		}

		for (int i = 1; i <= input.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j - input[i - 1] >= 0) {
					T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
				} else {
					T[i][j] = T[i - 1][j];
				}
			}
		}
		return T[input.length][total];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetSum ss = new SubsetSum();
		int arr[] = { 3, 4, 2, 1, 5, 6 };
		System.out.println(ss.subsetDynamic(arr, 14));
		System.out.println(ss.minsubsetDynamic(arr, 2));

	}

}
