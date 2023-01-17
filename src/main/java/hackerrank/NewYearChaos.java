package hackerrank;

import java.util.List;

public class NewYearChaos {

    public static void main(String[] args) {

    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int swapCount = 0;

        int[] arr = q.stream().mapToInt(i -> i).toArray();

        for (int i = (arr.length - 1); i >= 0; i--) {
            //filter cases, when you do not bribe, be at the ith position
            if (arr[i] != (i + 1)) {
                if (((i - 1) >= 0 && arr[i-1] == (i + 1))) {
                    swapCount++;
                    swap(arr, i, i - 1);
                } else if (((i - 2) >= 0) && arr[i-2] == (i + 1)) {
                    swapCount += 2;
                    swap(arr, i - 2, i - 1);
                    swap(arr, i - 1, i);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swapCount);
    }

    private static void swap(int[] arr, int init, int end) {
        int temp = arr[init];
        arr[init] = arr[end];
        arr[end] = temp;
    }
}
