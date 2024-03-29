package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

class JavaMap {
    public static void main(String []argh)
    {
        HashMap<String, Integer> phonebook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            phonebook.put(name, phone);
            in.nextLine();
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            if (phonebook.containsKey(s)){
                System.out.println(s+'='+phonebook.get(s));
            }else{
                System.out.println("Not found");
            }
        }
    }
}
