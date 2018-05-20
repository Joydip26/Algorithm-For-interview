package com.dynamicprogramming;

public class CuttingRod {

	private int calculateMaxValueDynamic(int[] price, int total) {
		// TODO Auto-generated method stub
		int T[][] = new int[price.length][total + 1];
		for (int i = 0; i < price.length; i++) {
			for (int j = 0; j <= total; j++) {
				if (j == 0) {
					T[i][j] = 0;
					continue;
				} else if (i == 0) {
					T[i][j] = price[i] * j;
				} else if (i >= j) {
					T[i][j] = T[i - 1][j];
				} else {
					T[i][j] = Math.max(T[i - 1][j], price[i] + T[i][j - (i + 1)]);
				}
			}
		}
		return T[price.length - 1][total];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CuttingRod cr = new CuttingRod();
		int[] price = { 2, 5, 7, 8 };
		int r = cr.calculateMaxValueDynamic(price, 5);
		System.out.println(r);
	}
}
