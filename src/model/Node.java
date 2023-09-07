package model;

class Node {
    int value;
    Node left;
    Node right;
    int hight;

    Node(int value) {
        this.value = value;
        this.hight = 1;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getHight() {
        return hight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }
}

