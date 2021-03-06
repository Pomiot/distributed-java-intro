package exercise3;

import common.Counter;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounter implements Counter {
	
	AtomicLong value = new AtomicLong();

    @Override
    public void increment() {
    	
    	this.value.incrementAndGet();

    }

    @Override
    public long getValue() {
        return value.longValue();
    }
}
