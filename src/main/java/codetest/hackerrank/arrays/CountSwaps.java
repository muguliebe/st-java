package codetest.hackerrank.arrays;

import java.util.Arrays;

public class CountSwaps {
    static void countSwaps(int[] a) {
        Integer swapCount = 0;

        for (int i = 0; i < a.length-1; i++) {
            for (int j = 1; j < a.length-i; j++) {
                if (a[i] > a[i+j]) {
                    int tmp = a[i];
                    a[i] = a[i+j];
                    a[i+j] = tmp;
                    swapCount++;
                }
            }
        }

        // result
        System.out.println("Array is sorted in " + swapCount + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length- 1]);

        // tmp
        Arrays.stream(a).forEach(i -> System.out.print(" " + i));
    }

    public static void main(String[] args) {
        int num = 3;
        String input = "3 2 1\n";

        int[] arr = new int[num];
        String[] s = input.trim().replaceAll("\n", "").split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        countSwaps(arr);
    }
}
