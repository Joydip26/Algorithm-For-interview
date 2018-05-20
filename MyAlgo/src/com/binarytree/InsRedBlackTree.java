package com.binarytree;

import java.util.HashMap;
import java.util.Map;

class RedBlackNode {
	String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	int data;
	RedBlackNode left, right;

	RedBlackNode(int d, String clr) {
		color = clr;
		data = d;
		left = null;
		right = null;
	}
}

public class InsRedBlackTree {
	static RedBlackNode root;
	static Map<RedBlackNode, RedBlackNode> map = new HashMap<RedBlackNode, RedBlackNode>();
	static Map<Integer, RedBlackNode> addnode = new HashMap<Integer, RedBlackNode>();
	boolean deleted = true;

	public void add(int val) {
		if (root == null) {
			root = new RedBlackNode(val, "Black");
			addnode.put(val, root);
			map.clear();
			parentnode(root, root);
		} else {
			root = insert(root, val);
			map.clear();
			parentnode(root, root);
		}
	}

	public RedBlackNode insert(RedBlackNode root, int val) {
		if (root == null) {
			root = new RedBlackNode(val, "Red");
			addnode.put(val, root);
		} else {
			if (val < root.data) {
				root.left = insert(root.left, val);
			} else {
				root.right = insert(root.right, val);
			}
		}
		return root;
	}

	public RedBlackNode checksibling(RedBlackNode parent) {
		RedBlackNode sibling = null;
		RedBlackNode topparent = map.get(parent);
		for (java.util.Map.Entry<RedBlackNode, RedBlackNode> entry : map.entrySet()) {
			if (entry.getKey() != entry.getValue()) {
				if (entry.getValue() == topparent) {
					if (parent.data != entry.getKey().data) {
						sibling = entry.getKey();
					}
				}
			}
		}
		return sibling;
	}

	private void checkparent(RedBlackNode node) {

		// TODO Auto-generated method stub
		RedBlackNode parent = map.get(node);
		RedBlackNode topparent = map.get(parent);
		if (!parent.color.equals("Black")) {
			RedBlackNode sibling = checksibling(parent);
			if ((sibling == null) || (!sibling.getColor().equals(node.getColor()))) {
				if ((node.data > parent.data) && (parent.data > topparent.data)) {
					RedBlackNode toppar = map.get(topparent);
					righttoright(topparent, parent, toppar);
					node = topparent;
				} else if ((node.data < parent.data) && (parent.data < topparent.data)) {
					RedBlackNode toppar = map.get(topparent);
					lefttoleft(topparent, parent, toppar);
					node = topparent;
				} else if ((node.data > parent.data) && (parent.data < topparent.data)) {
					righttoleft(parent, node, topparent);
					parent = map.get(node);
					RedBlackNode toppar = map.get(parent);
					lefttoright(parent, node, toppar);
				} else if ((node.data > parent.data) && (parent.data < topparent.data)) {
					lefttoright(parent, node, topparent);
					parent = map.get(node);
					RedBlackNode toppar = map.get(parent);
					righttoleft(parent, node, toppar);
				}
				if (node.getColor().equals("Red")) {
					node.setColor("Black");
				} else {
					node.setColor("Red");
				}
				if (parent.getColor().equals("Red")) {
					parent.setColor("Black");
				} else {
					parent.setColor("Red");
				}

			} else {
				if (parent != root) {
					parent.setColor("Black");
					sibling.setColor("Black");
					RedBlackNode toppar = map.get(parent);
					if (toppar != root)
						if (toppar.getColor().equals("Red")) {
							toppar.setColor("Black");
						} else {
							toppar.setColor("Red");
						}
					checkparent(toppar);
				}
			}

		}
	}

	public void righttoright(RedBlackNode parent, RedBlackNode node, RedBlackNode topparent) {
		RedBlackNode prevnode = parent;
		prevnode.right = null;
		map.put(node, topparent);
		map.put(parent, node);
		parent = node;
		if (node.left != null) {
			RedBlackNode temp = node.left;
			node.left = prevnode;
			node.left.right = temp;
		} else {
			node.left = prevnode;
		}

		if (node != map.get(topparent))
			topparent.right = node;
		else
			root = node;

	}

