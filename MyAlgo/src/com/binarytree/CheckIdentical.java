package com.binarytree;

public class CheckIdentical {
	static Node root1, root2;

	private boolean areIdentical(Node root1, Node root2) {
		// TODO Auto-generated method stub
		if ((root1 == null) && (root2 == null))
			return true;
		if ((root1 == null) || (root2 == null))
			return false;
		return (root1.data == root2.data && areIdentical(root1.left, root2.left)
				&& areIdentical(root1.right, root2.right));
	}

	boolean isSubtree(Node root1, Node root2) {
		if (root2 == null)
			return true;
		if (root1 == null)
			return false;
		if (areIdentical(root1, root2))
			return true;
		return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckIdentical check = new CheckIdentical();
		root1 = new Node(26);
		root1.right = new Node(3);
		root1.right.right = new Node(3);
		root1.left = new Node(10);
		root1.left.left = new Node(4);
		root1.left.left.right = new Node(30);
		root1.left.right = new Node(6);

		// TREE 2
		/*
		 * Construct the following tree 10 / \ 4 6 \ 30
		 */

		root2 = new Node(10);
		root2.right = new Node(6);
		root2.left = new Node(4);
		root2.left.right = new Node(30);

		if (check.isSubtree(root1, root2))
			System.out.println("Tree 2 is subtree of Tree 1 ");
		else
			System.out.println("Tree 2 is not a subtree of Tree 1");
	}

}
