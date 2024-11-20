package adder.substractor.multihreaded.syncronized;


import java.util.stream.IntStream;

public class Adder implements Runnable {

    private Counter counter;

    public Adder(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        IntStream.range(0, 100)
                .forEach(i -> counter.incrementValue(1));
    }

}
