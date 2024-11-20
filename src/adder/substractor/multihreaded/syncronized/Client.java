package adder.substractor.multihreaded.syncronized;


public class Client {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter(0);

        Adder adder = new Adder(counter);
        Substractor substractor = new Substractor(counter);

        Thread adderThread = new Thread(adder);
        Thread subtractThead = new Thread(substractor);

        adderThread.start();
        subtractThead.start();

        adderThread.join();
        subtractThead.join();

        System.out.println("Counter : " + counter.getCount());

    }

}
