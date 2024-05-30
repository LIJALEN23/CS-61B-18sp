public class FibonacciRecursion {
    public static int fib(int number) {

        if (number <= 0){

            System.out.println("Error");
            return -1;
        }

        else if (number == 1) {
            return 0;
        }

        else if (number == 2) {
            return 1;
        }

        return fib(number - 1) + fib(number - 2);
    }

    public static void main(String[] args) {
        System.out.println("The  5th is " + fib(5));
    }
}
