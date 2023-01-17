package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountingSort1 {

    public static void main(String[] args) {

    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] frequencyArray = new int[arr.size()];
        Arrays.fill(frequencyArray, 0);

        for (Integer i : arr) {
            frequencyArray[i]++;
        }

//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            result.add(frequencyArray[i]);
//        }

        List<Integer> result = Arrays.stream(frequencyArray)
                .boxed()
                .limit(100)
                .collect(Collectors.toList());

        return result;
    }
}
