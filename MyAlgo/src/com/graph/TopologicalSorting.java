package com.graph;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class TopologicalSorting {

	LinkedList<Integer> arr[];
	Stack<Integer> stack = new Stack<Integer>();

	@SuppressWarnings("unchecked")
	public void add() {
		arr = new LinkedList[6];
		for (int i = 0; i < 6; i++) {
			arr[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int vertex, int weight) {
		arr[vertex].add(weight);
	}

	public void topologicalUtil(LinkedList<Integer> arr[], int val, boolean visited[]) {
		visited[val] = true;
		ListIterator<Integer> itr = arr[val].listIterator();
		while (itr.hasNext()) {
			int value = itr.next();
			if (!visited[value])
				topologicalUtil(arr, value, visited);
		}
		stack.push(val);
	}

	public void topologicalSort() {
		boolean visited[] = new boolean[6];
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i])
				topologicalUtil(arr, i, visited);
		}
		System.out.println(stack);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopologicalSorting g = new TopologicalSorting();
		g.add();
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		g.topologicalSort();
	}

}
