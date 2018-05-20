package com.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InsDelChkAVLTree {
	static Node root;
	static Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	static ArrayList<Node> node = new ArrayList<Node>();

	public boolean checkAVLtree() {
		for (Node node : node) {
			if (!checkAVLTree(node)) {
				return false;
			}
		}
		return true;
	}

	public boolean checkAVLTree(Node root) {
		int left = 0;
		int right = 0;
		if (root == null) {
			return false;
		}
		left = heightleft(root.left);
		right = heightright(root.right);
		ArrayList<Integer> nodedistance = new ArrayList<Integer>();
		nodedistance.add(left);
		nodedistance.add(right);
		map.put(root.data, nodedistance);
		if (Math.abs(left - right) <= 1)
			return true;
		else
			return false;

	}

	private int heightright(Node node) {
		// TODO Auto-generated method stub
		if (node == null)
			return 0;
		return 1 + heightright(node.left);
	}

	private int heightleft(Node node) {
		// TODO Auto-generated method stub
		if (node == null)
			return 0;
		return 1 + heightleft(node.right);
	}

	public void addnode(Node root) {
		if (root == null) {
			return;
		}
		if (root.left == null) {
			addnode(root.right);
		} else if (root.right == null) {
			addnode(root.left);
		} else {
			addnode(root.left);
			addnode(root.right);
		}
		node.add(root);
	}

	public void add(int val) {
		root = insert(root, val);
	}

	public Node insert(Node root, int val) {
		if (root == null) {
			root = new Node(val);
		} else {
			if (val < root.data) {
				root.left = insert(root.left, val);
			} else {
				root.right = insert(root.right, val);
			}
		}
		if (!checkAVLTree(root)) {
			ArrayList<Integer> list = map.get(root.data);
			if (list.get(0) > list.get(1)) {
				Node prevroot = root;
				Node prevleft = root.left;
				root.left = root.left.right;
				root = prevleft;
				root.right = prevroot;

			} else {
				Node prevroot = root;
				Node prevright = root.right;
				root.right = root.right.left;
				root = prevright;
				root.left = prevroot;

			}
		}
		return root;
	}

	public void delete(int val) {
		root = deleteRecursive(root, val);
	}

	public Node deleteRecursive(Node root, int value) {
		if (root == null) {
			return null;
		}

		if (value == root.data) {
			if ((root.left == null) && (root.right == null)) {
				return null;
			} else if (root.left == null) {
				return root.right;
			} else {
				return root.left;
			}
		}
		if (value < root.data) {
			root.left = deleteRecursive(root.left, value);
		} else {
			root.right = deleteRecursive(root.right, value);
		}
		if (!checkAVLTree(root)) {
			ArrayList<Integer> list = map.get(root.data);
			if (list.get(0) > list.get(1)) {
				Node prevroot = root;
				Node prevleft = root.left;
				root.left = root.left.right;
				root = prevleft;
				root.right = prevroot;

			} else {
				Node prevroot = root;
				Node prevright = root.right;
				root.right = root.right.left;
				root = prevright;
				root.left = prevroot;

			}
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(15);
		// root.left.right = new Node(8);
		// root.left.right.left = new Node(7);
		InsDelChkAVLTree tree = new InsDelChkAVLTree();
		tree.addnode(root);
		tree.add(8);
		tree.add(7);
		tree.add(1);
		tree.delete(1);
		System.out.println(tree.checkAVLtree());
	}

}
