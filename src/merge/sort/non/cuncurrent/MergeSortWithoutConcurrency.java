package merge.sort.non.cuncurrent;

import java.util.ArrayList;
import java.util.List;

public class MergeSortWithoutConcurrency {
    public static void main(String[] args) {
       List<String > list = List.of("Ranjit","Ashvini", "Rajveer");
        List<String> sortedData = mergeSort(list);
        System.out.println(sortedData);
    }


    private static <T extends Comparable<T>> List<T> mergeSort(List<T> unsortedList) {
        if(unsortedList.size() == 1) {
            return unsortedList;
        }

        int mid = unsortedList.size()/2;
        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();

        for(int i = 0; i < mid; i++) {
            left.add(unsortedList.get(i));
        }

        for (int i = mid; i < unsortedList.size(); i++ ) {
            right.add(unsortedList.get(i));
        }

        List<T> leftSorted = mergeSort(left);
        List<T> rightSorted = mergeSort(right);

        return merge(leftSorted, rightSorted);
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> leftSorted, List<T> rightSorted) {
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
