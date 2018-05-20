package com.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class NodeRoot {
	String data;
	NodeRoot left;
	NodeRoot right;

	NodeRoot(String d) {
		data = d;
		left = null;
		right = null;
	}
}

public class Reversealternatelevel {
	static NodeRoot root;
	static Map<String, Integer> map = new HashMap<String, Integer>();
	TreeMap<Integer, Stack<String>> stack = new TreeMap<Integer, Stack<String>>();
	TreeMap<Integer, Queue<String>> queue = new TreeMap<Integer, Queue<String>>();

	public void allnodeorder(NodeRoot root, int order) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		map.put(root.data, order);
		stack.put(order, null);
		queue.put(order, null);
		if (root.left == null) {
			allnodeorder(root.right, order + 1);
		} else if (root.right == null) {
			allnodeorder(root.left, order + 1);
		} else {
			allnodeorder(root.left, order + 1);
			allnodeorder(root.right, order + 1);
		}

	}

	public void reversealternateView() {
		allnodeorder(root, 0);
		for (Entry<Integer, Stack<String>> entr : stack.entrySet()) {
			Stack<String> st = new Stack<String>();
			Queue<String> qu = new LinkedList<String>();
			for (Entry<String, Integer> entry : map.entrySet()) {
				Integer str = entry.getValue();
				if (entr.getKey() == str) {
					if (entry.getValue() % 2 != 0) {
						st.add(entry.getKey());
					} else {
						qu.add(entry.getKey());
					}
				}
			}
			stack.put(entr.getKey(), st);
			queue.put(entr.getKey(), qu);
		}
		for (Entry<Integer, Queue<String>> entry : queue.entrySet()) {
			for (Entry<Integer, Stack<String>> entr : stack.entrySet()) {
				if (entry.getKey() == entr.getKey()) {
					if (!entr.getValue().isEmpty()) {
						Stack<String> res = entr.getValue();
						while (res.size() != 0) {
							System.out.println(res.pop());
						}
					} else {
						Queue<String> res = entry.getValue();
						while (res.size() != 0) {
							System.out.println(res.poll());
						}
					}

				}

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reversealternatelevel tree = new Reversealternatelevel();
		root = new NodeRoot("a");
		root.left = new NodeRoot("b");
		root.right = new NodeRoot("c");
		root.left.left = new NodeRoot("d");
		root.left.right = new NodeRoot("e");
		root.right.left = new NodeRoot("f");
		root.right.right = new NodeRoot("g");
		root.left.left.left = new NodeRoot("h");
		root.left.left.right = new NodeRoot("i");
		root.left.right.left = new NodeRoot("j");
		root.left.right.right = new NodeRoot("k");
		root.right.left.left = new NodeRoot("l");
		root.right.left.right = new NodeRoot("m");
		root.right.right.left = new NodeRoot("n");
		root.right.right.right = new NodeRoot("o");
		tree.reversealternateView();
	}

}
