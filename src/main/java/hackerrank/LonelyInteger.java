package hackerrank;

import java.util.HashSet;
import java.util.List;

public class LonelyInteger {

    public static void main(String[] args) {

    }

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        HashSet<Integer> unique = new HashSet<>();

        for (Integer number : a) {
            if(unique.contains(number)){
                unique.remove(number);
            }else{
                unique.add(number);
            }
        }

        return unique.stream().findAny().get();
    }
}
