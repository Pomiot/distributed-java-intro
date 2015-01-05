package exercise2.equipment;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Brushes {

    BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
    public Brushes(){
        queue.offer("Triangular");
        queue.offer("Regular");
        queue.offer("Spectacular");
    }

    public String takeBrush() throws InterruptedException {
        return queue.take();
    }

    public void returnBrush(String brush) {

        queue.offer(brush);

    }
}
