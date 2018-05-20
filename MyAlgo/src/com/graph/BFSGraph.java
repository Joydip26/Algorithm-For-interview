package com.graph;

import java.util.LinkedList;
import java.util.ListIterator;

public class BFSGraph {

	public LinkedList<Integer> queue[];

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add() {
		queue = new LinkedList[4];
		for (int i = 0; i < 4; i++) {
			queue[i] = new LinkedList();
		}
	}

	public void insert(int edge, int weight) {
		queue[edge].add(weight);

	}

	public void bfs(int val) {
		boolean visited[] = new boolean[4];
		LinkedList<Integer> queuelist = new LinkedList<Integer>();
		visited[val] = true;
		queuelist.add(val);
		while (queuelist.size() != 0) {
			int res=queuelist.poll();
			System.out.println(res);
			ListIterator<Integer> itr = queue[res].listIterator();
			while (itr.hasNext()) {
				int value = itr.next();
				if (!visited[value]) {
					queuelist.add(value);
					visited[value] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFSGraph bfs = new BFSGraph();
		bfs.add();
		bfs.insert(0, 1);
		bfs.insert(0, 2);
		bfs.insert(1, 2);
		bfs.insert(2, 0);
		bfs.insert(2, 3);
		bfs.insert(3, 3);
		bfs.bfs(2);
	}

}
