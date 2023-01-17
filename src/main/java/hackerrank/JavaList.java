package hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

class JavaList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int arrInput = sc.nextInt();
            numbers.add(arrInput);
        }

        int q = sc.nextInt();


        for (int i = 0; i < q; i++) {
            sc.nextLine();
            String operation = sc.nextLine();
            if(operation.equals("Insert")){
                int x = sc.nextInt();
                int y = sc.nextInt();
                numbers.add(x,y);
            }else{
                int x = sc.nextInt();
                numbers.remove(x);
            }
        }

        numbers.forEach(x -> System.out.print(x + " "));
    }
}
