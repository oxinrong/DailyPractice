package algorithm;

    public class OthersPassDemo{
        public static void main(String[] args){
            int num,temp,m;
            for (int i = 1; i < 256; i++) {
                num = i * i;
                m = 0;
                while (num > 0) {
                    temp = num % 10;
                    m = temp + m * 10;
                    num = num / 10;
                }
                if (m == i * i)
                    System.out.println(i);
            }
        }
    }