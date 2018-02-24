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

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }
}
