package com.binarytree;

public class LowestCommonAncestor {

	static Node root;

	private int lca(Node root, int n1, int n2) {
		if (root == null) {
			return 0;
		}
		if ((root.data > n1) && (root.data > n2)) {
			return lca(root.left, n1, n2);
		} else if ((root.data < n1) && (root.data < n2)) {
			return lca(root.right, n1, n2);
		}
		return root.data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowestCommonAncestor tree = new LowestCommonAncestor();
		root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		int n1 = 10, n2 = 14;
		int res = tree.lca(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + res);

		n1 = 14;
		n2 = 8;
		res = tree.lca(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + res);

		n1 = 10;
		n2 = 22;
		res = tree.lca(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + res);

	}

}
