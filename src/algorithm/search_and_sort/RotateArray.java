package algorithm.search_and_sort;

/*
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组 {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为 1。
NOTE：给出的所有元素都大于 0，若数组大小为 0，请返回 0。
 */

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,
                9170,9359,9719,9895,9896,9913,9962,154,293,334,492,
                1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,
                3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,
                5668,5706,5725,6300,6335};

       //int[] arr = {5,6,7,8,1,2,3,4};
        System.out.println(minNumberInRotateArray2(arr));
    }

    public static int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                return array[i];
            } else if (i == array.length - 1) {
                return array[0];
            }
        }
        return -1;
    }



    public static int minNumberInRotateArray2(int [] array) {
        int low = 0 ; int high = array.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }
}