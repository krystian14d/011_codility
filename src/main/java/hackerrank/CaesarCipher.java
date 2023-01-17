package hackerrank;

import java.util.Locale;

public class CaesarCipher {
    public static void main(String[] args) {

    }

    public static String caesarCipher(String s, int k){
        String result = "";
        String str = "";
        int i;
        String smallAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String capitalAlphabet = smallAlphabet.toUpperCase(Locale.ROOT);

        for (char c : s.toCharArray()){
            str = c + "";
            if(Character.isLetter(c)){
                i = capitalAlphabet.indexOf(Character.toUpperCase(c));
                if(Character.isUpperCase(c)){
                    str = capitalAlphabet.toCharArray()[(i+k)%26]+"";
                }else{
                    str = smallAlphabet.toCharArray()[(i+k)%26]+"";
                }
            }
            result+=str;
        }
        return result;
    }
}
