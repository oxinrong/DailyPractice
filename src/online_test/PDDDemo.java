package online_test;

public class PDDDemo {

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,10};
        int[] arr2 = {2,1,5,8,9};
        int[] res = resort(arr, arr2);
        if (res.length == 1) {
            System.out.print("NO");
        } else {
            for (int i = 0; i < res.length - 1; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.print(res[res.length - 1]);
        }
    }

    public static int[] resort(int[] arr, int[] arr2) {
        int errorIndex = -1, newIndex = -1;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                errorIndex = i + 1;
                break;
            }
        }

        if (errorIndex < 0) return arr;

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > arr[errorIndex - 1] && arr2[i] < arr[errorIndex + 1]) {
                newIndex = newIndex < 0 ? i : newIndex;
                newIndex = arr2[newIndex] > arr2[i] ? newIndex : i;

            }
        }

        if (newIndex < 0)
            return new int[]{-1};

        arr[errorIndex] = arr2[newIndex];
        return arr;
    }
}
