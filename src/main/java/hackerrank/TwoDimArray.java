package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class TwoDimArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        int max = Integer.MIN_VALUE;
        for(int row = 0;row< arr.size()-2;row++){
            for(int col=0;col< arr.size()-2;col++){
                int sum = 0;
                sum+=arr.get(row).get(col) + arr.get(row).get(col+1) + arr.get(row).get(col+2) + arr.get(row+1).get(col+1) + arr.get(row+2).get(col) + arr.get(row+2).get(col+1) + arr.get(row+2).get(col+2);
                max = Math.max(sum,max);
            }

        }
        System.out.println(max);

    }
}
