package com.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class TopBottomViewTree {
	int distance = 0;
	Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	TreeMap<Integer, Stack<Integer>> stack = new TreeMap<Integer, Stack<Integer>>();
	Map<Integer, Queue<Integer>> queue = new HashMap<Integer, Queue<Integer>>();
	static Node root;

	public void bottomView() {
		// TODO Auto-generated method stub
		butoomView(root, distance, 0);
		for (Map.Entry<Integer, Stack<Integer>> entr : stack.entrySet()) {
			Stack<Integer> st = new Stack<Integer>();
			for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
				ArrayList<Integer> list = entry.getValue();
				if (entr.getKey() == list.get(0)) {
					st.add(entry.getKey());
				}
			}
			stack.put(entr.getKey(), st);
		}
		System.out.println("Buttom View");
		for (Map.Entry<Integer, Stack<Integer>> entry : stack.entrySet()) {
			Stack<Integer> res = entry.getValue();
			System.out.println(res.pop());
		}
	}

	public void topView() {
		// TODO Auto-generated method stub
		butoomView(root, distance, 0);
		for (Map.Entry<Integer, Queue<Integer>> entr : queue.entrySet()) {
			Queue<Integer> qu = new LinkedList<Integer>();
			for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
				ArrayList<Integer> list = entry.getValue();
				if (entr.getKey() == list.get(0)) {
					qu.add(entry.getKey());
				}
			}
			queue.put(entr.getKey(), qu);
		}
		System.out.println("Top View");
		for (Map.Entry<Integer, Queue<Integer>> entry : queue.entrySet()) {
			Queue<Integer> res = entry.getValue();
			System.out.println(res.poll());
		}
	}

	public void butoomView(Node root, int distance, int order) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		arrlist.add(distance);
		stack.put(distance, null);
		queue.put(distance, null);
		arrlist.add(order);
		map.put(root.data, arrlist);
		if (root.left == null) {
			butoomView(root.right, distance + 1, order + 1);
		} else if (root.right == null) {
			butoomView(root.left, distance - 1, order + 1);
		} else {
			butoomView(root.left, distance - 1, order + 1);
			butoomView(root.right, distance + 1, order + 1);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		/*
		 * root = new Node(1); root.left = new Node(2); root.right = new Node(3);
		 * root.left.right = new Node(4); root.left.right.right = new Node(5);
		 * root.left.right.right.right = new Node(6);
		 */

		TopBottomViewTree tree = new TopBottomViewTree();
		tree.bottomView();
		tree.topView();
	}

}
