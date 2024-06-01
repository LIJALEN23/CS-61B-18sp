public class Array {

    /** insert at position(This is the array index)*/
    public static int[] insert(int[] arr, int item, int position) {
        if (position >= arr.length) {
            position = arr.length;
        }

        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }

        newArr[position] = item;

        for (int i = position; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    /** Reverse the whole array*/
    public static void reverse(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[length - 1 - i];
            arr[length - 1 - i] = temp;
        }

    }

    /** The array items >= 0
     *  arr = {3, 2, 1}
     *  after replicate
     *  arr = {3, 3, 3, 2, 2, 1}
     *  three threes, two twos, one one
     *  so we can calculate the length of the newArray */
    public static int[] replicate(int[] arr) {
        int totalLength = 0;
        for (int num : arr) {
            totalLength += num;
        }

        int[] newArr = new int[totalLength];
        int index = 0;

        for (int i : arr) {
            for (int j = 0; j < i; j++) {
                newArr[index++] = i;
            }
        }

        return newArr;
    }

}
