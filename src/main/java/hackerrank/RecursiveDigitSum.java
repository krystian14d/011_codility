package hackerrank;

public class RecursiveDigitSum {
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
