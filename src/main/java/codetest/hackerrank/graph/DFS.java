package codetest.hackerrank.graph;

public class DFS {
    public static void main(String[] args) {

        String input = "1 2\n" +
                "3 1\n" +
                "2 3\n";

        String[]  rows      = input.trim().split("\n");
        int       nodeCount = 3;
        int[][]   map       = new int[nodeCount + 1][nodeCount + 1];
        boolean[] visited   = new boolean[nodeCount + 1];

        // input to map
        for (String row : rows) {
            String[] paths = row.split(" ");
            int      x     = Integer.parseInt(paths[0]);
            int      y     = Integer.parseInt(paths[1]);
            map[x][y] = 1;
            map[y][x] = 1;
        }
        for(int i=0; i<rows.length; i++) {
            if(!visited[i]) {
                System.out.println("Component " + i + " : ");
                dfs(map, visited, 1);
                System.out.println();
            }
        }
    }

    private static void dfs(int[][] map, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int target = 0; target < map.length; target++) {
            if (map[v][target] == 1 && !visited[target]) {
                dfs(map, visited, target);
            }
        }
    }
}
