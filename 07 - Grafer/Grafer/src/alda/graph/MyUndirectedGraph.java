package alda.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUndirectedGraph<T> implements UndirectedGraph<T> {

    private Map<T, Node<T>> nodes = new HashMap<>();
    private List<Edge<T>> edges = new ArrayList<>();

    public int getNumberOfNodes() {
        return nodes.size();
    }

    public int getNumberOfEdges() {
        return edges.size();
    }


    public boolean add(T newNode) {
        if (nodes.containsKey(newNode)) {
            return false;
        }
        Node<T> node = new Node<>(newNode);
        nodes.put(newNode, node);
        return true;
    }

    public boolean connect(T node1, T node2, int cost) {
        if (cost <= 0) {
            return false;
        }
        if (!nodes.containsKey(node1) || !nodes.containsKey(node2)) {
            return false;
        }
        try {
            getEdge(node1, node2).setCost(cost);
            return true;
        } catch (NullPointerException e) {

            Edge<T> newEdge = new Edge<>(nodes.get(node1), nodes.get(node2), cost);
            edges.add(newEdge);
            return true;
        }


    }

    public boolean isConnected(T node1, T node2) {
        if (!(nodes.containsKey(node1) || nodes.containsKey(node2))) {
            return false;
        }

        if (getEdge(node1, node2) != null) {
                return true;
        }
        return false;
    }

    private Edge<T> getEdge(T node1, T node2) {
        for (Edge<T> edge : edges) {
            if (edge.hasNode(node1) && edge.hasNode(node2)) {
                return edge;
            }
        }
        return null;
    }

    public int getCost(T node1, T node2) {
        try{
            return getEdge(node1, node2).getCost();
        } catch (NullPointerException n) {
            return -1;
        }
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
