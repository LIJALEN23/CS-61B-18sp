/**=======================
 *      红黑树的简单实现
 * 完成时间：2024.6.16
 * 问题：测试后有BUG且这种实现非常复杂
 *
 * 借鉴于ChatGPT
 * =========================
 * */
public class RedBlackBST1<Key extends Comparable<Key>, Val> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**定义一个红黑树的节点
     * 键
     * 值
     * 左子树
     * 右子树
     * 父亲：红黑树旋转时会用到父亲节点
     * 颜色：标记节点的颜色*/
    private class Node {
        private Key key;
        private Val val;
        private Node left, right, parent;

        private boolean color;

        public Node(Key key, Val val, boolean color, Node parent) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.parent = parent;
            this.left = this.right = null;
        }
    }

    private Node root;

    public RedBlackBST1() {

    }

    /**左旋*/
    private void leftRotate(Node x) {
        Node y = x.right;   //将初始节点的右孩子存起来
        x.right = y.left;   //将初始节点的右孩子的左孩子放在新的位置(可能是空节点)

        //更新旋转后每个结点的父亲节点
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;

        //更新原父亲节点的孩子节点
        if (x.parent == null) {     //x无父亲节点
            root = y;
        }
        else if (x == x.parent.left) {           //x是父亲节点的左孩子
            x.parent.left = y;
        }
        else {                      //x是父亲节点的右孩子
            x.parent.right = y;
        }

        //更新两个实现旋转的节点的前驱和后继节点
        y.left = x;
        x.parent = y;
    }

    /**右旋*/
    private void rightRotate(Node x) {
        Node y = x.left;
        x.right = y.right;

        if (y.right != null) {
            y.right.parent = x;
        }

        if (x.parent == null) {
            root = y;
        }
        else if (x.parent.left == x) {
            x.parent.left = y;
        }
        else {
            x.parent.right = y;
        }

        y.right = x;
        x.parent = y;
    }

    public void insert(Key key, Val val) {
        Node node = new Node(key, val, RED, null);
        if (root == null) {
            root = node;
            return;
        }

        Node parent = null;
        Node x = root;
        while (x != null) {
            parent = x;

            int cmp = key.compareTo(x.key);

            if (cmp > 0) {
                x = x.right;
            }
            else if (cmp < 0) {
                x = x.left;
            }
            else {
                x.val = val;
                return;
            }
        }
        node.parent = parent;

        if (key.compareTo(parent.key) > 0) {
            parent.right = node;
        }
        else {
            parent.left = node;
        }

        fixAfterInsert(node);
    }

    private void fixAfterInsert(Node node) {
        while (node != null && node != root && node.parent.color == RED) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (uncle != null && uncle.color == RED) {      //叔叔节点是红色的
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                }
                else {            //叔叔节点是黑色的
                    if (node == node.parent.right) {    //true->LR型,false->LL型
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rightRotate(node.parent.parent);
                }
            }
            else {
                Node uncle = node.parent.parent.left;
                if (uncle != null && uncle.color == RED) {      //叔叔节点是红色的
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                }
                else {          //叔叔节点是黑色的
                    if (node == node.parent.left) {    //true->RL型,false->RR型
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    leftRotate(node.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    public void delete(Key key) {
        Node node = search(root, key);      //是否存在这个节点
        if(node == null) {
            return;
        }

        //当该节点同时存在两个孩子时
        if (node.left != null && node.right != null) {
            Node successor = getMin(node.right);    //获取该节点的右孩子里最小的那一个节点，将它提上来作为当前子树的新根节点
            node.key = successor.key;
            node.val = successor.val;
            node = successor;
        }

        //处理节点只有一个孩子存在时
        Node replacement = (node.left != null) ? node.left : node.right;

        if (replacement != null) {
            replacement.parent = node.parent;
            if (node.parent == null) {  //当初始节点是根节点时
                root = replacement;
            }
            else if (node == node.parent.left) {    //当初始节点是父节点的左孩子时
                node.parent.left = replacement;
            }
            else {      //当初始节点是父节点的右孩子时
                node.parent.right = replacement;
            }

            //
            if (node.color == BLACK) {
                fixAfterDelete(replacement);
            }
        }
        else if (node.parent == null) {     //只有根节点存在
            root = null;
        }
        else {          //
            if (node.color == BLACK) {
                fixAfterDelete(node);
            }
            if (node.parent != null) {
                if (node == node.parent.left) {
                    node.parent.left = null;
                }
                else {
                    node.parent.right = null;
                }
                node.parent = null;
            }
        }
    }

    // 删除后修正
    private void fixAfterDelete(Node node) {
        while (node != root && colorOf(node) == BLACK) {
            if (node == leftOf(parentOf(node))) {
                Node sibling = rightOf(parentOf(node));
                if (colorOf(sibling) == RED) {
                    setColor(sibling, BLACK);
                    setColor(parentOf(node), RED);
                    leftRotate(parentOf(node));
                    sibling = rightOf(parentOf(node));
                }
                if (colorOf(leftOf(sibling)) == BLACK && colorOf(rightOf(sibling)) == BLACK) {
                    setColor(sibling, RED);
                    node = parentOf(node);
                } else {
                    if (colorOf(rightOf(sibling)) == BLACK) {
                        setColor(leftOf(sibling), BLACK);
                        setColor(sibling, RED);
                        rightRotate(sibling);
                        sibling = rightOf(parentOf(node));
                    }
                    setColor(sibling, colorOf(parentOf(node)));
                    setColor(parentOf(node), BLACK);
                    setColor(rightOf(sibling), BLACK);
                    leftRotate(parentOf(node));
                    node = root;
                }
            } else {
                Node sibling = leftOf(parentOf(node));
                if (colorOf(sibling) == RED) {
                    setColor(sibling, BLACK);
                    setColor(parentOf(node), RED);
                    rightRotate(parentOf(node));
                    sibling = leftOf(parentOf(node));
                }
                if (colorOf(leftOf(sibling)) == BLACK && colorOf(rightOf(sibling)) == BLACK) {
                    setColor(sibling, RED);
                    node = parentOf(node);
                } else {
                    if (colorOf(leftOf(sibling)) == BLACK) {
                        setColor(rightOf(sibling), BLACK);
                        setColor(sibling, RED);
                        leftRotate(sibling);
                        sibling = leftOf(parentOf(node));
                    }
                    setColor(sibling, colorOf(parentOf(node)));
                    setColor(parentOf(node), BLACK);
                    setColor(leftOf(sibling), BLACK);
                    rightRotate(parentOf(node));
                    node = root;
                }
            }
        }
        setColor(node, BLACK);
    }

    public Val search(Key key) {
        Node node = search(root, key);
        return node == null ? null : node.val;
    }

    //辅助方法
    private boolean colorOf(Node node) {
        return node == null ? BLACK : node.color;
    }

    private Node parentOf(Node node) {
        return node == null ? null : node.parent;
    }

    private Node leftOf(Node node) {
        return node == null ? null : node.left;
    }

    private Node rightOf(Node node) {
        return node == null ? null : node.right;
    }

    private void setColor(Node node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    private Node search(Node node, Key key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    // 获取最小节点
    private Node getMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        RedBlackBST1<Integer, String> BST1 = new RedBlackBST1<>();

        // 插入测试
        System.out.println("插入节点:");
        BST1.insert(10, "Value10");
        BST1.insert(20, "Value20");
        BST1.insert(30, "Value30");
        BST1.insert(15, "Value15");
        BST1.insert(25, "Value25");

        // 搜索测试
        System.out.println("\n搜索节点:");
        System.out.println("搜索键 10: " + BST1.search(10)); // 应输出: Value10
        System.out.println("搜索键 20: " + BST1.search(20)); // 应输出: Value20
        System.out.println("搜索键 30: " + BST1.search(30)); // 应输出: Value30
        System.out.println("搜索键 15: " + BST1.search(15)); // 应输出: Value15
        System.out.println("搜索键 25: " + BST1.search(25)); // 应输出: Value25
        System.out.println("搜索键 40: " + BST1.search(40)); // 应输出: null

        // 删除测试
        System.out.println("\n删除节点:");
        BST1.delete(10);
        System.out.println("删除键 10 后搜索键 10: " + BST1.search(10)); // 应输出: null
        BST1.delete(20);
        System.out.println("删除键 20 后搜索键 20: " + BST1.search(20)); // 应输出: null

        // 继续搜索测试
        System.out.println("\n继续搜索节点:");
        System.out.println("搜索键 15: " + BST1.search(15)); // 应输出: Value15
        System.out.println("搜索键 25: " + BST1.search(25)); // 应输出: Value25
        System.out.println("搜索键 30: " + BST1.search(30)); // 应输出: Value30
    }
}
