package hackerrank;

import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

class JavaAnagrams {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if(a.length() != b.length())
            return false;

        String aLower = a.toLowerCase(Locale.ROOT);
        String bLower = b.toLowerCase(Locale.ROOT);
        int[] anagramArray = new int[26];

        for (int i = 0; i < a.length(); i++) {
            char chA = aLower.charAt(i);
            char chB = bLower.charAt(i);

            anagramArray[chA - 'a']++;
            anagramArray[chB - 'a']--;
        }

        for (final int x : anagramArray) {
            if(x != 0){
                return false;
            }
        }

        return true;

    }
}
