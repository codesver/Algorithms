package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

    private final int MAX_VALUE = Integer.MAX_VALUE; // Sum of all cost + 1

    int[] solve(int[][] graph, int from) {
        boolean[] visited = new boolean[graph.length];
        int[] distances = new int[graph.length];
        Arrays.fill(distances, MAX_VALUE);
        distances[from] = 0;

        Queue<Integer> queue = new PriorityQueue<>
                (Comparator.comparingInt(o -> distances[o]));
        queue.offer(from);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            for (int neighbor = 0; neighbor < graph.length; neighbor++) {
                if (graph[node][neighbor] != 0 && !visited[neighbor]) {
                    distances[neighbor] = Math.min(
                            distances[neighbor],
                            distances[node] + graph[node][neighbor]);
                    queue.offer(neighbor);
                }
            }
        }

        return distances;
    }
}
