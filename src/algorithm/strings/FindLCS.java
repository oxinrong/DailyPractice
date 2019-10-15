package algorithm.strings;

public class FindLCS {
    public static void main(String[] args) {
        String a = "1A2C3D4B56";
        String b = "B1D23CA45B6A";
        String[] arr = a.split("");
        String[] brr = b.split("");
        System.out.println(getLCS(arr, brr));
    }

    private static int getLCS(String[] arr, String[] brr) {
        int lena = arr.length, lenb = brr.length;

        int[][] table = new int[lena + 1][lenb + 1];
        for (int i = 0; i < lena; i++) {
            table[i][0] = 0;
        }
        for (int i = 0; i < lenb; i++) {
            table[0][i] = 0;
        }
        for (int i = 0; i < lena; i++) {
            for (int j = 0; j < lenb; j++) {
                if (arr[i].equals(brr[j])) {
                    table[i + 1][j + 1] = table[i][j] + 1;
                } else {
                    table[i + 1][j + 1] = Math.max(table[i][j + 1], table[i + 1][j]);
                }
            }
        }

        return table[lena][lenb];
    }
}
