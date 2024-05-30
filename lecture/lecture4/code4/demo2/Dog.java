package code4.demo2;

public class Dog implements OurComparable {
    private String name;
    private int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark() {
        System.out.println(name + " bark!");
    }

    /**重写接口中的compareTo函数以实现Dog.size的实现*/
    @Override
    public int compareTo(Object obj) {
        return (size - ((Dog) obj).size);
    }
}
