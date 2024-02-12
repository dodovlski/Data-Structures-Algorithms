package LinkedList;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {


    private CLNode last;
    private int length;

    private class CLNode {
        private CLNode next;
        private int data;

        public CLNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList cll = new CircularSinglyLinkedList();
        cll.CreateCircularSinglyLinkedList();
        cll.Display();
    }

    public int Length() {
        return length;
    }

    public boolean IsEmpty() {
        return length == 0;
    }

    public void CreateCircularSinglyLinkedList() {
        CLNode first = new CLNode(1);
        CLNode second = new CLNode(5);
        CLNode third = new CLNode(10);
        CLNode fourth = new CLNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    public void Display() {
        if (last == null) {
            return;
        }

        CLNode first = last.next;
        while (first != last) {
            System.out.print(first.data + " --> ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    public void InsertFirst(int data) {
        CLNode temp = new CLNode(data);
        if (last == null) {
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    public void InsertLast(int data) {
        CLNode temp = new CLNode(data);
        if (last == null) {
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    public CLNode removeFirst() {
        if (IsEmpty()) {
            throw new NoSuchElementException("Circular Singly Linked List is already empty");
        }

        CLNode temp = last.next;
        if (last.next == last) {
            last = null;
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }
}
