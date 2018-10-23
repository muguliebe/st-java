package codetest.hackerrank.graph;

import zutil.FileUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RoadsAndLibraries {
    public static void main(String[] args) {

        URL          resource = RoadsAndLibraries.class.getClassLoader().getResource("questions/question1.txt");
        List<String> inputs   = FileUtils.readLargeFileLines(resource.getPath());
        assert inputs != null;
        int query = Integer.parseInt(inputs.get(0));

        int lines = 1;
        for (int test = 0; test < query; test++) {
            String summary = inputs.get(lines++);
            String[] nmC_libC_road = summary.trim().replaceAll("\n", "").split(" ");
            int     n      = Integer.parseInt(nmC_libC_road[0]);    // count of cities
            int     m      = Integer.parseInt(nmC_libC_road[1]);    // map
            int     c_lib  = Integer.parseInt(nmC_libC_road[2]);    // cost of library
            int     c_road = Integer.parseInt(nmC_libC_road[3]);    // cost of road

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] items = inputs.get(lines++).trim().split(" ");
                for (int j = 0; j < 2; j++) {
                    cities[i][j] = Integer.parseInt(items[j]);
                }
            }
            long result = new RoadsAndLibraries().roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println("result = " + result);
        }

    }

    /**
     * @param n      count of cities
     * @param c_lib  cost of library
     * @param c_road cost of road
     * @param cities arr that have a path
     * @return
     */
    long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        // declaration
        long minCostTotal = 0L;

        // get All Components
        List<List<Integer>> components = getComponents(n, cities);

        // get each cost of each Component's
        for (List<Integer> component : components) {
            long costOfLib  = component.size() * c_lib;
            long costOfRoad = (component.size() - 1) * c_road + c_lib;
            minCostTotal += costOfLib > costOfRoad ? costOfRoad : costOfLib;
        }

        return minCostTotal;
    }


    List<List<Integer>> getComponents(int n, int[][] cities) {
        List<List<Integer>> result  = new ArrayList<>();
        boolean[]           visited = new boolean[n + 1];
        int[][]         map     = new int[n + 1][n + 1];

        // make map
        for (int[] city : cities) {
            int x = city[0];
            int y = city[1];
            map[x][y] = 1;
            map[y][x] = 1;
        }

        // search
        for (int target = 1; target <= n; target++) {
            if (!visited[target]) {
                List<Integer> component = new ArrayList<>();
                search(map, visited, target, component);
                if (component.size() > 0) {
                    result.add(component);
                }
            }
        }

        return result;
    }

    private void search(int[][] map, boolean[] visited, int target, List<Integer> component) {
        visited[target] = true;
        component.add(target);
        for (int i = 1; i < map.length; i++) {
            if (map[target][i] == 1 && !visited[i]) {
                search(map, visited, i, component);
            }
        }
    }

}
