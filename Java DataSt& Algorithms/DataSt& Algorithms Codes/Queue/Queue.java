package Queue;

import java.util.NoSuchElementException;

public class Queue {

    private ListNode front;
    private ListNode rear;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        front = null;
        rear = null;
        length = 0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.Enqueue(10);
        queue.Enqueue(15);
        queue.Enqueue(20);

        queue.Display();

        queue.Dequeue();
        queue.Dequeue();

        queue.Display();
    }
    public int Length() {
        return length;
    }

    public boolean IsEmpty() {
        return length == 0;
    }

    public void Enqueue(int data) {
        ListNode temp = new ListNode(data);
        if (IsEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }

        rear = temp;
        length++;
    }

    public int Dequeue() {
        if (IsEmpty()) {
            throw new NoSuchElementException("Queue is already empty");
        }

        int result = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;
        return result;
    }

    public void Display() {
        if (IsEmpty()) {
            return;
        }

        ListNode current = front;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }


}

