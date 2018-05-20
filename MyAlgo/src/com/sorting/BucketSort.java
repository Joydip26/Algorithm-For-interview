package com.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
	public static int[] bucketSort(int[] array, int bucketCount) {
		if (bucketCount <= 0)
			throw new IllegalArgumentException("Invalid bucket count");
		if (array.length <= 1)
			return array;
		int high = array[0];
		int low = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > high)
				high = array[i];
			if (array[i] < low)
				low = array[i];
		}
		double arreachelementsize = ((double) (high - low + 1)) / bucketCount;

		@SuppressWarnings("unchecked")
		ArrayList<Integer> buckets[] = new ArrayList[bucketCount];
		for (int i = 0; i < bucketCount; i++) {
			buckets[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < array.length; i++) {
			buckets[(int) ((array[i] - low) / arreachelementsize)].add(array[i]);
		}

		int pointer = 0;
		for (int i = 0; i < buckets.length; i++) {
			Collections.sort(buckets[i]);
			for (int j = 0; j < buckets[i].size(); j++) {
				array[pointer] = buckets[i].get(j);
				pointer++;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 897, 565, 656, 1234, 665, 3434 };
		int sortedarray[] = bucketSort(arr, 5);
		for (int i = 0; i < sortedarray.length; i++) {
			System.out.println(sortedarray[i]);
		}

	}

}
