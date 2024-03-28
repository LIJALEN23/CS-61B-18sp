package HW0;

public class exercise3 {
    public static void windowPosSum(int[] array,int num){
        for (int i = 0; i < array.length; ++i){
            if (array[i] > 0){
                int sum = 0;
                for (int j = i; j <= Math.min(i + num,array.length - 1); ++j){
                        sum += array[j];
                    }
                array[i] = sum;
                }
            }

        }
}
