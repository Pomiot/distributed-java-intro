package exercise3;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Thread[] threads = new Thread[4];

        for(int i=0;i<4;i++){
            threads[i]=new Thread(new MyRunnable(),"Runnable-"+i);
        }

        for(int i=0;i<4;i++){
            threads[i].start();
        }

        //naiveApproach();
        //continuousPollingApproach(threads);
        joinApproach(threads);

    }

    private static void naiveApproach(){

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("FINISHED");

    }

    private static void continuousPollingApproach(Thread[] threads){

        while(true){

            boolean isAlive = false;

            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    isAlive = true;
                    break;
                }
            }
            if (!isAlive) {
                break;
            }
        }
        System.out.println("FINISHED");
    }


    private static void joinApproach(Thread[] threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("FINISHED");
    }
}
