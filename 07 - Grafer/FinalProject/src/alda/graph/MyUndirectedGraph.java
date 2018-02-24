package alda.graph;

import java.util.*;

public class MyUndirectedGraph<T> implements UndirectedGraph<T> {
    private Map<T, Node<T>> nodes = new HashMap<>();
    private List<Edge<T>> edges = new ArrayList<>();

    @Override
    public int getNumberOfNodes() {
        return nodes.size();
    }

    @Override
    public int getNumberOfEdges() {
        return edges.size();
    }

    @Override
    public boolean add(T newNode) {
        if (nodes.containsKey(newNode)) {
            return false;
        }
        Node<T> node = new Node<>(newNode);
        nodes.put(node.data, node);
        return true;
    }

    @Override
    public boolean connect(T node1, T node2, int cost) {
        if (cost < 1) {
            return false;
        }
        if (node1 != null && node2 != null) {
            if (isConnected(node1, node2)) {
                for (Edge<T> e: edges) {
                    if (isConnected(node1, node2)) {

                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isConnected(T node1, T node2) {
        for (Edge<T> e: edges) {
            if (e.first.data.equals(node1) && e.second.data.equals(node2)) {
                return true;
            }
            if (e.first.data.equals(node2) && e.second.data.equals(node1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getCost(T node1, T node2) {
        return 0;
    }

    @Override
    public List<T> depthFirstSearch(T start, T end) {
        return null;
    }

    @Override
    public List<T> breadthFirstSearch(T start, T end) {
        return null;
    }

    @Override
    public UndirectedGraph<T> minimumSpanningTree() {
        return null;
    }

    private static class Edge<T> {
        Node<T> first, second;
        int cost;

        public Edge(Node<T> first, Node<T> second, int cost) {
            this.first = first;
            this.second = second;
            this.cost = cost;
        }

    }

    private static class Node<T> {
        T data;
        boolean visited;
        Set<T> neighbours = new HashSet<>();

        public Node(T data) {
            this.data = data;
        }

        public String toString() {
            return (String) data;
        }
    }
}
