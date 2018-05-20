package com.graph;

import java.util.ArrayList;
import java.util.TreeMap;

public class MSTKruskal {
	static Graph grapharr[] = new Graph[5];
	static int parent[] = new int[5];
	TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

	class Graph {
		int src, dest, weight;

		Graph(int val_src, int dest_val, int weight_val) {
			src = val_src;
			dest = dest_val;
			weight = weight_val;
		}

	}

	public void add() {
		grapharr[0] = new Graph(0, 1, 10);
		grapharr[1] = new Graph(0, 2, 6);
		grapharr[2] = new Graph(0, 3, 5);
		grapharr[3] = new Graph(1, 3, 15);
		grapharr[4] = new Graph(2, 3, 4);
	}

	int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	void Union(int x, int y) {
		parent[x] = y;
	}

	public int isCycle(int src, int dest) {
		int x = find(parent, src);
		int y = find(parent, dest);

		if (x == y)
			return 1;

		Union(x, y);
		return 0;
	}

	void primMST() {
		for (int i = 0; i < grapharr.length; i++) {
			ArrayList<Integer> arrlist = new ArrayList<>();
			arrlist.add(grapharr[i].src);
			arrlist.add(grapharr[i].dest);
			map.put(grapharr[i].weight, arrlist);
		}
		for (int i = 0; i < 5; ++i)
			parent[i] = -1;
		java.util.Iterator<Integer> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			Integer key = itr.next();
			ArrayList<Integer> arrval = map.get(key);
			if (isCycle(arrval.get(0), arrval.get(1)) != 1) {
				System.out.println(arrval.get(0) + " - " + arrval.get(1) + " -- " + key);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MSTKruskal mstkrul = new MSTKruskal();
		mstkrul.add();
		mstkrul.primMST();
	}
}
