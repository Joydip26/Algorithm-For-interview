package com.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FenwickTreeorBinaryIndexedTree {
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static ArrayList<Integer> value = new ArrayList<Integer>();
	static ArrayList<String> range = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = { 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3 };

		FenwickTreeorBinaryIndexedTree tree = new FenwickTreeorBinaryIndexedTree();
		tree.createroot(input);
		System.out.println(map);
		tree.createrange();
		System.out.println(range);
		tree.createvalue(input);
		System.out.println(value);
		tree.range(0, 5);
	}

	public void range(int start, int end) {
		int result = 0;
		int root = map.get(end + 1);
		while (root != 0) {
			result = value.get(root - 1);
			root = map.get(root);
		}
		result = result + value.get(end + 1 - 1);
		System.out.println(result);
	}

	public void createrange() {
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			range.add((Integer.toString(entry.getValue()) + Integer.toString(Math.abs(entry.getKey() - 1))));
		}
	}

	public void createvalue(int input[]) {
		for (int i = 0; i < range.size(); i++) {
			String rang = range.get(i);
			int start = Integer.parseInt(rang.substring(0, rang.length() / 2));
			int end = Integer.parseInt(rang.substring(rang.length() / 2, rang.length()));
			int val = 0;
			for (int j = start; j <= end; j++) {
				val = val + input[j];
			}
			value.add(val);
		}
	}

	public void createroot(int input[]) {
		for (int i = 1; i <= input.length; i++) {
			map.put(i, fristsetbittounset(i));
		}
	}

	static int fristsetbittounset(int n) {
		return n & (n - 1);
	}
}
