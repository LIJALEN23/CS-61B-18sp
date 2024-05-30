package code4.demo3;

import java.util.Comparator;

public class Dog2 implements Comparable<Dog2> {
    private String name;
    private int size;

    public Dog2(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark() {
        System.out.println(name + " bark!");
    }

    /**重写接口中的compareTo函数以实现Dog.size的实现*/
    @Override
    public int compareTo(Dog2 dog2) {
        return this.size - dog2.size;
    }

    private static class NameComparator implements Comparator<Dog2> {
        @Override
        public  int compare(Dog2 d1, Dog2 d2) {
            return d1.name.compareTo(d2.name);
        }
    }
    public static Comparator<Dog2> getNameCompare(){
        return new NameComparator();
    }
}