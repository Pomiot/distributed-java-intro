package exercise2;

import common.Counter;
import java.util.concurrent.locks.ReentrantLock;

public class LockingCounter implements Counter {
	
	private long value=0;
	private final ReentrantLock locker = new ReentrantLock();

    @Override
    public void increment() {
    	
    	locker.lock();
    	try{
    		this.value++;
    	}
    	finally {
    		locker.unlock();
    	}
    	
    }

    @Override
    public long getValue() {
        return value;
    }
}
