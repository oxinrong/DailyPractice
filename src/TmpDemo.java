import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ListIterator;

public class TmpDemo {
    public static void main(String[] args) {
       String s = new String("abc");
       String s1 = "abc";
       String s2 = new String("abc");

        System.out.println(s == s1.intern());
        System.out.println(s == s2.intern());
        System.out.println(s1 == s2.intern());
    }
}
