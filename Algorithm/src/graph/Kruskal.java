package graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class Kruskal {

    static class Edge {
        int nodeA, nodeB, weight;

        public Edge(int nodeA, int nodeB, int weight) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.weight = weight;
        }
    }

    int[][] kruskal(int[][] graph) {
        int[][] mst = new int[graph.length][graph.length];

        Queue<Edge> edges = new PriorityQueue<>
                (Comparator.comparingInt(o -> o.weight));
        for (int nodeA = 0; nodeA < graph.length; nodeA++)
            for (int nodeB = 0; nodeB < graph.length; nodeB++)
                if (graph[nodeA][nodeB] != 0)
                    edges.offer(new Edge(nodeA, nodeB, graph[nodeA][nodeB]));

        int[] roots = IntStream.range(0, graph.length).toArray();
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            int rootA = roots[edge.nodeA] = find(roots, edge.nodeA);
            int rootB = roots[edge.nodeB] = find(roots, edge.nodeB);
            if (rootA != rootB) {
                union(roots, rootA, rootB);
                mst[edge.nodeA][edge.nodeB]
                        = mst[edge.nodeB][edge.nodeA] = edge.weight;
            }
        }

        return mst;
    }

    int find(int[] roots, int node) {
        return roots[node] == node ? node : find(roots, roots[node]);
    }

    void union(int[] roots, int rootA, int rootB) {
        if (rootA < rootB) roots[rootB] = rootA;
        else roots[rootA] = rootB;
    }
}
