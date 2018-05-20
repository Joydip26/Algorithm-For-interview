package com.binarytree;

class Node {
	int data;
	Node left, right;

	Node(int d) {
		data = d;
		left = null;
		right = null;
	}
}

public class InPreProInsDelBinaryTree {

	static Node root;

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
		return root;
	}

	static void inorder(Node tree) {
		if (tree == null)
			return;
		inorder(tree.left);
		System.out.print(tree.data + "\t");
		inorder(tree.right);
	}

	static void preorder(Node tree) {
		if (tree == null)
			return;
		System.out.print(tree.data + "\t");
		preorder(tree.left);
		preorder(tree.right);
	}

	static void postorder(Node tree) {
		if (tree == null)
			return;
		postorder(tree.left);
		postorder(tree.right);
		System.out.print(tree.data + "\t");
	}

	public static void main(String args[]) {
		InPreProInsDelBinaryTree bt = new InPreProInsDelBinaryTree();
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		bt.delete(9);
		InPreProInsDelBinaryTree.inorder(root);
		InPreProInsDelBinaryTree.postorder(root);
		InPreProInsDelBinaryTree.preorder(root);
	}
}
