package adder.substractor.multihreaded.lock.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.stream.IntStream;

public class Adder implements Runnable {

    private Counter counter;
    private Lock lock;

    public Adder(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        IntStream.range(0, 100)
                .forEach(i -> {
                        lock.lock();
                        counter.setCount(counter.getCount() + 1);
                        lock.unlock();
                 });
    }

}
