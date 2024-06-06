package code7;

public class SLList {
    /** 节点基本结构*/
    public static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }
    /** sentinel.next才是第一个元素*/
    private IntNode sentinel;
    private int size;

    /** 空单链表*/
    public SLList() {
        this.sentinel = new IntNode(23, null);
        this.sentinel.next = null;
        this.size = 0;
    }
    public SLList(int item) {
        this.sentinel = new IntNode(23, null);
        this.sentinel.next = new IntNode(item, sentinel.next);
        size += 1;
    }

    public SLList(int[] array) {
        this.sentinel = new IntNode(23,null);
        this.size = 0;

        for (int i : array) {
            this.sentinel.next = new IntNode(i,this.sentinel.next);
            this.size += 1;
        }
    }

    public void addFirst(int item) {
        this.sentinel.next = new IntNode(item, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        if (this.sentinel.next == null) {
            System.out.println("单链表为空，出错！");
            return -1;
        }
        return this.sentinel.next.item;
    }

    public void addLast(int item) {

        /** 有了哨兵节点后就可以不用这段冗杂的代码了*/
//        if (this.first == null) {
//            first = new IntNode(item, null);
//            this.size += 1;
//            return;
//        }

        IntNode temp = this.sentinel;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new IntNode(item, null);
        size += 1;
    }

//    /** 一个静态私密的方法用来辅助size的计算*/
//    private static int size(IntNode node) {
//        if (node.next == null) {
//            return 1;
//        }
//        return 1 + size(node.next);
//    }
//    /** 在实例化的SLList中使用size，两个size出现了方法重载
//     * 还有一种方法但需要non-static的IntNode下用，这会让IntNode的代码过于复杂*/
//    public int size() {
//        return size(this.sentinel.next);
//    }

    /** 类中有size了直接返回结果*/
    public int size() {
        return this.size;
    }

    public void deleteFirst() {
        this.sentinel.next = this.sentinel.next.next;
    }

    public int deleteLast() {

        return 0;
    }

    public int getLast() {
        return 0;
    }
}
