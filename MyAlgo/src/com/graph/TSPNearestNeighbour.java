package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class TSPNearestNeighbour {
	ArrayList<String> allcombo = new ArrayList<>();
	TreeSet<Integer> allsubsetcombo = new TreeSet<>();
	int parent[] = null;
	int shrostestpath[] = null;
	ArrayList<Integer> finalpath = new ArrayList<>();

	public void generatesubset(int adjacency_matrix[][]) {
		for (int i = 1; i < adjacency_matrix.length; i++) {
			genarateallcombination("", i, adjacency_matrix.length);
		}
		for (int j = 0; j < allcombo.size(); j++) {
			String val1 = allcombo.get(j);
			if ((val1.length() == 1) || (val1.length() == adjacency_matrix.length - 1))
				allsubsetcombo.add(Integer.parseInt(val1 + "0"));
			for (int z = 0; z < allcombo.size(); z++) {
				String val2 = allcombo.get(z);
				if (val1.length() == 1) {
					if (!val1.equals(val2)) {
						if (val2.length() == 1) {
							allsubsetcombo.add(Integer.parseInt(val1 + val2));
							allsubsetcombo.add(Integer.parseInt(val2 + val1));
						} else {
							if (!val2.contains(val1)) {
								allsubsetcombo.add(Integer.parseInt(val1 + val2));
							}
						}
					}
				}
			}
		}
		shrotestpath(adjacency_matrix);
		System.out.println(allsubsetcombo);
		System.out.println(Arrays.toString(shrostestpath));
		System.out.println(Arrays.toString(parent));
		System.out.println(finalpath);
	}

	public void shrotestpath(int adjacency_matrix[][]) {
		parent = new int[allsubsetcombo.size()];
		shrostestpath = new int[allsubsetcombo.size()];
		int count = 0;
		Iterator<Integer> itr = allsubsetcombo.iterator();
		while (itr.hasNext()) {
			String value = Integer.toString(itr.next());
			if (value.length() == 2) {
				calculatepathforsubsetsizetwo(adjacency_matrix, value, count);
			} else if (value.length() != adjacency_matrix.length) {
				calculatepathforsubsetsizemorethantwo(adjacency_matrix, value, count);
			} else {
				String fstval = value.substring(value.length() - 1, value.length());
				String sndval = value.substring(0, value.length() - 1);
				calculatepathforsubsetsizemorethantwo(adjacency_matrix, fstval + sndval, count);
				calculatefinalpath(value);
			}
			count++;
		}
	}

	public void calculatefinalpath(String value) {
		int parentval = searchparent(value);
		finalpath.add(parentval);
		while (parentval != 0) {
			String replace_val = "";
			if (value.contains("0")) {
				replace_val = value.replace("0", "");
				replace_val = "0" + replace_val;
			} else {
				replace_val = value;
			}
			String substring = replace_val.substring(1, value.length());
			String valuetotal = "";
			valuetotal = substring.replace(Integer.toString(parentval), "");
			if (valuetotal.equals("")) {
				calculatefinalpath(Integer.toString(parentval) + "0");
				break;
			} else {
				calculatefinalpath(Integer.toString(parentval) + valuetotal);
				break;
			}
		}
	}

	public void calculatepathforsubsetsizetwo(int adjacency_matrix[][], String val, int pos) {
		int first = Integer.parseInt(val.substring(0, 1));
		int second = Integer.parseInt(val.substring(1, 2));
		int value = adjacency_matrix[second][first] + adjacency_matrix[0][second];
		shrostestpath[pos] = value;
		parent[pos] = second;

	}

	public void calculatepathforsubsetsizemorethantwo(int adjacency_matrix[][], String val, int pos) {
		int first = Integer.parseInt(val.substring(0, 1));
		String second = val.substring(1, val.length());
		ArrayList<Integer> sec = new ArrayList<>();
		ArrayList<Integer> thrd = new ArrayList<>();
		String valuetotal = "";
		for (int i = 0; i < second.length(); i++) {
			String value = Character.toString(second.charAt(i));
			sec.add(Integer.parseInt(value));
			for (int j = 0; j < second.length(); j++) {
				if (!value.equals(Character.toString(second.charAt(j)))) {
					valuetotal = valuetotal + second.charAt(j);
				}
			}
			thrd.add(Integer.parseInt(valuetotal));
			valuetotal = "";
		}
		int value = Integer.MAX_VALUE;
		for (int z = 0; z < sec.size(); z++) {
			if (value > adjacency_matrix[sec.get(z)][first]
					+ searchvalue(Integer.toString(sec.get(z)) + Integer.toString(thrd.get(z)))) {
				value = adjacency_matrix[sec.get(z)][first]
						+ searchvalue(Integer.toString(sec.get(z)) + Integer.toString(thrd.get(z)));
				shrostestpath[pos] = value;
				parent[pos] = sec.get(z);

			}
		}

	}

	public int searchparent(String value) {
		int count = 0;
		Iterator<Integer> itr = allsubsetcombo.iterator();
		while (itr.hasNext()) {
			String val = Integer.toString(itr.next());
			if (val.equals(value)) {
				return parent[count];
			}
			count++;
		}
		return 0;
	}

	public int searchvalue(String value) {
		int count = 0;
		Iterator<Integer> itr = allsubsetcombo.iterator();
		while (itr.hasNext()) {
			String val = Integer.toString(itr.next());
			if (val.equals(value)) {
				return shrostestpath[count];
			}
			count++;
		}
		return 0;
	}

	public void genarateallcombination(String val, int i, int totallength) {
		val = val + Integer.toString(i);
		allcombo.add(val);
		for (i = i + 1; i < totallength; i++) {
			genarateallcombination(val, i, totallength);
		}
	}

	public static void main(String... arg) {
		/*
		 * int number_of_nodes; Scanner scanner = null;
		 * System.out.println("Enter the number of nodes in the graph"); scanner = new
		 * Scanner(System.in); number_of_nodes = scanner.nextInt();
		 * 
		 * int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
		 * System.out.println("Enter the adjacency matrix"); for (int i = 1; i <=
		 * number_of_nodes; i++) { for (int j = 1; j <= number_of_nodes; j++) {
		 * adjacency_matrix[i][j] = scanner.nextInt(); } }
		 */
		int adjacency_matrix[][] = { { 0, 1, 15, 6 }, { 2, 0, 7, 3 }, { 9, 6, 0, 12 }, { 10, 4, 8, 0 } };
		TSPNearestNeighbour tspNearestNeighbour = new TSPNearestNeighbour();
		tspNearestNeighbour.generatesubset(adjacency_matrix);
		/* scanner.close(); */
	}
}