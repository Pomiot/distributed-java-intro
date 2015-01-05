package exercise7.equipment;

public class Brushes {

    private int available = 3;

    public synchronized void takeBrush() throws InterruptedException {
        while (available == 0) {
            try {
            	wait();
            }
            catch(InterruptedException e) {}
        }
        available -= 1;
    }

    public synchronized void returnBrush() {
        available += 1;
        notifyAll();
    }
}
