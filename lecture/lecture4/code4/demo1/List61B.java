package code4.demo1;

public interface List61B<Item> {
    public void addFirst(Item x);
    public void addLast(Item y);
    public Item getFirst();
    public Item getLast();
    public Item removeLast();
    public Item get(int i);
    public void insert(Item x, int position);
    public int size();

    public default void print() {
        System.out.print("List is : ");

        for (int i = 0; i < size(); i += 1)  {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}