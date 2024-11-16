package merge.sort.cuncurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConcurrentMergeSort<T extends Comparable<T>> implements Callable<List<T>> {

    List<T> listToSort;
    ExecutorService executorService;

    public ConcurrentMergeSort(List<T> listToSort, ExecutorService executorService) {
        this.listToSort = listToSort;
        this.executorService = executorService;
    }


    @Override
    public List<T> call() throws ExecutionException, InterruptedException {

        if(listToSort.size() == 1) {
            return listToSort;
        }

        int mid = listToSort.size()/2;
        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();

        left.addAll(listToSort.subList(0, mid));
        right.addAll(listToSort.subList(mid, listToSort.size()));

        Future<List<T>> leftFuture = executorService.submit(new ConcurrentMergeSort<>(left, executorService));
        Future<List<T>> rightFuture = executorService.submit(new ConcurrentMergeSort<>(right, executorService));

        return merge(leftFuture.get(), rightFuture.get());
    }

    private  List<T> merge(List<T> leftSorted, List<T> rightSorted) {
        int l = 0, r = 0;
        List<T> result = new ArrayList<>();

        while (l < leftSorted.size() && r < rightSorted.size()) {

            if(leftSorted.get(l).compareTo(rightSorted.get(r)) >= 0) {
                result.add(leftSorted.get(l));
                l++;
            } else {
                result.add(rightSorted.get(r));
                r++;
            }
        }

        while (l < leftSorted.size()) {
            result.add(leftSorted.get(l));
            l++;
        }

        while (r < rightSorted.size()) {
            result.add(rightSorted.get(r));
            r++;
        }

        return result;
    }
}
