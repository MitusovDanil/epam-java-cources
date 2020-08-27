package com.epam.university.java.core.task012;

import java.util.*;

public class Task012Impl implements Task012 {

    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        for (GraphAction act : actions) {
            act.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(from);
        queue.add(from);
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            for (Integer i : graph.getAdjacent(vertex)) {
                if (graph.edgeExists(vertex, i)) {
                    if (!visited.contains(i)) {
                        visited.add(i);
                        queue.add(i);
                    }
                }
            }
        }
        return visited.contains(to);
    }
}
