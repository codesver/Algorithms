package graph;

public class FloydWarshall {

    private final int MAX_VALUE = Integer.MAX_VALUE; // Sum of all cost + 1

    int[][] floydWarshall(int[][] graph) {
        int[][] distances = new int[graph.length][graph.length];
        for (int from = 0; from < graph.length; from++)
            for (int to = 0; to < graph.length; to++)
                distances[from][to] = graph[from][to] == 0 ?
                        MAX_VALUE :
                        graph[from][to];

        for (int mid = 0; mid < graph.length; mid++)
            for (int from = 0; from < graph.length; from++)
                for (int to = 0; to < graph.length; to++)
                    distances[from][to] = Math.min(
                            distances[from][to],
                            distances[from][mid] = distances[mid][to]
                    );

        return distances;
    }
}
