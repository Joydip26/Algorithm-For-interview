package com.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Bridges {

	public LinkedList<Integer> graph[];
	int time = 0;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add() {
		graph = new LinkedList[7];
		for (int i = 0; i < 7; i++) {
			graph[i] = new LinkedList();
		}
	}

	public void insert(int edge, int weight) {
		graph[edge].add(weight);
		graph[weight].add(edge);

	}

	void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {

		visited[u] = true;
		disc[u] = low[u] = time++;

		Iterator<Integer> i = graph[u].iterator();
		while (i.hasNext()) {
			int v = i.next();
			if (!visited[v]) {
				parent[v] = u;
				bridgeUtil(v, visited, disc, low, parent);

				low[u] = Math.min(low[u], low[v]);

				if (low[v] > disc[u])
					System.out.println(u + " " + v);
			}

			else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
	}

	void bridge() {
		boolean visited[] = new boolean[7];
		int disc[] = new int[7];
		int low[] = new int[7];
		int parent[] = new int[7];

		for (int i = 0; i < 7; i++)
			if (visited[i] == false)
				bridgeUtil(i, visited, disc, low, parent);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bridges bridge = new Bridges();
		bridge.add();
		bridge.insert(0, 1);
		bridge.insert(1, 2);
		bridge.insert(2, 0);
		bridge.insert(1, 3);
		bridge.insert(1, 4);
		bridge.insert(1, 6);
		bridge.insert(3, 5);
		bridge.insert(4, 5);
		bridge.bridge();
	}

}
