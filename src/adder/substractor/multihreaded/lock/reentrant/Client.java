package adder.substractor.multihreaded.lock.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter(0);
        Lock lock = new ReentrantLock();
        Adder adder = new Adder(counter, lock);
        Substractor substractor = new Substractor(counter, lock);

        Thread adderThread = new Thread(adder);
        Thread subtractThead = new Thread(substractor);

        adderThread.start();
        subtractThead.start();

        adderThread.join();
        subtractThead.join();

        System.out.println("Counter : " + counter.getCount());

    }

}
