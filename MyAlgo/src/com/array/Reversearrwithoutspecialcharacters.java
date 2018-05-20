package com.array;

public class Reversearrwithoutspecialcharacters {

	private static void reverse(char[] arr) {
		// TODO Auto-generated method stub
		String reverse = "", res = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			if (Character.isAlphabetic(arr[i])) {
				reverse = reverse + arr[i];
			}
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (Character.isAlphabetic(arr[i])) {
				res = res + reverse.charAt(count++);
			} else {
				res = res + arr[i];
			}
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "a!!!b.c.d,e'f,ghi";
		char[] charArray = str.toCharArray();

		System.out.println("Input string: " + str);
		reverse(charArray);
	}
}
