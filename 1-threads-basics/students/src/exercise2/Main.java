package exercise2;

public class Main {

    public static void main(String[] args) {

        MyThread[] threads = new MyThread[4];

        for(int i=0;i<4;i++){
            threads[i]=new MyThread("Thread-"+i);
        }

        for(int i=0;i<4;i++){
            threads[i].run();
        }

    }
}
