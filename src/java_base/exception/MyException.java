package java_base.exception;

class MyException1 extends Exception {
    String msg;
    MyException1(String s){
        msg = s;
    }

    public void printString() {
        System.out.println(msg);
    }
    
}

public class MyException {
    public void f() throws MyException1 {
     
            throw new MyException1("throw my exception1");
       
    }
    public static void main(String[] args) {
        MyException me = new MyException();
        try { 
           
            l:
            while (true) {
                System.out.println("inside while");
                me.f();
                break l;
            }
        } catch (MyException1 e) {
            e.printStackTrace();
        } finally {
            System.out.print("finally executed");
        }
    }
}


