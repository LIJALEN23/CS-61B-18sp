package code2;

import java.awt.desktop.SystemEventListener;

public class IntList {
    public int first;
    public IntList rest;

    /** The constructor of the IntList*/
    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    /** Return the size of the list by recursion*/
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size of the list by loops*/
    public int iteractiveSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Return the List[index](Start from 0)*/
    public int get(int index) {
        int size = this.size();

        if (index + 1 > size) {
            System.out.println("The number is larger than the size of the list!");
            return -1;
        }

        int element;
        IntList temp = this;
        for (int i = 0; i < index; i += 1) {
            temp = temp.rest;
        }
        return temp.first;
    }

    public void addFirst(int item) {
        IntList new_Rest = new IntList(this.first, this.rest);
        this.first = item;
        this.rest = new_Rest;
    }

    public static IntList addFirst(IntList list,int item) {
        return new IntList(item, list);
    }
    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
//    public static IntList incrList(IntList L, int x) {
//        IntList temp = L;
//        while (temp != null) {
//            temp.first += x;
//            temp = temp.rest;
//        }
//        return L;
//    }
//
//    /** Returns an IntList identical to L, but with
//     * each element incremented by x. Not allowed to use
//     * the 'new' keyword. */
//    public static IntList dincrList(IntList L, int x) {
//        IntList temp = L;
//        while (temp != null) {
//            temp.first += x;
//            temp = temp.rest;
//        }
//        return L;
//    }

    public void addAdjacent() {
        IntList temp = this;

        while (temp != null && temp.rest != null) {

            if (temp.first == temp.rest.first) {
                temp.first = temp.first * 2;
                temp.rest = temp.rest.rest;
            }
            else {
                temp = temp.rest;
            }
        }
    }

    /** 将前面的所有元素平方并将平方后的值放在该值的后一位
     *  最后将需要添加的值添加到表的最后一位
     *  通过原的表长和两个移动的节点来完成对表中所有元素遍历并平方*/
    public void addAndSquare(int value) {
        //获得表的长度
        int originalSize = this.size();

        //一个作为新的头节点，一个用来移动操作节点
        IntList newHead = new IntList(this.first, null);
        IntList currentNew = newHead;

        //操作原来的表
        IntList currentOld = this;
        for (int i = 1; i < originalSize; i += 1) {
            currentNew = new IntList(currentOld.first, new IntList(currentOld.first * currentOld.first, null));

            currentNew = currentNew.rest.rest;
            currentOld = currentOld.rest;
        }
        currentNew.rest = new IntList(currentOld.first, new IntList(currentOld.first * currentOld.first, null));

        currentNew = currentNew.rest.rest;
        currentOld = currentOld.rest;

        currentNew.rest = new IntList(value, null);

        this.first = newHead.first;
        this.rest = newHead.rest;
    }


    public static void main(String[] args) {

        IntList list1 = new IntList(12, null);
        list1.rest = new IntList(23, null);
        list1.rest.rest = new IntList(34, null);

        System.out.println("The list1 is : 12 23 34");
        System.out.println("The size of list1 is " + list1.size());
        System.out.println("The list1[0] is " + list1.get(0));
        System.out.println("The list1[1] is " + list1.get(1));
        System.out.println("The list1[2] is " + list1.get(2));

        System.out.println("The list1[0] is " + list1.get(0));

//        list1 = incrList(list1, 100);
//
//        System.out.println("The list1 is : 12 23 34");
//        System.out.println("The size of list1 is " + list1.size());
//        System.out.println("The list1[0] is " + list1.get(0));
//        System.out.println("The list1[1] is " + list1.get(1));
//        System.out.println("The list1[2] is " + list1.get(2));
    }
}
