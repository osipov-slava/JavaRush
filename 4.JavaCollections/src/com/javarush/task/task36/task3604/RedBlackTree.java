package com.javarush.task.task36.task3604;

public class RedBlackTree {
    private static final Node EMPTY = new Node(0);

    static {
        EMPTY.left = EMPTY;
        EMPTY.right = EMPTY;
    }

    protected Node current;
    private Node parent;
    private Node grand;
    private Node great;
    private Node header;

    public RedBlackTree() {
        header = new Node(Integer.MIN_VALUE);
        header.left = EMPTY;
        header.right = EMPTY;
    }

    public boolean isEmpty() {
        return header.left == EMPTY && header.right == EMPTY;
    }

    public void clear() {
        header.right = EMPTY;
    }

    public void insert(int item) {
        current = grand = parent = header;
        EMPTY.element = item;// чтобы дойти до листов дерева
        while (current.element != item) { // пока нашли такое же значение ИЛИ пришли в конец дерева!
            great = grand;
            grand = parent;
            parent = current;
            current = item > current.element ? current.right : current.left;

            if (current.left.color == Color.RED && current.right.color == Color.RED) {
                reorient(item);
            }
        }

        if (current != EMPTY) { // если такой элемент уже есть
            return; // ничего не делать
        }

        current = new Node(item, EMPTY, EMPTY); // добавляем новый элемент

        if (item < parent.element) { // пишем ссылку родителю
            parent.left = current;
        } else {
            parent.right = current;
        }

        reorient(item); // перебалансируем дерево
    }

    protected void reorient(int item) {
        current.color = Color.RED;
        current.left.color = Color.BLACK;
        current.right.color = Color.BLACK;

        if (parent.color == Color.RED) {
            grand.color = Color.RED;
            if (item < grand.element != item < parent.element) {
                parent = rotate(item, grand);
            }
            current = rotate(item, great);
            current.color = Color.BLACK;
        }

        header.right.color = Color.BLACK;
    }

    private Node rotate(int item, Node parent) {
        if (item < parent.element) {
            Node node = parent.left;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.left = resultNode;
            return parent.left;
        } else {
            Node node = parent.right;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.right = resultNode;
            return parent.right;
        }
    }

    private Node rotateWithLeftNode(Node element) {
        Node left = element.left;
        element.left = left.right;
        left.right = element;
        return left;
    }

    private Node rotateWithRightNode(Node element) {
        Node right = element.right;
        element.right = right.left;
        right.left = element;
        return right;
    }

    public static enum Color {
        BLACK,
        RED
    }

    public static class Node {
        private int element;
        private Node left;
        private Node right;
        private Color color;

        public Node(int element) {
            this(element, null, null);
        }

        public Node(int element, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.element = element;
            this.color = Color.BLACK;
        }
    }
}
