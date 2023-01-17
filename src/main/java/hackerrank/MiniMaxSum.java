package hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MiniMaxSum {
    public static void main(String[] args) {

    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int sum = arr.stream()
                .reduce(0, Integer::sum);

        int max = arr.stream()
                .max(Integer::compare)
                .get();

        int min = arr.stream()
                .min(Integer::compare)
                .get();

        int minSum = sum - max;
        int maxSum = sum - min;

        System.out.println(minSum + " " + maxSum);
//        arr.stream()
//                .sorted(Collections.reverseOrder())
//                .limit(4)
//                .reduce(0, Integer::sum);
//
//        arr.stream()
//                .sorted()
//                .limit(4)
//                .reduce(0, Long::sum);

    }
}
