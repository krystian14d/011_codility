package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) throws Exception {

        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        Stack<String> s = new Stack<>();
        String s1="";
        s.push(s1);
        int k= Integer.parseInt(br.readLine());

        for(int i=0;i<k;i++)
        {

            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            switch(n)
            {
                case 1:
                    s1=s.peek();
                    s1=s1+arr[1];
                    s.push(s1);
                    break;

                case 2 :

                    s1=s.peek();

                    s1 = s1.substring(0, s1.length()-Integer.valueOf(arr[1]));
                    s.push(s1);
                    break;

                case 3 :
                    s1=s.peek();
                    System.out.println(s1.charAt(Integer.valueOf(arr[1])-1));
                    break;

                case 4:
                    s.pop();
                    break;
            }

        }
    }
}
