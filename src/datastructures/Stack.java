package datastructures;

public class Stack {
    protected CLList list;

    public Stack() {
        list = new CLList();
    }

    public int peek() {
        return list.getFirst();
    }

    public void push(int data) {
        list.addFirst(data);
    }

    public int pop() {
        return list.removeFirst();
    }

    public void print() {
        list.print();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(20);
        s.push(100);
        s.push(200);
        s.print();
        System.out.println("popping off from stack: " + s.pop());
        s.print();
        System.out.println("pushing to stack: 11");
        s.push(11);
        System.out.println("pushing to stack: 22");
        s.push(22);
        s.print();
        System.out.println("popping from stack: " + s.pop());
        s.print();
    }
}
