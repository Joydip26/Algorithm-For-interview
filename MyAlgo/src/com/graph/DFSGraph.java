package com.graph;

import java.util.LinkedList;
import java.util.ListIterator;


public class DFSGraph {

	public LinkedList<Integer> stack[];

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add() {
		stack = new LinkedList[4];
		for (int i = 0; i < 4; i++) {
			stack[i] = new LinkedList();
		}
	}

	public void insert(int edge, int weight) {
		stack[edge].add(weight);

	}

	public void dfsUtil(int val, boolean visited[]) {
		visited[val]=true;
		System.out.println(val);
		ListIterator<Integer> lst = stack[val].listIterator();
		while (lst.hasNext()) {
			int value=lst.next();
			if (!visited[value])
				dfsUtil(value, visited);
		}
	}

	public void dfs() {
		boolean visited[] = new boolean[4];
		for (int i = 0; i < 4; i++) {
			if (!visited[i]) {
				dfsUtil(i, visited);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DFSGraph dfs = new DFSGraph();
		dfs.add();
		dfs.insert(0, 1);
		dfs.insert(0, 2);
		dfs.insert(1, 2);
		dfs.insert(2, 0);
		dfs.insert(2, 3);
		dfs.insert(3, 3);
		dfs.dfs();
	}

}
