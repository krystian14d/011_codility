package codility.lessons.arrays;

public class TapeEquilibrium {
    public static void main(String[] args) {

        int[] A = {3, 1, 2, 4, 3};

        System.out.println("minimum difference is: " + solution(A));

    }

    static int solution(int[] A) {
        long sumOfAllElements = 0;
        for (int i = 0; i < A.length; i++) {
            sumOfAllElements += A[i];
        }

        int minDifference = Integer.MAX_VALUE;
        int currentDifference = Integer.MAX_VALUE;
        long sumFirstPart = 0;
        long sumSecondPart = 0;

        for (int p = 0; p < A.length - 1; p++) {
            sumFirstPart += A[p];
            sumSecondPart = sumOfAllElements - sumFirstPart;
            currentDifference = (int) Math.abs(sumFirstPart - sumSecondPart);
            minDifference = Math.min(minDifference, currentDifference);
        }

        return minDifference;
    }
}
