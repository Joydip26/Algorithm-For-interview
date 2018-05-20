package com.dynamicprogramming;

public class RegexMatching {

	private boolean matchRegexDynamic(char[] text, char[] pattern) {
		// TODO Auto-generated method stub
		boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

		T[0][0] = true;
		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					T[i][j] = T[i][j - 2];
					if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) {
						T[i][j] = T[i][j] | T[i - 1][j];
					}
				} else {
					T[i][j] = false;
				}
			}
		}
		return T[text.length][pattern.length];
	}

	private boolean wildcardmatchDynamic(char[] text, char[] pattern) {
		// TODO Auto-generated method stub
		boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

		T[0][0] = true;
		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (pattern[j - 1] == '?' || pattern[j - 1] == text[i - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					T[i][j] = T[i][j - 1] | T[i - 1][j];
				} else {
					T[i][j] = false;
				}
			}
		}
		return T[text.length][pattern.length];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegexMatching rm = new RegexMatching();
		System.out.println(rm.matchRegexDynamic("xaabyc".toCharArray(), "xa*b.c".toCharArray()));
		System.out.println(rm.wildcardmatchDynamic("xaylmz".toCharArray(), "x?y*z".toCharArray()));
	}

}
