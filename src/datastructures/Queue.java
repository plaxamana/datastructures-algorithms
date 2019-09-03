package datastructures;

public class Queue {
    protected CLList list;

    public Queue() {
        list = new CLList();
    }

    public void add(int data) {
        list.addLast(data);
    }

    public int remove() {
        return list.removeFirst();
    }

    public int peek() {
        return list.getFirst();
    }

    public void print() {
        list.print();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(50);
        q.add(-100);
        q.print();
        System.out.println("removing from queue: " + q.remove());
        q.print();
        System.out.println("Adding to queue: 25");
        q.add(25);
        q.print();
        System.out.println("removing from queue: " + q.remove());
        q.print();
    }
}
