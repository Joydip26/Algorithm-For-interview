package com.graph;

public class BoggleWord {

	static boolean foundword;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char boggle[][] = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
		String dictionary[] = { "GIZ", "FOR", "QEZ", "IES", "QEK" };
		for (int i = 0; i < dictionary.length; i++) {
			boolean isfind = isfind(dictionary[i], boggle);
			System.out.println("Find " + isfind);
		}
	}

	static boolean isfind(String word, char boggle[][]) {
		foundword=false;
		char fstword = word.charAt(0);
		outer:for (int row = 0; row < boggle.length; row++) {
			for (int column = 0; column < boggle[row].length; column++) {
				if (boggle[row][column] == fstword) {

					// for vertically
					int searchrow = row;
					int searchcolumn = column;
					for (int i = 0; i < word.length(); i++) {
						if (searchrow >= 0 && searchcolumn >= 0 && searchrow < boggle.length
								&& searchcolumn < boggle[row].length
								&& boggle[searchrow][searchcolumn] == word.charAt(i)) {
							if (i == 2) {
								foundword = true;
								break outer;
							}

							searchcolumn++;
							
						}
					}

					// for vertically reverse
					searchrow = row;
					searchcolumn = column;
					for (int i = 0; i < word.length(); i++) {
						if (searchrow >= 0 && searchcolumn >= 0 && searchrow < boggle.length
								&& searchcolumn < boggle[row].length
								&& boggle[searchrow][searchcolumn] == word.charAt(i)) {
							if (i == 2) {
								foundword = true;
								break outer;
							}
							searchcolumn--;
						}
					}

					// for horizentally
					searchrow = row;
					searchcolumn = column;
					for (int i = 0; i < word.length(); i++) {
						if (searchrow >= 0 && searchcolumn >= 0 && searchrow < boggle.length
								&& searchcolumn < boggle[row].length
								&& boggle[searchrow][searchcolumn] == word.charAt(i)) {
							if (i == 2) {
								foundword = true;
								break outer;
							}
							searchrow++;
						}
					}

					// for horizentally reverse
					searchrow = row;
					searchcolumn = column;
					for (int i = 0; i < word.length(); i++) {
						if (searchrow >= 0 && searchcolumn >= 0 && searchrow < boggle.length
								&& searchcolumn < boggle[row].length
								&& boggle[searchrow][searchcolumn] == word.charAt(i)) {
							if (i == 2) {
								foundword = true;
								break outer;
							}
							searchrow--;
						}
					}
					// for horizentally upward
					searchrow = row;
					searchcolumn = column;
					for (int i = 0; i < word.length(); i++) {
						if (searchrow >= 0 && searchcolumn >= 0 && searchrow < boggle.length
								&& searchcolumn < boggle[row].length
								&& boggle[searchrow][searchcolumn] == word.charAt(i)) {
							if (i == 2) {
								foundword = true;
								break outer;
							}
							searchrow++;
							searchcolumn++;
						}
					}
					// for horizentally upward reverse
					searchrow = row;
					searchcolumn = column;
					for (int i = 0; i < word.length(); i++) {
						if (searchrow >= 0 && searchcolumn >= 0 && searchrow < boggle.length
								&& searchcolumn < boggle[row].length
								&& boggle[searchrow][searchcolumn] == word.charAt(i)) {
							if (i == 2) {
								foundword = true;
								break outer;
							}
							searchrow--;
							searchcolumn++;
						}
					}

					// for horizentally downword
					searchrow = row;
					searchcolumn = column;
					for (int i = 0; i < word.length(); i++) {
						if (searchrow >= 0 && searchcolumn >= 0 && searchrow < boggle.length
								&& searchcolumn < boggle[row].length
								&& boggle[searchrow][searchcolumn] == word.charAt(i)) {
							if (i == 2) {
								foundword = true;
								break outer;
							}
							searchrow++;
							searchcolumn--;
						}
					}

					// for horizentally downword reverse
					searchrow = row;
					searchcolumn = column;
					for (int i = 0; i < word.length(); i++) {
						if (searchrow >= 0 && searchcolumn >= 0 && searchrow < boggle.length
								&& searchcolumn < boggle[row].length
								&& boggle[searchrow][searchcolumn] == word.charAt(i)) {
							if (i == 2) {
								foundword = true;
								break outer;
							}
							searchrow++;
							searchcolumn++;
						}
					}
				}
			}

		}
		return foundword;
	}

}
