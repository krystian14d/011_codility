package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuperDigit {

    public static void main(String[] args) {

    }

    public static int superDigit(String n, int k) {
        // Write your code here
        return superDigitOf(String.valueOf(superDigitOf(n)*k));
    }

    public static int superDigitOf(String str){
        if(str.length() == 1)
            return Integer.parseInt(str);
        long num = 0l;
        for(char c : str.toCharArray()){
            num += Character.getNumericValue(c);
        }
        return superDigitOf(String.valueOf(num));
    }


}
