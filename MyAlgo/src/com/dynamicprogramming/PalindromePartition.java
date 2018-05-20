package com.dynamicprogramming;

public class PalindromePartition {

	private int palindromeDynamic(String str) {
		// TODO Auto-generated method stub
		int T[][] = new int[str.length()][str.length()];
		for (int i = 0; i < str.length() - 1; i++) {
			T[i][i] = 0;
			T[i][i + 1] = 1;
		}

		for (int l = 3; l <= str.length(); l++) {
			for (int i = 0; i < str.length() - l + 1; i++) {
				int j = i + l - 1;
				if (ispalindrome(str.substring(i, j + 1))) {
					T[i][j] = 0;
				} else {
					T[i][j] =  Math.min((1 + T[i][i] + T[i + 1][j]), (1 + T[j][j] + T[i][j-1]));
				}
			}
		}
		return T[0][str.length() - 1];
	}

	private boolean ispalindrome(String str) {
		// TODO Auto-generated method stub
		String reverse = new StringBuffer(str).reverse().toString();
		if (str.equals(reverse))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcbm";
		PalindromePartition pp = new PalindromePartition();
		System.out.println(pp.palindromeDynamic(str));
	}
}
