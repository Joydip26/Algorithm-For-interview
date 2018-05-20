package com.dynamicprogramming;

class MaximumHistogram {

	public int maxHistogram(int[] temp) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				count++;
				if (min > temp[i]) {
					min = temp[i];
				}
			} else {
				count = 0;
			}
		}

		return min * count;
	}

}

public class MaximumRectangularSubmatrixOf1s {
	private int maximumDynamic(int[][] input) {
		// TODO Auto-generated method stub
		int temp[] = new int[input[0].length];
		MaximumHistogram mh = new MaximumHistogram();
		int maxArea = 0;
		int area = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if (input[i][j] == 0) {
					temp[j] = 0;
				} else {
					temp[j] += input[i][j];
				}
			}
			area = mh.maxHistogram(temp);
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[][] = { { 1, 0, 0, 1, 1, 1 }, { 1, 0, 1, 1, 0, 1 }, { 0, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1 } };
		MaximumRectangularSubmatrixOf1s mrs = new MaximumRectangularSubmatrixOf1s();
		int maxRectangle = mrs.maximumDynamic(input);
		System.out.println(maxRectangle);
	}

}
