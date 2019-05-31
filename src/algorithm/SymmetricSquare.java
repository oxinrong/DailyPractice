package algorithm;

public class SymmetricSquare {
    public static void main(String[] args) {
        for (int i = 1; i < 256; i++) {
            int n = i * i;
            String s = n + " ";
            s = s.trim();
            int flag = 0;
            for (int j = 0; j < s.length()/2; j++) {
                if (s.charAt(j) == s.charAt(s.length()-1-j))
                    flag ++;
            }

            if (flag >= s.length()/2) {
                System.out.println(i);
            }
        }
    }
}
