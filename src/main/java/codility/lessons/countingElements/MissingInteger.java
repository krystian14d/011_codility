//This is a demo task.
//
//        Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//        Given A = [1, 2, 3], the function should return 4.
//
//        Given A = [−1, −3], the function should return 1.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [1..100,000];
//        each element of array A is an integer within the range [−1,000,000..1,000,000].

package codility.lessons.countingElements;

public class MissingInteger {

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(A));
    }

    //100%
    public static int solution(int[] A) {

        boolean[] existingNumbers = new boolean[100001];

        for (int i : A) {
            if (i >= 1 && i <= 100000) {
                existingNumbers[i - 1] = true;
            }
        }

        for (int i = 0; i < existingNumbers.length; i++) {
            if (!existingNumbers[i]) {
                return i + 1;
            }
        }

        return 1;
    }
}
