public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void addAtMiddle(int data, int index) {
        Node newNode = new Node(data);

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node temp = head;
        int idx = 0;
        size++;

        while (idx < index - 1) {
            temp = temp.next;
            idx++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst() {

        if (size == 0) {
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {

        if (size == 0) {
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        int val = temp.next.data;
        temp.next = null;
        tail = temp;

        size--;

        return val;

    }

    public int removeAtIndex(int index) {
        if(index == 0) {
            int val = removeFirst();
            return val;
        } else if (index == size - 1) {
            int val = removeLast();
            return val;
        } else if(index < 0 || index >= size) {
            return Integer.MIN_VALUE;
        }

        Node temp = head;

        int idx = 0;

        while (idx < index-1) {
            temp = temp.next;
            idx++;
        }

        int val = temp.next.data;

        temp.next = temp.next.next;
        size--;
        return val;

    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);

        ll.addAtMiddle(9, 2);

        ll.print();

        System.out.println("\nSize: " + size);

    }
}