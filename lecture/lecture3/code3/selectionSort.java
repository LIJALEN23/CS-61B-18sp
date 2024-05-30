package code3;

public class selectionSort {
    public static void StringSort(String[] strings){
        //获得数组的总长度
        int length = strings.length;

        for (int i = 0; i < length - 1; i += 1) {
            int minIndex = i;   //从每次都从i处开始向后寻找最小的元素

            for (int j = i + 1; j < length - 1; j += 1) {

                //在未排序的部分寻找是否有更小的元素
                if (strings[j].compareTo(strings[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            //找到了比strings[i]更小的元素，将strings[i] 和 strings[minIndex]交换
            if (minIndex != i) {
               String temp = strings[minIndex];
                strings[minIndex] = strings[i];
                strings[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        //test



    }
}
