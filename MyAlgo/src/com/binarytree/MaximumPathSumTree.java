package com.binarytree;

public class MaximumPathSumTree {
	Node root;
	int maxpath = Integer.MIN_VALUE;

	int findMaxUtil(Node node) {
		if (node == null)
			return 0;
		int l = findMaxUtil(node.left);
		int r = findMaxUtil(node.right);
		int max_single = Math.max(Math.max(l, r) + node.data, node.data);
		int max_top = Math.max(max_single, l + r + node.data);
		maxpath = Math.max(maxpath, max_top);
		return max_single;
	}

	int findMaxSum() {
		return findMaxSum(root);
	}

	// Returns maximum path sum in tree with given root
	int findMaxSum(Node node) {
		findMaxUtil(node);
		return maxpath;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		MaximumPathSumTree tree = new MaximumPathSumTree();
		tree.root = new Node(-1);
		tree.root.left = new Node(-2);
		tree.root.right = new Node(-3);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(-2);
		tree.root.left.left.left = new Node(-1);
		
		System.out.println("maximum path sum is : " + tree.findMaxSum());
	}
}
