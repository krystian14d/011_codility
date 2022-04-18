package codility.lessons.arrays;

import java.util.HashSet;

public class PermMissingElem {
    public static void main(String[] args) {

        int[] A = {2, 3, 5, 1};
        System.out.println("Missing element is " + solution(A));
    }

    static int solution(int[] A) {
        HashSet<Integer> numbersSet = new HashSet<>();
        int maxNumber = A.length + 1;

        //dodajemy do setu wszystkie listy z naszej listy
        for (int i = 0; i < A.length; i++) {
            numbersSet.add(A[i]);
        }

        //sprawdzamy czy set zawiera każdą liczbę od 1 do max, jeśli nie to ją zwracamy
        for (int i = 1; i <= maxNumber; i++) {
            if (!numbersSet.contains(i)) {
                return i;
            }
        }
        return 0;
    }


}


//    static int solution(int[] A) {
//
//        HashSet<Integer> numbers = new HashSet<>();
//        int maxNumber = A.length + 1;
//
//        for (int i = 0; i < A.length; i++) {
//            numbers.add(A[i]);
//        }
//
//        for (int i = 1; i < maxNumber + 1; i++) {
//            if (!numbers.contains(i))
//                return i;
//        }
//        return 0;
//    }

