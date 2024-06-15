/**===========================
 *      AVL树的简单实现
 * 完成时间：2024.6.15
 * 问题：未测试
 *
 * 难点：insert和delete
 *
 * 借鉴于ChatGPT
 * ==========================
 * */
public class AVLBST <Key extends Comparable<Key>, Val>{
    /**定义一个AVL树的节点*/
    private class Node {
        private Key key;
        private Val val;
        private Node left, right;
        private int height;

        public Node(Key key, Val val) {
            this.key = key;
            this.val = val;
            left = right = null;
            height = 1;
        }
    }

    private Node root;

    public AVLBST() {

    }

    /**获得当前节点的高度*/
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    /**更行当前节点的高度*/
    private void updateHeight(Node node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    /**获取当前节点的平衡因子*/
    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    /**左旋转
     * 当一个节点的平衡因子 < -1 时， 将该节点进行左旋转，该节点的右孩子成为新的父节点，并将该节点的左孩子成为原节点的右孩子*/
    private Node leftRotate(Node z) {
        Node y = z.right;
        Node T2 = y.left;

        y.left = z;
        z.right = T2;

        //更新两个节点的高度
        updateHeight(z);
        updateHeight(y);

        return y;
    }

    /**右旋转
     * 当一个节点的平衡因子 > 1 时， 将该节点进行右旋转，该节点的左孩子成为新的父节点，并将该节点的左孩子成为原节点的左孩子*/
    private Node rightRotate(Node z) {
        Node y = z.left;
        Node T2 = y.right;

        y.right = z;
        z.left = T2;

        //更新两个节点的高度
        updateHeight(y);
        updateHeight(z);

        return y;
    }

    /**插入操作*/
    public void insert(Key key, Val val) {
        root = insert(root, key, val);
    }

    /**插入操作的辅助函数*/
    private Node insert(Node node, Key key, Val val) {
        if (node == null) {
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

        updateHeight(node);

        int balance = getBalance(node);

        //LL情况。该节点的平衡因子 >1 且 插入值小于该节点的左孩子,只需要将该节点进行右旋转
        if (balance > 1 && key.compareTo(node.left.key) < 0) {
            return rightRotate(node);
        }

        //RR情况。该节点的平衡因子 <1 且 插入值大于该节点的右孩子,只需要将该节点进行左旋转
        if (balance < -1 && key.compareTo(node.right.key) > 0) {
            return leftRotate(node);
        }

        //LR情况。该节点的平衡因子 >1 且 插入值大于该节点的左孩子，需要先将左孩子进行左旋，再将节点进行右旋
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //RL情况。该节点的平衡因子 <1 且 插入值小于该节点的左孩子,需要先将右孩子进行右旋，再将节点进行左旋
        if(balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /**删除操作*/
    public void delete(Key key) {
        root = delete(root, key);
    }

    /**删除操作的辅助函数*/
    private Node delete(Node node, Key key) {
        if (node == null) {
            return node;
        }

        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            node = delete(node.right, key);
        }

        else if (cmp < 0) {
            node = delete(node.left, key);
        }

        else {
            if (node.right == null || node.left == null) {  //该节点最多有一个孩子
                Node temp = null;

                if (temp == node.left) {
                    temp = node.right;
                }
                if (temp == node.right) {
                    temp = node.left;
                }

                if (temp == null) {
                    node = null;
                }
                else {
                    node = temp;
                }

            }

            else {  //该节点有两个孩子:1.将该节点下的(右孩子/左孩子)的(最小/最大)节点提上来替换当前节点，并把提上来的节点删除
                Node temp = getMinValNode(node.right);  //将右孩子的最小节点提上来替换
                node.key = temp.key;
                node.val = temp.val;
                node.right = delete(node.right, node.key);
            }
        }

        if (node == null) {
            return node;
        }

        updateHeight(node);

        int balance = getBalance(node);

        //LL情况。该节点的平衡因子 >1 且 插入值小于该节点的左孩子,只需要将该节点进行右旋转
        if (balance > 1 && key.compareTo(node.left.key) < 0) {
            return rightRotate(node);
        }

        //RR情况。该节点的平衡因子 <1 且 插入值大于该节点的右孩子,只需要将该节点进行左旋转
        if (balance < -1 && key.compareTo(node.right.key) > 0) {
            return leftRotate(node);
        }

        //LR情况。该节点的平衡因子 >1 且 插入值大于该节点的左孩子，需要先将左孩子进行左旋，再将节点进行右旋
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //RL情况。该节点的平衡因子 <1 且 插入值小于该节点的左孩子,需要先将右孩子进行右旋，再将节点进行左旋
        if(balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /**获取值最小的节点*/
    private Node getMinValNode(Node node) {
        Node currentNode = node;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    /**查找键值*/
    public Val search(Key key) {
        Node node = search(root, key);
        return node == null ? null : node.val;
    }

    /**查找键值的辅助函数*/
    private Node search(Node node, Key key) {
        if (node == null || key.compareTo(node.key) == 0) {
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }
}