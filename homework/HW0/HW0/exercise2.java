package HW0;

public class exercise2 {
    public static int getMax(int[] array){
        int max = array[0];
        for (int i : array){
            if (max < i){
                max = i;
            }
        }
        return max;
    }
}
