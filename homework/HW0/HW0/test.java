package HW0;
import java.util.Scanner;
public class test {
    public static void main(String[] args){

        //test1a
        exercise1a.PrintTriangle1();

        //test1b
        Scanner scanner = new Scanner(System.in);
        exercise1b.PrintTriangle2(scanner.nextInt());

        //test2
        int[] array1 = {23,34,34,543,23,12,23425};
        System.out.println(exercise2.getMax(array1));

        //test3
        int[] array2 = {1, 2, -3, 4, 5, 4};
        exercise3.windowPosSum(array2,3);
        for (int i :  array2){
            System.out.print(i + " ");
        }
    }
}
