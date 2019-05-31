package algorithm.stack_and_queue;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MarkBalance {
    public static void main(String[] args) {
        Mark mark = new Mark();
        String strR = "((()[s]()))";
        for (int i = 0; i < strR.length(); i++) {
            if (Pattern.matches("[a-z]", strR.charAt(i) + "")) {
                continue;
            }
            if (strR.charAt(i) == '(' || strR.charAt(i) == '{'
                    || strR.charAt(i) == '[' ) {
                mark.push(strR.charAt(i));
            } else if ( mark.isMatch(strR.charAt(i)) ) {
                mark.pop();
            } else {
                System.out.println("error: can't match!!");
                break;
            }
            System.out.println(mark.toString());
        }
    }
}

class Mark {
    ArrayList<Character> markStack = new ArrayList<>();

    public boolean push(Character c) {
        return markStack.add(c);
    }

    public Character pop() {
        Character c = markStack.remove(markStack.size()-1);
        return c;
    }

    public Character top() {
        Character c = markStack.get(markStack.size()-1);
        return c;
    }

    public boolean isMatch(Character c) {
        if (this.isEmpty()) {
            return false;
        }
        switch (this.top()) {
            case '(':
                if (c == ')')
                    return true;
                break;
            case '[':
                if (c == ']')
                    return true;
                break;
            case '{':
                if (c == '}')
                    return true;
                break;
        }
        return false;
    }

    public boolean isEmpty() {
        return markStack.isEmpty();
    }

    @Override
    public String toString() {
        return markStack.toString();
    }
}



