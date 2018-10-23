package codetest.hackerrank.search;

import codetest.hackerrank.graph.RoadsAndLibrariesMemory;
import zutil.FileUtils;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class WhatFlavors {

    public static void main(String[] args) {

        URL resource = RoadsAndLibrariesMemory.class.getClassLoader().getResource("questions/q4.txt");
        assert resource != null;
        List<String> inputs = FileUtils.readLargeFileLines(resource.getPath());
        assert inputs != null;

        int line  = 0;
        int query = Integer.parseInt(inputs.get(line++));

        for (int i = 0; i < query; i++) {
            int money = Integer.parseInt(inputs.get(line++));
            int n     = Integer.parseInt(inputs.get(line++));
            int[] cost = Arrays.stream(inputs.get(line++).trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            whatFlavors(cost, money);
        }
    }

    private static void whatFlavors(int[] cost, int money) {
        int[] org = cost.clone();
        Arrays.sort(cost);

        for (int val : cost) {
            int idx = Arrays.binarySearch(cost, money - val);
            if (idx >= 0) {
                int minIdx = getIndex(org, val, -1) + 1;
                int maxIdx = getIndex(org, cost[idx], minIdx-1) + 1;
                System.out.println(Math.min(minIdx, maxIdx) + " " + Math.max(minIdx, maxIdx));
                return;
            }
        }
    }

    private static int getIndex(int[] a, int key, int exceptIndex) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key && i != exceptIndex) {
                return i;
            }
        }
        return -1;
    }
}
