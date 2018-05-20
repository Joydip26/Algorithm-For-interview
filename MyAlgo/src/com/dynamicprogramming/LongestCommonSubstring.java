package com.dynamicprogramming;

public class LongestCommonSubstring {

	private int lcsDynamic(char[] str1, char[] str2) {
		// TODO Auto-generated method stub
		int solution[][] = new int[str1.length + 1][str2.length + 1];
		int max = 0;
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					solution[i][j] = solution[i - 1][j - 1] + 1;
					if (max < solution[i][j]) {
						max = solution[i][j];
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		String str1 = "abcdef";
		String str2 = "zcdemf";
		int result = lcs.lcsDynamic(str1.toCharArray(), str2.toCharArray());
		System.out.print(result);
	}

}
