package codility.lessons.arrays;

import java.util.HashSet;

public class OddOccurencesInArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, 6, 2, 3, 7, 9, 7, 9, 6, 1, 1}));
    }

    public static int solution(int[] A) {
        HashSet<Integer> ints = new HashSet<>();
        for (int a : A) {
            if (!ints.contains(a)) {
                ints.add(a);
            } else {
                ints.remove(a);
            }

        }
        for (Integer a : ints) {
            return a;
        }
        return 0;
    }
}
