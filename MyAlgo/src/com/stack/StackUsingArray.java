package com.stack;

public class StackUsingArray {
	int top = -1;
	int stack[] = new int[10];

	public void push(int val) {
		if (isfull()) {
			System.out.println("Stack Overflow");
		} else {
			stack[++top] = val;
			
		}

	}

	public int pop() {
		if (stack.length == 0) {
			System.out.println("Stack empty");
			return 0;
		}
		return stack[top--];
	}

	public boolean isfull() {
		if (top == 10) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingArray s = new StackUsingArray();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
	}

}
