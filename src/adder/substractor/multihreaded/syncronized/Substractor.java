package adder.substractor.multihreaded.syncronized;

import java.util.stream.IntStream;

public class Substractor implements Runnable {

    private Counter counter;

    public Substractor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        IntStream.range(0, 100)
                .forEach(i -> counter.decrementValue(1));
    }

}
