package com.epam.university.java.core.task012;

import java.util.ArrayList;


public class GraphFactoryImpl implements GraphFactory {

    @Override
    public Graph newInstance(int vertexesCount) {
        GraphImpl graph = new GraphImpl();
        for (int i = 1; i <= vertexesCount; i++) {
            graph.getAdjVer()
                    .putIfAbsent(i, new ArrayList<>());
        }
        return graph;
    }
}
