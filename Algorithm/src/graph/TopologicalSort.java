package graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopologicalSort {

    List<Integer> topologicalSort(boolean[][] graph) {
        int[] entryDegrees = new int[graph.length];
        Map<Integer, Set<Integer>> nextNodes = new HashMap<>();

        for (int from = 0; from < graph.length; from++) {
            nextNodes.put(from, new HashSet<>());
            for (int to = 0; to < graph.length; to++) {
                if (graph[from][to]) {
                    entryDegrees[to]++;
                    nextNodes.get(from).add(to);
                }
            }
        }

        List<Integer> sortedNodes = new ArrayList<>();
        Queue<Integer> readyToSearchNodes = IntStream
                .range(0, entryDegrees.length).boxed()
                .filter(i -> entryDegrees[i] == 0)
                .collect(Collectors.toCollection(LinkedList::new));

        while (!readyToSearchNodes.isEmpty()) {
            for (int nextNode : nextNodes.get(readyToSearchNodes.peek()))
                if (--entryDegrees[nextNode] == 0)
                    readyToSearchNodes.offer(nextNode);
            sortedNodes.add(readyToSearchNodes.poll());
        }

        return sortedNodes;
    }
}
