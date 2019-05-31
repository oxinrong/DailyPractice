package algorithm.arrays;

/*
    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    例如输入一个长度为 9 的数组 {1,2,3,2,2,2,5,4,2}。
    由于数字 2 在数组中出现了 5 次，
    超过数组长度的一半，因此输出 2。如果不存在则输出 0。
 */

import java.util.*;

public class MoreThanHalfNum {

    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 1, 4, 2};
        System.out.println(moreThanHalfNum_Solution1(arr));

    }

    public static int moreThanHalfNum_Solution(int[] array) {
        int res = 0;
        int max = 0;
        HashSet<Integer> uniq = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            uniq.add(array[i]);
        }

        Iterator<Integer> integerIterator = uniq.iterator();
        while (integerIterator.hasNext()) {
            int num = 0;
            int val = integerIterator.next();
            for (int i = 0; i < array.length; i++) {
                if (val == array[i]) {
                    num++;
                }
            }

            if (num > max) {
                max = num;
                res = val;
            }
        }

        if (max <= array.length / 2) {
            res = 0;
        }

        return res;
    }

    public int MoreThanHalfNum_Solution2(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int count = map.get(array[i]);
                map.put(array[i], ++count);
            }
        }
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer key = (Integer) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (val > array.length / 2) {
                return key;
            }
        }
        return 0;
    }


    // 超过一半，所以排序后必然是 arr[len/2] 时间复杂度 logN
    public int MoreThanHalfNum_Solution(int[] array) {
        int len = array.length;

        if (len < 1) {
            return 0;
        }

        int count = 0;

        Arrays.sort(array);

        int num = array[len / 2];
        for (int i = 0; i < len; i++) {
            if (num == array[i])
                count++;
        }
        if (count <= (len / 2)) {
            num = 0;
        }
        return num;
    }


    // N
    /*
    如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
    采用阵地攻守的思想：
    第一个数字作为第一个士兵，守阵地；count = 1；
    遇到相同元素，count++;
    遇到不相同元素，即为敌人，同归于尽，count--；
    当遇到 count 为 0 的情况，又以新的 i 值作为守阵地的士兵，继续下去，
    到最后还留在阵地上的士兵，有可能是主元素。
    再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
     */
    public static int moreThanHalfNum_Solution1(int[] array) {
        int length = array.length;
        if (array == null || length <= 0) {
            return 0;
        }

        int result = array[0];
        int times = 1;
        for (int i = 1; i < length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else {
                if (array[i] == result) {
                    times++;
                } else {
                    times--;
                }
            }
        }

        times = 0;
        for (int i = 0; i < length; i++) {
            if (result == array[i]) {
                times++;
            }
        }

        if (times * 2 <= length) {
            result = 0;
        }
        return result;
    }

}
