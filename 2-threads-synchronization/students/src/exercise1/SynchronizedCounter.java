package exercise1;

import common.Counter;

public class SynchronizedCounter implements Counter {
	
	private long value=0;
	
    @Override
    synchronized public void  increment() {
    	this.value++;

    }
	 
    @Override
    public long getValue() {
        return value;
    }
}
