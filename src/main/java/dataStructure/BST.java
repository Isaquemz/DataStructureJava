package dataStructure;

public class BST {

    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public Integer getValue() {
            try{
                return this.value;
            }
            catch (Exception e) {
                return null;
            }
        }

    }

    public void insert(int value) {
        if (this.root == null) this.root = new Node(value);
        else {
            insert(root, value);
        }
    }

    private void insert(final Node node, final int value) {

        if (node == null) return;
        if (value == node.value) return;

        Node newNode = new Node(value);

        if (value > node.value) {
            if (node.right == null) node.right = newNode;
            else insert(node.right, value);
        } else {
            if (node.left == null) node.left = newNode;
            else insert(node.left, value);
        }
    }

    private boolean contains(final int value) {
        return contains(this.root, value);
    }

    private boolean contains(final Node node, final int value) {
        if (node == null) return false;
        if (value == node.value) return true;
        if (value < node.value) return contains(node.left, value);
        else return contains(node.right, value);
    }

    private void inOrder () {
        inOrder(this.root);
    }

    private void inOrder(Node node) {
        // E R D
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void deleteNode(int value) {
        this.root = deleteNode(this.root, value);
    }

    private Node deleteNode(final Node node, final int value) {
        if (node == null) {
            return null;
        };

        // Se o valor a deletar for menor que o valor atual,
        // percorre pela esquerda recursivamente.
        if (value < node.value) {
            node.left = deleteNode(node.left, value);

        // Se o valor a deletar for maior que o valor atual,
        // percorre pela direita recursivamente.
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);

        // Se não...
        } else {

            // Se não existe nós filho, retorna nulo
            if ((node.left == null) && (node.right == null)) {
                return null;

            // Se esquerda for nulo, retorna direita
            } else if (node.left == null) {
                return node.right;

            // Se direita for nulo, retorna esquerda
            } else if (node.right == null) {
                return node.left;

            // Se não,
            } else {
                int minValue = minValue(node.right);
                node.value = minValue;
                node.right = deleteNode(node.right, minValue);
            }

        }
        return node;
    }

    private Integer getValue(Node node){
        if (node == null){
            return null;
        } else {
            return node.getValue();
        }
    }

    private void verificManual(){
        System.out.println("----- Nivel 1 --------");
        System.out.println("Raiz:" + this.getValue(this.root));
        System.out.println(" ----- Nivel 2 --------");
        System.out.println("Esquerda da Raiz:" + this.getValue(this.root.left));
        System.out.println("Direita da Raiz:" + this.getValue(this.root.right));
        System.out.println(" ----- Nivel 3 --------");
        System.out.println("Esquerda da Esquerda da Raiz:" + this.getValue(this.root.left.left));
        System.out.println("Direita da Esquerda da Raiz:" + this.getValue(this.root.left.right));
        System.out.println("Esquerda da Direita da Raiz:" + this.getValue(this.root.right.left));
        System.out.println("Direita da Direita da Raiz:" + this.getValue(this.root.right.right));
        System.out.println(" ----- Nivel 4 --------");
        System.out.println("Esquerda da Esquerda da Esquerda da Raiz:" + this.getValue(this.root.left.left.left));
        System.out.println("Direita da Esquerda da Esquerda da Raiz:" + this.getValue(this.root.left.left.right));
        System.out.println("Esquerda da Direita da Esquerda da Raiz:" + this.getValue(this.root.left.right.left));
        System.out.println("Direita da Direita da Esquerda da Raiz:" + this.getValue(this.root.left.right.right));
        System.out.println("Esquerda da Esquerda da Direita da Raiz:" + this.getValue(this.root.right.left.left));
        System.out.println("Direita da Esquerda da Direita da Raiz:" + this.getValue(this.root.right.left.right));
        System.out.println("Esquerda da Direita da Direita da Raiz:" + this.getValue(this.root.right.right.left));
        System.out.println("Direita da Direita da Direita da Raiz:" + this.getValue(this.root.right.right.right));
    }

    public static void main(String[] args) {

        // BST tree = new BST();
        // tree.insert(37);
        // tree.insert(11);
        // tree.insert(66);
        // tree.insert(8);
        // tree.insert(17);
        // tree.insert(42);
        // tree.insert(72);
        // tree.inOrder();

        // System.out.println("#############################");
        // tree.deleteNode(8);
        // tree.inOrder();

        BST tree = new BST();
        tree.insert(50);
        tree.insert(17);
        tree.insert(72);
        tree.insert(12);
        tree.insert(23);
        tree.insert(54);
        tree.insert(76);
        tree.insert(9);
        tree.insert(14);
        tree.insert(19);
        tree.insert(67);
        tree.inOrder();

        System.out.println("#############################");
        tree.verificManual();

        System.out.println("#############################");
        tree.deleteNode(50);

        System.out.println("#############################");
        tree.verificManual();

        tree.inOrder();
        System.out.println(tree.contains(10));
    }

}
