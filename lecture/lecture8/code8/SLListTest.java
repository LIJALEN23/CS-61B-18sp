package code8;

public class SLListTest {
    public static void main(String[] args) {
        SLList s1 = new SLList<Integer>();
        for (int i = 0; i < 4; i += 1) {
            s1.addLast(i);
        }
        s1.printList();
    }
}
