package com.binarytree;

public class MinimumDepthTree {
	Node root;

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

	int minheight() {
		return minimumheight(root);
	}

	public int minimumheight(Node root) {
		if (root == null)
			return 0;
		if ((root.left == null) && (root.right == null))
			return 1;
		if (root.left == null)
			return minimumheight(root.right) + 1;
		if (root.right == null)
			return minimumheight(root.left) + 1;
		return Math.min(minimumheight(root.left), minimumheight(root.right)) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumDepthTree tree = new MinimumDepthTree();
		tree.add(2);
		tree.add(1);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		System.out.println(tree.minheight());
	}

}
