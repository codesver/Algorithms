package graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prim {

    static class Edge {
        int connectedNode, unconnectedNode, weight;

        public Edge(int connectedNode, int unconnectedNode, int weight) {
            this.connectedNode = connectedNode;
            this.unconnectedNode = unconnectedNode;
            this.weight = weight;
        }
    }

    int[][] prim(int[][] graph) {
        int[][] mst = new int[graph.length][graph.length];

        boolean[] visited = new boolean[graph.length];
        Queue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        int randomNode = (int) (Math.random() * graph.length);
        edges.offer(new Edge(randomNode, randomNode, 0));

        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            if (visited[edge.unconnectedNode]) continue;
            visited[edge.unconnectedNode] = true;
            mst[edge.connectedNode][edge.unconnectedNode]
                    = mst[edge.unconnectedNode][edge.connectedNode]
                    = edge.weight;
            for (int node = 0; node < graph.length; node++)
                if (graph[edge.unconnectedNode][node] != 0 && !visited[node])
                    edges.offer(new Edge(edge.unconnectedNode, node, graph[edge.unconnectedNode][node]));
        }

        return mst;
    }
}
