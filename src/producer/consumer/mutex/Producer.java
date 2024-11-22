package producer.consumer.mutex;

import java.util.Queue;

public class Producer implements Runnable {

    private String name;
    private Queue<Shirt> store;
    private int maximumSize;

    public Producer(String name, Queue<Shirt> store, int maximumSize) {
        this.name = name;
        this.store = store;
        this.maximumSize = maximumSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized(store) { //this is mutex lock allowing only one producer to produce one shirt at a time
                if (store.size() < maximumSize) {
                    System.out.println("Producer " + name + " is producing. Current store size - " + store.size());
                    store.add(new Shirt());
                }
            }
        }
    }

}
