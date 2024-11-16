package merge.sort.cuncurrent;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestConcurrentMergeSort {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer > list = List.of(5, 8, 4, 2, 6, 2, 9, 10);
        ExecutorService service = Executors.newFixedThreadPool(10);

        ConcurrentMergeSort sort = new ConcurrentMergeSort(list, service);

        System.out.println(service.submit(new ConcurrentMergeSort<>(list, service)).get());

        service.shutdown();
    }
}
