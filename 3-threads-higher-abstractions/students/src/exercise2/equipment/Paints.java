package exercise2.equipment;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Paints {

    BlockingQueue<String> queue = new ArrayBlockingQueue<String>(4);

    public Paints(){
        queue.offer("Red");
        queue.offer("Blue");
        queue.offer("Green");
    }

    public String takePaint() throws InterruptedException {
        return queue.take();
    }

    public void returnPaint(String paint) {
        queue.offer(paint);
    }
}
