package com.linkedlist;

/*class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}*/

public class CirlularLinkedList {

	Node head;

	public void printList() {
		Node n = head;
		do {
			System.out.print(n.data + " ");
			n = n.next;
		} while (n != head);
	}

	public void insertfirst(Node node) {
		node.next = head;
		Node n = head;
        while (n.next != head) {
        	n=n.next;
        }
        n.next=node;
		head = node;
	}

	public void insertlast(Node node) {
		Node node_last =head;
		while (node_last.next != head) {
			node_last=node_last.next;
        }
		node_last.next=node;
		node.next = head;
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
		node.next = next_node;

	}
    
	public void deletenode(Node node) {
		Node n=head;
		Node pre_node = null;
		while (n.next != head) {
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
		CirlularLinkedList llist = new CirlularLinkedList();

		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		llist.head.next = second; // Link first node with the second node
		second.next = third; // Link first node with the second node
		third.next=llist.head;
		llist.insetmid(2, new Node(4));
		llist.insertfirst(new Node(5));
		llist.insertlast(new Node(6));
		llist.deletenode(new Node(3));
		llist.printList();
	}

}
