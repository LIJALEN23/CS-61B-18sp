package code2;

import javax.swing.text.Element;

public class DLList<ElementType, pre> {

    public class IntNode {

        public IntNode pre;
        public ElementType item;
        public IntNode next;

        public IntNode(IntNode pre,ElementType item,IntNode next) {
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }

    private IntNode sentinel;
    private int size;

//    public DLList() {
//        sentinel = new IntNode(null, 0, null);
//    }
    public DLList(ElementType item) {
        sentinel = new IntNode(null, item, new IntNode(null, item, null));
        size = 1;
    }

    public void addFirst(ElementType item) {
        if (this.size == 1) {
            sentinel.next = new IntNode(sentinel.next, item, sentinel.next);
            sentinel.next.next.pre = sentinel.next;
            sentinel.next.next.next = sentinel.next;
            size += 1;
        }

        else {
            sentinel.next = new IntNode(sentinel.next.pre, item, sentinel.next);
            sentinel.next.next.pre = sentinel.next;
            size += 1;
        }
    }

    public ElementType getFirst() {
        if (sentinel.next == null) {
            System.out.println("ERROR!");
//            return -1;
        }

        return sentinel.next.item;
    }

    public void removeFirst() {
        //更新头节点的前后两个节点的指向
        sentinel.next.next.pre = sentinel.next.pre;
        sentinel.next.pre.next = sentinel.next.next;

        //改变哨兵节点的指向
        sentinel.next = sentinel.next.next;
    }
    public void addLast(ElementType item) {
        if (this.size == 1) {
            sentinel.next.next = new IntNode(sentinel.next, item, sentinel.next);
            sentinel.next.pre = sentinel.next.next;
            size += 1;
        }

        else {
            //新增节点，将第一个节点的pre指向新的节点，将新节点的pre指向第一个节点的pre，将新节点的next指向第一个节点
            sentinel.next.pre = new IntNode(sentinel.next.pre, item, sentinel.next);
            //更新节点的指向，将原来最后一个节点的next指向新节点
            sentinel.next.pre.pre.next = sentinel.next.pre;
            size += 1;
        }

    }

    public ElementType getLast() {
        if (sentinel.next == null) {
            System.out.println("ERROR!");
//            return -1;
        }

        return sentinel.next.pre.item;
    }

    public void removeLast() {
        //更新尾节点的前后两个节点的指向
        sentinel.next.pre.pre.next = sentinel.next;
        sentinel.next.pre = sentinel.next.pre.pre;
    }

    public int size() {
        return size;
    }
}