	public void lefttoleft(RedBlackNode parent, RedBlackNode node, RedBlackNode topparent) {
		RedBlackNode prevnode = parent;
		prevnode.right = null;
		map.put(node, topparent);
		map.put(parent, node);
		parent = node;
		if (node.left != null) {
			RedBlackNode temp = node.left;
			node.left = prevnode;
			node.left.right = temp;
		} else {
			node.left = prevnode;
		}

		if (node != map.get(topparent))
			topparent.left = node;
		else
			root = node;

	}

	public void righttoleft(RedBlackNode parent, RedBlackNode node, RedBlackNode topparent) {
		RedBlackNode prevnode = parent;
		prevnode.right = null;
		map.put(node, topparent);
		map.put(parent, node);
		parent = node;
		if (node.left != null) {
			RedBlackNode temp = node.left;
			node.left = prevnode;
			node.left.right = temp;
		} else {
			node.left = prevnode;
		}

		if (node != map.get(topparent))
			topparent.left = node;
		else
			root = node;

	}

	public void lefttoright(RedBlackNode parent, RedBlackNode node, RedBlackNode topparent) {
		RedBlackNode prevnode = parent;
		prevnode.left = null;
		map.put(node, topparent);
		map.put(parent, node);
		parent = node;
		if (node.right != null) {
			RedBlackNode temp = node.right;
			node.right = prevnode;
			node.right.left = temp;
		} else {
			node.right = prevnode;
		}
		if (node != map.get(topparent))
			topparent.right = node;
		else
			root = node;
	}

	public void printtree(RedBlackNode root) {
		for (java.util.Map.Entry<RedBlackNode, RedBlackNode> entry : map.entrySet()) {
			System.out.println(entry.getKey().data + "--" + entry.getKey().color);
		}
	}

