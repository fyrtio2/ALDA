package alda.graph;

import java.util.HashSet;
import java.util.Set;

public class Node<T> {
    private T data;
    private boolean visited = false;
    private Set<Node<T>> neighbours = new HashSet<>();

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void addNeighbour(Node<T> node) {
        neighbours.add(node);
    }

    public Set<Node<T>> getNeighbours() {
        return neighbours;

    }

    public String toString() {
        return (String) this.data;
    }
}
