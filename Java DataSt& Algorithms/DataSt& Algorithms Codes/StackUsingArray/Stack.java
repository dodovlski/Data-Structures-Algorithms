package StackUsingArray;

public class Stack {

    private int top;
    private int[] arr;

    public Stack(int capacity) {
        top = -1;
        arr = new int[capacity];
    }

    public Stack() {
        this(10);
    }

    public int Size() {
        return top + 1;
    }

    public boolean IsEmpty() {
        return top < 0;
    }

    public boolean IsFull() {
        return arr.length == Size();
    }

    public void Push(int data) {
        if (IsFull()) {
            throw new RuntimeException("Stack is full !!!");
        }
        top++;
        arr[top] = data;
    }

    public int Pop() {
        if (IsEmpty()) {
            throw new RuntimeException("Stack is empty !!!");
        }
        int result = arr[top];
        top--;
        return result;
    }

    public int Peek() {
        if (IsEmpty()) {
            throw new RuntimeException("Stack is empty !!!");
        }
        return arr[top];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(3);
        stack.Push(10);
        stack.Push(15);
        stack.Push(20);

        System.out.println(stack.Peek());
        stack.Pop();
        System.out.println(stack.Peek());
        stack.Pop();
        System.out.println(stack.Peek());
        stack.Pop();
        stack.Pop();
    }
}