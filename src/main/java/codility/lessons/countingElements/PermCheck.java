package codility.lessons.countingElements;

import java.util.HashSet;

public class PermCheck {
    public static void main(String[] args) {

        int[] A = {4, 1, 3, 2};

        System.out.println(solution2(A));
    }


//    public int solution(int[] A) {
//        HashSet<Integer> numbers = new HashSet<>();
//
//        for (int i = 0; i < A.length; i++) {
//            numbers.add(A[i]);
//        }
//
//        for (int i = 1; i < numbers.size(); i++) {
//            if (!numbers.contains(i)) {
//                return 0;
//            }
//        }
//        return 1;
//    }

    static int solution2(int[] A) {
        HashSet<Integer> testedSet = new HashSet<>();
        HashSet<Integer> idealSet = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            testedSet.add(A[i]);
            idealSet.add(i + 1);
        }

        for (int current : idealSet) {
            if(!testedSet.contains(current)){
                return 0;
            }
        }
        return 1;
    }
}
