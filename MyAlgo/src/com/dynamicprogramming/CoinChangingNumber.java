package com.dynamicprogramming;

public class CoinChangingNumber {

	public int ccnDynamic(int total, int coins[]) {
		int temp[][] = new int[coins.length + 1][total + 1];
		for (int i = 0; i <= coins.length; i++) {
			temp[i][0] = 1;
		}
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (coins[i - 1] > j) {
					temp[i][j] = temp[i - 1][j];
				} else {
					temp[i][j] = temp[i][j - coins[i - 1]] + temp[i - 1][j];
				}
			}
		}
		return temp[coins.length][total];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChangingNumber cc = new CoinChangingNumber();
		int total = 5;
		int coins[] = { 1, 2, 3 };
		System.out.println(cc.ccnDynamic(total, coins));
	}

}
