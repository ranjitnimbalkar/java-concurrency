package producer.consumer.semaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {

    public static void main(String[] args) {
        Queue<Shirt> store = new ConcurrentLinkedQueue<>();
        Semaphore producerSemaphore = new Semaphore(6);
        Semaphore consumerSemaphore = new Semaphore(0);

        Producer p1 = new Producer("P1", store, producerSemaphore, consumerSemaphore, 6);
        Producer p2 = new Producer("P2", store, producerSemaphore, consumerSemaphore, 6);
        Producer p3 = new Producer("P3", store, producerSemaphore, consumerSemaphore, 6);

        Consumer c1 = new Consumer("C1", store, producerSemaphore, consumerSemaphore);
        Consumer c2 = new Consumer("C2", store, producerSemaphore, consumerSemaphore);
        Consumer c3 = new Consumer("C3", store, producerSemaphore, consumerSemaphore);
        Consumer c4 = new Consumer("C4", store, producerSemaphore, consumerSemaphore);
        Consumer c5 = new Consumer("C5", store, producerSemaphore, consumerSemaphore);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);

        Thread t4 = new Thread(c1);
        Thread t5 = new Thread(c2);
        Thread t6 = new Thread(c3);
        Thread t7 = new Thread(c4);
        Thread t8 = new Thread(c5);

        t1.start();
        t2.start();
        t3.start();

        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();

    }

}
