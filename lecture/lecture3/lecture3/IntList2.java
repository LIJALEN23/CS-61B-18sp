package lecture3;
public class IntList2 {
    public int val;
    public IntList2 next;

    //头插法？
    public IntList2(int v, IntList2 n){
        val = v;
        next = n;
    }

    //递归method
    public int size(){
        if (next == null){
            return 1;
        }
        return this.next.size();
    }

    public int iteractiveSize(){
        IntList2 p = this;
        int totalSize = 0;
        while (p != null){
            p = p.next;
            totalSize++;
        }
        return totalSize;
    }
}
