package com.dynamicprogramming;

class Job {
	int start;
	int end;
	int profit;

	Job(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
}

public class WeightedJobSchedulingMaximumProfit {

	public boolean cheackoverlap(Job job1, Job job2) {
		if (job1.end <= job2.start) {
			return false;
		} else {
			return true;
		}
	}

	public int maximumDynamic(Job[] jobs) {
		int T[] = new int[jobs.length];
		for (int i = 0; i < jobs.length; i++) {
			T[i] = jobs[i].profit;
		}

		for (int i = 1; i < jobs.length; i++) {
			for (int j = 0; j < i; j++) {
				if (!cheackoverlap(jobs[j], jobs[i])) {
					T[i] = Math.max(T[i], jobs[i].profit + T[j]);
				}
			}
		}
		int maxVal = Integer.MIN_VALUE;
		for (int val : T) {
			if (maxVal < val) {
				maxVal = val;
			}
		}
		return maxVal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Job jobs[] = new Job[6];
		jobs[0] = new Job(1, 3, 5);
		jobs[1] = new Job(2, 5, 6);
		jobs[2] = new Job(4, 6, 5);
		jobs[3] = new Job(6, 7, 4);
		jobs[4] = new Job(5, 8, 11);
		jobs[5] = new Job(7, 9, 2);
		WeightedJobSchedulingMaximumProfit mp = new WeightedJobSchedulingMaximumProfit();
		System.out.println(mp.maximumDynamic(jobs));
	}

}
