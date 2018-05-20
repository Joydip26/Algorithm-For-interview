package com.array;

import java.util.ArrayList;

public class Generateallpossiblesorted {
	static int fst[] = new int[] { 10, 15, 25 };
	static int sec[] = new int[] { 1, 5, 20, 30 };
	static ArrayList<String> arrlist = new ArrayList<String>();
	static ArrayList<String> arlist = new ArrayList<String>();

	static void genaratepossible() {
		for (int i = 0; i < fst.length; i++) {
			for (int j = 0; j < sec.length; j++) {
				if (fst[i] < sec[j]) {
					String str = Integer.toString(fst[i]) + Integer.toString(sec[j]);
					arrlist.add(str);
				}
			}
		}
		for (int i = 0; i < arrlist.size() - 1; i++) {
			for (int j = 1; j < arrlist.size(); j++) {
				String fstval = arrlist.get(i);
				String secval = arrlist.get(j);
				int fst = Integer.parseInt(fstval.substring((0 + fstval.length()) / 2, fstval.length()));
				int sec = Integer.parseInt(secval.substring(0, (0 + secval.length()) / 2));
				if (fst < sec) {
					arlist.add(fstval + secval);
				}
			}
		}
		arrlist.addAll(arlist);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		genaratepossible();
		System.out.println(arrlist);
	}

}
