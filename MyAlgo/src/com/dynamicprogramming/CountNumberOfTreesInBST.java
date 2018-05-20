package com.dynamicprogramming;

public class CountNumberOfTreesInBST {

	private int countTreesDynamic(int n) {
		// TODO Auto-generated method stub
		int T[] = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        for(int i=2; i <= n; i++){
            for(int j=0; j <i; j++){
                T[i] += T[j]*T[i-j-1];
            }
        }
        return T[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountNumberOfTreesInBST cnt = new CountNumberOfTreesInBST();
		System.out.println(cnt.countTreesDynamic(3));
	}

}
