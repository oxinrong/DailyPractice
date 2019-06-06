package algorithm.strings;

/*
    请编写一个方法，将字符串中的空格全部替换为 “%20”。
    假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度 (小于等于 1000)，
    同时保证字符串由大小写的英文字母组成。
    给定一个 string iniString 为原始的串，以及串的长度 int len, 返回替换后的 string。
 */
public class ReplaceBlank {
    public static void main(String[] args) {
        String a = "Hello hello ";
        System.out.println(replaceBlank(a, a.length()));
    }

    public static String replaceBlank1(StringBuffer stringBuffer) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == ' ') {
                str.append('%');
                str.append('2');
                str.append('0');
            } else {
                str.append(stringBuffer.charAt(i));
            }
        }
        return str.toString();
    }

    public static String replaceBlank(String iniString, int len) {
        char[] arr = iniString.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                count++;
            }
        }
        char[] res = new char[count * 2 + len];
        int resLen = res.length - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                res[resLen--] = '0';
                res[resLen--] = '2';
                res[resLen--] = '%';
            } else res[resLen--] = arr[i];
        }
        return String.valueOf(res);
    }

}
