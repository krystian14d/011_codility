package hackerrank;

import java.util.List;

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        if(k<2){
            return 1;
        }
        //counting equal remainders when divided be k, using basic hashing concept
        int[] remaindersCounter = new int[k];
        for (int i = 0; i < s.size(); i++) {
            int place = s.get(i)%k;
            remaindersCounter[place]++;
        }

        //main logic - count number of subsets
        int counter = 0;
        for (int i = 0; i < k/2; i++) {//we use k/2 because sum of remainder lower than k/2 and bigger than k/2 may give number dividable by k
            counter = counter + Math.max(remaindersCounter[i],remaindersCounter[k-i]);
        }

        return 0;
    }
}
