package algorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDemo {


    public static void main(String[] args) throws IOException {


        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            if ("2".equals(s))
                list.remove(s);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
    }
}
