package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class JavaArrayList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 0; //number of rows
        n = sc.nextInt();

        ArrayList<ArrayList<Integer>> userInput = new ArrayList<>();

        int d = 0;
        int number = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("How many numbers in row " + (i + 1) + " ?");
            d = sc.nextInt();
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for (int j = 0; j < d; j++) {
                System.out.println("Provide number " + (j + 1) + " in row " + (i + 1) + ":");
                number = sc.nextInt();
                numbers.add(number);
            }
            userInput.add(numbers);
        }

        System.out.println("How many queries?");
        int q = 0;
        q = sc.nextInt();
        int x = 0;
        int y = 0;

        for (int i = 0; i < q; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            if (userInput.get(x-1).size() < y){
                System.out.println("ERROR!");
            }else{
                System.out.println(userInput.get(x-1).get(y-1));
            }
        }
    }
}
