package hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class JesseAndCookies {
    public static int cookies(int k, List<Integer> A) {
//        A.sort((a,b)->a-b);
//        int sum=0;
//        if(A.get(0)>=k)
//            return sum;
//        while (A.get(0)<k && (A.size()>=2)) {
//            int t=A.get(0)+A.get(1)*2;
//            A.set(1, t);
//            A.remove(0);
//            A.sort((a,b)->a-b);
//            sum++;
//        }
//        if(A.get(0)>=k)
//            return sum;
//        return -1;


        int result = 0;
        boolean flag = true;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(A);

        while (priorityQueue.peek() >= k) {
            if (priorityQueue.size() > 1) {
                if (priorityQueue.peek() < k) {
                    int number = priorityQueue.poll() + 2 * priorityQueue.poll();
                    priorityQueue.add(number);
                    result++;
                }
//                if (priorityQueue.peek() >= k) {
//                    flag = false;
//                }
            } else {
                return -1;
            }
        }
        return result;
    }
}
