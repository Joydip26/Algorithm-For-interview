package com.array;

import java.util.ArrayList;

public class Smallestpositiveinteger {

	static ArrayList<Integer> arrlist = new ArrayList<Integer>();
	static int max = 0;
	static int smallestinteger = 0;

	private static int smallestpositiveinteger(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			arrlist.add(arr[i]);
			for (int j = i + 1; j < arr.length; j++) {
				int val = arrlist.get(arrlist.size() - 1) + arr[j];
				arrlist.add(val);
				if (max < val)
					max = val;
			}
		}
		for (int i = 1; i <= max + 1; i++) {
			if (!arrlist.contains(i)) {
				smallestinteger = i;
				break;
			}
		}
		return smallestinteger;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 3, 6, 10, 11, 15 };
		System.out.println(smallestpositiveinteger(arr));
	}
}
