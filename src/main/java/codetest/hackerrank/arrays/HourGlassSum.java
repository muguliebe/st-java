package codetest.hackerrank.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HourGlassSum {
    public static void main(String[] args) {
        String input = "-1 -1 0 -9 -2 -2\n" +
                       "-2 -1 -6 -8 -2 -5\n" +
                       "-1 -1 -1 -2 -3 -4\n" +
                       "-1 -9 -2 -4 -4 -5\n" +
                       "-7 -3 -3 -2 -9 -9\n" +
                       "-1 -3 -1 -2 -4 -5";

        int[][] arr = new int[6][6];
        String[] inputs = input.split("\n");
        int i = 0, j = 0;
        for (String line : inputs) {
            String[] in = line.split(" ");
            for (String s : in) {
                arr[i][j++] = Integer.parseInt(s);
            }
            i++;
            j = 0;
        }
        int result = hourglassSum(arr);
        System.out.println("result = " + result);
    }

    static int hourglassSum(int[][] arr) {
        Integer maxSum = Integer.MIN_VALUE;

        for(int x=0 ;x<=arr.length/2; x++){
            for (int y=0; y<=arr.length/2; y++) {
                int[][] square = extractHourGlass(arr, x, y);
                int curSum = getSum(square);
                if (curSum > maxSum) maxSum = curSum;
            }
        }
        return maxSum;
    }

    private static int[][] extractHourGlass(int[][] arr, int width, int height) {
        int[][] result = new int[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                result[x][y] = arr[x+width][y+height];
            }
        }
        return result;
    }

    private static int getSum(int[][] arr) {
        int sum = Arrays.stream(arr)
                .map(Arrays::stream)
                .mapToInt(IntStream::sum)
                .sum();
        sum -= arr[1][0] - arr[1][2];
        return sum;
    }
}
