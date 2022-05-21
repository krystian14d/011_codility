package codility.lessons.countingElements;

public class MissingInteger {

    public static void main(String[] args) {

    }

    public int solution(int[] A) {

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
