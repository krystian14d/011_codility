package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridChallenge {
    public static void main(String[] args) {

    }

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        //sort the strings in each element of the grid
        List<String> sorted = new ArrayList<>();
        for (String s : grid) {
            //convert String to char array
            char[] charArray = s.toCharArray();
            //sort
            Arrays.sort(charArray);
            //add to the list
            sorted.add(new String(charArray));
        }

//        iterate through "columns"
        for (int i = 0; i < sorted.get(0).length(); i++) {
            int max = 0;
            //iterate through "rows"
            for (int j = 0; j < sorted.size(); j++) {
                //iterating through rows and taking character at place "i"
                int temp = sorted.get(j).charAt(i);
                //if checked character (temp) is lower than max - then return NO
                if(temp<max){
                    return "NO";
                }else{
                    //assign to max current temp value to check further characters in the column
                    max = temp;
                }
            }

        }
        return "YES";
    }
}
