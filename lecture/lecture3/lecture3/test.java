package lecture3;

public class test {
    public static void main(String[] args){
            IntList1 L1 = new IntList1(12,null);
            L1.next = new IntList1(23,null);
            L1.next.next = new IntList1(34,null);



            IntList2 L2 = new IntList2(12,null);
            L2 = new IntList2(23,L2);
            L2 = new IntList2(34,L2);
            System.out.println(L2.iteractiveSize());
//            System.out.println(L2.size());//??
    }
}
