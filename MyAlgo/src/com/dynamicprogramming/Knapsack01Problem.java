package com.dynamicprogramming;

public class Knapsack01Problem {

	public int bottomUpDPDynamic(int val[], int wt[], int W) {
		int K[][] = new int[val.length + 1][W + 1];
		 for(int i=0; i <= val.length; i++){
	            for(int j=0; j <= W; j++){
	                if(i == 0 || j == 0){
	                    K[i][j] = 0;
	                    continue;
	                }
	                if(j - wt[i-1] >= 0){
	                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
	                }else{
	                    K[i][j] = K[i-1][j];
	                }
	            }
	        }
		return K[val.length][W];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knapsack01Problem kp = new Knapsack01Problem();
		int val[] = { 1, 4, 5, 7 };
		int wt[] = { 1, 3, 4, 5 };
		System.out.println(kp.bottomUpDPDynamic(val, wt, 7));
	}

}
