package exercise2;

public class MyThread extends Thread {

    public MyThread(String name){
        super(name);

    }

    public void run(){

        for(int i=1;i<=10;i++){

            System.out.println("Thread " + this.getName() + ": iteration " + i);
            try {
                Thread.sleep(10);
            }
            catch(Exception e){
                System.out.println("Something bad happened");
                e.printStackTrace();
            }
        }
    }
}
