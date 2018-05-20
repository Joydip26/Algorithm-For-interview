package com.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

	private boolean breakWordDynamic(String str, Set<String> dictionary) {
		// TODO Auto-generated method stub
		boolean T[][] = new boolean[str.length()][str.length()];
		for (int i = 0; i < str.length(); i++) {
			String word = Character.toString(str.charAt(i));
			if (dictionary.contains(word)) {
				T[i][i] = true;
			} else {
				T[i][i] = false;
			}
		}

		for (int l = 2; l <= str.length(); l++) {
			for (int i = 0; i <= str.length() - l; i++) {
				int j = i + l - 1;
				String word = str.substring(i, j + 1);
				if (dictionary.contains(word)) {
					T[i][j] = true;
				} else {
					for (int z = 0; z < word.length(); z++) {
						if ((T[i][z] == true) && (T[z + 1][j] == true)) {
							T[i][j] = true;
							break;
						} else {
							T[i][j] = false;
						}
					}
				}
			}
		}
		return T[0][str.length() - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("I");
		dictionary.add("am");
		dictionary.add("ace");
		dictionary.add("a");
		String str = "Iamace";
		WordBreakProblem wbp = new WordBreakProblem();
		System.out.println(wbp.breakWordDynamic(str, dictionary));
	}
}
