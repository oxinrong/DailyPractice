package algorithm.arrays;

public class NbeforeP {
    public static void main(String[] args) {
        int[] arr = {1, 3, -2, 8, -4, 5};
        int startIndex = 0, endIndex = arr.length - 1;
        while (startIndex <= endIndex) {
            if (arr[startIndex] > 0 && arr[endIndex] < 0) {
                swap(startIndex++, endIndex--, arr);
            } else if (arr[startIndex] < 0) {
                startIndex++;
            } else if (arr[endIndex] > 0) {
                endIndex--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
