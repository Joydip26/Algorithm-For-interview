package com.bitmanupulation;

import java.util.HashMap;
import java.util.Map;


public class HuffmanCoding {
	static HashMap<String, Integer> map = new HashMap<String, Integer>();

	private static int totalbit(String value) {
		for (int i = 0; i < value.length(); i++) {
			int count = 0;
			String word = Character.toString(value.charAt(i));
			if (!map.containsKey(word)) {
				for (int j = i; j < value.length(); j++) {
					if (value.charAt(i) == value.charAt(j)) {
						count++;
					}
				}
				map.put(word, count);
			}
		}
		int bit = getdivisablebytwo(map.size());
		int total = 0;
		for (Map.Entry<String, Integer> ent : map.entrySet()) {
			total = total + bit * map.get(ent.getKey());
		}

		return total;
	}

	public static int getdivisablebytwo(int n) {
		float res = n;
		int count = 0;
		while (res != 0) {
			if ((res / 2) == 2) {
				break;
			} else {
				res--;
			}
		}
		int value = (int) (res * 2);
		while (value != 1) {
			value = value / 2;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value = "abbcdbcccdccaecfeccc";
		System.out.println(totalbit(value));
	}
}
