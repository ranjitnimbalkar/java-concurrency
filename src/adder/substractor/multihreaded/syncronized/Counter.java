package adder.substractor.multihreaded.syncronized;

public class Counter {

    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void incrementValue(int value) {
        synchronized(this) {
            count += value;
        }
    }

    public void decrementValue(int value) {
        synchronized(this) {
            count -= value;
        }
    }
}
