package hackerrank;

import java.util.Scanner;

class StringReverse {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        StringBuilder sb = new StringBuilder();
        String B = sb.append(A).reverse().toString();

        if(A.equals(B)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
