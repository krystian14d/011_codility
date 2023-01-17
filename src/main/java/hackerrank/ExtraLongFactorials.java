package hackerrank;

import java.math.BigInteger;

public class ExtraLongFactorials {

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger number = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            number = number.multiply(BigInteger.valueOf(i));
        }
        System.out.println(number);
    }
}
