package hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

class JavaDequeue {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        HashSet<Integer> hashSet = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            hashSet.add(num);

            if(deque.size() == m){
                max = Math.max(max, hashSet.size());
                int removed = (int) deque.removeFirst();
                if (!deque.contains(removed)){
                    hashSet.remove(removed);
                }
            }
        }

        System.out.println(max);
    }
}
