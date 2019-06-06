package algorithm.strings;

/*
    对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
    给定一个字符串 A 和它的长度 n，请返回一个 bool 值代表它是否为一个合法的括号串。
 */

public class ChkParenthesisDemo {

    public static void main(String[] args) {
        String a = "(()())";
        String b = "()a()()";
        String c = "()(()()";

        System.out.println(new ChkParenthesisDemo().chkParenthesis(a, a.length()));
    }

    public boolean chkParenthesis(String A, int n) {
        char[] arr = A.toCharArray();
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ')' && arr[i] != '(') {
                return false;
            }
            if (arr[i] == '(')
                flag++;
            else if (arr[i] == ')' && --flag < 0)
                return false;
        }
        return flag == 0;
    }

}
