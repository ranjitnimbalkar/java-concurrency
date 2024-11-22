package producer.consumer.mutex;

import java.util.Queue;

public class Consumer implements Runnable {

    private String name;
    private Queue<Shirt> store;

    public Consumer(String name, Queue<Shirt> store) {
        this.store = store;
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (store) {
                if (!store.isEmpty()) {
                    System.out.println("Consumer " + name + " is consuming. Current store size - " + store.size());
                    store.remove();
                }
            }
        }
    }
}
