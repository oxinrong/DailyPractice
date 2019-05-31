package algorithm.strings;

public class ReplaceBlank {
    public static void main(String[] args) {
        System.out.println(replaceBlank(new StringBuffer("Hello hello ")));
    }

    public static String replaceBlank(StringBuffer stringBuffer) {
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
}
