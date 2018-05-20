package com.dynamicprogramming;

public class MinCostPath {

	private int minCostDynamic(int[][] cost) {
		// TODO Auto-generated method stub
		int temp[][] = new int[cost.length][cost[0].length];
		int sum = 0;
		for (int i = 0; i < cost[0].length; i++) {
			temp[0][i] = sum + cost[0][i];
			sum = temp[0][i];
		}
		sum = 0;
		for (int i = 0; i < cost.length; i++) {
			temp[i][0] = sum + cost[i][0];
			sum = temp[i][0];
		}

		for (int i = 1; i < cost[0].length-1; i++) {
			for (int j = 1; j < cost[0].length; j++) {
				temp[i][j] = cost[i][j] + Math.min(temp[i][j - 1], temp[i - 1][j]);
			}
		}
		return temp[cost.length-1][cost.length];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinCostPath mcp = new MinCostPath();
		int cost[][] = { { 1, 3, 5, 8 }, { 4, 2, 1, 7 }, { 4, 3, 2, 3 } };
		System.out.println(mcp.minCostDynamic(cost));

	}
}
