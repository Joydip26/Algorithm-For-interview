package com.dynamicprogramming;

public class MinJumpToReachEnd {
	public int[] minJumpDynamic(int arr[]) {

		int[] jump = new int[arr.length];
		int result[] = new int[arr.length];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] + j >= i) {
					if (jump[i] == 0) {
						result[i] = j;
						jump[i] = jump[j] + 1;
					} else {
						jump[i] = Math.min(jump[i], jump[j] + 1);
					}
				}
			}
		}
		System.out.println("Minimum Jump :"+jump[jump.length - 1]);
		return result;
	}

	public void jumpDynamic(int result[],int arr[]) {
		int res=result[result.length-1];
		System.out.println(result.length-1);
		while(res!=0) {
			System.out.println(res);
			res=result[res];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinJumpToReachEnd mj = new MinJumpToReachEnd();
		int arr[] = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };
		int result[] = mj.minJumpDynamic(arr);
		mj.jumpDynamic(result,arr);
	}

}
