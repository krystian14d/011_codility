package hackerrank;

import java.util.Scanner;

class JavaSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        int negatives = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;

                for (int k = i; k <= j ; k++) {
                    sum+=arr[k];
                }

                if(sum < 0){
                    negatives++;
                }
            }

        }

        System.out.println(negatives);

    }
}
