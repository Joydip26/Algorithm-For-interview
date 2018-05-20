package com.array;


public class PythagoreanTriplet {

	private static void pythagoreanTriplet(int[] arr) {
		// TODO Auto-generated method stub
		int[] sq = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			sq[i] = (int) Math.pow(arr[i], 2);
		}
		for (int i = 0; i < sq.length - 1; i++) {
			for (int j = 1; j < sq.length; j++) {
				int value = sq[i] + sq[j];
				for (int z = 0; z < sq.length; z++) {
					if (sq[z] == value) {
						System.out.println(arr[i] + " " + arr[j] + " " + arr[z]);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 4, 6, 12, 5 };
		pythagoreanTriplet(arr);
	}

}
