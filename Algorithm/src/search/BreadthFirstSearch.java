package search;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    void search(boolean[][] map, int start) {
        boolean[] visited = new boolean[map.length];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>(Collections.singleton(start));
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 0; i < map[num].length; i++) {
                if (map[num][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
