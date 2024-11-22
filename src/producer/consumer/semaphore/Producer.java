package producer.consumer.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    private String name;
    private Queue<Shirt> store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    private int maximumSize;

    public Producer(String name, Queue<Shirt> store, Semaphore producerSemaphore, Semaphore consumerSemaphore, int maximumSize) {
        this.name = name;
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.maximumSize = maximumSize;
    }

    @Override
    public void run() {
        while (true) {

            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(store.size() < maximumSize) {
                   System.out.println("Producer " + name + " is producing. Current store size - " + store.size());
                   store.add(new Shirt());
            }

            consumerSemaphore.release();
        }
    }

}
