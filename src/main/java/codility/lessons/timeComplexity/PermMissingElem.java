//An array A consisting of N different integers is given.
// The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
//
//        Your goal is to find that missing element.
//
//        Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A, returns the value of the missing element.
//
//        For example, given array A such that:
//
//        A[0] = 2
//        A[1] = 3
//        A[2] = 1
//        A[3] = 5
//        the function should return 4, as it is the missing element.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [0..100,000];
//        the elements of A are all distinct;
//        each element of array A is an integer within the range [1..(N + 1)].

package codility.lessons.timeComplexity;

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

