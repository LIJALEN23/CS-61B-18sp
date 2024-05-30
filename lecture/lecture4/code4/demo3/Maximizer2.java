package code4.demo3;

import java.util.Comparator;

public class Maximizer2 {
    public static Comparable max(Comparable[] items) {
        int maxIndex = 0;

        for (int i = 0; i < items.length; i += 1) {
            if (items[i].compareTo(items[maxIndex]) > 0) {
                maxIndex = i;
            }
        }

        return items[maxIndex];
    }

    public static void main(String[] args) {
        Dog2[] dogs = {new Dog2("White", 12), new Dog2("Black", 23), new Dog2("Yellow", 34)};

        Dog2 maxDog = (Dog2) max(dogs);
//      Dog2 maxDog = (Dog2) max(dogs);为什么还是要强制转化，问题比较复杂
        maxDog.bark();


        Comparator<Dog2> nc = Dog2.getNameCompare();
        if (nc.compare(dogs[0], dogs[1]) > 0) {
            dogs[0].bark();
        }
        else {
            dogs[1].bark();
        }
    }
}
