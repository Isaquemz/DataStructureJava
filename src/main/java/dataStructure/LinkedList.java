package dataStructure;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {

        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }

    }

    public LinkedList(String data) {
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public void getHead() {
        if (this.head == null){
            System.out.println("Lista vazia!");
        }else {
            System.out.println("Head: " + this.head.data);
        }
    }

    public void getTail() {
        if (this.tail == null) {
            System.out.println("Lista vazia!");
        } else {
            System.out.println("Tail: " + this.tail.data);
        }
    }

    public void getLength() {
        System.out.println("Length: " + this.length);
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Node get(int index) {
        if (index < 0 || index >= this.length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void append(String data) {
        Node newNode = new Node(data);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }

    public void preprend(String data) {
        Node newNode = new Node(data);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
          newNode.next = this.head;
          this.head = newNode;
        }
        this.length++;
    }

    public boolean set(int index, String data) {
        Node temp = get(index);
        if (temp != null) {
            temp.data = data;
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(int index, String data) {
        if(index < 0 || index > this.length) return false;
        if (index == 0) {
            preprend(data);
            return true;
        }
        if (index == this.length) {
            append(data);
            return true;
        }

        Node newNode = new Node(data);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;

    }

    public Node removeFirst() {
        if (this.length == 0) return null;
        Node temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        this.length--;
        if (this.length == 0) {
            this.head = null;
            this.tail = null;
        }
        return temp;
    }

    public Node removeLast() {
        if (this.length == 0) return null;
        Node pre = this.head;
        Node temp = null;

        while(pre.next != this.tail) {
            pre = pre.next;
        }

        temp = this.tail;
        this.tail = pre;
        this.tail.next = null;

        this.length--;
        if (this.length == 0) {
            this.head = null;
            this.tail = null;
        }
        return temp;

    }

    public Node remove (int index) {
        if (index < 0 || index >= this.length) return null;
        if (index == 0) return removeFirst();
        if (index == this.length-1) return removeLast();

        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length --;

        return temp;
    }

    public static void main(String[] args) {

        System.out.println("########################");
        LinkedList list = new LinkedList("elemento 1");
        list.getTail();
        list.getHead();
        list.getLength();
        list.print();

        System.out.println("########################");
        list.append("elemento 2");
        list.getTail();
        list.getHead();
        list.getLength();
        list.print();

        System.out.println("########################");
        list.append("elemento 3");
        list.getTail();
        list.getHead();
        list.getLength();
        list.print();

        System.out.println("########################");
        System.out.println(list.removeLast().data);
        list.getTail();
        list.getHead();
        list.getLength();
        list.print();

        System.out.println("########################");
        list.preprend("elemento 0");
        list.getTail();
        list.getHead();
        list.getLength();
        list.print();

        System.out.println("########################");
        System.out.println(list.removeFirst().data);
        list.getTail();
        list.getHead();
        list.getLength();
        list.print();

        System.out.println("########################");
        System.out.println(list.get(4));

        System.out.println("########################");
        list.insert(4, "elemento 2.5");
        list.getTail();
        list.getHead();
        list.getLength();
        list.print();

        System.out.println("########################");
        list.set(1, "elemento 0.5");
        list.getTail();
        list.getHead();
        list.getLength();
        list.print();

        System.out.println("########################");
        list.remove(2);
        list.getTail();
        list.getHead();
        list.getLength();
        list.print();

        System.out.println("########################");

    }

}
