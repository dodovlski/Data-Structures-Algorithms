package LinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private DLNode head;
    private DLNode tail;
    private int length;

    private class DLNode {
        private int data; // Can be any generic type
        private DLNode next;
        private DLNode prev;

        public DLNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.InsertEnd(1);
        dll.InsertEnd(2);
        dll.InsertEnd(3);

        dll.DisplayForward();

        dll.DeleteEnd();
        dll.DeleteEnd();

        dll.DisplayForward();
    }


    public boolean isEmpty() {
        return length == 0; // or head == null
    }

    public int Length() {
        return length;
    }

    public void DisplayForward() {
        if (head == null) {
            return;
        }
        DLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void DisplayBackward() {
        if (head == null) {
            return;
        }
        DLNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public void InsertFront(int value) {
        DLNode newNode = new DLNode(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void InsertEnd(int value) {
        DLNode newNode = new DLNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    public DLNode DeleteFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        DLNode temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public DLNode DeleteEnd() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        DLNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
        temp.prev = null;
        length--;
        return temp;
    }
}
