package com.graph;

public class MSTPrime {

	static void printMST(int parent[], int n, int key[]) {
		System.out.println("Edge   Weight");
		for (int i = 0; i < 5; i++)
			if (key[i] != 0)
				System.out.println(parent[i] + " -  " + key[i]);
	}

	public int minvalkey(int key[], boolean visited[]) {
		int min = Integer.MAX_VALUE, min_index = 0;
		for (int i = 0; i < 5; i++) {
			if ((min > key[i]) && (!visited[i])) {
				min = key[i];
				min_index = i;
			}
		}
		return min_index;
	}

	void primMST(int graph[][]) {
		int parent[] = new int[5];
		boolean visited[] = new boolean[5];
		int key[] = new int[5];

		for (int i = 0; i < 5; i++) {
			key[i] = Integer.MAX_VALUE;
		}

		visited[0] = true;
		parent[0] = 0;
		key[0] = 0;

		for (int i = 0; i < 5; i++) {
			int min_index = minvalkey(key, visited);
			visited[min_index] = true;
			parent[min_index] = min_index;
			for (int j = 0; j < 5; j++) {
				if ((graph[i][j] < key[j]) && (graph[i][j] != 0) && (visited[j] == false)) {
					key[j] = graph[i][j];
				}

			}
		}
		printMST(parent, 5, key);
	}

	public static void main(String[] args) {

		MSTPrime mst = new MSTPrime();
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 }, };

		mst.primMST(graph);
	}

}
