package com.linkedlist;


class Node{
	 int data;
	 Node prev;
	 Node next;
	 Node(int val){
		 data=val;
		 prev = null;
		 next=null;
	 }
}

public class DoubleLinkedlist {
	Node head;
	
	public void printlist() {
		Node n=head;
		while(n != null) {
			System.out.println(n.data);
			n=n.next;
		}
	}
	
	public void insertfirst(Node node) {
		Node n = head;
		node.next = n;
		n.prev = node;
		head = node;
	}

	public void insertlast(Node node) {
		Node n=head;
		Node node_last =head;
		while (n != null) {
			node_last=n;
			n = n.next;
		}
		node_last.next=node;
		node.prev=node_last;
	}

	public void insetmid(int pos, Node node) {
		int val = 0;
		Node pre_node, next_node = null;
		pre_node = head;
		while (pre_node != null) {
			if (val == pos) {
				break;
			} else {
				next_node = pre_node.next;
				val++;
			}
		}
		pre_node.next = node;
		node.prev=pre_node;
		node.next = next_node;

	}
    
	public void deletenode(Node node) {
		Node n=head;
		Node pre_node = null;
		while (n != null) {
			if(n.data==node.data) {
				pre_node.next=n.next;
				break;
			}
			pre_node=n;
			n=n.next;
		}
		
	}

	
	
	
	
	public static void main(String[] args) {
		/* Start with the empty list. */
		DoubleLinkedlist llist = new DoubleLinkedlist();

		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		llist.head.next = second;
		// Link first node with the second node
		second.next = third; // Link first node with the second node
		second.prev = llist.head;
		third.prev=second;
		llist.insetmid(2, new Node(4));
		llist.insertfirst(new Node(5));
		llist.insertlast(new Node(6));
		llist.deletenode(new Node(3));
		llist.printlist();
	}

}
