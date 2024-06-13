/** This is data structure is provided by CS 61B.So it is very complicated but comprehensive.
 */

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
            this.size = size;
        }
    }

    private Node root;  //the root of the tree

    /*Initial the BST*/
    public BinarySearchTree() {

    }

    /**
     * Return true if this symbol table is empty
     * @return {@code true} if this symbol table is empty; {@code false} if this symbol table is not empty
     * */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Return the number of key-value pairs in this symbol table
     * @return the number of key-value pairs in this symbol table
     * */
    public int size() {
        return size(root);
    }
    //Return the number of key-value pairs in BST rooted at node
    private int size(Node node) {
        if (node == null) {
            return 0;
        }

        return node.size;
    }

    /**Does this symbol table contains this key?
     *
     * @param key the key
     * @return {@code true} if the symbol table contains {@code key}; {@code false} Otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * */
    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }

        return get(key) != null;
    }

    /**Get the value of the key
     *
     * @param key the key
     * @return the value associated with the key or {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}*/
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with a null key");
        }
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return get(node.right, key);
        }
        else if (cmp < 0) {
            return get(node.left, key);
        }

        else {
            return node.val;
        }
    }


    public void put(Key key, Value val) {

    }
}
