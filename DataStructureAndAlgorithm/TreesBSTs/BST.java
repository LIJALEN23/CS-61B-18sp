/**===========================
 *      二叉搜索树的简单实现
 * 完成时间：2024.6.13
 * 问题：未测试
 *
 * 难点：
 *
 * 借鉴于菜鸟教程
 * ===========================
 * */


import java.util.Deque;
import java.util.LinkedList;

public class BST <Key extends Comparable<Key>, Val> {
    private class Node {
        private Key key;
        private Val val;
        private Node left, right;

        public Node(Key key, Val val) {
            this.key = key;
            this.val = val;
            left = right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Key key, Val val) {
        root = insert(root, key, val);
    }

    public boolean contain(Key key) {
        return contain(root, key);
    }

    public Val search(Key key) {
        return search(root, key);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void levelOrder() {
        if (root == null) {
            return ;
        }

        Deque<Node> deque = new LinkedList<Node>();
        deque.add(root);

        while (!deque.isEmpty()) {
            Node currentNode = deque.poll();
            System.out.println(currentNode.key);

            if (currentNode.left != null) {
                deque.add(currentNode.left);
            }
            if (currentNode.right != null) {
                deque.add(currentNode.right);
            }
        }
    }

    public Key minimum() {
        if (root == null) {
            return null;
        }

        Node minNode = minimum(root);
        return minNode.key;
    }

    public Key maximum() {
        if (root == null) {
            return null;
        }

        Node maxNode = maximum(root);
        return maxNode.key;
    }

    public void removeMax() {
        if (root == null) {
            return;
        }

        root = removeMax(root);
    }

    public void removeMin() {
        if (root == null) {
            return;
        }

        root = removeMin(root);
    }

    public void remove(Key key) {
        root = remove(root, key);
    }

    /**辅助函数*/
    private Node insert(Node node, Key key, Val val) {
        if (node == null) {
            size += 1;
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            node.right = insert(node.right, key, val);
        }

        else if (cmp < 0) {
            node.left = insert(node.left, key, val);
        }

        else  {
            node.val = val;
        }

        return node;
    }

    private void preOrder(Node node) {
        if (node != null ) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    private boolean contain(Node node, Key key) {
        if (node == null) {
            return false;
        }

        int cmp = node.key.compareTo(key);
        if (cmp > 0) {
            return contain(node.left, key);
        }
        else if (cmp < 0) {
            return contain(node.right, key);
        }
        else {
            return true;
        }
    }

    private Val search(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = node.key.compareTo(key);
        if (cmp > 0) {
            return search(node.left, key);
        }
        else if (cmp < 0) {
            return search(node.right, key);
        }
        else {
            return node.val;
        }
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            size -= 1;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            size -= 1;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    private Node remove(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = node.key.compareTo(key);
        if (cmp < 0) {
            node = remove(node.right, key);
            return node;
        }

        else if (cmp > 0) {
            node = remove(node.left, key);
            return node;
        }

        else {

            if (node.left == null && node.right != null) {
                Node rightNode = node.right;
                size -= 1;
                return rightNode;
            }

            else if (node.right == null && node.left != null) {
                Node leftNode = node.left;
                size -= 1;
                return leftNode;
            }

            else if (node.left == null && node.right == null) {
                return null;
            }

            else {
                Node newNode = maximum(node.left);

                newNode.right = node.right;
                newNode.left = removeMax(node.left);

                size -= 1;

                return newNode;
            }
        }
    }
}
