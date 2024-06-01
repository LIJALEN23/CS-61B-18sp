/** 2-D array arr[i][j]
 *  arr.length is the rows
 *  arr[i].length is the ith columns*/
public class Flatten {
    public static int[] flatten(int[][] arr) {
        int totalLength = 0;

        for (int i = 0; i < arr.length; i++) {
            totalLength += arr[i].length;
        }

        int[] newArr = new int[totalLength];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[index] = arr[i][j];
                index++;
            }
        }

        return newArr;
    }

}
