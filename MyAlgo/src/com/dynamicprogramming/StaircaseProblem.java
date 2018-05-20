package com.dynamicprogramming;

public class StaircaseProblem {
	public int fibonacciSeriesDynamic(int num) {
		int fst = 0, sec = 1, res = 0;
		for (int i = 0; i < num; i++) {
			res = fst + sec;
			fst = sec;
			sec = res;
		}
		return sec;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaircaseProblem fs = new StaircaseProblem();
		System.out.println(fs.fibonacciSeriesDynamic(4));

	}

}
