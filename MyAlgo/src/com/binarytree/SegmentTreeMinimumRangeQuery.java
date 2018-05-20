package com.binarytree;

public class SegmentTreeMinimumRangeQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = { 1, 2, 4, 0 };
		int segtree[];
		if (isPowerOfTwo(input.length)) {
			segtree = new int[input.length * 2 - 1];
		} else {
			segtree = new int[nextpoweroftwo(input.length) * 2 - 1];
		}
		cretesegarr(input, segtree, 0, input.length - 1, 0);
		int res = rangeminquery(segtree, 1, 3, 0, input.length - 1, 0);
		System.out.println(res);
	}

	public static void cretesegarr(int input[], int segtree[], int low, int high, int pos) {
		if (low == high) {
			segtree[pos] = input[low];
			return;
		}
		int mid = (low + high) / 2;
		cretesegarr(input, segtree, low, mid, (2 * pos + 1));
		cretesegarr(input, segtree, mid + 1, high, (2 * pos + 2));
		segtree[pos] = Math.min(segtree[2 * pos + 1], segtree[2 * pos + 2]);
	}

	public static int rangeminquery(int segtree[], int qlow, int qhigh, int low, int high, int pos) {
		if ((qlow <= low) && (qhigh >= high)) {
			return segtree[pos];
		}
		if ((qlow > high) || (qhigh < low)) {
			return Integer.MAX_VALUE;
		}
		int mid = (low + high) / 2;
		return Math.min(rangeminquery(segtree, qlow, qhigh, low, mid, (2 * pos + 1)),
				rangeminquery(segtree, qlow, qhigh, mid + 1, high, (2 * pos + 2)));
	}

	static boolean isPowerOfTwo(int n) {
		if (n == 0)
			return false;

		while (n != 1) {
			if (n % 2 != 0)
				return false;
			n = n / 2;
		}
		return true;
	}

	static int nextpoweroftwo(int n) {
		if (isPowerOfTwo(n)) {
			return n;
		} else {
			nextpoweroftwo(n + 1);
		}
		return n;
	}
}
