package lecture4;
public class SLList {
    public static class IntNode {
        public int val;
        public IntNode next;

        public IntNode(int v, IntNode n) {
            val = v;
            next = n;
        }
    }

    private IntNode first;
    private int size;

    public SLList(int val) {
        first = null;
        size = 0;
    }

    public void addFirst(int val) {
        if (first == null){
            first = new IntNode(val,null);
            size += 1;
            return;
        }
        first = new IntNode(val, first);
        size += 1;
    }

    public int getFirst() {
        if (first == null){
            System.out.println("List is empty");
        }
        return first.val;
    }

    public void addLast(int val) {
        IntNode p = this.first;
        if (p == null){
            System.out.println("List is empty");
            return;
        }
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(val, null);
        size += 1;
    }

    public int getLast() {
        IntNode p = this.first;
        if (p == null){
            System.out.println("List is empty");
            return -1;
        }
        while (p.next != null) {
            p = p.next;
        }
        return p.val;
    }

//
//    private static int size(IntNode p){
//        if (p.next == null){
//            return 1;
//        }
//        return 1 + size(p.next);
//    }
//
//    public int size(){
//        return size(first);
//    }


}
