package dataStructure;

public class Stack {

    private Node top;
    private int height;

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

    public Stack(int value) {
        Node newNode = new Node(value);
        this.top = newNode;
        this.height++;
    }

    public void getTop() {
        if (this.top == null) {
            System.out.println("Pilha vazia");
        } else {
            System.out.println("Topo: " + this.top.value);
        }
    }

    public void getHeight() {
        System.out.println("Altura: " + this.height);
    }

    public void print() {
        Node temp = this.top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (this.height == 0) {
            this.top = newNode;
        } else {
            newNode.next = this.top;
            this.top = newNode;
        }
        height++;
    }

    public Node pop() {
        if (this.height == 0) return null;

        Node temp = this.top;
        this.top = temp.next;
        temp.next = null;
        this.height--;

        return temp;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack(4);

        System.out.println("############################");
        myStack.getTop();
        myStack.getHeight();
        myStack.print();

        System.out.println("############################");
        myStack.push(1);
        myStack.getTop();
        myStack.getHeight();
        myStack.print();

        System.out.println("############################");
        myStack.push(10);
        myStack.getTop();
        myStack.getHeight();
        myStack.print();

        System.out.println("############################");
        myStack.pop();
        myStack.getTop();
        myStack.getHeight();
        myStack.print();

        System.out.println("############################");

    }

}
