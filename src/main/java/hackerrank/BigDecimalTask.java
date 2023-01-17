package hackerrank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class BigDecimalTask {

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here

        Comparator<String> comparator = (o1, o2) -> {
            BigDecimal a = new BigDecimal(o1);
            BigDecimal b = new BigDecimal(o2);

            return b.compareTo(a);
        };

        Arrays.sort(s, 0, n, comparator);

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
