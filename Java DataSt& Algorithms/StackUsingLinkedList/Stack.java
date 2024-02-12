package StackUsingLinkedList;

import java.util.EmptyStackException;

public class Stack {

    private ListNode top;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public Stack() {
        top = null;
        length = 0;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }

    public void Display() {
        if (IsEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        ListNode current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public boolean IsEmpty() {
        return length == 0;
    }

    public int Length() {
        return length;
    }

    public void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() {
        if (IsEmpty()) {
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public int peek() {
        if (IsEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }


}
