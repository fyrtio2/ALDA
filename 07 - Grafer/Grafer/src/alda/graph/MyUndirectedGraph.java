package alda.graph;

import java.util.List;

public class MyUndirectedGraph<T> implements UndirectedGraph<T> {

    public int getNumberOfNodes() {
        return 0;
    }

    public int getNumberOfEdges() {
        return 0;
    }


    public boolean add(T newNode) {
        return false;
    }

    public boolean connect(T node1, T node2, int cost) {
        return false;
    }

    public boolean isConnected(T node1, T node2) {
        return false;
    }

    public int getCost(T node1, T node2) {
        return 0;
    }

    public List<T> depthFirstSearch(T start, T end) {
        return null;
    }

    public List<T> breadthFirstSearch(T start, T end) {
        return null;
    }

    public UndirectedGraph<T> minimumSpanningTree() {
        return null;
    }
}