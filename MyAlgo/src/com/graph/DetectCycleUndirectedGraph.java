package com.graph;

public class DetectCycleUndirectedGraph {

	static Graph grapharr[] = new Graph[3];
	static int parent[] = new int[3];;

	class Graph {
		int src, dest;

		Graph(int val_src, int dest_val) {
			src = val_src;
			dest = dest_val;
		}

	}

	public void add() {
		grapharr[0] = new Graph(0, 1);
		grapharr[1] = new Graph(1, 2);
		grapharr[2] = new Graph(0, 2);
	}

	int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	void Union(int x, int y) {
		parent[x] = y;
	}

	public int isCycle(Graph graarr[]) {

		for (int i = 0; i < 3; ++i)
			parent[i] = -1;

		for (int i = 0; i < 3; ++i) {
			int x = find(parent, grapharr[i].src);
			int y = find(parent, grapharr[i].dest);

			if (x == y)
				return 1;

			Union(x, y);
		}
		return 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetectCycleUndirectedGraph undirgraph = new DetectCycleUndirectedGraph();
		undirgraph.add();
		if (undirgraph.isCycle(grapharr) == 1)
			System.out.println("graph contains cycle");
		else
			System.out.println("graph doesn't contain cycle");
	}

}
