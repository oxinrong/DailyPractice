package algorithm.strings;

/*
    如果对于一个字符串 A，将 A 的前面任意一部分挪到后边去形成的字符串称为 A 的旋转词。
    比如 A="12345",A 的旋转词有 "12345","23451","34512","45123" 和 "51234"。
    对于两个字符串 A 和 B，请判断 A 和 B 是否互为旋转词。

    给定两个字符串 A 和 B 及他们的长度 lena，lenb，请返回一个 bool 值，代表他们是否互为旋转词。
 */

public class ChkRotationDemo {

    public static void main(String[] args) {
        String a = "cdab";
        String b = "abcd";
        System.out.println(new ChkRotationDemo().chkRotation(a, a.length(), b, b.length()));
    }

    public boolean chkRotation(String A, int lena, String B, int lenb) {
        String tmp1 = A + A;
        String tmp2 = B + B;
        return tmp1.contains(B) && tmp2.contains(A);
    }
}
