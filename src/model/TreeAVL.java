package model;

public class TreeAVL {
    private Node root;

    public int hight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHight();
    }

    int balance(Node node) {
        if (node == null) {
            return 0;
        }
        return hight(node.getLeft()) - hight(node.getRight());
    }

    public Node  rotateRight(Node x) {
        Node y = x.getLeft();
        Node t2 = y.getRight();
        y.setRight( x);
        x.setLeft(t2);
        x.setHight(Math.max(hight(x.getLeft()), hight(x.getRight())) + 1);
        y.setHight( Math.max(hight(y.getLeft()), hight(y.getRight())) + 1);

        return y;
    }

    public Node rotateLeft(Node y) {
        Node x = y.getRight();
        Node t2 = x.getLeft();
        x.setLeft(y);
        y.setRight( t2);
        y.setHight(Math.max(hight(y.getLeft()), hight(y.getRight())) + 1);
        x.setHight(Math.max(hight(x.getLeft()), hight(x.getRight())) + 1);
        return x;
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.setLeft( insert(node.getLeft(), value));
        } else if (value > node.value) {
            node.setRight(insert(node.getRight(), value));
        } else {
            return node;
        }

        node.setHight(1 + Math.max(hight(node.getLeft()), hight(node.getRight())));

        int balance = balance(node);

        if (balance > 1 && value < node.getLeft().value) {
            return rotateRight(node);
        }
        if (balance < -1 && value > node.getRight().value) {
            return rotateLeft(node);
        }
        if (balance > 1 && value > node.getLeft().value) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if (balance < -1 && value < node.getRight().value) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }

        return node;
    }

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    public void showInOrder(Node node) {
        if (node != null) {
            showInOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            showInOrder(node.getRight());
        }
    }

    public void showTree(Node node, String prefijo, boolean isLeft) {
        if (node != null) {
            System.out.println(prefijo + (isLeft ? "├── " : "└── ") + node.getValue());
            showTree(node.getLeft(), prefijo + (isLeft ? "│   " : "    "), true);
            showTree(node.getRight(), prefijo + (isLeft ? "│   " : "    "), false);
        }
    }

    public Node getRoot() {
        return root;
    }
}
