package codility.lessons.countingElements;

public class MissingInteger {

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {

        boolean[] existingNumbers = new boolean[100001];

        for (int i : A) {
            System.out.println(i);
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
