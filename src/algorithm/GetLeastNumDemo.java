package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
    输入 n 个整数，找出其中最小的 K 个数。
    例如输入 4,5,1,6,2,7,3,8 这 8 个数字，则最小的 4 个数字是 1,2,3,4,。
 */
public class GetLeastNumDemo {

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 7, 9, 8, 6};
        ArrayList<Integer> res = new GetLeastNumDemo().GetLeastNumbers_Solution(arr, 3);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }


    // 用最大堆保存这 k 个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }

        // 优先队列基于堆实现
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // 从大到小
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        result.addAll(maxHeap);
        return result;
    }
}
