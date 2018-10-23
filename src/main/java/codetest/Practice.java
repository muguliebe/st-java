package codetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {

        addEdge(1, 2);
        System.out.println("edges = " + edges);
        Node node = new Node(1);
        System.out.println("node = " + node);
    }

    static Map<Integer, ArrayList<Integer>> edges = new HashMap<>();

    static void addEdge(int v, int w) {
        edges.computeIfAbsent(v, k -> new ArrayList<>()).add(v);
        edges.computeIfAbsent(w, k -> new ArrayList<>()).add(w);
    }

    static class Node {
        int id;
        boolean bMarked = false;
        ArrayList<Integer> connedtedNodes;

        public Node(int id) {
            this.id = id;
            bMarked = false;
        }

        public void mark(){
            this.bMarked = true;
        }

    }
}
