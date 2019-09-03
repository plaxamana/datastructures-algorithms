package datastructures;

public class CLList {

    private class Node {
        private int data;
        private Node next;
        private Node prev;

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // The first node (if it exists) will be at sentinel.next
    // The last node will be at sentinel.prev
    private Node sentinel;
    private int size;

    public CLList(){
        sentinel = new Node(88, null, null);
        size = 0;
    }

    public CLList(int x) {
        sentinel.next = new Node(x, sentinel.next, null);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return sentinel.next == null;
    }

    public void addFirst(int x) {

        if(isEmpty()){
            sentinel.next = new Node(x, sentinel, null);
            sentinel.prev = sentinel.next;
        } else {
            Node temp = sentinel.next;
            sentinel.next = new Node(x, sentinel.next, sentinel);
            temp.prev = sentinel.next;
        }

        size += 1;
    }

    public int removeFirst(){
        Node temp = sentinel.next;
        temp.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;

        return temp.data;
    }

    public int getFirst() {
        return sentinel.next.data;
    }

    public int getLast() {
        return sentinel.prev.data;
    }

    public void addLast(int x) {

        if(isEmpty()){
            sentinel.next = new Node(x, sentinel, null);
            sentinel.prev = sentinel.next;
        } else {
            Node temp = sentinel.prev;
            temp.next = new Node(x, sentinel, temp);
            sentinel.prev = temp.next;
        }
        size += 1;
    }

    public int removeLast(){
        Node temp = sentinel.prev;
        sentinel.prev = temp.prev;
        temp.prev.next = sentinel;
        size -= 1;

        return temp.data;
    }

    public void print() {
        Node p = sentinel.next;

        while (p.next != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
            if(p.data == sentinel.data) break;
        }

        System.out.println("\n");
    }

    public static void main(String[] args) {
        CLList L = new CLList();
        L.addFirst(20);
        L.addFirst(30);
        L.addFirst(50);
        L.addFirst(100);
        L.print();
        L.addLast(200);
        L.addLast(300);
        L.addLast(400);
        L.print();
        System.out.println("get first: " + L.getFirst());
        System.out.println("get last: " + L.getLast());
        System.out.println("removing last: " + L.removeLast());
        L.print();
        System.out.println("removing first: " + L.removeFirst());
        L.print();
        System.out.println("removing first: " + L.removeFirst());
        L.print();
        System.out.println("removing last: " + L.removeLast());
        L.print();
    }
}
