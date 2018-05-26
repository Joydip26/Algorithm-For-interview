package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DijkstrasShortestpath {

	Map<Integer, Integer> parent = new HashMap<Integer, Integer>(8);
	int distance[] = new int[9];
	boolean visited[] = new boolean[9];

	static void printSolution(int dist[]) {
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < 9; i++)
			System.out.println(i + "           " + dist[i]);
	}

	static ArrayList<Integer> allconnectedadge(int graph[][], int val) {
		ArrayList<Integer> pos = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			if (graph[val][i] != 0) {
				pos.add(i);
			}
		}
		return pos;

	}

	static HashMap <Integer, ArrayList<Integer>> values(int graph[][], int row, boolean visited[], int[] distance) {
		HashMap<Integer, ArrayList<Integer>> values = new HashMap<>();
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		for (int i = 0; i < distance.length; i++) {
			if (visited[i]) {
				if (graph[row][i] != 0) {
					arrlist.add(distance[i] + graph[row][i]);
				}
			}
		}
		values.put(row, arrlist);
		return values;

	}

	void dijkstra(int graph[][], int src) {

		visited[0] = true;
		int min = 0;
		for (int i = 0; i < 8; i++) {
			ArrayList<Integer> connectededge = allconnectedadge(graph, min);
			HashMap<Integer, ArrayList<Integer>> allvalues = new HashMap<>();
			for (int j = 0; j < connectededge.size(); j++) {
				if (!visited[connectededge.get(j)]) {
					allvalues.putAll(values(graph, connectededge.get(j), visited, distance));
				}
			}
			if (allvalues.isEmpty()) {
				connectededge = allconnectedadge(graph, parent.get(min));
				for (int j = 0; j < connectededge.size(); j++) {
					if (!visited[connectededge.get(j)]) {
						allvalues.putAll(values(graph, connectededge.get(j), visited, distance));
					}
				}
			}
			java.util.Iterator<Integer> itr = allvalues.keySet().iterator();
			int minval = Integer.MAX_VALUE;
			while (itr.hasNext()) {
				Integer key = itr.next();
				ArrayList<Integer> arrval = allvalues.get(key);
				for (int x = 0; x < arrval.size(); x++) {
					if (minval > arrval.get(x)) {
						minval = arrval.get(x);
						min = key;
					}
				}

			}
			visited[min] = true;
			distance[min] = minval;
			for (int x = 0; x < visited.length; x++) {
				if (visited[x]) {
					if (graph[min][x] != 0) {
						parent.put(min, x);
						break;
					}
				}
			}

		}
		printSolution(distance);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		DijkstrasShortestpath t = new DijkstrasShortestpath();
		t.dijkstra(graph, 0);
	}

}
