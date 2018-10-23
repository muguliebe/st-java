package codetest.hackerrank.graph;

import zutil.FileUtils;

import java.net.URL;
import java.util.*;

public class RoadsAndLibrariesMemory {
    public static void main(String[] args) {

//        URL          resource = RoadsAndLibrariesMemory.class.getClassLoader().getResource("questions/question1.txt");
//        URL          resource = RoadsAndLibrariesMemory.class.getClassLoader().getResource("questions/question2.txt");
        URL          resource = RoadsAndLibrariesMemory.class.getClassLoader().getResource("questions/q3.txt");
        List<String> inputs   = FileUtils.readLargeFileLines(resource.getPath());
        assert inputs != null;
        int query = Integer.parseInt(inputs.get(0));

        int lines = 1;
        for (int test = 0; test < query; test++) {
            String   summary       = inputs.get(lines++);
            String[] nmC_libC_road = summary.trim().replaceAll("\n", "").split(" ");
            int      n             = Integer.parseInt(nmC_libC_road[0]);    // count of cities
            int      m             = Integer.parseInt(nmC_libC_road[1]);    // map
            int      c_lib         = Integer.parseInt(nmC_libC_road[2]);    // cost of library
            int      c_road        = Integer.parseInt(nmC_libC_road[3]);    // cost of road

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] items = inputs.get(lines++).trim().split(" ");
                for (int j = 0; j < 2; j++) {
                    cities[i][j] = Integer.parseInt(items[j]);
                }
            }
            long result = roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println("result = " + result + "  c_lib:" + c_lib + " c_road:" + c_road);
        }

    }

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        // declaration
        long minCostTotal = 0L;
        map = new HashMap<>();
        visited = new boolean[n + 1];

        // get All Components
        List<List<Integer>> components = getComponents(cities);

        // get each cost of each Component's
        for (List<Integer> component : components) {
            long costOfLib  = component.size() * c_lib;
            long costOfRoad = (component.size() - 1) * c_road + c_lib;
            minCostTotal += costOfLib > costOfRoad ? costOfRoad : costOfLib;
        }

        return minCostTotal;
    }

    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static boolean[] visited;

    private static void addEdge(int v, int w) {
        map.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
        map.computeIfAbsent(w, k -> new ArrayList<>()).add(v);
    }

    private static List<List<Integer>> getComponents(int[][] cities) {
        List<List<Integer>> result = new ArrayList<>();

        // make map
        for (int[] city : cities) {
            addEdge(city[0], city[1]);
        }

        // search
        map.keySet().stream()
                .filter(next -> !visited[next])
                .forEach(next -> {
                    List<Integer> component = new ArrayList<>();
                    search(next, component);
                    result.add(component);
                });
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                component.add(i);
                result.add(component);
            }
        }
        return result;
    }

    private static void search(int target, List<Integer> component) {
        visited[target] = true;
        component.add(target);

        map.get(target).stream()
                .filter(next -> !visited[next])
                .forEach(next -> search(next, component));
    }
}
