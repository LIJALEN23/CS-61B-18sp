public class Fibonacci {

    public static int fib(int number) {

        if (number <= 0) {
            System.out.println("ERROR");
            return -1;
        }

        else if (number == 1) {
            return 0;
        }

        int pre = 0;
        int next = 1;
        for (int i = 2; i < number; i += 1) {

            int temp = pre + next;

            pre = next;
            next = temp;
        }
        return next;
    }

    public static void main(String[] args) {


        System.out.println("The  5th is " + fib(5));

    }
}
