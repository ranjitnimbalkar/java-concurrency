package producer.consumer.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    private String name;
    private Queue<Shirt> store;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;

    public Consumer(String name, Queue<Shirt> store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.name = name;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true) {
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!store.isEmpty()) {
                System.out.println("Consumer " + name + " is consuming. Current store size - " + store.size());
                store.remove();
            }
            producerSemaphore.release();
        }
    }
}
