public class SLList {
    public class IntNode {
        public int val;
        public IntNode next;

        public IntNode(int val, IntNode next) {
            this.val = val;
            this.next = next;
        }
    }
    private IntNode first;

    public SLList(int val) {
        first = new IntNode(val, null);
    }

    public void print() {
        System.out.print("The SLList is : ");

        IntNode temp = first;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addFirst(int val) {

//        IntNode newNode = new IntNode(val, first.next);
//        first.next = newNode;

        first = new IntNode(val, first);
    }

    public void insert(int val, int position) {
        if (position == 1) {
            addFirst(val);
            return;
        }

        IntNode getNode = first;

        for(int i = 1; i < position - 1; i += 1) {
            getNode = getNode.next;
        }

        IntNode newNode = new IntNode(val, getNode.next);
        getNode.next = newNode;
    }

    public void reverse() {
        /** frontNode : pre  midNode : current  rearNode : next
         *  while current is not a null pointer
         *  next = current.next
         *  current.next = pre
         *  pre = current
         *  current = next*/
        IntNode frontNode = null;
        IntNode midNode = first;
        IntNode rearNode = null;

        while (midNode != null) {
            rearNode = midNode.next;

            midNode.next = frontNode;
            frontNode = midNode;
            midNode = rearNode;
        }

        first = frontNode;
    }

    public void reverseRecursion() {
        first = reverseHelper(first, null);
    }
    private IntNode reverseHelper(IntNode current, IntNode pre) {
        if (current == null) {
            return pre;
        }

        IntNode next = current.next;
        current.next = pre;
        return reverseHelper(next, current);
    }

    public static void main(String[] args) {
        SLList list = new SLList(45);

        list.addFirst(34);
        list.addFirst(23);
        list.addFirst(12);

        list.print();

        list.insert(56, 5);
        list.print();

        list.reverse();
        list.print();

        list.reverseRecursion();
        list.print();
    }
}

