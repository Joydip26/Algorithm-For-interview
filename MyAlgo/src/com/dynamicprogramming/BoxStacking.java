package com.dynamicprogramming;

import java.util.Arrays;

class Dimension implements Comparable<Dimension> {
	int height;
	int length;
	int width;

	Dimension(int height, int length, int width) {
		this.height = height;
		this.length = length;
		this.width = width;
	}

	Dimension() {
	}

	static Dimension createDimension(int height, int side1, int side2) {
		Dimension d = new Dimension();
		d.height = height;
		if (side1 >= side2) {
			d.length = side1;
			d.width = side2;
		} else {
			d.length = side2;
			d.width = side1;
		}
		return d;
	}

	public int compareTo(Dimension d) {
		if (this.length * this.width >= d.length * d.width) {
			return -1;
		} else {
			return 1;
		}
	}

}

public class BoxStacking {

	private int maxHeightDynamic(Dimension[] input) {
		// TODO Auto-generated method stub
		Dimension[] allRotationInput = new Dimension[input.length * 3];
		createAllRotation(input, allRotationInput);

		Arrays.sort(allRotationInput);

		int T[] = new int[allRotationInput.length];
		int result[] = new int[allRotationInput.length];

		for (int i = 0; i < T.length; i++) {
			T[i] = allRotationInput[i].height;
			result[i] = i;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < T.length; i++) {
			for (int j = 0; j < i; j++) {
				if (allRotationInput[i].length < allRotationInput[j].length
						&& allRotationInput[i].width < allRotationInput[j].width) {
					if (T[j] + allRotationInput[i].height > T[i]) {
						T[i] = T[j] + allRotationInput[i].height;
						result[i] = j;
						if (T[i] > max) {
							max = T[i];
						}
					}
				}
			}
		}
		return max;

	}

	private void createAllRotation(Dimension[] input, Dimension[] allRotationInput) {
		// TODO Auto-generated method stub
		int index = 0;
		for (int i = 0; i < input.length; i++) {
			allRotationInput[index++] = Dimension.createDimension(input[i].height, input[i].length, input[i].width);
			allRotationInput[index++] = Dimension.createDimension(input[i].length, input[i].height, input[i].width);
			allRotationInput[index++] = Dimension.createDimension(input[i].width, input[i].length, input[i].height);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoxStacking bs = new BoxStacking();
		Dimension input[] = { new Dimension(3, 2, 5), new Dimension(1, 2, 4) };
		int maxHeight = bs.maxHeightDynamic(input);
		System.out.println("Max height is " + maxHeight);
	}

}
