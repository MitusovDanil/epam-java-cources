package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImpl implements Graph {

    private Map<Integer, List<Integer>> adjVer;

    public GraphImpl() {
        adjVer = new HashMap<>();
    }

    @Override
    public void createEdge(int from, int to) {
        Integer vertex1 = from;
        Integer vertex2 = to;
        adjVer.get(vertex1).add(vertex2);
        adjVer.get(vertex2).add(vertex1);
    }

    @Override
    public boolean edgeExists(int from, int to) {
        Integer vertex1 = from;
        Integer vertex2 = to;

        List<Integer> first = adjVer.get(vertex1);
        List<Integer> second = adjVer.get(vertex2);

        return first.contains(vertex2) && second.contains(vertex1);
    }

    @Override
    public void removeEdge(int from, int to) {
        Integer vertex1 = from;
        Integer vertex2 = to;

        List<Integer> first = adjVer.get(vertex1);
        List<Integer> second = adjVer.get(vertex2);

        if (first != null) {
            first.remove(vertex2);
        }

        if (second != null) {
            first.remove(vertex1);
        }
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        return adjVer.get(from);
    }

    public Map<Integer, List<Integer>> getAdjVer() {
        return adjVer;
    }
}
