package algorithm;

import java.util.HashSet;

public class StampDemo {
    public static void main(String[] args) {
        int eightStamp = 8;
        int tenStamp = 10;
        int eighteenStamp = 18;

        HashSet hashSet = new HashSet();
        System.out.println(hashSet.size());
        int sum;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 7; k++) {
                    sum = i * eightStamp + j * tenStamp + k * eighteenStamp;
                    hashSet.add(sum);
                }
            }
        }
        System.out.println(hashSet.size()-1);

        HashSet test = new HashSet();
        test.add(1);
        test.add(2);
        test.add(2);
        test.add(3);
        System.out.println(test.size());
    }
}
