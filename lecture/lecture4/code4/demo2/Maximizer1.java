package code4.demo2;

public class Maximizer1 {
    /** 一个通用的对象比较函数，通过接口实现
     *  接受一个对象数组
     *  返回对象数组中的最大值
     *  根据传过来的对象类型不同实现多态*/

    public static OurComparable max(OurComparable[] items) {
        int maxIndex = 0;

        for (int i = 0; i < items.length; i += 1) {
            if (items[i].compareTo(items[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return items[maxIndex];
    }

    public static void main(String[] args) {

        Dog[] dogs = {new Dog("White", 12), new Dog("Black", 23), new Dog("Yellow", 34)};

        Dog maxDog = (Dog) max(dogs);
        maxDog.bark();
    }
}
