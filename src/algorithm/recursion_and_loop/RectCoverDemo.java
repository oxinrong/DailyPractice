package algorithm.recursion_and_loop;

/*
    我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
    请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 */

public class RectCoverDemo {

    public static void main(String[] args) {
        System.out.println(RectCover2(5));

    }

    public static int RectCover(int target) {
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }

        return RectCover(target - 1) + RectCover(target - 2);
    }

    public static int RectCover2(int target) {
        int first = 0, second = 1;
        if (target == 0 || target == 1) {
            return target;
        }

        int tmp = 0;
        while (target-- >= 1) {
            tmp = first + second;
            first = second;
            second = tmp;
        }
        return tmp;
    }
}
