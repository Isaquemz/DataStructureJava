package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public boolean isLeaf() {
            return (this.left == null) && (this.right == null);
        }

    }

    public void insert (int value) {
        // Se a raiz esta vazia, adiciona na rais
        if (root == null) root = new Node(value);
        else {
            Node newNode = new Node(value);

            // Adiciono valor raiz na fila para ser verificado
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while(queue.size() > 0) {

                // Pego proximo valor da fila
                Node currentNode = queue.remove();

                // Se o lado esquerdo estiver vazio, aloco no lado esquerdo
                // Se não, adiciono valor na fila para ser verificao.
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    queue.add(currentNode.left);
                }

                // Se o lado direito estiver vazio, aloco no lado direito
                // Se não, adiciono valor na fila para ser verificao.
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public void preOrder() {
        preOrder(this.root);
    }

    public void preOrder(final Node node) {
        // R E D
        if (node == null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder () {
        inOrder(this.root);
    }

    public void inOrder (final Node node) {
        // E R D
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void posOrder () {
        posOrder(this.root);
    }

    public void posOrder (final Node node) {
        // E D R
        if (node == null) return;
        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);
    }

    public void BFS() {

        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node nodeCurrent = queue.remove();
            if (nodeCurrent.left != null) queue.add(nodeCurrent.left);
            if (nodeCurrent.right != null) queue.add(nodeCurrent.right);
            System.out.println(nodeCurrent.value);
        }

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(37);
        tree.insert(11);
        tree.insert(66);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(72);

        System.out.println("###################");
        tree.preOrder();
        System.out.println("###################");

        System.out.println("###################");
        tree.inOrder();
        System.out.println("###################");

        System.out.println("###################");
        tree.posOrder();
        System.out.println("###################");

        System.out.println("###################");
        tree.BFS();
        System.out.println("###################");

//        System.out.println(tree.root.value);
//        System.out.println(tree.root.left.value);
//        System.out.println(tree.root.right.value);

    }

}
