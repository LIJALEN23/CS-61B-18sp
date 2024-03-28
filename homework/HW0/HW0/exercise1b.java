package HW0;

public class exercise1b {
    public static void PrintTriangle2(int num){
        for (int i = 1; i <= num; ++i){
            for (int j = 1; j <= i; ++j){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
