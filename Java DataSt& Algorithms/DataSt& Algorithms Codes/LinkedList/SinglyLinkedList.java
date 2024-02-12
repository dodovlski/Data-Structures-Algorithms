package LinkedList;

public class SinglyLinkedList {

    private SLNode head;

    private static class SLNode {
        private int data;
        private SLNode next;

        public SLNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList slist = new SinglyLinkedList();
//        slist.head = new SLNode(10);
//        SLNode second = new SLNode(1);
//        SLNode third = new SLNode(8);
//        SLNode fourth = new SLNode(11);
//
//        // Now we will connect them together to form a chain
//        slist.head.next = second;
//        second.next = third;
//        third.next = fourth;
        slist.InsertToFront(10);
        slist.InsertToFront(2);
        slist.InsertToFront(7);
        slist.InsertToFront(16);
        slist.InsertToFront(23);
        slist.InsertToGivenPosition(33, 3);
        slist.DeleteFirst();
        slist.DeleteEnd();
        slist.Display();
        System.out.println(slist.Search(33));
        System.out.println(slist.ListSize());
    }

    public void Display() {
        SLNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int ListSize() {
        int counter = 0;
        SLNode current = head;
        while (current != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    public void InsertToFront(int data) {
        SLNode newNode = new SLNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void InsertToEnd(int data) {
        SLNode newNode = new SLNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        SLNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void InsertToGivenPosition(int data, int order) {
        SLNode newNode = new SLNode(data);
        if (order == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            SLNode prev = head;
            int count = 1;
            while (count < order - 1) {
                prev = prev.next;
                count++;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    public void DeleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void DeleteEnd() {
        if (head.next == null) {
            head = null;
            return;
        }
        SLNode current, prev;
        current = prev = head;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
    }

    public void DeleteGivenPosition(int order) {
        if (order == 1) {
            head = head.next;
        } else {
            SLNode prev = head;
            int count = 1;
            while (count < order - 1) {
                prev = prev.next;
                count++;
            }
            SLNode current = prev.next;
            prev.next = current.next;
        }
    }

    public boolean Search(int data) {
        SLNode current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public SLNode Reverse(SLNode head) {
        if (head == null) {
            return head;
        }

        SLNode current = head;
        SLNode prev = null;
        SLNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void SortedInsert(int data) {
        SLNode newNode = new SLNode(data);
        if (head == null) {
            head = newNode;
        } else if (head.data >= data) {
            newNode.next = head;
            head = newNode;
        } else {
            SLNode current = head;
            while (current.next != null && current.next.data > data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public SLNode SortedInsert_2(int data) {
        SLNode newNode = new SLNode(data);
        SLNode current = head;
        SLNode temp = null;
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    public SLNode GetMiddleNode() {
        if (head == null) {
            return null;
        }
        SLNode slowPtr = head;
        SLNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public SLNode GetNthNodeFromEnd(int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid Value : n = " + n);
        }
        SLNode mainPtr = head;
        SLNode refPtr = head;

        int count = 0;
        while (count < n) {
            if (refPtr == null) {
                throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
            }
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public void RemoveDuplicate() {
        SLNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void CreateALoopInLinkedList() {
        SLNode first = new SLNode(1);
        SLNode second = new SLNode(2);
        SLNode third = new SLNode(3);
        SLNode fourth = new SLNode(4);
        SLNode fifth = new SLNode(5);
        SLNode sixth = new SLNode(6);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }

    public boolean DetectALoop() {
        SLNode fastPtr = head;
        SLNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    public SLNode StartNodeInALoop() {
        SLNode fastPtr = head;
        SLNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                return GetStartingNode(slowPtr);
            }
        }
        return null;
    }

    private SLNode GetStartingNode(SLNode slowPtr) {
        SLNode temp = head;
        while (slowPtr != temp) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public void RemoveLoop() {
        SLNode fastPtr = head;
        SLNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                return;
            }
        }
    }

    public void RemoveLoop(SLNode slowPtr) {
        SLNode temp = head;
        while (temp.next != slowPtr.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    public static SLNode merge(SLNode a, SLNode b) {
        // a --> 1 --> 3 --> 5 --> null
        // b --> 2 --> 4 --> 6 --> null
        // result --> 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> null
        SLNode dummy = new SLNode(0);
        SLNode tail = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        // a --> 1 --> 3 --> null
        // b --> 2 --> 4 --> 6 --> 7 --> 9 --> 10 --> null
        // result --> 1 --> 2 --> 3 --> 4 --> 6 --> 7 --> 9 --> 10 --> null

        if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }

        return dummy.next;
    }
}











