package com.bitmanupulation;

import java.util.ArrayList;

public class SparseNumber {
	ArrayList<String> arrlist = new ArrayList<String>();

	int sparseNumber(int n) {
		bin(n);
		String bit = "";
		int pos = 0;
		for (int i = 0; i < arrlist.size(); i++) {
			if ((Integer.parseInt(arrlist.get(i)) == 0) && (Integer.parseInt(arrlist.get(i + 1)) == 1)) {
				pos = i;
				break;
			}
		}
		for (int i = 0; i < arrlist.size(); i++) {
			if (pos > i) {
				bit = bit + arrlist.get(i);
			} else if (pos == i) {
				bit = bit + "1";
			} else {
				bit = bit + "0";
			}

		}
		return Integer.parseInt(bit, 2);
	}

	void bin(int n) {
		if (n > 1)
			bin(n / 2);
		arrlist.add(Integer.toString(n % 2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparseNumber sn = new SparseNumber();
		System.out.println(sn.sparseNumber(38));
	}

}
