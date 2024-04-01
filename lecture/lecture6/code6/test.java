package code6;

public class test {
    public static void main(String[] args){
        GenericAList<Integer> list = new GenericAList<>() ;
        list.addList(1010);
        list.addList(2020);
        System.out.println(list.getLast());
    }
}
