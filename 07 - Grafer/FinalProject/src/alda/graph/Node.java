package alda.graph;

import java.util.HashSet;
import java.util.Set;

public class Node<T> {
    private T data;
    private boolean visited;
    private Set<Node<T>> neighbours = new HashSet<>();

    public Node(T data) {
        this.data = data;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addNeighbour(Node<T> n) {
        neighbours.add(n);
    }

    public Set<Node<T>> getNeighbours() {
        return neighbours;
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public String toString() {
        return (String) data;
    }
}
