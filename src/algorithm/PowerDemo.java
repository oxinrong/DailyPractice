package algorithm;

/*
    给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent。
    求 base 的 exponent 次方。
 */

public class PowerDemo {

    public static void main(String[] args) {
        double base = 2;
        int exp = -3;
        System.out.println(Power(base, exp));
    }

    public static double Power(double base, int exponent) {
        double res = 1.0;
        if (base == 0) {
            return 0.0;
        }
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                res = res * base;
            }
            return res;
        } else if (exponent < 0) {
            for (int i = exponent; i < 0; i++) {
                res = res / base;
            }
            return res;
        } else return res;

    }
}
