package algorithm.stack_and_queue;

/*
    有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边，
    窗口每次向右边滑一个位置。 返回一个长度为 n-w+1 的数组 res，
    res [i] 表示每一种窗口状态下的最大值。 以数组为 [4,3,5,4,3,3,6,7]，w=3 为例。
    因为第一个窗口 [4,3,5] 的最大值为 5，第二个窗口 [3,5,4] 的最大值为 5，
    第三个窗口 [5,4,3] 的最大值为 5。第四个窗口 [4,3,3] 的最大值为 4。
    第五个窗口 [3,3,6] 的最大值为 6。第六个窗口 [3,6,7] 的最大值为 7。
    所以最终返回 [5,5,5,4,6,7]。

    给定整形数组 arr 及它的大小 n，同时给定 w，请返回 res 数组。
    保证 w 小于等于 n，同时保证数组大小小于等于 500。
 */


import java.util.ArrayList;

public class SlideWindowDemo {

    public static void main(String[] args) {
        int[] arr = {308,427,36,77,147,144,273};
        int wid = 6;
        int[] res = new SlideWindowDemo().slide(arr, arr.length, wid);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public int[] slide(int[] arr, int n, int w) {
        // 存放数组下标
        ArrayList<Integer> queue = new ArrayList<>();
        int[] res = new int[n - w + 1];
        int count = 0, j = 0;
        for (int i = 0; i < n; i++, count++) {
            // 若队列为空或队尾对应元素大于当前元素直接插入
            if (queue.isEmpty() || arr[queue.get(queue.size() - 1)] > arr[i]) {
                queue.add(i);
            } else {
                // 反复出队直到队尾对应元素大于当前元素或队为空时插入当前元素，保证队头为最大值
                while (!queue.isEmpty() && arr[queue.get(queue.size() - 1)] <= arr[i])
                    queue.remove(queue.size() - 1);
                queue.add(i);
            }

            // 若队头元素下标超出窗口范围则移出
            if (queue.get(0) == i - w)
                queue.remove(0);

            // 队头为最大值，每个窗口存一个结果
            if (count == w - 1) {
                res[j++] = arr[queue.get(0)];
                count = w - 2;
            }
        }

        return res;
    }
}


