package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BellmanFord {

    private final int MAX_VALUE = Integer.MAX_VALUE; // Sum of all positive cost + 1

    int[] bellmanFord(int[][] graph, int start) {
        List<Edge> edges = new ArrayList<>();
        for (int from = 0; from < graph.length; from++)
            for (int to = 0; to < graph.length; to++)
                if (graph[from][to] != 0)
                    edges.add(new Edge(from, to, graph[from][to]));
        int[] distances = new int[graph.length];
        Arrays.fill(distances, MAX_VALUE);
        distances[start] = 0;

        IntStream.range(0, edges.size() - 1)
                .forEach(i -> searchEdges(edges, distances));
        int[] clone = distances.clone();
        searchEdges(edges, distances);
        for (int node = 0; node < distances.length; node++)
            if (distances[node] != clone[node]) return null;

        return distances;
    }

    void searchEdges(List<Edge> edges, int[] distances) {
        for (Edge edge : edges)
            if (distances[edge.from] != MAX_VALUE)
                distances[edge.to] = Math.min(
                        distances[edge.to],
                        distances[edge.from] + edge.weight
                );
    }
}
