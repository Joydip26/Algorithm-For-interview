package com.bitmanupulation;

import java.util.ArrayList;

public class MagicNumber {
	ArrayList<String> arrlist = new ArrayList<String>();
	int res = 0;
	int magicNo(int n) {
		bin(n);
		for (int i = 0; i < arrlist.size(); i++) {
			if (Integer.parseInt(arrlist.get(i)) == 1) {
				res = res + (int) Math.pow(5, i + 1);
			}
		}
		return res;
	}

	void bin(int n) {
		if (n > 1)
			bin(n / 2);
		arrlist.add(Integer.toString(n % 2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MagicNumber mg = new MagicNumber();
		System.out.println(mg.magicNo(5));
	}

}
