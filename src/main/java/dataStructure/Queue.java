package dataStructure;

public class Queue {

    private Node first;
    private Node last;
    private int lenght;

    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Queue (int value) {
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        this.lenght++;
    }

    public void getFirst() {
        if (this.first != null) {
            System.out.println("First: " + this.first.value);
        } else {
            System.out.println("Fila está vazia");
        }
    }

    public void getLast() {
        if (this.last != null) {
            System.out.println("Last: " + this.last.value);
        } else {
            System.out.println("Fila está vazia");
        }
    }

    public void getLength() {
        System.out.println("Length: " + this.lenght);
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (this.lenght == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
        this.lenght++;
    }

    public Node dequeue() {
        if (this.lenght == 0) return null;
        Node temp = this.first;
        if (this.lenght == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = temp.next;
            temp.next = null;
        }
        this.lenght--;

        return temp;
    }

    public void print() {
        if (this.first == null) System.out.println("Fila esta vazia");

        Node temp = this.first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue(1);

        System.out.println("#############################");
        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.print();

        System.out.println("#############################");
        myQueue.enqueue(3);
        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.print();

        System.out.println("#############################");
        myQueue.enqueue(13);
        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.print();

        System.out.println("#############################");
        myQueue.dequeue();
        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.print();

        System.out.println("#############################");

    }

}
