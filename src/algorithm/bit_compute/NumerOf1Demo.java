package algorithm.bit_compute;

public class NumerOf1Demo {

    public static void main(String[] args) {
        int n = -2147483648;
        System.out.println(NumberOf1(n));
    }

    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
