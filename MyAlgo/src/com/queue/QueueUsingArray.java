package com.queue;

public class QueueUsingArray {
	int front = -1;
	int rear = -1;
	int Queue[] = new int[10];

	public void enqueue(int val) {
		if (isfull()) {
			System.out.println("Stack Overflow");
		} else {
			Queue[++rear] = val;
		}
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Stack Empty");
		}
		return Queue[++front];
	}

	public boolean isfull() {
		if (rear == 10) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isEmpty() {
		if (front == -1) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingArray queue = new QueueUsingArray();
        queue.enqueue(4);
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);
        System.out.println("Removed element "+queue.dequeue());
	}

}
