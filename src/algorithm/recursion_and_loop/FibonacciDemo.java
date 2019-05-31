package algorithm.recursion_and_loop;

public class FibonacciDemo {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Fibonacci2(n));
    }

    public static int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }

    }

    public static int Fibonacci2(int n) {
        int first = 0, second = 1;
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int tmp = 0;
        while (n > 1) {
            tmp = first + second;
            first = second;
            second = tmp;
            n--;
        }
        return tmp;

    }
}
