package code4;
public class SLList<ElemType> {
    public static class IntNode<ElemType> {
        public ElemType val;
        public IntNode next;

        public IntNode(ElemType v, IntNode n) {
            val = v;
            next = n;
        }
    }

    private IntNode first;
    private int size;

    public SLList(ElemType val) {
        first = null;
        size = 0;
    }

    public void addFirst(ElemType val) {
        if (first == null){
            first = new IntNode(val,null);
            size += 1;
            return;
        }
        first = new IntNode(val, first);
        size += 1;
    }

    public ElemType getFirst() {
        if (first == null){
            System.out.println("List is empty");
        }
        return (ElemType) first.val;
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

    public ElemType getLast() {
        IntNode p = this.first;
        if (p == null){
            System.out.println("List is empty");
//            return (ElemType) -1;
        }
        while (p.next != null) {
            p = p.next;
        }
        return (ElemType) p.val;
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