	public void parentnode(RedBlackNode node, RedBlackNode root) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		map.put(node, root);
		if (node.left == null) {
			parentnode(node.right, node);
		} else if (node.right == null) {
			parentnode(node.left, node);
		} else {
			parentnode(node.left, node);
			parentnode(node.right, node);
		}

	}

	/*
	 * public void delete(RedBlackNode node) { if (node != null) { RedBlackNode
	 * parent = map.get(node); RedBlackNode sibling = checksibling(node);
	 * 
	 * if ((node.left == null) && (node.right == null) &&
	 * (node.getColor().equals("Red"))) { if (node.data > parent.data) parent.right
	 * = null; else parent.left = null;
	 * 
	 * } else { RedBlackNode nodetorepalec = findSmallest(node.right); RedBlackNode
	 * nodetorepalecparent = map.get(nodetorepalec); if ((nodetorepalec != null) &&
	 * (nodetorepalec.getColor().equals("Red"))) { nodetorepalecparent.left =
	 * nodetorepalec.right; nodetorepalec.right = node.right; nodetorepalec.left =
	 * node.left; if (node.data > parent.data) parent.right = nodetorepalec; else
	 * parent.left = nodetorepalec;
	 * 
	 * map.remove(node); map.put(nodetorepalec, parent); } else if ((nodetorepalec
	 * != null) && (nodetorepalec.getColor().equals("Black")) &&
	 * ((nodetorepalec.left == null) || (nodetorepalec.right == null))) {
	 * RedBlackNode temp = nodetorepalec.right; temp.setColor("Black");
	 * nodetorepalecparent.left = nodetorepalec.right; nodetorepalec.right =
	 * node.right; nodetorepalec.left = node.left; if (node.data > parent.data)
	 * parent.right = nodetorepalec; else parent.left = nodetorepalec;
	 * 
	 * map.remove(node); map.put(nodetorepalec, parent); } else if ((nodetorepalec
	 * != null) && (node.getColor().equals("Black")) &&
	 * (parent.getColor().equals("Red")) && (sibling.getColor().equals("BlacK"))) {
	 * if (deleted) { if (node.data > parent.data) { parent.right = null; } else {
	 * parent.left = null; } } if (sibling.getColor().equals("Red")) {
	 * sibling.setColor("Black"); } else { sibling.setColor("Red"); } if
	 * (parent.getColor().equals("Red")) { parent.setColor("Black"); } else {
	 * parent.setColor("Red"); } } else if ((nodetorepalec != null) &&
	 * (node.getColor().equals("Black")) && (sibling.getColor().equals("Black")) &&
	 * (sibling.left.getColor().equals("Red"))) { if (node.data > parent.data) {
	 * RedBlackNode toppar = map.get(parent); if (deleted) { parent.right = null; }
	 * righttoright(parent, parent.left, toppar); if
	 * (sibling.left.getColor().equals("Red")) { sibling.setColor("Black"); } else {
	 * sibling.setColor("Red"); } } else { RedBlackNode toppar = map.get(parent); if
	 * (deleted) { parent.left = null; } lefttoleft(parent, parent.right, toppar);
	 * if (sibling.right.getColor().equals("Red")) { sibling.setColor("Black"); }
	 * else { sibling.setColor("Red"); } }
	 * 
	 * } else if ((nodetorepalec != null) && (node.getColor().equals("Black")) &&
	 * (parent.getColor().equals("Black")) && (sibling.getColor().equals("Black"))
	 * && ((sibling.left == null) || (sibling.left.getColor().equals("Black")) &&
	 * ((sibling.right == null) || (sibling.right.getColor().equals("Black"))))) {
	 * if (deleted) { if (node.data > parent.data) { parent.right = null; } else {
	 * parent.left = null; } } if (sibling.getColor().equals("Red")) {
	 * sibling.setColor("Black"); } else { sibling.setColor("Red"); } deleted =
	 * false; delete(parent);
	 * 
	 * } else if ((nodetorepalec != null) && (node.getColor().equals("Black")) &&
	 * (parent.getColor().equals("Black")) && (sibling.getColor().equals("Black"))
	 * && ((sibling.right == null) || (sibling.left.getColor().equals("Red")) ||
	 * (sibling.right.getColor().equals("Black"))) || ((sibling.left == null) ||
	 * (sibling.right.getColor().equals("Red")) ||
	 * (sibling.right.getColor().equals("Black")))) {
	 * 
	 * if (node.data > parent.data) { RedBlackNode toppar = map.get(parent); if
	 * (deleted) { parent.right = null; } lefttoright(parent, sibling.left, toppar);
	 * if (sibling.left.getColor().equals("Red")) { sibling.setColor("Black"); }
	 * else { sibling.setColor("Red"); } } else { RedBlackNode toppar =
	 * map.get(parent); if (deleted) { parent.left = null; } lefttoright(parent,
	 * sibling.right, toppar); if (sibling.right.getColor().equals("Red")) {
	 * sibling.setColor("Black"); } else { sibling.setColor("Red"); } } deleted =
	 * false; delete(parent); } else if ((nodetorepalec != null) &&
	 * (node.getColor().equals("Black")) && (sibling.getColor().equals("Red")) &&
	 * ((sibling.left == null) || sibling.left.getColor().equals("Black")) &&
	 * ((sibling.right == null) || sibling.right.getColor().equals("Black"))) { if
	 * (node.data > parent.data) { RedBlackNode toppar = map.get(parent); if
	 * (deleted) { parent.right = null; } righttoright(parent, parent.left, toppar);
	 * if (sibling.left.getColor().equals("Red")) { sibling.setColor("Black"); }
	 * else { sibling.setColor("Red"); } } else { RedBlackNode toppar =
	 * map.get(parent); if (deleted) { parent.left = null; } lefttoleft(parent,
	 * parent.right, toppar); if (sibling.right.getColor().equals("Red")) {
	 * sibling.setColor("Black"); } else { sibling.setColor("Red"); } }
	 * 
	 * }
	 * 
	 * } }
	 * 
	 * }
	 * 
	 */
	public RedBlackNode findSmallest(RedBlackNode root) {
		while (root != null && root.left != null) {
			root = root.left;
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsRedBlackTree tree = new InsRedBlackTree();
		tree.add(10);
		tree.checkparent(addnode.get(10));
		tree.add(-10);
		tree.checkparent(addnode.get(-10));
		tree.add(30);
		tree.checkparent(addnode.get(30));
		tree.add(25);
		tree.checkparent(addnode.get(25));
		tree.add(40);
		tree.checkparent(addnode.get(40));
		map.clear();
		tree.parentnode(root, root);
		tree.printtree(root);

	}

}
