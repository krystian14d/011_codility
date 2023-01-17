package hackerrank;

import java.util.List;

public class DiagonalDifference {
    public static void main(String[] args) {

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int diagonalDifference = 0;
        int sumMainDiagonal = sumMainDiagonal(arr);
        int sumSecondaryDiagonal = sumSecondaryDiagonal(arr);
        diagonalDifference = Math.abs(sumMainDiagonal - sumSecondaryDiagonal);
        return diagonalDifference;
    }

    public static int sumMainDiagonal(List<List<Integer>> arr){
        int sumMainDiagonal = 0;
        int x = 0, y = 0;
        while (x < arr.size() && y < arr.get(0).size()) {
            sumMainDiagonal += arr.get(y).get(x);
            x++;
            y++;
        }
        return sumMainDiagonal;
    }

    public static int sumSecondaryDiagonal(List<List<Integer>> arr){
        int sumSecondaryDiagonal = 0;
        int x = 0, y = arr.size() - 1;
        while (x < arr.size() && y >= 0) {
            sumSecondaryDiagonal += arr.get(y).get(x);
            x++;
            y--;
        }
        return sumSecondaryDiagonal;
    }
}
