package search;

import java.util.Stack;

public class DepthFirstSearch extends Search {

    @Override
    void search(boolean[][] map, int start) {
        boolean[] visited = new boolean[map.length];
        visited[start] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int num = stack.pop();
            for (int i = 0; i < map[num].length; i++) {
                if (map[num][i] && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}
